package com.codegym.blog.controller;

import com.codegym.blog.model.Blog;
import com.codegym.blog.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("view");
       Iterable<Blog> blogList = blogService.findAll();
        modelAndView.addObject("blogs",blogList);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView showCreate(){
        ModelAndView modelAndView = new ModelAndView("create");
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView  save(@ModelAttribute Blog blog){
        blogService.save(blog);
      ModelAndView modelAndView = new ModelAndView("create");
      modelAndView.addObject("message","Đăng bài mới thành công");
      return modelAndView;
    }
    @GetMapping("/{id}/view2")
    public ModelAndView view2(@PathVariable Long id){
       Optional<Blog> blog = blogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("view2");
        modelAndView.addObject("blog",blog.get());
        return modelAndView;
    }
}
