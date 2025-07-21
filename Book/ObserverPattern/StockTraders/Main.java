public class Main {
    public static void main(String[] args) {
        StockData stockData = new StockData();
        Stock s1 = new Stock("APPLE", 43.56);
        Stock s2 = new Stock("GOOGLE", 23.66);
        Stock s3 = new Stock("TESLA", 11.99);
        Stock s4 = new Stock("dfa", 11.99);
        stockData.addStock(s1);

        MobileTrader t1 = new MobileTrader(stockData);

        stockData.addStock(s2);
        stockData.addStock(s3);
        stockData.removeStock(s2);

        // MobileTrader t2 = new MobileTrader(stockData);

        stockData.addStock(s4);
        stockData.changeStockPrice(s4.name, 70.34);

    }
}