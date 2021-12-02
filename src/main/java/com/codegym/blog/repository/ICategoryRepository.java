package com.codegym.blog.repository;

import com.codegym.blog.model.category.Category;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ICategoryRepository extends PagingAndSortingRepository<Category,Long> {
}
