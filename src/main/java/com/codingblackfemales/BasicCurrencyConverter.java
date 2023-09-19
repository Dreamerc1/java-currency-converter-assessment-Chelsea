package com.codingblackfemales;

import java.util.Arrays;
import java.util.Set;

public class BasicCurrencyConverter implements CurrencyConverter{

    private Currencies currencies;

    public BasicCurrencyConverter(Currencies currencies){
        this.currencies = currencies;
    }

    @Override
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) throws ExchangeRateUnavailable, InsufficientAmountEntered {
    // method that converts currencies from source code to destination code.
        try {

        Double sourceRate = currencies.getAllExchangeRates().get(sourceCurrencyCode);
        Double destinationRate = currencies.getAllExchangeRates().get(destinationCurrencyCode);
            if(Double.isNaN(amount)  || amount <= 0){
                System.out.println("Invalid request for conversion. Please enter an amount greater than 0.");
                // throw new InsufficientAmountEntered("Invalid request for conversion. Please enter an amount greater than 0.");
                return 0.0;
            }

        double convertedTransaction = 0;
            
            if(sourceRate == null || destinationRate == null){
                throw new ExchangeRateUnavailable("Exchange rate is unavailable for the currencies provided.");
            }else{
                convertedTransaction = amount * (destinationRate / sourceRate);
                // convertedTransaction = amount * getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
            return convertedTransaction;       
            }
       
        } catch (ExchangeRateUnavailable e) {
            System.out.println("We are unable to offer an exchange rate for this transaction.");
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public String[] getCurrencyCodes() {
       // gets the currency codes from the currenciesGBP class, meaning if currencies in class change. so will the getCurrencyCodes method.
        
        try {
            
                Set<String> keys = currencies.getAllExchangeRates().keySet();
                
                String[] currencyCodes = new String[keys.size()];
                int i = 0;
                for(String key: keys){
                    currencyCodes[i] = key;
                    i++;
                    
                }
                return currencyCodes;
    
        } catch (Exception e) {
            System.out.println("An exception has been logged");
            e.printStackTrace();
            return new String[0];
        }
    }

    @Override
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) throws ExchangeRateUnavailable{
        // method that gets given exchange rate 
        try {
            FindRates findRates = new FindRates();
            double destinationRate = findRates.findValue(destinationCurrencyCode);
            double sourceRate = findRates.findValue(sourceCurrencyCode);
           

            if(sourceCurrencyCode.isEmpty() || destinationCurrencyCode.isEmpty()){
                throw new ExchangeRateUnavailable("We are unable to offer an exchange rate for this transaction.");
            }

            double transactionExchangeRate = 0;
            // if(!sourceCurrencyCode.equals("GBP")){
            //     transactionExchangeRate = destinationRate;
            //     // return destinationRate;
            // }else{
                transactionExchangeRate = destinationRate/sourceRate;
            
             
            // return Double.parseDouble(String.format("%.2f", transactionExchangeRate));
            return transactionExchangeRate;
        } catch (Exception e){
            System.out.println("We are unable to provide an exchange rate for this transaction.");
            e.printStackTrace();
            return 0;
        } 
    }

     public void checkCode(String destinationCurrencyCode, String sourceCurrencyCode){
        // check if source code and destination code is available in the the currencies array.
        String[] currencyCodes = getCurrencyCodes();
        if(!Arrays.stream(currencyCodes).anyMatch(destinationCurrencyCode::equals)){
           throw new CountryCodeUnavailableException("I'm sorry the requested destination currency " +destinationCurrencyCode + " is not one that we currently carry. Please try another currency");
        } else if(!Arrays.stream(currencyCodes).anyMatch(sourceCurrencyCode ::equals)){
            throw new CountryCodeUnavailableException("I'm sorry the source currency " +sourceCurrencyCode + " is not currently supported. Please select another currency.");
        }
    }
}
