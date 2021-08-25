package binance.services;


import binance.dto.StatusExchangerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static binance.constants.Сonstants.urlStatus;

@Component
public class StatusApi {

    @Autowired
    private RestTemplate restTemplate;

    public StatusExchangerDto getStatus() {
        StatusExchangerDto response = null;
        response = restTemplate.getForObject(urlStatus, StatusExchangerDto.class);
        return response;

    }

}
