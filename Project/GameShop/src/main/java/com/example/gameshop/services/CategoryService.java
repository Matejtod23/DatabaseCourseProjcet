package com.example.gameshop.services;

import com.example.gameshop.models.Category;

import java.util.List;
import java.util.Set;

public interface CategoryService {
    Set<Category> getAllCategoriesByIds(List<Integer> categories);
}
