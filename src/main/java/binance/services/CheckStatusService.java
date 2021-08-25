package binance.services;

import binance.dto.StatusExchangerDto;
import binance.jdbc.ExchangerJdbcDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class CheckStatusService {

    @Autowired
    StatusApi statusApi;

    @Autowired
    ExchangerJdbcDao exchangerJdbcDao;

    @Scheduled(fixedRate = 50000)
    public void checkStatus(){
        StatusExchangerDto freshStatusApi = statusApi.getStatus();
        if(!freshStatusApi.equals(exchangerJdbcDao.getLastStatus())) {
            exchangerJdbcDao.addStatus(freshStatusApi);
            System.out.println("Status changed");
        }
        else
        System.out.println("Status checked");
    }
}
