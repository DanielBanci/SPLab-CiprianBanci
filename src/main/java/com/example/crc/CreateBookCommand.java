package com.example.crc;

import com.example.splab.Book;

import java.util.concurrent.TimeUnit;

public class CreateBookCommand implements Command<Book>{
//    private final BookService bookService;
    private final CommandContext commandContext;
    private Book bookToCreate;

    public CreateBookCommand(CommandContext commandContext, Book bookToCreate) {
        this.commandContext = commandContext;
        this.bookToCreate = bookToCreate;
    }

    @Override
    public Book execute() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        bookToCreate = commandContext.getBooksRepository().save(bookToCreate);
        return bookToCreate;
    }
}
