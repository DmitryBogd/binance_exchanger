package binance.services;

import binance.dto.StatusExchangerDto;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication
public class StatusApi {
    private RestTemplate restTemplate = new RestTemplate();

    public void getStatus() {
        String url = "https://api.binance.com/sapi/v1/system/status";

        StatusExchangerDto response = null;

        response = restTemplate.getForObject(url, StatusExchangerDto.class);

        System.out.printf(response.getMsg());

    }

}
