package org.sus.patterns.decorator.legacy;

interface Dress
{
    void assemble();
}
class BasicDress implements Dress{

    @Override
    public void assemble() {
        System.out.println("basic Dress feature added....");
    }
}
class DressDecorator implements Dress
{

    protected Dress dress;

    public DressDecorator(Dress dress) {
        this.dress = dress;
    }

    @Override
    public void assemble() {
        this.dress.
                assemble();

    }
}
class CasualDress extends DressDecorator
{

    public CasualDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("adding casual dress features......");

    }
}
class FancyDress extends DressDecorator
{

    public FancyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("adding fancy dress features......");
    }
}
class SportyDress extends DressDecorator
{

    public SportyDress(Dress dress) {
        super(dress);
    }

    @Override
    public void assemble() {
        super.assemble();
        System.out.println("adding sporty dress features......");
    }
}

public class DecoratorWithLegacyApproach {
    public static void main(String[] args) {
        Dress sportyDress = new SportyDress(new BasicDress());
        sportyDress.assemble();
        Dress sportyandFancyDress = new SportyDress(new FancyDress(new BasicDress()));
        sportyandFancyDress.assemble();


    }
}
