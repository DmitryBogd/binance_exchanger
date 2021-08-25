package binance.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import static binance.constants.Сonstants.urlOrderBook;

@Component
public class OrderBook {
    private RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<String> GetOrderBook(String symbol, int limit){
        ResponseEntity<String> response
                = restTemplate.getForEntity(urlOrderBook + "symbol="+ symbol +"&limit=" + limit, String.class);
        System.out.println(response.getBody());
        return response;
    }
}
