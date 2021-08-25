package binance.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class StatusExchangerDto {
    private int status;
    private String msg;

    public StatusExchangerDto(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public StatusExchangerDto(){
    }

}