package com.example.splab;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(force = true)
public class ImageProxy extends BaseElement implements Picture{
    private final String url;
    @OneToOne
    private final Dimension dimension;
    @Transient
    private Image realImage;

    public ImageProxy(String url){
        this.url = url;
        this.dimension = new Dimension(200, 200);
        this.realImage = null;
    }

    public ImageProxy(ImageProxy imageProxy){
        this.url = imageProxy.url;
        this.dimension = new Dimension(200, 200);
        this.realImage = null;
    }

    private Image loadImage(){
        if(realImage == null){
            realImage = new Image(url);
        }
        return realImage;
    }

    @Override
    public void print() {
        loadImage().print();
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
    public Element copy() {
        return new ImageProxy(this);
    }

    @Override
    public String url() {
        return url;
    }

    @Override
    public Dimension dim() {
        return dimension;
    }

    @Override
    public ImageContent content() {
        return loadImage().content();
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}
