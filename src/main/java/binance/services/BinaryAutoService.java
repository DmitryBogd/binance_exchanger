package binance.services;

import binance.dao.NetworkDao;
import binance.dto.*;
import binance.dto.MetadataDto;
import binance.exceptions.ThereIsNoSuchSymbolException;
import binance.interfaces.GetOrderBookDao;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static binance.constants.Сonstants.*;

@Component
@AllArgsConstructor
public class BinaryAutoService {

    private final RestTemplate restTemplate;


    public List<MetadataDto> getMetadata() throws Exception {
        NetworkDao networkDao = new NetworkDao();
//        Retrofit retrofit = new Retrofit.Builder()
//                .baseUrl("https://api.binance.com")
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        GetMetadateDAO getMetadateDAO = retrofit.create(GetMetadateDAO.class);
//
//       Call<SymbolsListDto> allSymbols =  getMetadateDAO.getAllSymbols();
//       Response<SymbolsListDto> execute = allSymbols.execute();
//       SymbolsListDto symbolsListDto = execute.body();
//       List<SymbolsDto> symbolsDto = symbolsListDto.getSymbols();
//       return symbolsDto;
//    --------------------------------------------------------------------------

        List<MetadataDto> metadataDtoList = new ArrayList<>();
        String rawJson = networkDao.request(urlExchangeInfo);
        //get json
        JSONObject root = new JSONObject(rawJson);
        //looking for an array "symbols" to choose jsonObject
        JSONArray symbols = root.getJSONArray("symbols");

        for(int i =0;i<symbols.length(); i++){
            MetadataDto metadata = new MetadataDto();
            //create json object to find variables: "status", "symbol" and array "filters"
           JSONObject jsonSymbol = symbols.getJSONObject(i);

           if(!jsonSymbol.getString("status").equals("TRADING")){}
           else {

               for (int k = 0; k < symbols.length(); k++) {
                   metadata.setCurrencyPair(jsonSymbol.getString("symbol"));
                   //looking for an array "filters" to choose jsonObject
                   JSONArray jsonFilters = jsonSymbol.getJSONArray("filters");

                   for (int j = 0; j < jsonFilters.length(); j++) {
                       //create a json object to search for metadata object variables
                       JSONObject jsonFilter = jsonFilters.getJSONObject(j);

                       for(int l=0; l<jsonFilter.length();l++) {
                           if (jsonFilter.has("tickSize")) {
                               metadata.setCounterPrecision(jsonFilter.getString("tickSize"));
                           }

                           if (jsonFilter.has("minQty")) {
                               metadata.setMinBaseAmount(jsonFilter.getString("minQty"));
                               metadata.setMaxBaseAmount(jsonFilter.getString("maxQty"));
                               metadata.setBasePrecision(jsonFilter.getString("stepSize"));
                           }

                           if (jsonFilter.has("minNotional")) {
                               metadata.setMinCounterAmount(jsonFilter.getString("minNotional"));
                           }
                       }
                   }

               }
               metadataDtoList.add(metadata);
           }
        }
        return metadataDtoList;

    }

    public OrderBookDto getOrderBook(String symbol, int limit) throws IOException {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.binance.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        GetOrderBookDao getOrderBookDao = retrofit.create(GetOrderBookDao.class);
        Call<OrderBookDto> orderBookDto =  getOrderBookDao.getOrderBook(limit,symbol);
        Response<OrderBookDto> execute = orderBookDto.execute();
        OrderBookDto orderBookDto1 = execute.body();
        return orderBookDto1;

    }

    public StatusExchangerDto getStatus() {
        StatusExchangerDto response = restTemplate.getForObject(urlStatus, StatusExchangerDto.class);
        assert response != null;
        if (response.getMsg() == null) {
            throw new ThereIsNoSuchSymbolException();
        }
        return response;
    }
}
