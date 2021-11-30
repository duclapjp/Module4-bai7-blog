package com.codegym.blog.controller;

import com.codegym.blog.model.Category;
import com.codegym.blog.service.category.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    private ICategoryService categoryService;
    @RequestMapping("/view")
    public ModelAndView view(){
        ModelAndView modelAndView = new ModelAndView("category/list");
        Iterable<Category> categories = categoryService.findAll();
        modelAndView.addObject("categories",categories);
        return modelAndView;
    }
    @GetMapping("/create")
    public ModelAndView create(){
        ModelAndView modelAndView = new ModelAndView("category/create");
        modelAndView.addObject("category",new Category());
        return modelAndView;
    }
    @PostMapping("/save")
    public ModelAndView save(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("category/create");
        categoryService.save(category);
        modelAndView.addObject("message","tao moi thanh cong");
        return modelAndView;
    }
    @GetMapping("/edit/{id}")
    public ModelAndView showEdit(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("category",categoryService.findById(id).get());
        return modelAndView;
    }

    @PostMapping("/update")
    public ModelAndView update(@ModelAttribute Category category){
        ModelAndView modelAndView = new ModelAndView("category/edit");
        modelAndView.addObject("message","chinh sua thanh cong");
        categoryService.save(category);
        return modelAndView;
    }
    @GetMapping("/delete/{id}")
    public ModelAndView showDelete(@PathVariable Long id){
        ModelAndView modelAndView = new ModelAndView("category/delete");
        modelAndView.addObject("category",categoryService.findById(id).get());
        return modelAndView;
    }
    @PostMapping("/remove")
    public  ModelAndView remove(@RequestParam Long id){
        ModelAndView modelAndView = new ModelAndView("category/delete");
        categoryService.remove(id);
        modelAndView.addObject("message","xoa thanh cong");
        return modelAndView;
    }
}
