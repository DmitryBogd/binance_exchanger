package binance.jdbc;

import binance.dto.ExchangerMapper;
import binance.dto.StatusExchangerDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

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
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss") ;
        jdbcTemplate.update("INSERT INTO binance VALUES(DEFAULT,?,?,?)",
                statusExchangerDto.getMsg(),
                statusExchangerDto.getStatus(), format.format(date));
    }

}
