package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.model.Category;
import com.codegym.blog.service.blog.IBlogService;
import com.codegym.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;

    @Autowired
    private ICategoryService categoryService;

    @ModelAttribute("categories")
    public Iterable<Category> categories() {
        return categoryService.findAll();
    }

    @GetMapping("/view")
    public ModelAndView view(@RequestParam("search") Optional<String> search, @PageableDefault(value = 1) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/view");
        Page<Blog> blogList;
        if (search.isPresent()) {
            blogList = blogService.findAllByAuthorContaining(search.get(), pageable);
            modelAndView.addObject("se",search);
        } else {
            blogList = blogService.findAll(pageable);
        }
        modelAndView.addObject("blogs", blogList);
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreate() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/save")
    public ModelAndView save(@Validated @ModelAttribute Blog blog, BindingResult bindingResult) {
        if (bindingResult.hasFieldErrors()) {
            return new ModelAndView("blog/create");
        } else {
            blogService.save(blog);
            ModelAndView modelAndView = new ModelAndView("blog/create");
            modelAndView.addObject("message", "dang bai thanh cong");
            return modelAndView;
        }
    }

    @GetMapping("/{id}/view2")
    public ModelAndView view2(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/view2");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id) {
        Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Blog blog) {
        blogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "chinh sua thanh cong");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id) {
        ModelAndView modelAndView = new ModelAndView("blog/delete");
        Optional<Blog> blog = blogService.findById(id);
        modelAndView.addObject("blog", blog.get());
        return modelAndView;
    }

    @PostMapping("/remove")
    public ModelAndView delete(@RequestParam Long id) {
        ModelAndView modelAndView = new ModelAndView("blog/result");
        blogService.remove(id);
        modelAndView.addObject("message", "xoa thanh cong");
        return modelAndView;
    }
}
