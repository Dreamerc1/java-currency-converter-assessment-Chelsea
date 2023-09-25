/*The class houses the UI and handles rooting a majority of the logic for user interaction. In this program the user gets to make decisions several times including selecting whether they would like to use the original currency converter which meets the assessment brief or the live rate converter which has been implemented as my stretch goal. */

package com.codingblackfemales;

import java.util.Scanner;

public class OriginalUI {
    public void startApp(int numberOfConversions){
        
        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicConverter = new BasicCurrencyConverter(currencies);
        clientInteractions interact = new clientInteractions();
        Scanner scanner = new Scanner(System.in);
        APIUi apiUI = new APIUi();
        
        interact.timeDelay(400);

        System.out.println("Please enter your chosen destination currency.");

        String destinationCurrencyCode = scanner.nextLine().toUpperCase();
        
        System.out.println("Please enter the code of the currency you wish to convert from.");
        String sourceCurrencyCode = scanner.nextLine().toUpperCase();

        //checks to see if location and destination codes are available in the original converter if user has selected this option.

        // logic for using the original currency converter.
        boolean destinationAvailable = basicConverter.checkCode(destinationCurrencyCode); 
        boolean sourceAvailable = basicConverter.checkCode(sourceCurrencyCode);

        interact.ratesUnavailable(sourceAvailable, destinationAvailable, scanner);

        if(!sourceAvailable || !destinationAvailable){
        interact.timeDelay(250);
        System.out.println("Would you like to search the live rate database?");
        interact.timeDelay(500);
        System.out.println("Please type your answer yes or no");
                
            if(!interact.checkRatesAPI(scanner).equalsIgnoreCase("yes")){
                        
                System.out.println("Thank you for using Currency Converter!");
                System.exit(0);
            }else{
                interact.warning();
                apiUI.startLiveConverter(numberOfConversions, scanner);
            }
        }else{
        System.out.println("Please enter the amount that you would like to convert.");       
        double amount = scanner.nextDouble();
                   

            if(interact.confirmTransaction(scanner, sourceCurrencyCode, sourceCurrencyCode, amount).equalsIgnoreCase("yes")){
                scanner.close();
                double transactionExchangeRate = basicConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
                interact.timeDelay(250);
                String formatRate = String.format("%.2f", transactionExchangeRate);
                System.out.println("The exchange rate for this transaction is " + formatRate);
                double convertedCurrency = basicConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);
                String formatTotal = String.format("%.2f", convertedCurrency);
                interact.timeDelay(500);
                System.out.println(amount +" "+ sourceCurrencyCode +" converts to "+formatTotal +" "+ destinationCurrencyCode);
                System.out.println(interact.goodbye());
                
            } else {
                interact.timeDelay(100);
                System.out.println("Apologies for the inconvenience, please start again.");
                System.exit(0);
            }
        }
    }
}