package binance;

import binance.jdbc.ExchangerJdbcDao;
import binance.services.CheckStatusService;
import binance.services.OrderBook;
import binance.services.StatusApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringdataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringdataApplication.class, args);
    }

    @Autowired
    private StatusApi statusApi;

    @Autowired
    private ExchangerJdbcDao exchangerJdbcDao;

    @Autowired
    private OrderBook orderBook;
    @Override
    public void run(String... args) throws Exception {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        System.out.println(exchangerJdbcDao.getLastStatus().getStatus());

        System.out.println(statusApi.getStatus().getMsg());

        orderBook.GetOrderBook("ETHBTC", 5);
    }
}
