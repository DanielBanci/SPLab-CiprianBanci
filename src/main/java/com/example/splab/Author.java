package com.example.splab;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor(force = true)
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Getter
    @Setter
    private String name;

    @Getter
    @Setter
    private String surname;

    public Author(String name, String surname){
        this.name = name;
        this.surname = surname;
    }

    public Author(String name){
        this(name, "");
    }

    public Author(Author author){
        this.id = author.id;
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
