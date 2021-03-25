import java.util.ArrayList;
import java.util.List;

public class StocksPortfolio {
    private String name;
    private IStockMarket stockMarket;
    private List<Stock> stocks;

    public StocksPortfolio() {
        this.stocks = new ArrayList<>();
    }

    public IStockMarket getMarketService(){
        return this.stockMarket;
    }

    public void setMarketService(IStockMarket newMarket){
        this.stockMarket = newMarket;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String newName){
        this.name = newName;
    }

    public double getTotalValue(){
        double total = 0;

        for(Stock stock : this.stocks){
            total += (stock.getQuantity() *stockMarket.getPrice(stock.getName()) );
        }
        return total;
    }

    public void addStock(Stock newStock){
        this.stocks.add(newStock);
    }



}
