import binance.services.OrderBook;
import binance.services.StatusApi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static binance.constants.Сonstants.depthLimit;
import static binance.constants.Сonstants.depthSymbol;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;


public class OrderBookTest {

    @Test
    public void getOrderBookNotNullValueExpected() throws JsonProcessingException {

        RestTemplate restTemplate = new RestTemplate();
        OrderBook orderBook = new OrderBook(restTemplate);
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(orderBook.GetOrderBook(depthSymbol, depthLimit).getBody());

        JsonNode bids = root.path("lastUpdateId");
        assertThat(bids.asText(), notNullValue());
    }
}
