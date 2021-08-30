package binance.dto.metadata.filters;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class PriceFilter {

    @SerializedName("tickSize")
    @Expose
    private String counterPrecision;
}
