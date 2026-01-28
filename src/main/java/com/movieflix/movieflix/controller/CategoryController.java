package com.movieflix.movieflix.controller;

import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.service.CategoryService;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("movieflix/category")
@RequiredArgsConstructor //Fez os construtores de private final CategoryService
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping
    public List<Category> getAllCategories(){

        return categoryService.findAll();
    }

    @GetMapping("/{id}")
    public Category getCategoriesById(@PathVariable Long id){
        Optional<Category> optionalCategory=categoryService.findById(id);
        if(optionalCategory.isPresent()){ //SE TEM ALGO DENTRO DE CATEGORY "IsPresent" então faça:
            return optionalCategory.get();
        } else
            return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoriesByID(@PathVariable Long id){
        categoryService.deleteByID(id);
    }


    @PostMapping
    public Category saveCategory(@RequestBody Category category){

        return categoryService.saveCategory(category);
    }








}
