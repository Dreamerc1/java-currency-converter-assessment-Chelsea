package com.codingblackfemales;

import java.util.Scanner;

import com.codingblackfemales.exceptions.ExceededRequestLimit;
import com.codingblackfemales.exceptions.InsufficientAmountEntered;

public class UI {

    public void checkAmount(int numberOfConversions){
        try (Scanner scanner = new Scanner(System.in)) {
            if(numberOfConversions > 1 || numberOfConversions < 1){
            
                if(numberOfConversions > 10 || numberOfConversions < 1){
                System.out.println("I'm sorry, you have exceeded the number of legal request per search. please type a number less than 10");
                numberOfConversions = scanner.nextInt();
                    if(numberOfConversions > 10 || numberOfConversions < 1){
                    throw new ExceededRequestLimit("An incorrect number of request");
                    }
                }
            }
        }
        }

     public void startLiveConverter(int numberOfConversions){
        Using using = new Using();
        try (Scanner scanner = new Scanner(System.in)) {
            for(int i = 0; i <= numberOfConversions; i++){

            System.out.println("Please enter your chosen destination currency.");
            String destinationCurrencyCode = scanner.nextLine().toUpperCase();

            System.out.println("Please enter the code of the currency you wish to convert from.");
            String sourceCurrencyCode = scanner.nextLine().toUpperCase();

            double transactionExchangeRate = 0.0;
            using.checkAPI(sourceCurrencyCode, sourceCurrencyCode);

            System.out.println("Please enter the amount that you would like to convert.");       
            double amount = scanner.nextDouble();

            UseRatesAPI useAPI = new UseRatesAPI();
            using.timeDelay(250);
            String formatRate = String.format("%.2f", transactionExchangeRate);
            System.out.println("The live exchange rate for this transaction is " + formatRate+"%.");
            double apiConvertedCurrency = useAPI.apiConversion(transactionExchangeRate, amount);
            String formatTotal = String.format("%.2f", apiConvertedCurrency);
            using.timeDelay(500);
            String result = amount +" " +sourceCurrencyCode + " converts to "+formatTotal +" "+ destinationCurrencyCode;
            }
        } catch (InsufficientAmountEntered e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        

         // depending on which converter the user has chosen we use a different class and method to convert their currency.
             

            using.timeDelay(600);
            System.out.println("We hope you enjoyed your experience with Currency Converter today!");
    
}

    public void checkAmount() {
    }
}