package com.example.gameshop.repository.DTOImpl;

import com.example.gameshop.models.view_models.GameReviewsSummaryDTO;
import com.example.gameshop.models.view_models.RatingsPerCutomerDTO;
import com.example.gameshop.repository.RatingsPerCustomerRepo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class RatingsPerCustomerRepoImpl implements RatingsPerCustomerRepo {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public RatingsPerCustomerRepoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<RatingsPerCutomerDTO> getRatingsPerCustomer() {
        String sql = "SELECT * FROM gameshop.ratings_per_cutomer";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(RatingsPerCutomerDTO.class)
        );
    }
}
