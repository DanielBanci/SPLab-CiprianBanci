package com.example.splab;

public class Author {
    private final String name;
    private final String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Author(String name){
        this(name, "");
    }

    public void print(){
        System.out.println("Author: " + name + " " + surname);
    }
}
