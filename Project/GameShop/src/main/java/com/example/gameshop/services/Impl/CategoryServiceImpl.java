package com.example.gameshop.services.Impl;

import com.example.gameshop.models.Category;
import com.example.gameshop.repository.CategoryRepository;
import com.example.gameshop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository categoryRepository;
    @Override
    public Set<Category> getAllCategoriesByIds(List<Integer> categories) {
        Set<Category> cat = new HashSet<>();
        categories.forEach(c -> {
            Category categ = categoryRepository.findById(Long.valueOf(c)).get();
            cat.add(categ);
        });
        return cat;
    }
}
