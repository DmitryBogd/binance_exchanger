package binance;

import binance.dto.MetadataDto;
import binance.jdbc.ExchangerJdbcDao;

import binance.services.Metadata;
import binance.services.OrderBook;
import binance.services.StatusApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import static binance.constants.Сonstants.depthLimit;
import static binance.constants.Сonstants.depthSymbol;

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

    @Autowired
    private Metadata metadata;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(exchangerJdbcDao.getLastStatus().getStatus());

        System.out.println(statusApi.getStatus().getMsg());

        System.out.println(orderBook.GetOrderBook(depthSymbol, depthLimit).getBody());

        System.out.println(metadata.getMetadata().getSymbol());
    }
}
