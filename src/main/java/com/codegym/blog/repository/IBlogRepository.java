package com.codegym.blog.repository;

import com.codegym.blog.model.Blog;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
}
