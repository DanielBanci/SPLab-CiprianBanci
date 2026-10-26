package com.example.splab;

public class TableOfContents implements Element{
    private final String something;

    public TableOfContents(String something){
        this.something = something;
    }

    @Override
    public void print() {
        System.out.println("TableOfContents: " + something);
    }

    @Override
    public void add(Element e) {

    }

    @Override
    public void remove(Element e) {

    }

    @Override
    public Element get(int index) {
        return null;
    }
}
