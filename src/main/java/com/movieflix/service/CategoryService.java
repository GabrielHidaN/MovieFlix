package com.movieflix.service;

import com.movieflix.entity.Category;
import com.movieflix.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories(){
        return categoryRepository.findAll();
    }

    public Category saveCategory(Category category){
        return categoryRepository.save(category);
    }

    public  Category getCategoryById (Long id) {

        Optional<Category> getById = categoryRepository.findById(id);

        if (getById.isPresent()) {
            return categoryRepository.findById(id).orElse(null);

        }
        return null;
    }

    public void deleteById (Long id){
        categoryRepository.deleteById(id);
    }

    public Category updateById(Category category , Long id){

        Optional<Category> getCategory = categoryRepository.findById(id);

        if(getCategory.isPresent()){
            category.setId(id);
            return  categoryRepository.save(category);
        }
        return null;
    }
}
