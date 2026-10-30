package com.example.splab;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor(force = true)
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class BaseElement implements Element{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected long id;

    public BaseElement(long id) {
        this.id = id;
    }

    @Override
    public void print() {
        throw new UnsupportedOperationException("Unsupported operation");
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
        throw new UnsupportedOperationException("Unsupported operation");
    }

    @Override
    public void accept(Visitor visitor) {
        throw new UnsupportedOperationException("Unsupported operation");
    }
}
