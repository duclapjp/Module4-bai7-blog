package com.codegym.blog.service;

import com.codegym.blog.exception.NotFoundException;

import java.util.List;
import java.util.Optional;

public interface IGeneralService <T>{
    Iterable<T> findAll();
    Optional findById(Long id) throws NotFoundException;
    void save(T t);
    void remove(Long id);
}
