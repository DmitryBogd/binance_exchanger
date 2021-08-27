package binance.jobs;

import binance.dto.StatusExchangerDto;
import binance.dao.ExchangerJdbcDao;
import binance.services.BinaryAutoService;
import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
@AllArgsConstructor
public class CheckStatusJob {

    private final BinaryAutoService binaryAutoService;
    private final ExchangerJdbcDao exchangerJdbcDao;

    @Scheduled(fixedRate = 500000)
    public void checkStatus(){
        StatusExchangerDto freshStatusApi = binaryAutoService.getStatus();
        if(!freshStatusApi.equals(exchangerJdbcDao.getLastStatus())) {
            exchangerJdbcDao.addStatus(freshStatusApi);
            System.out.println("Status changed");
        }
        else
        System.out.println("Status checked");
    }
}
