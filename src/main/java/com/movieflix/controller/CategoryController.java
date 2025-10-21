package com.movieflix.controller;

import com.movieflix.entity.Category;
import com.movieflix.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/movieflix/category")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @GetMapping()
    public List<Category> getAllCategories(){
        return categoryService.getAllCategories();
    }

    @PostMapping("/create")
    public Category saveCategory(@RequestBody Category category){

        return categoryService.saveCategory(category);
    }

    @GetMapping("/{id}")
    public Category getById (@PathVariable Long id){
        return categoryService.getCategoryById(id);
    }

    @PutMapping ("/{id}")
    public Category updateCategory (@PathVariable Long id , @RequestBody  Category category){
        if (category != null){
            return categoryService.updateById(category , id);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteCategory (@PathVariable  Long id){
        categoryService.deleteById(id);
    }



}
