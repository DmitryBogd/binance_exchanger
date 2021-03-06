package binance.services;

import binance.deserializers.SymbolListDtoDeserializer;
import binance.dto.*;
import binance.dto.metadata.SymbolsListDto;
import binance.exceptions.NoSuchSymbolException;
import binance.interfaces.GetOrderBookDao;
import binance.jobs.CheckStatusJob;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.net.URL;


@Component
public class BinaryAutoService {
    private final Logger logger = LoggerFactory.getLogger(CheckStatusJob.class);

    public SymbolsListDto getMetadata() throws Exception {
        String requestURL = "https://api.binance.com/api/v3/exchangeInfo";
        URL BinanceRequest = new URL(requestURL);
        JSONTokener tokener = new JSONTokener(BinanceRequest.openStream());
        JSONObject root = new JSONObject(tokener);
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(SymbolsListDto.class, new SymbolListDtoDeserializer());
        Gson gson = builder.create();

        SymbolsListDto results = gson.fromJson(String.valueOf(root), SymbolsListDto.class);
        return results;

    }

    public OrderBookDto getOrderBook(String symbol, int limit) throws IOException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.binance.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetOrderBookDao getOrderBookDao = retrofit.create(GetOrderBookDao.class);
        Call<OrderBookDto> orderBookDtoCall =  getOrderBookDao.getOrderBook(limit,symbol);
        Response<OrderBookDto> execute = orderBookDtoCall.execute();
        OrderBookDto orderBookDto = execute.body();
        if(orderBookDto == null){
            logger.error("Introduced non-existent symbol");
            throw new NoSuchSymbolException();
        }
        return orderBookDto;

    }

    public StatusExchangerDto getStatus() {
        RestTemplate restTemplate = new RestTemplate();
        StatusExchangerDto response = restTemplate.getForObject("https://api.binance.com/sapi/v1/system/status", StatusExchangerDto.class);
        assert response != null;
        return response;
    }
}
