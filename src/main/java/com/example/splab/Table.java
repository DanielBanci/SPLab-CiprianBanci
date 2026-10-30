package com.example.splab;

import jakarta.persistence.Entity;
import lombok.NoArgsConstructor;

@Entity
@jakarta.persistence.Table(name = "book_table")
@NoArgsConstructor(force = true)
public class Table extends BaseElement{
    private final String something;

    public Table(String something){
        this.something = something;
    }

    public Table(Table table){
        this.something = table.something;
    }

    @Override
    public void print() {
        System.out.println("Table: " + this.something);
    }

    @Override
    public Element copy() {
        return new Table(this);
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
