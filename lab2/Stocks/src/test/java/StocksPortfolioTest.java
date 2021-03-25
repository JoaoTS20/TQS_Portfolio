import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class StocksPortfolioTest {

    //1.
    @Mock
    private IStockMarket stockMarket;

    //2.
    @InjectMocks
    private StocksPortfolio portfolio;

    @Test
    void getTotalValue() {

        //3.
        when(stockMarket.getPrice("Nike")).thenReturn(4.0);
        when(stockMarket.getPrice("Apple")).thenReturn(1.5);

        //4.
        portfolio.addStock(new Stock("Nike",2));
        portfolio.addStock(new Stock("Apple",4));
        double result =portfolio.getTotalValue();

        //5.
        //assertEquals(14.0,result);
        assertThat(result, is(14.0));
        verify(stockMarket, times(2)).getPrice(anyString());

    }
}