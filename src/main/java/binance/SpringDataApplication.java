package binance;

import binance.dao.ExchangerJdbcDao;

import binance.services.BinaryAutoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import static binance.constants.Сonstants.depthLimit;
import static binance.constants.Сonstants.depthSymbol;

@SpringBootApplication
@AllArgsConstructor
public class SpringDataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    private final BinaryAutoService binaryAutoService;
    private final ExchangerJdbcDao exchangerJdbcDao;

    @Override
    public void run(String... args) throws Exception {
        System.out.println(exchangerJdbcDao.getLastStatus());

        System.out.println(binaryAutoService.getStatus());

        System.out.println(binaryAutoService.getOrderBook(depthSymbol, depthLimit).toString());

        System.out.println(binaryAutoService.getMetadata());
    }
}
