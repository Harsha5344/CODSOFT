import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class CurrencyConverter {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Select base currency (e.g. USD, EUR, JPY):");
        String baseCurrency = scanner.next().toUpperCase();

        System.out.println("Select target currency (e.g. USD, EUR, JPY):");
        String targetCurrency = scanner.next().toUpperCase();

        System.out.println("Enter amount to convert:");
        double amount = scanner.nextDouble();

        double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        double convertedAmount = amount * exchangeRate;

        System.out.println(amount + " " + baseCurrency + " = " + convertedAmount + " " + targetCurrency);
    }

    private static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
        URL url = new URL("(link unavailable)" + baseCurrency);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        int responseCode = connection.getResponseCode();
        if (responseCode != 200) {
            throw new Exception("Failed to fetch exchange rates");
        }

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        String response = reader.readLine();

        // Assuming the API response is in JSON format
        // You may need to parse the response according to the actual API format
        String exchangeRateString = response.split("\"" + targetCurrency + "\":")[1].split(",")[0];
        return Double.parseDouble(exchangeRateString);
    }
}

