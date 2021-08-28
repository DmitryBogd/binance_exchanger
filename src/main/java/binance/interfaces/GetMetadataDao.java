package binance.interfaces;

import binance.dto.metadata.SymbolsListDto;
import retrofit2.Call;
import retrofit2.http.GET;

public interface GetMetadataDao {

    @GET("/api/v3/exchangeInfo?symbols=[\"ETHBTC\",\"OMGETH\",\"LTCBTC\"]")
    Call<SymbolsListDto> getAllSymbolsDtoCall();
}
