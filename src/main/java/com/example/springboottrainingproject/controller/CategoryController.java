package com.example.springboottrainingproject.controller;

import com.example.springboottrainingproject.domain.Category;
import com.example.springboottrainingproject.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class CategoryController {

  @Autowired
  CategoryRepository categoryRepository;

  @RequestMapping(value = "/category", method = RequestMethod.GET)
  public List<Category> getCategories(){
    return categoryRepository.findAll();
  }

  @RequestMapping(value = "/category/{id}", method = RequestMethod.GET)
  public Category getCategory(@PathVariable Long id){
    return categoryRepository.findOne(id);
  }

}
