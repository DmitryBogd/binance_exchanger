package binance.dto;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ExchangerMapper implements RowMapper<StatusExchangerDto> {
    @Override
    public StatusExchangerDto mapRow(ResultSet resultSet, int i) throws SQLException {
        StatusExchangerDto statusExchangerDto = new StatusExchangerDto(resultSet.getInt("status"), resultSet.getString("msg"));

        return statusExchangerDto;
    }
}