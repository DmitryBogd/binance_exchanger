package binance.jdbc;

import binance.dto.ExchangerMapper;
import binance.dto.StatusExchangerDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
@Repository
@AllArgsConstructor
public class ExchangerJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public StatusExchangerDto getLastStatus(){
        return jdbcTemplate.query("Select * FROM binance WHERE id=(SELECT MAX(id) FROM binance)", new ExchangerMapper())
                .stream().findAny().orElse(null);
    }

    public void addStatus(StatusExchangerDto statusExchangerDto){
        jdbcTemplate.update("INSERT INTO binance VALUES(1,?,?,?)",
                statusExchangerDto.getMsg(),
                statusExchangerDto.getStatus(),
                LocalDate.now() + LocalTime.now().toString());
    }

}
