package com.movieflix.movieflix.mapper;

import com.movieflix.movieflix.entity.Category;
import com.movieflix.movieflix.request.CategoryRequest;
import com.movieflix.movieflix.response.CategoryResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest){
         return Category //@Builder usei no CATEGORY
                 .builder()
                 .name(categoryRequest.name())
                 .build();
    }


    public static CategoryResponse toCategoryResponse(Category category){
    return CategoryResponse
            .builder()
            .id(category.getId())
            .name(category.getName())
            .build();
    }



}
