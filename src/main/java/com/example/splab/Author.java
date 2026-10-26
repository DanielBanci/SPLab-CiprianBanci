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

    public Author(Author author){
        this.name = author.name;
        this.surname = author.surname;
    }

    public Author copy(){
        return new Author(this);
    }

    public void print(){
        System.out.println("Author: " + name + " " + surname);
    }
}
