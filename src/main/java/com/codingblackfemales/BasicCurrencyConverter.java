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
    
                 try {
            // CurrencyConverter currencyConverter = new CurrencyConverter();
            CurrenciesGBP currenciesGBP = new CurrenciesGBP();
         
               if(amount <= 0){
            throw new InsufficientAmountEntered("Invalid request for conversion. Please enter an amount greater than 0.");
            }

            double convertedTransaction = 0;
            Double sourceRate = currenciesGBP.getAllExchangeRates().get(sourceCurrencyCode);
            Double destinationRate = currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
            
            if(sourceRate == null || destinationRate == null){
                throw new ExchangeRateUnavailable("Exchange rate is unavailable for the currencies provided.");
            }else{
                convertedTransaction = amount * (destinationRate / sourceRate);
            return convertedTransaction;       
            }
       
        } catch (ExchangeRateUnavailable e) {
            System.out.println("We are unable to offer an exchange rate for tis transaction.");
            e.printStackTrace();
            return 0.0;
        }
    }

    @Override
    public String[] getCurrencyCodes() {
       // gets the currency codes from the currenciesGBP class, meaning if currencies in class change. so will the getCurrencyCodes method.
        
        try {
            
                CurrenciesGBP currenciesgbp = new CurrenciesGBP();

                Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                
                String[] currencyCodes = new String[keys.size()];
                int i = 0;
                for(String key: keys){
                    currencyCodes[i] = key;
                    i++;
                    
                }
                System.out.println(Arrays.toString(currencyCodes));
                return currencyCodes;
    
        } catch (Exception e) {
            System.out.println("An exception has been logged");
            e.printStackTrace();
            return new String[0];
        }
    }

    @Override
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) throws ExchangeRateUnavailable{
        try {
            FindRates findRates = new FindRates();
            double destinationRate = findRates.findValue(destinationCurrencyCode);
            double sourceRate = findRates.findValue(sourceCurrencyCode.toUpperCase());
           

            if(sourceCurrencyCode.isEmpty() || destinationCurrencyCode.isEmpty()){
                throw new ExchangeRateUnavailable("We are unable to offer an exchange rate for this transaction.");
            }

            double transactionExchangeRate =  destinationRate/sourceRate;
            return Double.parseDouble(String.format("%.2f", transactionExchangeRate));
        } catch (Exception e){
            System.out.println("We are unable to provide an exchange rate for this transaction.");
            e.printStackTrace();
            return 0;
        } 
    }
}
