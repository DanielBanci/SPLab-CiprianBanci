package com.example.splab;

import java.util.ArrayList;
import java.util.List;

public class TableOfContents implements Element{
    private List<String> entries;

    public TableOfContents(){
        this.entries = new ArrayList<>();
    }

    public TableOfContents(TableOfContents tableOfContents){
        this.entries = new ArrayList<>();
        for(String str : tableOfContents.entries){
            entries.add(str);
        }
    }

    public void addEntry(String entry){
        entries.add(entry);
    }

    @Override
    public void print() {
        System.out.println("TableOfContents: ");
        for(String entry : entries){
            System.out.println(entry);
        }
    }

    @Override
    public Element copy() {
        return new TableOfContents(this);
    }

    @Override
    public void add(Element e) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public void remove(Element e) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public Element get(int index) {
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
