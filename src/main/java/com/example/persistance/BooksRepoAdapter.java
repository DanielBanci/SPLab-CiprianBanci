package com.example.persistance;

import com.example.splab.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class BooksRepoAdapter implements CrudRepository<Book, Integer>{
    private final BooksRepository booksRepository;

    @Autowired
    public BooksRepoAdapter(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    @Override
    public Book save(Book book) {
        return booksRepository.save(book);
    }

    @Override
    public Optional<Book> findById(Integer integer) {
        return booksRepository.findById(integer);
    }

    @Override
    public List<Book> findAll() {
        return booksRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        booksRepository.deleteById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return booksRepository.existsById(integer);
    }
}
