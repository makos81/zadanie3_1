package com.kodilla.bytebuddy;

public class User {
    private String name;
    private String surname;

    public User(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    void doSomething(){
        System.out.println("some text");
    }
}
