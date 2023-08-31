package com.codingblackfemales;

import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // System.out.println("Hello World!");
        CurrenciesGBP currenciesGBP = new CurrenciesGBP();

        String inputCode = "";

        String outputCode = "";

        boolean findCodeIn = currenciesGBP.getAllExchangeRates().containsKey(inputCode);

        boolean findCodeOut = currenciesGBP.getAllExchangeRates().containsKey(outputCode);

        Scanner scanner = new Scanner(System.in);

        System.out.println("Please enter your currency code.");

        inputCode = scanner.nextLine();

        System.out.println("Please enter the code of the currency you wish to convert to.");

        outputCode = scanner.nextLine();

        System.out.println("Please enter the amount that you would like to convert.");

        double amount = scanner.nextDouble();

        System.out.println("You would like to convert "+ inputCode, amount +" into " + outputCode+ ". Is this correct?");

        boolean transactionCorrect = scanner.nextBoolean();

        if(!transactionCorrect){
            System.out.println("Please start again.");
        }

        if(!findCodeIn){
        throw CountryCodeUnavailableException("The source code that you have entered is unavailable");
        System.out.println("I'm sorry, you have enetered a source code tha we do not convert from yet.");
        }

        if(!findCodeOut){
        throw CountryCodeUnavailableException("The destination code that you have entered is unavailable");
        System.out.println("I'm sorry, you have enetered a source code tha we do not convert from yet.");
        }

                // you need to build a constructor that gets the target excahnge rate 
                // CurrenciesGBP currenciesgbp = new CurrenciesGBP();
                // // System.out.println(currenciesgbp.getAllExchangeRates());

                // Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                // for(String key: keys){
                //     System.out.println(key);
                // }


                CurrencyConvert convert = new CurrencyConvert();
                // creating a new instance of currency converter
                convert.getCurrencyCodes();
                // invodes the method that gets the array of codes available from currency converter
                
                CurrenciesGBP currenciesGBP = new CurrenciesGBP();
                if (!currenciesGBP.getAllExchangeRates().containsKey(inputCode)){
                    // throws custom exception 
                    // ask to choose another code
                }
    }
}
