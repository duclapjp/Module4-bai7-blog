package com.codegym.blog.repository;

import com.codegym.blog.model.blog.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface IBlogRepository extends PagingAndSortingRepository<Blog, Long> {
    Page<Blog> findAllByAuthorContaining(String author, Pageable pageable);
//    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
