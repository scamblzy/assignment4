package com.example.endka.interfaces;

import java.util.List;

public interface CrudRepository<T> {

    void save(T entity);

    T findById(int id);

    List<T> findAll();

    void update(int id, T entity);

    void delete(int id);
}
