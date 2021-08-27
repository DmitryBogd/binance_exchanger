package binance.dto;

import lombok.Data;

@Data
public class MetadataDto {

    private String CurrencyPair;
    private String minBaseAmount;
    private String maxBaseAmount;
    private String minCounterAmount;
    private String basePrecision;
    private String counterPrecision;
}
