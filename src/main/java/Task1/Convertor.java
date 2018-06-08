package Task1;

public class Convertor {

    public double converteUSD (double price, String currency) {

        ExchangeRate currentRate = new ExchangeRate();
        currentRate.setCurrentRate();

        double usdRate = currentRate.getUsdRate();
        double eurRate = currentRate.getEurRate();
        double gbpRate = currentRate.getGbpRate();

        if (currency.equalsIgnoreCase("GRN")) {
            double grnPrice = price * usdRate;
            return grnPrice;
        }
        if (currency.equalsIgnoreCase("EUR")) {
            double grnPrice = price * usdRate;
            double eurPrice = grnPrice / eurRate;
            return eurPrice;
        }
        if (currency.equalsIgnoreCase("GBP")) {
            double grnPrice = price * usdRate;
            double gbpPrice = grnPrice / gbpRate;
            return gbpPrice;
        } else {
            System.out.println("You`ve chosen wrong currency.");
        }
        return price;
    }
}
