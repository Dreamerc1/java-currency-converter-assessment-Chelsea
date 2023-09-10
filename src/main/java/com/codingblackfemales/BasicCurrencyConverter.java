package com.codingblackfemales;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import com.codingblackfemales.CurrenciesGBP;


public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        // CurrenciesGBP currenciesGBP = new CurrenciesGBP();
        CurrencyConverter currencyConverter = new CurrencyConverter();
        String sourceCurrencyCode = "";

        String destinationCurrencyCode = "";

        // boolean findCodeIn = currenciesGBP.getAllExchangeRates().containsKey(sourceCurrencyCode);

        // boolean findCodeOut = currenciesGBP.getAllExchangeRates().containsKey(destinationCurrencyCode);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Here are a list of the currencies codes currently available");

        System.out.println(currencyConverter.getCurrencyCodes());

        System.out.println("Please enter your chosen destination currency.");

        destinationCurrencyCode = scanner.nextLine().toUpperCase();

        System.out.println("Please enter the code of the currency you wish to convert from.");

        sourceCurrencyCode = scanner.nextLine().toUpperCase();

        System.out.println("Please enter the amount that you would like to convert.");

        double amount = scanner.nextDouble();

        // System.out.printf("You would like to convert "+ Currency, amount +" into " + destinationCurrencyCode+ ". Is this correct?");

        String formatAmount = String.format("%.2f", amount);
        
        System.out.printf("You would like to convert %s %s into %s. Is this correct?\n", formatAmount, sourceCurrencyCode, destinationCurrencyCode);

        System.out.println("Please type yes or no");
        
        String transactionCorrect = scanner.next();

        

        if(!transactionCorrect.equalsIgnoreCase("yes")){
            System.out.println("Please start again.");
        }
        // System.out.printf("The exchange rate we can offer you for this transaction is %s " + currencyConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode)+"%.");
        System.out.println("The exchange rate we can offer you for this transaction is " + currencyConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode) + "%." );

        System.out.println("This amount converts to " + currencyConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount));
        // if(!findCodeIn){
        // throw CountryCodeUnavailableException("The source code that you have entered is unavailable");
        // System.out.println("I'm sorry, you have enetered a source code tha we do not convert from yet.");
        // }

        // if(!findCodeOut){
        // throw CountryCodeUnavailableException("The destination code that you have entered is unavailable");
        // System.out.println("I'm sorry, you have enetered a source code tha we do not convert from yet.");
        // }

                // you need to build a constructor that gets the target excahnge rate 
                // CurrenciesGBP currenciesgbp = new CurrenciesGBP();
                // // System.out.println(currenciesgbp.getAllExchangeRates());

                // Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                // for(String key: keys){
                //     System.out.println(key);
                // }


                // CurrencyConverter convert = new CurrencyConverter();
                // // creating a new instance of currency converter
                // convert.getCurrencyCodes();
                // // invodes the method that gets the array of codes available from currency converter
                
                // // if (!currenciesGBP.getAllExchangeRates().containsKey(sourceCurrencyCode)){
                // //     // throws custom exception 
                // //     // ask to choose another code
                // // }
    }
}
