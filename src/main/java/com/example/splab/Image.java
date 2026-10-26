package com.example.splab;

public class Image implements Element{
    private final String url;

    public Image(String url){
        this.url = url;
    }

    public Image(Image image){
        this.url = image.url;
    }

    @Override
    public void print() {
        System.out.println("Image with name: " + url);
    }

    @Override
    public Element copy() {
        return new Image(this);
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
