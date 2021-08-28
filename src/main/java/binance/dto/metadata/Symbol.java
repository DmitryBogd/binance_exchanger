package binance.dto.metadata;

import binance.dto.metadata.filters.MarketLotSize;
import binance.dto.metadata.filters.MinNotional;
import binance.dto.metadata.filters.PriceFilter;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Data
@ToString
public class Symbol {
    @Expose
    private String symbol;

    @Expose
    private MarketLotSize marketLotSize;

    @Expose
    private MinNotional minNotional;

    @Expose
    private PriceFilter priceFilter;
}
