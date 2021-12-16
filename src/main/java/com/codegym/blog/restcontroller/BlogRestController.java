package com.codegym.blog.restcontroller;

import com.codegym.blog.model.blog.Blog;
import com.codegym.blog.model.category.Category;
import com.codegym.blog.service.blog.IBlogService;
import com.codegym.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/home")
public class BlogRestController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("/blog")
    public ResponseEntity<Iterable<Blog>> showBlogList(){
        List<Blog> blogs = (List<Blog>) blogService.findAll();
        if (blogs.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogs,HttpStatus.OK);
    }
    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> showCategoryList(){
        List<Category> categories = (List<Category>) categoryService.findAll();
        if (categories.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categories,HttpStatus.OK);
    }

}
