package binance.interfaces;

import binance.dto.OrderBookDto;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface GetOrderBookDao{


    @GET("/api/v1/depth?")
    Call<OrderBookDto> getOrderBook(@Query("limit") int limit, @Query("symbol") String symbol);
}
