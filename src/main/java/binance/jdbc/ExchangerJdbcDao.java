package binance.jdbc;

import binance.dto.ExchangerMapper;
import binance.dto.StatusExchangerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ExchangerJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public StatusExchangerDto findAll(){
        return jdbcTemplate.query("Select * FROM binance WHERE id=(SELECT MAX(id) FROM binance)", new ExchangerMapper())
                .stream().findAny().orElse(null);

    }
}
