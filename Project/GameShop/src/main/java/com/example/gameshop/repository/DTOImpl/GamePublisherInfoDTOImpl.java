package com.example.gameshop.repository.DTOImpl;

import com.example.gameshop.models.view_models.CustomerOrderSummary;
import com.example.gameshop.models.view_models.GamePublisherInfoDTO;
import com.example.gameshop.repository.GamePublisherInfoRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class GamePublisherInfoDTOImpl implements GamePublisherInfoRepository {

    private final NamedParameterJdbcTemplate jdbcTemplate;

    public GamePublisherInfoDTOImpl(NamedParameterJdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
    @Override
    public List<GamePublisherInfoDTO> getGamePublisherInof() {
        String sql = "SELECT * FROM gameshop.game_publisher_info";
        return jdbcTemplate.query(
                sql,
                new BeanPropertyRowMapper<>(GamePublisherInfoDTO.class)
        );
    }
}
