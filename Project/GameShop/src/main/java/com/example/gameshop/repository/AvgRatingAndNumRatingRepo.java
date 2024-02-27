package com.example.gameshop.repository;

import com.example.gameshop.models.view_models.AvgRatingAndNumRatingDTO;
import com.example.gameshop.models.view_models.RatingsPerCutomerDTO;

import java.util.List;

public interface AvgRatingAndNumRatingRepo {
    List<AvgRatingAndNumRatingDTO> getAvgRatings();
}
