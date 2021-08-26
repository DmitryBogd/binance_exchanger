package binance.services;


import binance.dto.StatusExchangerDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static binance.constants.Сonstants.urlStatus;

@Component
@AllArgsConstructor
public class StatusApi {

    private RestTemplate restTemplate;

    public StatusExchangerDto getStatus() {
        StatusExchangerDto response = restTemplate.getForObject(urlStatus, StatusExchangerDto.class);
        return response;

    }

}
