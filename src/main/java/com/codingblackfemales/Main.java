package com.codingblackfemales;

import java.util.Arrays;
import java.util.Scanner;

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

        System.out.println("Please enter the amount that you would like to convert.");       

        double amount = scanner.nextDouble();

        String formatAmount = String.format("%.2f", amount);
        
        System.out.printf("You would like to convert %s %s into %s. Is this correct?\n", formatAmount, sourceCurrencyCode, destinationCurrencyCode);

        System.out.println("Please type yes or no");
        
        String transactionCorrect = scanner.next();

        if(!transactionCorrect.equalsIgnoreCase("yes")){
            System.out.println("Please start again.");
        }

        double transactionExchangeRate = basicConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);

        System.out.println("The exchange rate for this transaction is " + transactionExchangeRate);

        double convertedCurrency = basicConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);

        String formatTotal = String .format("%.2f", convertedCurrency);
        System.out.println("This amount converts to "+formatTotal +" "+ destinationCurrencyCode);

        scanner.close();
    }
}
