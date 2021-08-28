package binance;

import binance.interfaces.BinanceRepository;
import binance.services.BinaryAutoService;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication
@AllArgsConstructor
public class SpringDataApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringDataApplication.class, args);
    }

    private final BinaryAutoService binaryAutoService;
    private final BinanceRepository binanceRepository;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(binanceRepository.findMaxId());

        System.out.println(binaryAutoService.getStatus());

        System.out.println(binaryAutoService.getOrderBook("ETHBTC", 5).toString());

        System.out.println(binaryAutoService.getMetadata());

    }
}
