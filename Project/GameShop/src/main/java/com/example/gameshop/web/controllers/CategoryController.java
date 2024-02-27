package com.example.gameshop.web.controllers;

import com.example.gameshop.models.Category;
import com.example.gameshop.repository.CategoryRepository;
import jakarta.persistence.GeneratedValue;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
@RequestMapping("/category")
public class CategoryController {

    CategoryRepository categoryRepository;

    @GetMapping("/list")
    public String getCategoryList(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("bodyContent", "categories");
        return "landingpage";
    }

    @GetMapping("/add")
    public String getAddCategoryPage(Model model){
        model.addAttribute("bodyContent", "add_pages/category_add");
        return "landingpage";
    }

    @PostMapping("/add")
    public String addCategory(@RequestParam String name){
        Category c = new Category(name);
        categoryRepository.save(c);
        return "redirect:/category/list";
    }
}
