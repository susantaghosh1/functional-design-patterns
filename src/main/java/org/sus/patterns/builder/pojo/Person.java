package org.sus.patterns.builder.pojo;

public class Person {
    private String name;
    private String address;
    private String contactNo;
    private String email;

    public Person() {
    }

    public Person(String name, String address, String contactNo, String email) {
        this.name = name;
        this.address = address;
        this.contactNo = contactNo;
        this.email = email;
    }
    public Person withName(String name){
        this.name = name;
        return this;
    }
    public Person withAddress(String address){
        this.address = address;
        return this;
    }
    public Person withContactNo(String contactNo){
        this.contactNo = contactNo;
        return this;
    }
    public Person withEmail(String email){
        this.email = email;
        return this;
    }
}
