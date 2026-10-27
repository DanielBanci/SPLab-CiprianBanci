package com.example.crc;

public class DeleteCommand implements Command<Boolean>{
    private final BookService bookService;
    private final long id;

    public DeleteCommand(BookService bookService, long id) {
        this.bookService = bookService;
        this.id = id;
    }

    @Override
    public Boolean execute() {
        return bookService.delete(id);
    }
}
