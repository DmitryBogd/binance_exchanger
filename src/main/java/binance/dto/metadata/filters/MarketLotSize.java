package binance.dto.metadata.filters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MarketLotSize {

    @SerializedName("minQty")
    @Expose
    private String minBaseAmount;
    @SerializedName("maxQty")
    @Expose
    private String maxBaseAmount;
    @SerializedName("stepSize")
    @Expose
    private String basePrecision;
}
