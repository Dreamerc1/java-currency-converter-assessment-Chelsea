package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

// import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicConverter = new BasicCurrencyConverter(currencies);

        String sourceCurrencyCode = "";

        String destinationCurrencyCode = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Here are a list of the currencies codes currently available");

        System.out.println(Arrays.toString(basicConverter.getCurrencyCodes()));

        System.out.println("Please enter your chosen destination currency.");

        destinationCurrencyCode = scanner.nextLine().toUpperCase();

        boolean destinationAvailable = basicConverter.checkCode(destinationCurrencyCode);        

        System.out.println("Please enter the code of the currency you wish to convert from.");

        sourceCurrencyCode = scanner.nextLine().toUpperCase();

        boolean sourceAvailable = basicConverter.checkCode(sourceCurrencyCode);

        boolean traditionalRoute = true;

        UseRatesAPI useRatesAPI = new UseRatesAPI();

        if(!sourceAvailable || !destinationAvailable){
            traditionalRoute = false;
            System.out.println("I'm sorry, the rate for your source currency or destination currency are unavailable on the traditional currency converter at this time.");
            System.out.println("Would you like to search the live rate database instead?");
            System.out.println("Please type your answer yes or no");
            String checkRatesAPI = scanner.next();
            

                if(checkRatesAPI.equalsIgnoreCase("yes")){
                    
                    String configFilePath = "src/config.properties";
                    
                        try (FileInputStream propsInput = new FileInputStream("src/main/java/com/codingblackfemales/config.properties")) {
                            Properties prop = new Properties();
                            prop.load(propsInput);

                            // OpenExchangeRates openExchangeRates = new OpenExchangeRates(prop.getProperty("app_id"));
                            

                                // BigDecimal APISourceRate = useRatesAPI.findRatesInAPI(sourceCurrencyCode);
                                // double returnedSource = APISourceRate.doubleValue();
                                
                                // BigDecimal APIDestinationRate = useRatesAPI.findRatesInAPI(destinationCurrencyCode);
                                // double returnedDestination = APIDestinationRate.doubleValue();

                               double exRate =  useRatesAPI.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);

                               System.out.println("ex rate is "+ exRate);
                                // System.out.println("returned rates are source:" + returnedSource + "returned destination:" + returnedDestination );

                                
                        }catch(ExchangeRateUnavailable | IOException e){
                            System.out.println("We are unable to obtain a live rate for you at the moment. Please try again later.");
                            e.printStackTrace();
                        }


        // check if source and destination code are available

        


        // if eaither code is not available throw the else asking if they would like to check live rate converter.


        
            // double APISourceRate = 0.0;
            // double APIDestinationRate = 0.0;
            // this may be able to go

                
// think about if you would like to build the rest of the method here or in useRatesAPI

                    
                    
                }else{
                    System.out.println("Thank you for using CBF Currency Converter!");
                    System.exit(0);
                }
        }

        System.out.println("Please enter the amount that you would like to convert.");       

        double amount = scanner.nextDouble();

        String formatAmount = String.format("%.2f", amount);
        
        System.out.printf("You would like to convert %s %s into %s. Is this correct?\n", formatAmount, sourceCurrencyCode, destinationCurrencyCode);

        System.out.println("Please type yes or no");
        
        String transactionCorrect = scanner.next();

        if(!transactionCorrect.equalsIgnoreCase("yes")){
            System.out.println("Please start again.");
            System.exit(0);
        }

        double transactionExchangeRate = 0.0;
        if(!traditionalRoute){
            transactionExchangeRate = useRatesAPI.getExchangeRate(transactionCorrect, transactionCorrect);
        }
        transactionExchangeRate = basicConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);

        System.out.println("The exchange rate for this transaction is " + transactionExchangeRate);

        double convertedCurrency = basicConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);

        String formatTotal = String .format("%.2f", convertedCurrency);
        System.out.println("This amount converts to "+formatTotal +" "+ destinationCurrencyCode);

        // have a look at putting timers on rate before they expire
        // indicitaive rate is ...

        scanner.close();
    }
}
