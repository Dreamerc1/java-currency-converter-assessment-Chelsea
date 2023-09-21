package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;
import com.codingblackfemales.exchangeRateAPI.UnavailableExchangeRateException;

public class UseRatesAPI {
   
    private OpenExchangeRates openExchangeRates;

    public UseRatesAPI(){
         
    }

    public OpenExchangeRates useRatesAPI(){
        return openExchangeRates;
    }

    public BigDecimal findRatesInAPI(String checkCode){
        
                    // openExchangeRates.currency(checkCode);
        try{
            BigDecimal rate = openExchangeRates.latest().get(checkCode);
                    
        
                if(rate != null){
                    
                    return rate;
                }else{
                    System.out.println("I'm sorry, we are unable to provide details for that code.");                        return 0.0;
                }
                        
        } catch ( UnavailableExchangeRateException e) {
            System.out.println("I'm sorry, we are unable to provide details for that code.");
            e.printStackTrace();
            
        }                    
                    
    }

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) throws ExchangeRateUnavailable{
        // method that gets given exchange rate 
        OpenExchangeRates openExchangeRates = new OpenExchangeRates(destinationCurrencyCode);
        try {
            
            BigDecimal destinationRate = openExchangeRates.currency(destinationCurrencyCode);
            BigDecimal sourceRate = openExchangeRates.currency(sourceCurrencyCode);
           

            if(sourceCurrencyCode.isEmpty() || destinationCurrencyCode.isEmpty()){
                throw new ExchangeRateUnavailable("You have not requested a valid currency to convert, We are unable to offer an exchange rate for this transaction.");
            }

               double transactionExchangeRate = destinationRate.doubleValue()/sourceRate.doubleValue();
            
            // return Double.parseDouble(String.format("%.2f", transactionExchangeRate));
            return transactionExchangeRate;
        } catch (Exception e){
            System.out.println("We are unable to provide an exchange rate for this transaction.");
            e.printStackTrace();
            return 0;
        } 
    }
}
