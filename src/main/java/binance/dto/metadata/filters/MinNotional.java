package binance.dto.metadata.filters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class MinNotional {

    @SerializedName("minNotional")
    @Expose
    private String minCounterAmount;
}
