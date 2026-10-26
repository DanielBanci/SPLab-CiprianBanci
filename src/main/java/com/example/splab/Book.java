package com.example.splab;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section{
    private final List<Author> authors;

    public Book(String title){
        super(title);
        this.authors = new ArrayList<>();
    }

    public void addAuthor(Author author){
        authors.add(author);
    }

    public void addContent(Element e){
        super.add(e);
    }

    @Override
    public void print() {
        System.out.println("Book: " + this.title);
        System.out.println("\nAuthors:");
        for(Author a : authors){
            a.print();
        }
        System.out.println();

        super.print();
    }
}
