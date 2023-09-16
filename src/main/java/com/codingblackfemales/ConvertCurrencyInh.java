package com.codingblackfemales;

import com.codingblackfemales.Exceptions.ExchangeRateUnavailable;
import com.codingblackfemales.Exceptions.InsufficientAmountEntered;

public class ConvertCurrencyInh extends InheritedConverter{

    private double amount;
    
// do you need another variable that will show what the amount converts to? and use a getter to show it.
    public ConvertCurrencyInh(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
        super(sourceCurrencyCode, destinationCurrencyCode);
        this.setAmount(amount);
    }

    public double getAmount(){
        return amount;
    }

    public double setAmount(double amount){
        return this.amount = amount;
    }

    public double convertAmount(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
       double convertedTransaction = 0;
        try {
            CurrencyConverter currencyConverter = new CurrencyConverter();
              CurrenciesGBP currenciesGBP = new CurrenciesGBP();
              
               Double sourceRate = currenciesGBP.getAllExchangeRates().get(sourceCurrencyCode);
               Double destinationRate = currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
         
               if(amount <= 0){
            throw new InsufficientAmountEntered("Invalid request for conversion. Please enter an amount greater than 0.");
        }
              
               if(sourceRate == null || destinationRate == null){
                throw new ExchangeRateUnavailable("Exchange rate is unavailable for the currencies provided.");
               }else{
                convertedTransaction = amount * (destinationRate / sourceRate);
               return convertedTransaction;       
               }
        } catch (ExchangeRateUnavailable e) {
            System.out.println("We are unable to offer an exchage rate for tis transaction.");
            e.printStackTrace();
        }
        return convertedTransaction;
        
}
}