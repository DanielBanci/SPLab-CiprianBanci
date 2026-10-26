package com.example.splab;

public class TableOfContents implements Element{
    private final String something;

    public TableOfContents(String something){
        this.something = something;
    }

    public TableOfContents(TableOfContents tableOfContents){
        this.something = tableOfContents.something;
    }

    @Override
    public void print() {
        System.out.println("TableOfContents: " + something);
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
}
