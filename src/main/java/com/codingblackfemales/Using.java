package com.codingblackfemales;

import java.util.Arrays;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.json.simple.parser.ParseException;

import com.codingblackfemales.exceptions.ExchangeRateUnavailable;
import com.codingblackfemales.exceptions.InsufficientAmountEntered;

public class Using {
   
    private String sourceCurrencyCode;
    private String destinationCurrencyCode;
    private double amount;

    public void usability(TimeDelay timeDelay, String destinationCurrencyCode, String sourceCurrencyCode, double amount ){
        
        this.destinationCurrencyCode = destinationCurrencyCode;
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.amount = amount;
    }

    public void timeDelay(int milliseconds){
        try {
        TimeUnit.MILLISECONDS.sleep(milliseconds); 
        } catch (InterruptedException e) {
            System.out.println("Time delay failed to execute");
            e.printStackTrace();
        }
    }

    protected void originalCurrencies(BasicCurrencyConverter basicConverter) {
        System.out.println(Arrays.toString(basicConverter.getCurrencyCodes()));
    }

    public boolean selectConverter(Scanner scanner) {
        boolean originalRoute = true;
        System.out.println("Would you like to use the original currency converter or the live rate currency converter?");
            this.timeDelay(250);
            System.out.println();
            System.out.println("please select 1 for the original converter and 2 for the live rate converter.");
        
            int selectConverter = scanner.nextInt();
            scanner.nextLine();
            if(!(selectConverter == 1 || selectConverter == 2)){
                    System.out.println("I'm sorry you have made an invalid selection. Please start again");
                    System.exit(0);
                }else if(selectConverter == 2){
                    originalRoute = false;
                }else{
                    originalRoute = true;
                }
                return originalRoute;
        }

    public void ratesUnavailable(boolean sourceAvailable, boolean destinationAvailable, Scanner scanner) {
        if (!sourceAvailable && !destinationAvailable) {
            System.out.println("I'm sorry, the rate for your source currency and destination currency are unavailable on the original currency converter at this time.");
        } else if (!sourceAvailable) {
            System.out.println("I'm sorry, we cannot offer a rate for your source currency on the original currency converter at this time.");
        } else if (!destinationAvailable) {
            System.out.println("I'm sorry, we cannot offer a rate for your destination currency on the original currency converter at this time.");
        }
    }

    public String checkRatesAPI(Scanner scanner){
            String checkRatesAPI = scanner.next();
            return checkRatesAPI;
    }

    public double checkAPI(String sourceCurrencyCode, String destinationCurrencyCode){
        double transactionExchangeRate = 0.0;
        try {
            UseRatesAPI useAPI = new UseRatesAPI();
                try {
                    transactionExchangeRate = useAPI.useApi(sourceCurrencyCode, destinationCurrencyCode);
                } catch (ParseException e) {
                    timeDelay(250);
                    System.out.println("I'm sorry, a fatal error has occurred while retrieving data from API.");
                    e.printStackTrace();
                }
            } catch (ExchangeRateUnavailable e) {
                timeDelay(250);
                System.out.println("We are unable to obtain a live rate for you at the moment. Please try again later.");
            }
            return transactionExchangeRate;
        }

        public void checkAmount(double amount){
            if ( amount < 0) {
                System.out.println("Invalid request for conversion. Your input amount should be greater than 0.");
                throw new InsufficientAmountEntered("Invalid request for conversion. Please enter an amount greater than 0.");
                
            }
        }

        public String confirmTransaction(Scanner scanner, String sourceCurrencyCode, String destinationCurrencyCode, double amount){
            String formatAmount = String.format("%.2f", amount);
            System.out.printf("You would like to convert %s %s into %s. Is this correct?\n", formatAmount, sourceCurrencyCode, destinationCurrencyCode);
            System.out.println("Please type yes or no");
            String transactionCorrect = scanner.next();
            return transactionCorrect;
        }

        public String goodbye(){
            timeDelay(600);
            
            return "We hope you enjoyed your experience with Currency Converter today!";
        }

}
