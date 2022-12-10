package org.sus.patterns.decorator.functional;

import java.util.Objects;
import java.util.stream.Stream;


interface Dress
{
    void assemble();
}
@FunctionalInterface
interface DynamicDecorator
{
    void assemble();
    default DynamicDecorator andThen(DynamicDecorator other)
    {
        Objects.requireNonNull(other);
        return () ->{
            this.assemble();
            other.assemble();
        };
    }
    static DynamicDecorator identity()
    {
        return () ->{};
    }

}
class DressImpl implements Dress{

    private DynamicDecorator dynamicDecorator;

    public DressImpl(DynamicDecorator... dynamicDecorators) {
        this.dynamicDecorator = Stream.of(dynamicDecorators)
                                      .reduce(DynamicDecorator.identity(),
                                              DynamicDecorator::andThen,
                                              DynamicDecorator::andThen);
    }

    @Override
    public void assemble() {
        this.dynamicDecorator.assemble();
    }
}
public class DecoratorWithModrenApproach {
    public static void main(String[] args) {
        DynamicDecorator basicDress = () -> System.out.println("adding basic dress...");
        DynamicDecorator fancyDress = () -> System.out.println("adding fancy dress...");
        DynamicDecorator sportyDress = () -> System.out.println("adding sporty dress...");
        Dress basicDress1 = new DressImpl(basicDress);
        basicDress1.assemble();
        Dress sportyDress1 = new DressImpl(basicDress,sportyDress);
        sportyDress1.assemble();
        Dress sportyAndFancyDress = new DressImpl(basicDress,fancyDress,sportyDress);
        sportyAndFancyDress.assemble();
    }
}
