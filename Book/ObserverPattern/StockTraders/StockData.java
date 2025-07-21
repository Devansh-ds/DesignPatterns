
import java.util.ArrayList;

public class StockData implements Subject {

    private ArrayList<Stock> stocks = new ArrayList<>();
    private ArrayList<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer o) {
        if (observers.contains(o)) {
            System.out.println("Observer already exist, " + o.toString());
        } else {
            observers.add(o);
        }
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for (Observer o : observers) {
            o.update(stocks);
        }
    }

    public ArrayList<Stock> geStocks() {
        return stocks;
    }

    public void addStock(Stock stock) {
        stocks.add(stock);
        notifyObserver();
    }

    public void removeStock(Stock stock) {
        stocks.remove(stock);
        notifyObserver();
    }

    public void changeStockPrice(String name, Double newPrice) {
        boolean stockExist = false;
        for (Stock stock : stocks) {
            if (stock.name.equals(name)) {
                stock.price = newPrice;
                stockExist = true;
            }
        }
        if (stockExist) {
            notifyObserver();
        } else {
            System.out.println("No stock existed with name: " + name);
        }
        
    }
    
}
