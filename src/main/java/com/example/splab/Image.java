package com.example.splab;

import java.util.concurrent.TimeUnit;

public class Image implements Element, Picture{
    private final String url;
    private ImageContent content;

    public Image(String url){
        this.url = url;
        this.content = null;

        try{
            TimeUnit.SECONDS.sleep(5);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public Image(Image image){
        this.url = image.url;
        this.content = image.content;
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return new Dimension(200, 200);
    }

    @Override
    public ImageContent content() {
        return content;
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
