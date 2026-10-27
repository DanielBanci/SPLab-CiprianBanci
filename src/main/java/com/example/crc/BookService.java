package com.example.crc;

import com.example.splab.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    private final Map<Long, Book> books = new HashMap<>();
    private static long counter = 1;

    public BookService(){
        save(new Book(1, "Carte 1"));
        save(new Book(2, "Carte 2"));
    }

    public List<Book> findAll(){
        return new ArrayList<>(books.values());
    }

    public Book findById(long id){
        return books.get(id);
    }

    public long save(Book book){
        book.setId(counter++);
        books.put(book.getId(), book);

        return counter - 1;
    }

    public Book update(long id, Book book){
        book.setId(id);
        books.put(id, book);

        return book;
    }

    public boolean delete(long id){
        return books.remove(id) != null;
    }


}
