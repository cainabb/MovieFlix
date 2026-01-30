package com.movieflix.movieflix.controller;

import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.mapper.CategoryMapper;
import com.movieflix.movieflix.request.CategoryRequest;
import com.movieflix.movieflix.response.CategoryResponse;
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
    public ResponseEntity<List<CategoryResponse>> getAllCategories(){
        List<Category> categories = categoryService.findAll();
        List<CategoryResponse> List =   categories.stream()
                .map(category -> CategoryMapper.toCategoryResponse(category))
                .toList();
        return ResponseEntity.ok(List);
    }

    @GetMapping("/{id}")
    public ResponseEntity<> getCategoriesById(@PathVariable Long id){
        Optional<Category> optionalCategory=categoryService.findById(id);
        if(optionalCategory.isPresent()){
            return CategoryMapper.toCategoryResponse(optionalCategory.get());
        } else
            return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategoriesByID(@PathVariable Long id){
        categoryService.deleteByID(id);
    }


    @PostMapping
    public CategoryResponse saveCategory(@RequestBody CategoryRequest request){
        Category newCategory = CategoryMapper.toCategory(request);
        Category savedCategory = categoryService.saveCategory(newCategory);
    return CategoryMapper.toCategoryResponse(savedCategory);
    }








}
