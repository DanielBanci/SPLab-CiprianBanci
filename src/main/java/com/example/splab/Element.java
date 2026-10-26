package com.example.splab;

public interface Element {
    void print();
    void add(Element e);
    void remove(Element e);
    Element get(int index);
    Element copy();
    void accept(Visitor visitor);
}