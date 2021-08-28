package binance.dto.metadata;

import binance.dto.metadata.filters.MarketLotSize;
import binance.dto.metadata.filters.MinNotional;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class SymbolsListDto {

    @SerializedName("symbols")
    @Expose
    private List<Symbol> symbols = null;

}
