package com.example.crc;

import com.example.splab.Book;

public class UpdateBookCommand implements Command<Book> {
    private final CommandContext commandContext;
    private final long id;
    private final Book updatedData;

    public UpdateBookCommand(CommandContext commandContext, long id, Book updatedData) {
        this.commandContext = commandContext;
        this.id = id;
        this.updatedData = updatedData;
    }

    @Override
    public Book execute() {
        updatedData.setId(id);
        return commandContext.getBooksRepository().save(updatedData);
    }
}
