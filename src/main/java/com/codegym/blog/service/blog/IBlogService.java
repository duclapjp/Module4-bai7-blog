package com.codegym.blog.service.blog;

import com.codegym.blog.model.blog.Blog;
import com.codegym.blog.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBlogService extends IGeneralService<Blog> {
    Page<Blog> findAll(Pageable pageable);
    Page<Blog> findAllByAuthorContaining(String author, Pageable pageable);
//    Page<Blog> findAllByTitleContaining(String title, Pageable pageable);
}
