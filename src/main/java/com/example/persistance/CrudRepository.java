package com.example.persistance;

import java.util.List;
import java.util.Optional;

public interface CrudRepository <T, ID>{
    T save(T t);
    Optional<T> findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
    boolean existsById(ID id);
}
