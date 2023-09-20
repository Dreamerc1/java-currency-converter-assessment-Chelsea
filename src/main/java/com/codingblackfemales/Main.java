package com.codingblackfemales;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Properties;
import java.util.Scanner;

import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;

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

        System.out.println("Please enter the code of the currency you wish to convert from.");

        sourceCurrencyCode = scanner.nextLine().toUpperCase();

        basicConverter.checkCode(destinationCurrencyCode, sourceCurrencyCode);
        
        if(!basicConverter.checkCode(destinationCurrencyCode, sourceCurrencyCode)){
            // if basic currency converter does not carry the code that triggered. User gets the option to use a live rate generatin api.
            System.out.println(basicConverter.checkCode(destinationCurrencyCode, sourceCurrencyCode));
            System.out.println("Would you like to search the live rate database instead?");
            System.out.println("Please type your answer yes or no");
            String checkRatesAPI = scanner.next();
            UseRatesAPI checkAPI = new UseRatesAPI();
            double APISourceRate = 0.0;
            double APIDestinationRate = 0.0;

                if(checkRatesAPI.equalsIgnoreCase("yes") && basicConverter.checkCode(destinationCurrencyCode, sourceCurrencyCode).equals(false)){
                    APISourceRate = checkAPI.useRatesAPI(sourceCodeAvailable);
                    
                }else if(checkRatesAPI.equalsIgnoreCase("yes") && destinationCurrencyCode.equals(false)){
                    APIDestinationRate = checkAPI.useRatesAPI(destinationCodeAvailable);
                
                }else if(checkRatesAPI.equalsIgnoreCase("yes") && both.equals(false)){
                APIDestinationRate = checkAPI.useRatesAPI(destinationCodeAvailable);
                APISourceRate = checkAPI.useRatesAPI(sourceCodeAvailable);
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

        double transactionExchangeRate = basicConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);

        System.out.println("The exchange rate for this transaction is " + transactionExchangeRate);

        double convertedCurrency = basicConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);

        String formatTotal = String .format("%.2f", convertedCurrency);
        System.out.println("This amount converts to "+formatTotal +" "+ destinationCurrencyCode);

        // have a look at putting timers on rate before they expire
        // indicitaive rate is ...

        scanner.close();
    }
}
