package com.codingblackfemales;

import com.codingblackfemales.Exceptions.CountryCodeUnavailableException;
import com.codingblackfemales.Exceptions.ExchangeRateUnavilable;

public class FindRates {
    public Double findValue(String checkCodeGetValue){
        // method will use binary search to find the value in the key value pair of the currency codes array.
        CurrenciesGBP currenciesgbp = new CurrenciesGBP();
        Double rate = currenciesgbp.getAllExchangeRates().get(checkCodeGetValue);
        try {
            
            if(rate != null){
               return rate;
               
            }

        } catch (CountryCodeUnavailableException | ExchangeRateUnavilable e) {
            System.out.println("I'm sorry, we are unable to provide details for that code.");
        }
        
                          return rate;  
    }
    
}
