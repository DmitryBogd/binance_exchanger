package binance.jobs;

import binance.dto.StatusExchangerDto;
import binance.interfaces.BinanceRepository;
import binance.services.BinaryAutoService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component
@EnableScheduling
@AllArgsConstructor
public class CheckStatusJob {

    private final BinaryAutoService binaryAutoService;
    private final BinanceRepository binanceRepository;
    private final Logger logger = LoggerFactory.getLogger(CheckStatusJob.class);


    @Scheduled(fixedRate = 500000)
    public void checkStatus() {
        StatusExchangerDto freshStatusApi = binaryAutoService.getStatus();
        if (binanceRepository.findMaxId() == null) {
            binanceRepository.save(freshStatusApi);
        } else {
            if (!freshStatusApi.getMsg().equals(binanceRepository.findMaxId().getMsg())) {
                binanceRepository.save(freshStatusApi);
                logger.info("Status changed");
            } else
                logger.info("Status checked");
        }
    }
}
