import binance.services.BinaryAutoService;
import lombok.AllArgsConstructor;
import org.junit.Before;
import org.junit.Test;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;

import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

@AllArgsConstructor
public class BinaryAutoServiceTest {
    private final BinaryAutoService binaryAutoService = new BinaryAutoService();

    @Test
    public void getStatusNotNullValue(){
        assertThat(binaryAutoService.getStatus().getMsg(), notNullValue());
    }

    @Test
    public void getOrderBookNotNullValue() throws IOException {
        assertThat(binaryAutoService.getOrderBook("ETHBTC", 5).getAsks(), notNullValue());
    }

    @Test
    public void getMetadataNotNullValue() throws Exception {
        assertThat(binaryAutoService.getMetadata(), notNullValue());
    }
}
