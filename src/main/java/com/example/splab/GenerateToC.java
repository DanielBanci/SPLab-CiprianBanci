package com.example.splab;

public class GenerateToC implements Visitor{
    private TableOfContents tableOfContents = new TableOfContents();
    private int sectionIndex = 0;
    private int elementCount = 0;

    public TableOfContents getTableOfContents(){
        return tableOfContents;
    }

    @Override
    public void visit(Book book) {
        // pass
    }

    @Override
    public void visit(Section section) {
        sectionIndex++;
        tableOfContents.addEntry(section.getTitle() + " ......... " + (elementCount + 1));
    }

    @Override
    public void visit(TableOfContents tableOfContents) {
        // pass
    }

    @Override
    public void visit(Paragraph paragraph) {
        elementCount++;
    }

    @Override
    public void visit(ImageProxy imageProxy) {
        elementCount++;
    }

    @Override
    public void visit(Image image) {
        elementCount++;
    }

    @Override
    public void visit(Table table) {
        elementCount++;
    }
}
