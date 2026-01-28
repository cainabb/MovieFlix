package com.movieflix.movieflix.service;

import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository repository;

    @GetMapping
    public List<Category>findAll(){
    return repository.findAll(); //CATEGORY é uma Interface que implementa o JPA REPOSITORY onde tem o findAll()
    }

    public Optional<Category> findById(Long id){
        return repository.findById(id);
    }

    public void deleteByID(Long id){
        repository.deleteById(id);
    }

    public Category saveCategory(Category category){
        return repository.save(category);
    }


}
