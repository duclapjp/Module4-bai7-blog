package com.codegym.blog.service;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();
    Optional findById(Long id);
    void save(T t);
    void remove(Long id);
}
