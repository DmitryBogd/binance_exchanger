import binance.dto.StatusExchangerDto;
import binance.interfaces.BinanceRepository;
import binance.jobs.CheckStatusJob;
import binance.services.BinaryAutoService;
import lombok.Data;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.when;

@Data
public class CheckStatusJobTest {

    @InjectMocks
    private CheckStatusJob classToTest;

    @Mock
    StatusExchangerDto statusExchangerDto;
    @Mock
    BinaryAutoService binaryAutoService;
    @Mock
    BinanceRepository binanceRepository;
    @Mock
    CheckStatusJob checkStatusJob;

    @Before
    public void preTestSetup()
    {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void CheckStatusJobWorkSuccess()
    {
        classToTest.checkStatus();
        statusExchangerDto.setStatus(1);
        when(binanceRepository.findMaxId()).thenReturn(statusExchangerDto);
        when(binanceRepository.save(statusExchangerDto));
    }

}
