package binance.dto;

import lombok.Data;

@Data
public class MetadataDto {
    private String symbol;
    private double minQty;
    private double maxQty;
    private double minNotional;
    private int stepSize;
    private int  tickSize;
}
