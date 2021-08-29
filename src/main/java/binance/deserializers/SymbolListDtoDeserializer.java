package binance.deserializers;

import binance.dto.metadata.Symbol;
import binance.dto.metadata.SymbolsListDto;
import binance.dto.metadata.filters.MarketLotSize;
import binance.dto.metadata.filters.MinNotional;
import binance.dto.metadata.filters.PriceFilter;
import com.google.gson.*;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class SymbolListDtoDeserializer implements JsonDeserializer<SymbolsListDto> {

    @Override
    public SymbolsListDto deserialize(JsonElement jsonElement, Type type, JsonDeserializationContext jsonDeserializationContext) throws JsonParseException {
        SymbolsListDto symbolsListDto = new SymbolsListDto();
        List<Symbol> symbolList = new ArrayList<>();
        JsonArray typeObj = (JsonArray) jsonElement
                .getAsJsonObject().get("symbols");

        for (int i =0; i<typeObj.size();i++){
            JsonArray filters = (JsonArray) typeObj.get(i).getAsJsonObject().get("filters");

            if(typeObj.get(i).getAsJsonObject().get("status").toString().equals("\"TRADING\"")){
                Symbol symbol = new Symbol();
                symbol.setSymbol(typeObj.get(i).getAsJsonObject().get("symbol").toString());

               for (int j=0;j<filters.size();j++) {
                   JsonObject filter = filters.get(j).getAsJsonObject();
                   JsonElement filterElement = filters.get(j).getAsJsonObject().get("filterType");
                   String filterType = filterElement.getAsString();

                   switch (filterType) {

                       case "MARKET_LOT_SIZE":
                           MarketLotSize marketLotSize = jsonDeserializationContext.deserialize(filter, MarketLotSize.class);
                           symbol.setMarketLotSize(marketLotSize);
                           break;

                       case "MIN_NOTIONAL":
                           MinNotional minNotional = jsonDeserializationContext.deserialize(filter, MinNotional.class);
                           symbol.setMinNotional(minNotional);
                           break;

                       case "PRICE_FILTER":
                           PriceFilter priceFilter = jsonDeserializationContext.deserialize(filter, PriceFilter.class);
                           symbol.setPriceFilter(priceFilter);
                           break;
                   }
               }
                symbolList.add(symbol);
           }
        }
        symbolsListDto.setSymbols(symbolList);
        return symbolsListDto;
    }
}
