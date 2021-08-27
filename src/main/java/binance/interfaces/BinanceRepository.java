package binance.interfaces;

import binance.dto.StatusExchangerDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BinanceRepository extends CrudRepository<StatusExchangerDto, Integer> {
    @Query(value = "Select * FROM binance WHERE id=(SELECT MAX(id) FROM binance)", nativeQuery = true)
    StatusExchangerDto findMaxId();
}
