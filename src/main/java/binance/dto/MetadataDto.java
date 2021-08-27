package binance.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
public class MetadataDto {

    private String CurrencyPair;
    private String minBaseAmount;
    private String maxBaseAmount;
    private String minCounterAmount;
    private String basePrecision;
    private String counterPrecision;
}
