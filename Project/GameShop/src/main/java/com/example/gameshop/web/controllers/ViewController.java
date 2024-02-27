package com.example.gameshop.web.controllers;

import com.example.gameshop.models.view_models.*;
import com.example.gameshop.repository.*;
import com.example.gameshop.repository.DTOImpl.CustomerNumOrdersAndGamesPerOrderDTORepoImpl;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping("/view")
public class ViewController {
    CustomerOrderSummaryRepository customerOrderSummaryRepository;
    GamePublisherInfoRepository gamePublisherInfoRepository;
    GameReviewsSummaryRepositoryDTO gameReviewsSummaryRepositoryDTO;
    CustomerNumOrdersAndGamesPerOrderDTORepo customerNumOrdersAndGamesPerOrderDTORepo;
    AvgRatingAndNumRatingRepo avgRatingAndNumRatingRepo;
    RatingsPerCustomerRepo ratingsPerCustomerRepo;

    @GetMapping("/summaries")
    public String showOrderSummary(Model model) {
        List<CustomerOrderSummary> orderSummaries = customerOrderSummaryRepository.getOrderSummary();
        List<GamePublisherInfoDTO> gamePublisherInfos = gamePublisherInfoRepository.getGamePublisherInof();
        List<GameReviewsSummaryDTO> gameReviewInfos = gameReviewsSummaryRepositoryDTO.getGameSummaryInfo();
        model.addAttribute("gameReviewInfo", gameReviewInfos);
        model.addAttribute("gamePublisherInfo", gamePublisherInfos);model.addAttribute("orderSummaries", orderSummaries);
        model.addAttribute("bodyContent", "summaries");
        return "landingpage";
    }

    @GetMapping("/aggregations")
    public String showCustomerOrderInfo(Model model) {
        List<CustomerNumOrdersAndGamesPerOrderDTO> customerInfo = customerNumOrdersAndGamesPerOrderDTORepo.getCustomerInfo();
        List<RatingsPerCutomerDTO> ratingsPerCustomer = ratingsPerCustomerRepo.getRatingsPerCustomer();
        List<AvgRatingAndNumRatingDTO> avgRatings = avgRatingAndNumRatingRepo.getAvgRatings();
        model.addAttribute("avgRatings", avgRatings);
        model.addAttribute("ratingsPerCustomer", ratingsPerCustomer);
        model.addAttribute("customerInfo", customerInfo);
        model.addAttribute("bodyContent", "aggregations");
        return "landingpage";
    }
}
