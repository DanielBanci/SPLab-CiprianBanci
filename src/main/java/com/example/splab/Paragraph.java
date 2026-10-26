package com.example.splab;

public class Paragraph implements Element{
    private final String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text){
        this.text = text;
    }

    public Paragraph(Paragraph paragraph){
        this.text = paragraph.text;
        this.alignStrategy = paragraph.alignStrategy;
    }

    @Override
    public void print() {
        if(alignStrategy == null) {
            System.out.println("Paragraph: " + text);
        }else{
            alignStrategy.render(this, new Context());
        }
    }

    @Override
    public Element copy() {
        return new Paragraph(this);
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
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
