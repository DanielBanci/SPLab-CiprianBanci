package com.example.crc;

import com.example.splab.Book;

public class UpdateBookCommand implements Command<Book> {
    private final BookService bookService;
    private final long id;
    private final Book updatedData;

    public UpdateBookCommand(BookService bookService, long id, Book updatedData) {
        this.bookService = bookService;
        this.id = id;
        this.updatedData = updatedData;
    }

    @Override
    public Book execute() {
        return bookService.update(id, updatedData);
    }
}
