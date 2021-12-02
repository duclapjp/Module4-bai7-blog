package com.codegym.blog.service.blog;

import com.codegym.blog.exception.NotFoundException;
import com.codegym.blog.model.blog.Blog;
import com.codegym.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class BlogService implements IBlogService {

    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public Iterable<Blog> findAll() {
        return blogRepository.findAll();
    }

    @Override
    public Optional<Blog> findById(Long id) {
        return blogRepository.findById(id);
    }

    @Override
    public void save(Blog blog) {
        blogRepository.save(blog);
    }

    @Override
    public void remove(Long id) {
        blogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return blogRepository.findAll(pageable);
    }

    @Override
    public Page<Blog> findAllByAuthorContaining(String author, Pageable pageable) throws NotFoundException {
        Page<Blog> blogs = blogRepository.findAllByAuthorContaining(author,pageable);
        if (blogs!=null){
            return blogs;
        }else {
            throw new NotFoundException();
        }
    }

//    @Override
//    public Page<Blog> findAllByTitleContaining(String title, Pageable pageable) {
//        return blogRepository.findAllByTitleContaining(title,pageable);
//    }
}
