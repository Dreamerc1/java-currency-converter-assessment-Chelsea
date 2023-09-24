/*The class houses the UI and handles rooting a majority of the logic for user interaction. In this program the user gets to make decisions several times including selecting whether they would like to use the original currency converter which meets the assessment brief or the live rate converter which has been implemented as my stretch goal. */

package com.codingblackfemales;

import java.util.Scanner;

public class UserInterface {
    public void startApp(){
        
        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicConverter = new BasicCurrencyConverter(currencies);
        Using using = new Using();
        Scanner scanner = new Scanner(System.in);
        UI ui = new UI();
        

       
        System.out.println("Welcome to the currency converter!\n");
        using.timeDelay(1000);

        System.out.println("Here are a list of the currencies codes currently available on the original converter\n");
        using.timeDelay(500);
        using.originalCurrencies(basicConverter);
        using.timeDelay(1250);

        System.out.println("Please note that other currencies may be available on our live rate converter, we can search for these rates when you make your selection.\n");
        using.timeDelay(400);

        using.selectConverter(scanner);        

        using.timeDelay(500);
        System.out.println("Please type the number of conversions you would like to make. You can convert a maximum number of 10 currencies at once. Note that for more than one conversion you will need to use the live rates converter\n");
        int numberOfConversions = scanner.nextInt();
        ui.checkAmount(numberOfConversions);
        scanner.nextLine();


        if(numberOfConversions != 1){
            scanner.nextLine();
            ui.startLiveConverter(numberOfConversions);
        }
        
        using.timeDelay(400);

        System.out.println("Please enter your chosen destination currency.");

        String destinationCurrencyCode = scanner.nextLine().toUpperCase();
        
        System.out.println("Please enter the code of the currency you wish to convert from.");
        String sourceCurrencyCode = scanner.nextLine().toUpperCase();

        //checks to see if location and destination codes are available in the original converter if user has selected this option.

 

        // logic for using the original currency converter.
        boolean destinationAvailable = basicConverter.checkCode(destinationCurrencyCode); 
        boolean sourceAvailable = basicConverter.checkCode(sourceCurrencyCode);

        using.ratesUnavailable(sourceAvailable, destinationAvailable, scanner);

        if(!sourceAvailable || !destinationAvailable){
        using.timeDelay(250);
        System.out.println("Would you like to search the live rate database?");
        using.timeDelay(500);
        System.out.println("Please type your answer yes or no");
                
            if(!using.checkRatesAPI(scanner).equalsIgnoreCase("yes")){
                        
                System.out.println("Thank you for using Currency Converter!");
                System.exit(0);
            }else{
                System.out.println("Please note these rates are live and may fluctuate hourly. Currency converter cannot guarantee a rate you may have seen earlier if you decide not to proceed with yor transaction.");
                ui.startLiveConverter(numberOfConversions);
            }
        }else{
        System.out.println("Please enter the amount that you would like to convert.");       
        double amount = scanner.nextDouble();
                   

            if(using.confirmTransaction(scanner, sourceCurrencyCode, sourceCurrencyCode, amount).equalsIgnoreCase("yes")){
                scanner.close();
                double transactionExchangeRate = basicConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
                using.timeDelay(250);
                String formatRate = String.format("%.2f", transactionExchangeRate);
                System.out.println("The exchange rate for this transaction is " + formatRate);
                double convertedCurrency = basicConverter.convertCurrency(sourceCurrencyCode, destinationCurrencyCode, amount);
                String formatTotal = String.format("%.2f", convertedCurrency);
                using.timeDelay(500);
                System.out.println("This amount converts to "+formatTotal +" "+ destinationCurrencyCode);
            } else {
                using.timeDelay(100);
                System.out.println("Apologies for the inconvenience, please start again.");
                System.exit(0);
            }
        }
    using.goodbye();
    }
}