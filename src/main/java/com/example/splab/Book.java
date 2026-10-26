package com.example.splab;

import java.util.ArrayList;
import java.util.List;

public class Book extends Section{
    private final List<Author> authors;

    public Book(String title){
        super(title);
        this.authors = new ArrayList<>();
    }

    public Book(Book book){
        super((Section) book);
        this.authors = new ArrayList<>();
        for(Author author : book.authors){
            this.authors.add(author.copy());
        }
    }

    public void addAuthor(Author author){
        authors.add(author.copy());
    }

    public void addContent(Element e){
        super.add(e);
    }

    @Override
    public Element copy() {
        return new Book(this);
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
