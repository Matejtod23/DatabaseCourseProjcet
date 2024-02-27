package com.example.gameshop.repository.DTOImpl;

import com.example.gameshop.models.view_models.CustomerOrderSummary;
import com.example.gameshop.repository.CustomerOrderSummaryRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerOrderSummaryRepositoryImpl implements CustomerOrderSummaryRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerOrderSummaryRepositoryImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<CustomerOrderSummary> getOrderSummary() {
        String sql = "SELECT * FROM gameshop.customer_order_summary";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(CustomerOrderSummary.class)
        );
    }
}
