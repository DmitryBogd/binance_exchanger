import binance.deserializers.SymbolListDtoDeserializer;
import binance.dto.metadata.Symbol;
import binance.dto.metadata.SymbolsListDto;
import binance.dto.metadata.filters.MarketLotSize;
import binance.dto.metadata.filters.MinNotional;
import binance.dto.metadata.filters.PriceFilter;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.Test;

import static constants.Constants.metadataTest;
import static constants.Constants.metadataTestCheckAnswer;
import static org.hamcrest.CoreMatchers.notNullValue;
import static org.hamcrest.MatcherAssert.assertThat;

public class SymbolListDtoDeserializerTest {

    @Test
    public void SymbolListDtoDeserializerReturnNotNull(){
        JSONObject root = new JSONObject(metadataTest);
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(SymbolsListDto.class, new SymbolListDtoDeserializer());
        Gson gson = builder.create();

        SymbolsListDto results = gson.fromJson(String.valueOf(root), SymbolsListDto.class);
        assertThat(results, notNullValue());
    }

    @Test
    public void SymbolListDtoDeserializerReturnCorrectAnswer(){

        JSONObject root = new JSONObject(metadataTest);
        GsonBuilder builder = new GsonBuilder();

        builder.registerTypeAdapter(SymbolsListDto.class, new SymbolListDtoDeserializer());
        Gson gson = builder.create();

        SymbolsListDto results = gson.fromJson(String.valueOf(root), SymbolsListDto.class);
        Assert.assertEquals(results.toString(), metadataTestCheckAnswer);
    }
}
