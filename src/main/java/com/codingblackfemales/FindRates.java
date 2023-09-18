package com.codingblackfemales;

public class FindRates {
    public Double findValue(String checkCodeGetValue){
        // method will use binary search to find the value in the key value pair of the currency codes array.
        CurrenciesGBP currenciesgbp = new CurrenciesGBP();
        Double rate = currenciesgbp.getAllExchangeRates().get(checkCodeGetValue);
            
        if(rate != null){
            return rate;
        }else{

            throw new  ExchangeRateUnavailable ("I'm sorry, we are unable to provide details for that code.");
        }
    }
}
