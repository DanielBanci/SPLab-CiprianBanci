package com.example.crc;

import com.example.splab.Book;

import java.util.Optional;

public class GetBookByIdCommand implements Command<Optional<Book>> {
    private final CommandContext commandContext;
    private final long id;

    public GetBookByIdCommand(CommandContext commandContext, Long id) {
        this.commandContext = commandContext;
        this.id = id;
    }

    @Override
    public Optional<Book> execute() {
        return commandContext.getBooksRepository().findById((int)id);
    }
}
