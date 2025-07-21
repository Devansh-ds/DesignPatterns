import java.util.ArrayList;

public class MobileTrader implements Observer {

    private ArrayList<Stock> stocks = new ArrayList<>();
    private Subject stockData;

    @Override
    public void update(ArrayList<Stock> updateStocks) {
       stocks = updateStocks;
       display();
    }

    public MobileTrader(StockData stockData) {
        this.stockData = stockData;
        this.stocks = stockData.geStocks();
        display();
        stockData.addObserver(this);
    }

    public void display() {
        System.out.println("Stocks updated: ");
        for(Stock stock: stocks) {
            System.out.println(stock.name + ": " + stock.price);
        }
    }
    
}
