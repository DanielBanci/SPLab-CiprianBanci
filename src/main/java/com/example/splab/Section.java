package com.example.splab;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Section extends BaseElement{
    @Setter
    @Getter
    protected String title;

    @OneToMany(targetEntity = BaseElement.class)
    protected final List<Element> children;

    protected Section(){
        title = "-1";
        children = new ArrayList<>();
    }

    public Section(String title){
        this.title = title;
        children = new ArrayList<>();
    }

    public Section(Section section){
        this.title = section.title;
        this.children = new ArrayList<>();
        for(Element e : section.children){
            this.children.add(e.copy());
        }
    }

    @Override
    public Element copy() {
        return new Section(this);
    }

    @Override
    public void print() {
        if(!(this instanceof Book))
            System.out.println(title);
        for(Element e : children){
            e.print();
        }
    }

    @Override
    public void add(Element e) {
        children.add(e.copy());
    }

    @Override
    public void remove(Element e) {
        children.remove(e);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
        for(Element e : children){
            e.accept(visitor);
        }
    }
}