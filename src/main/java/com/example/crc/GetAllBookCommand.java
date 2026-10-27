package com.example.crc;

import com.example.splab.Book;

import java.util.List;

public class GetAllBookCommand implements Command<List<Book>>{
    private final BookService bookService;

    public GetAllBookCommand(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public List<Book> execute() {
        return bookService.findAll();
    }
}
