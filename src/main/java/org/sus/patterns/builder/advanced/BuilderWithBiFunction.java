package org.sus.patterns.builder.advanced;

import org.sus.patterns.builder.pojo.Person;

import java.util.Objects;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Consumer;

public class BuilderWithBiFunction {
    public <T> BiFunction<Consumer<T>,String,T> build()
    {
        return (anyConsumer, anyClassName) -> {
            Objects.requireNonNull(anyConsumer);
            Object o = Optional.ofNullable(anyClassName)
                    .map(s -> {
                        try {
                            return Class.forName(s).getDeclaredConstructor().newInstance();
                        } catch (Exception e) {
                            throw new RuntimeException(e);
                        }
                    }).orElseThrow();


            T t = (T) o;
            anyConsumer.accept(t);
            return t;
        };
    }
     public static <T> void main(String[] args) {

        Person person = new BuilderWithBiFunction()
                .<Person>build()
                .apply(anyPerson -> anyPerson
                                      .withName("Sus")
                                      .withContactNo("8250398913")
                                      .withAddress("Raniganj")
                                      .withEmail("ghoshsusanta21@gmail.com"),
                        "org.sus.patterns.builder.pojo.Person");
        System.out.println(person);
    }
}
