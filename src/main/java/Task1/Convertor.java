package Task1;

public class Convertor {

    ExchangeRate currentRate;

    public double converteUSD (double price, String currency) {

        this.currentRate = new ExchangeRate();
        this.currentRate.setCurrentRate();

        double usdRate = this.currentRate.getUsdRate();
        double eurRate = this.currentRate.getEurRate();
        double gbpRate = this.currentRate.getGbpRate();

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
