package com.example.gameshop.repository;

import com.example.gameshop.models.view_models.GamePublisherInfoDTO;
import com.example.gameshop.models.view_models.GameReviewsSummaryDTO;

import java.util.List;

public interface GameReviewsSummaryRepositoryDTO {
    List<GameReviewsSummaryDTO> getGameSummaryInfo();
}
