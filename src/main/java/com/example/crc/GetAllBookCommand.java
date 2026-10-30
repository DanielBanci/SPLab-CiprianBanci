package com.example.crc;

import com.example.splab.Book;

import java.util.List;

public class GetAllBookCommand implements Command<List<Book>>{
    private final CommandContext commandContext;

    public GetAllBookCommand(CommandContext commandContext) {
        this.commandContext = commandContext;
    }

    @Override
    public List<Book> execute() {
        return commandContext.getBooksRepository().findAll();
    }
}
