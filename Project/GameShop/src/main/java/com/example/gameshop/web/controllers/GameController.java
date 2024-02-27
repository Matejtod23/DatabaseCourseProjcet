package com.example.gameshop.web.controllers;

import com.example.gameshop.models.Category;
import com.example.gameshop.models.Game;
import com.example.gameshop.models.Publisher;
import com.example.gameshop.models.view_models.GameReviewsSummaryDTO;
import com.example.gameshop.repository.CategoryRepository;
import com.example.gameshop.repository.GameRepository;
import com.example.gameshop.repository.GameReviewsSummaryRepositoryDTO;
import com.example.gameshop.repository.PublisherRepository;
import com.example.gameshop.services.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.web.PageableDefault;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Controller
@AllArgsConstructor
@RequestMapping("/game")
public class GameController {

    GameRepository gameRepository;
    CategoryService categoryService;
    CategoryRepository categoryRepository;
    PublisherRepository publisherRepository;
    GameReviewsSummaryRepositoryDTO gameReviewsSummaryRepositoryDTO;

//    @GetMapping("/list")
//    public String getGamesList(Model model){
//        model.addAttribute("games", gameRepository.findAll());
//        model.addAttribute("bodyContent", "games");
//        return "landingpage";
//    }

    @GetMapping("/listPagination")
    public String getGames(Model model, @PageableDefault(size = 6) Pageable pageable) {
        Page<Game> games = gameRepository.findAll((org.springframework.data.domain.Pageable) pageable);
        model.addAttribute("games", games);
        model.addAttribute("bodyContent", "games");
        return "landingpage";
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/add")
    public String getAddGamePage(Model model){
        model.addAttribute("categories", categoryRepository.findAll());
        model.addAttribute("bodyContent", "add_pages/game_add");
        model.addAttribute("publishers", publisherRepository.findAll());
        return "landingpage";
    }

    @PostMapping("/save")
    public String saveGame(@RequestParam String title,
                           @RequestParam Integer price,
                           @RequestParam String platform,
                           @RequestParam LocalDate releaseDate,
                           @RequestParam Integer publisherId,
                           @RequestParam("categories") List<Integer> categoryIds,
                           @RequestParam String gamePoster){
        Set<Category> cat = categoryService.getAllCategoriesByIds(categoryIds);
        Publisher p = publisherRepository.findById(Long.valueOf(publisherId)).get();
        Game g = new Game(title, price, platform, releaseDate,p , cat, gamePoster);
        gameRepository.save(g);
        return "redirect:/game/listPagination";
    }

    @GetMapping("/details/{id}")
    public String getDetailsPage(@PathVariable Integer id, Model model){
        Game g = gameRepository.findById(Long.valueOf(id)).get();
        model.addAttribute("game", g);
        model.addAttribute("bodyContent", "game_details");
        return "landingpage";
    }
}
