package binance.services;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static binance.constants.Сonstants.urlOrderBook;

@Component
@AllArgsConstructor
public class OrderBook {


    private RestTemplate restTemplate;

    public ResponseEntity<String> GetOrderBook(String symbol, int limit){
        ResponseEntity<String> response
                = restTemplate.getForEntity(urlOrderBook + "symbol="+ symbol +"&limit=" + limit, String.class);
        return response;
    }
}
