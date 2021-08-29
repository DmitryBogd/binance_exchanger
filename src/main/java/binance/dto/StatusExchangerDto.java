package binance.dto;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="binance")
@ToString
public class StatusExchangerDto {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private int status;
    private String msg;

}