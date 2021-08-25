package binance;

import binance.jdbc.ExchangerJdbcDao;
import binance.services.StatusApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.jdbc.core.JdbcTemplate;

public class SpringdataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();

        StatusApi statusApi = new StatusApi();
        statusApi.getStatus();

    }
}
