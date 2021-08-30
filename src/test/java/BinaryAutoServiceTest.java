import binance.exceptions.NoSuchSymbolException;
import binance.services.BinaryAutoService;
import org.junit.Test;
import java.io.IOException;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;


public class BinaryAutoServiceTest {
    private BinaryAutoService binaryAutoService = new BinaryAutoService();

    @Test
    public void getStatusNotNullValue(){
        assertThat(binaryAutoService.getStatus().getMsg(), notNullValue());
    }

    @Test
    public void getOrderBookNotNullValue() throws IOException {
        assertThat(binaryAutoService.getOrderBook("ETHBTC", 5).getAsks(), notNullValue());
    }


    @Test(expected = NoSuchSymbolException.class)
    public void getOrderBookThrowNoSuchSymbolException() throws IOException {
       binaryAutoService.getOrderBook("ERROR", 5);
    }

    @Test
    public void getMetadataNotNullValue() throws Exception {
        assertThat(binaryAutoService.getMetadata(), notNullValue());
    }
}
