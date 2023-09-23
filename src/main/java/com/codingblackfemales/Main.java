package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;

// import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicConverter = new BasicCurrencyConverter(currencies);
        TimeDelay timeDelay = new TimeDelay();

        String sourceCurrencyCode = "";

        String destinationCurrencyCode = "";

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the currency converter!");

        timeDelay.timeDelay(1000);

        System.out.println("Here are a list of the currencies codes currently available");

        timeDelay.timeDelay(500);

        System.out.println(Arrays.toString(basicConverter.getCurrencyCodes()));

        timeDelay.timeDelay(1250);

        System.out.println("Please enter your chosen destination currency.");

        destinationCurrencyCode = scanner.nextLine().toUpperCase();

        boolean destinationAvailable = basicConverter.checkCode(destinationCurrencyCode);        

        System.out.println("Please enter the code of the currency you wish to convert from.");

        sourceCurrencyCode = scanner.nextLine().toUpperCase();

        boolean sourceAvailable = basicConverter.checkCode(sourceCurrencyCode);

        boolean traditionalRoute = true;

        double transactionExchangeRate = 0.0;

        if(!sourceAvailable || !destinationAvailable){
            traditionalRoute = false;
            timeDelay.timeDelay(500);

            if(!sourceAvailable && !destinationAvailable){
            System.out.println("I'm sorry, the rate for your source currency and destination currency are unavailable on the traditional currency converter at this time.");
            } else if(!sourceAvailable && destinationAvailable){ 
            traditionalRoute = false;
            System.out.println("I'm sorry, we cannot offer a rate for " + sourceCurrencyCode+ " on the traditional currency converter at this time.");
            } else if(!destinationAvailable && sourceAvailable){
            traditionalRoute = false;
            System.out.println("I'm sorry, we cannot offer a rate for " + destinationCurrencyCode+ " on the traditional currency converter at this time.");
            } 
        
                if(!traditionalRoute){
                timeDelay.timeDelay(250);
                System.out.println("Would you like to search the live rate database instead?");
                timeDelay.timeDelay(500);
                System.out.println("Please type your answer yes or no");
                String checkRatesAPI = scanner.next();

                    if(checkRatesAPI.equalsIgnoreCase("yes")){
                    timeDelay.timeDelay(500);
                    System.out.println("Please note these rates are live and may fluctuate hourly. Currency converter cannot guarantee a rate you may have seen earlier if you decide not to proceed with yor transaction.");
                    
                    try {
                        UseRatesAPI useAPI = new UseRatesAPI();
                        try {
                            transactionExchangeRate = useAPI.useApi(sourceCurrencyCode, destinationCurrencyCode);
                            // may wish to return here to as if they would like to proceed
                        } catch (ParseException e) {
                            timeDelay.timeDelay(250);
                            System.out.println("I'm sorry, a fatal error has occurred while retrieving data from API.");
                            e.printStackTrace();
                        }
                    } catch (ExchangeRateUnavailable e) {
                        timeDelay.timeDelay(250);
                        System.out.println("We are unable to obtain a live rate for you at the moment. Please try again later.");
                    }
            
                    }else{
                        timeDelay.timeDelay(400);
                        System.out.println("Thank you for using Currency Converter!");
                        System.exit(0);
                    }
                }
            }

            timeDelay.timeDelay(250);
            System.out.println("Please enter the amount that you would like to convert.");       

            double amount = scanner.nextDouble();

            String formatAmount = String.format("%.2f", amount);

            timeDelay.timeDelay(250);
            
            System.out.printf("You would like to convert %s %s into %s. Is this correct?\n", formatAmount, sourceCurrencyCode, destinationCurrencyCode);

            timeDelay.timeDelay(250);
            System.out.println("Please type yes or no");
        
            String transactionCorrect = scanner.next();
            scanner.close();

            if(!transactionCorrect.equalsIgnoreCase("yes")){
                timeDelay.timeDelay(100);
                System.out.println("Apologies for the inconvenience, please start again.");
                System.exit(0);
            }
            String formatRate = "";
            String formatTotal = "";

            if(!traditionalRoute){
                UseRatesAPI useAPI = new UseRatesAPI();
                timeDelay.timeDelay(250);
                formatRate = String.format("%.2f", transactionExchangeRate);
                System.out.println("The live exchange rate for this transaction is " + formatRate+"%.");
                double apiConvertedCurrency = useAPI.apiConversion(transactionExchangeRate, amount);
                formatTotal = String.format("%.2f", apiConvertedCurrency);
                timeDelay.timeDelay(500);
                System.out.println("This amount converts to "+formatTotal +" "+ destinationCurrencyCode);
            }else{
                transactionExchangeRate = basicConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
                timeDelay.timeDelay(250);
                formatRate = String.format("%.2f", transactionExchangeRate);
                System.out.println("The exchange rate for this transaction is " + transactionExchangeRate);
                double convertedCurrency = basicConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);
                formatTotal = String .format("%.2f", convertedCurrency);
                timeDelay.timeDelay(500);
                System.out.println("This amount converts to "+formatTotal +" "+ destinationCurrencyCode);
            }            

            timeDelay.timeDelay(600);
            System.out.println("We hope you enjoyed your experience with Currency Converter today!");
    }
}
