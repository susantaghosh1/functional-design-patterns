package org.sus.patterns.builder.functional;

import org.sus.patterns.builder.pojo.Person;

public class BuilderDemo {

    public static void main(String[] args) {
        Person person = MyBuilder.<Person>build(anyPerson -> anyPerson
                                                       .withName("Sus")
                                                       .withContactNo("8250398913")
                                                        .withAddress("Raniganj").withEmail("g"),"org.sus.patterns.builder.pojo.Person");
        System.out.println(person);

    }
}
