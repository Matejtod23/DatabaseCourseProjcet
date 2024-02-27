package com.example.gameshop.repository.DTOImpl;

import com.example.gameshop.models.view_models.CustomerNumOrdersAndGamesPerOrderDTO;
import com.example.gameshop.models.view_models.CustomerOrderSummary;
import com.example.gameshop.repository.CustomerNumOrdersAndGamesPerOrderDTORepo;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class CustomerNumOrdersAndGamesPerOrderDTORepoImpl implements CustomerNumOrdersAndGamesPerOrderDTORepo {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public CustomerNumOrdersAndGamesPerOrderDTORepoImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<CustomerNumOrdersAndGamesPerOrderDTO> getCustomerInfo() {
        String sql = "SELECT * FROM gameshop.customer_num_orders_and_games_per_order";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(CustomerNumOrdersAndGamesPerOrderDTO.class)
        );
    }
}
