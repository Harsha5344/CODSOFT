import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CurrencyConverter {

    private static final Map<String, Double> exchangeRates = new HashMap<>();
    
    static {
        exchangeRates.put("USDEUR", 0.85);
        exchangeRates.put("USDGBP", 0.75);
        exchangeRates.put("USDINR", 74.0);
        
        
        exchangeRates.put("EURUSD", 1.18);
        exchangeRates.put("EURGBP", 0.88);
        exchangeRates.put("EURINR", 87.0);
        exchangeRates.put("GBPUSD", 1.33);
        exchangeRates.put("GBPEUR", 1.14);
        exchangeRates.put("GBPINR", 99.0);
        exchangeRates.put("INRUSD", 0.013);
        exchangeRates.put("INREUR", 0.011);
        exchangeRates.put("INRGBP", 0.010);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter base currency (e.g., USD, EUR, GBP, INR): ");
        String baseCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter target currency (e.g., USD, EUR, GBP, INR): ");
        String targetCurrency = scanner.nextLine().toUpperCase();
        System.out.print("Enter amount to convert: ");
        double amount = scanner.nextDouble();
        String rateKey = baseCurrency + targetCurrency;
        if (exchangeRates.containsKey(rateKey)) {
            double rate = exchangeRates.get(rateKey);
            double convertedAmount = amount * rate;
            System.out.printf("%.2f %s = %.2f %s%n", amount, baseCurrency, convertedAmount, targetCurrency);
        } else {
            System.out.println("Exchange rate for " + baseCurrency + " to " + targetCurrency + " not available.");
        }

        scanner.close();
    }
}

