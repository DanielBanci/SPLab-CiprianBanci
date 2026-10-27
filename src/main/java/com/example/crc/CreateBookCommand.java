package com.example.crc;

import com.example.splab.Book;

import java.util.concurrent.TimeUnit;

public class CreateBookCommand implements Command<Book>{
    private final BookService bookService;
    private final Book bookToCreate;

    public CreateBookCommand(BookService bookService, Book bookToCreate) {
        this.bookService = bookService;
        this.bookToCreate = bookToCreate;
    }

    @Override
    public Book execute() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bookToCreate.setId(bookService.save(bookToCreate));
        return bookToCreate;
    }
}
