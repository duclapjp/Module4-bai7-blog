package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.blog.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


import java.util.Optional;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private IBlogService blogService;
    @RequestMapping("/view")
    public ModelAndView view(@PageableDefault(value = 1) Pageable pageable){
        ModelAndView modelAndView = new ModelAndView("blog/view");
      Page<Blog> blogList = blogService.findAll(pageable);
        modelAndView.addObject("blogs",blogList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView  save(@ModelAttribute Blog blog){
        blogService.save(blog);
      ModelAndView modelAndView = new ModelAndView("blog/create");
      modelAndView.addObject("message","dang bai thanh cong");
      return modelAndView;
    }
    @GetMapping("/{id}/view2")
    public ModelAndView view2(@PathVariable Long id){
       Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/view2");
        modelAndView.addObject("blog",blog.get());
        return modelAndView;
    }
}
