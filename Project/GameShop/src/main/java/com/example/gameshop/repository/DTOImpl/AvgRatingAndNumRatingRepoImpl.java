package com.example.gameshop.repository.DTOImpl;

import com.example.gameshop.models.view_models.AvgRatingAndNumRatingDTO;
import com.example.gameshop.repository.AvgRatingAndNumRatingRepo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class AvgRatingAndNumRatingRepoImpl implements AvgRatingAndNumRatingRepo {
    private final NamedParameterJdbcTemplate jdbcTemplate;

    public AvgRatingAndNumRatingRepoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<AvgRatingAndNumRatingDTO> getAvgRatings() {
        String sql = "SELECT * FROM gameshop.avg_rating_and_num_rating";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(AvgRatingAndNumRatingDTO.class)
        );
    }
}
