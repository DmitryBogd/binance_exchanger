package binance.dto;

import lombok.Data;

@Data
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