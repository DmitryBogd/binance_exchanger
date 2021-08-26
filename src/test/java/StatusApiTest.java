import binance.services.StatusApi;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.junit.Assert.assertThat;

public class StatusApiTest {


    @Test
    public void getStatusNotNullValueExpected(){
        RestTemplate restTemplate = new RestTemplate();
        StatusApi statusApi = new StatusApi(restTemplate);
        assertThat(statusApi.getStatus().getMsg(), notNullValue());
        assertThat(statusApi.getStatus().getStatus(), is(0));
    }
}
