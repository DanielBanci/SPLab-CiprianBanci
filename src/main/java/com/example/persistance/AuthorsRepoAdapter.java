package com.example.persistance;

import com.example.splab.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class AuthorsRepoAdapter implements CrudRepository<Author, Integer> {
    private final AuthorsRepository authorsRepository;

    @Autowired
    public AuthorsRepoAdapter(AuthorsRepository authorsRepository) {
        this.authorsRepository = authorsRepository;
    }

    @Override
    public Author save(Author author) {
        return authorsRepository.save(author);
    }

    @Override
    public Optional<Author> findById(Integer integer) {
        return authorsRepository.findById(integer);
    }

    @Override
    public List<Author> findAll() {
        return authorsRepository.findAll();
    }

    @Override
    public void deleteById(Integer integer) {
        authorsRepository.deleteById(integer);
    }

    @Override
    public boolean existsById(Integer integer) {
        return authorsRepository.existsById(integer);
    }
}
