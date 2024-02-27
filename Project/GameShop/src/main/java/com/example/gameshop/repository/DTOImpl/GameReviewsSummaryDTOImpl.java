package com.example.gameshop.repository.DTOImpl;

import com.example.gameshop.models.view_models.GamePublisherInfoDTO;
import com.example.gameshop.models.view_models.GameReviewsSummaryDTO;
import com.example.gameshop.repository.GameReviewsSummaryRepositoryDTO;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GameReviewsSummaryDTOImpl implements GameReviewsSummaryRepositoryDTO {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public GameReviewsSummaryDTOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<GameReviewsSummaryDTO> getGameSummaryInfo() {
        String sql = "SELECT * FROM gameshop.game_reviews_summary";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(GameReviewsSummaryDTO.class)
        );
    }
}
