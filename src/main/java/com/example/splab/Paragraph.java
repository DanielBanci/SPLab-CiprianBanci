package com.example.splab;

public class Paragraph implements Element{
    private final String text;

    public Paragraph(String text){
        this.text = text;
    }

    public Paragraph(Paragraph paragraph){
        this.text = paragraph.text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
    }

    @Override
    public Element copy() {
        return new Paragraph(this);
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
