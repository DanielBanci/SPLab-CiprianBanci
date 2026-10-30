package com.example.crc;

import com.example.persistance.CrudRepository;
import com.example.splab.Book;
import lombok.Getter;

public class CommandContext {
    @Getter
    private final CrudRepository<Book, Integer> booksRepository;

    public CommandContext(CrudRepository<Book, Integer> booksRepository) {
        this.booksRepository = booksRepository;
    }
}
