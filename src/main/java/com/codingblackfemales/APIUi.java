package com.codingblackfemales;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import com.codingblackfemales.exceptions.ExceededRequestLimit;
import com.codingblackfemales.exceptions.ExchangeRateUnavailable;

public class APIUi {

    String destinationCurrencyCode =  "";
    String sourceCurrencyCode = "";

    public void checkAmount(int numberOfConversions){
        try (Scanner scanner = new Scanner(System.in)) {
            if(numberOfConversions > 1 || numberOfConversions < 1){
                if(numberOfConversions > 10 || numberOfConversions < 1){
                System.out.println("I'm sorry, you have exceeded the number of legal request per search. please type a number less than 10");
                numberOfConversions = scanner.nextInt();
                scanner.nextLine();
                    if(numberOfConversions > 10 || numberOfConversions < 1){
                    throw new ExceededRequestLimit("An incorrect number of request");
                    }
                }
            }
        }
    }

     public void startLiveConverter(int numberOfConversions, Scanner scanner){
        clientInterractions using = new clientInterractions();
        ArrayList<String> conversions = new ArrayList<>();
        
        // Scanner scanner = new Scanner(System.in);

            for(int i = 0; i <= numberOfConversions; i++){
            
            
            System.out.println("Please enter your chosen destination currency.");
            destinationCurrencyCode = scanner.nextLine().toUpperCase();

            System.out.println("Please enter the code of the currency you wish to convert from.");
            sourceCurrencyCode = scanner.nextLine().toUpperCase();

            double transactionExchangeRate = 0.0;
            using.checkAPI(sourceCurrencyCode, sourceCurrencyCode);

            System.out.println("Please enter the amount that you would like to convert.");       
            double amount = scanner.nextDouble();

            using.checkAmount(amount);

            UseRatesAPI useAPI = new UseRatesAPI();
            // String formatRate = String.format("%.2f", transactionExchangeRate);
            // System.out.println("The live exchange rate for this transaction is " + formatRate+"%.");
            double apiConvertedCurrency = useAPI.apiConversion(transactionExchangeRate, amount);
            String formatTotal = String.format("%.2f", apiConvertedCurrency);
            String result = amount +" " +sourceCurrencyCode + " converts to "+formatTotal +" "+ destinationCurrencyCode;
            conversions.add(result);
            }

            for(String completeConversions : conversions){
                System.out.println(conversions);
                using.goodbye();
            }
        
            System.out.println("I'm sorry, we are having issues with our live rate system at the moment. Please try again later.");
            scanner.close();
        
    }
}