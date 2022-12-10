package org.sus.patterns.builder.functional;

import java.util.Objects;
import java.util.Optional;
import java.util.function.Consumer;

public interface MyBuilder {
    public static <T> T build(Consumer<T> consumer,String className) throws RuntimeException {
        Objects.requireNonNull(consumer);
        Object o = Optional.ofNullable(className)
                .map(s -> {
                    try {
                        return Class.forName(s).getDeclaredConstructor().newInstance();
                    } catch (Exception e) {
                        throw new RuntimeException(e);
                    }
                }).orElseThrow();


        T t = (T) o;
        consumer.accept(t);
        return t;
    }
}
