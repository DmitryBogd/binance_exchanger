package binance.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.util.List;

@Data
public class OrderBookDto {
    @SerializedName("lastUpdateId")
    @Expose
    private Long lastUpdateId;
    @SerializedName("bids")
    @Expose
    private List<List<String>> bids = null;
    @SerializedName("asks")
    @Expose
    private List<List<String>> asks = null;

}
