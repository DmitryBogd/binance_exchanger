package binance.services;

import binance.dto.MetadataDto;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static binance.constants.Сonstants.urlExchangeInfo;
import static binance.constants.Сonstants.urlOrderBook;

@Component
@AllArgsConstructor
public class Metadata {

    private RestTemplate restTemplate;

    public MetadataDto getMetadata(){
        MetadataDto response = restTemplate.getForObject(urlExchangeInfo, MetadataDto.class);
        return response;
    }
}
