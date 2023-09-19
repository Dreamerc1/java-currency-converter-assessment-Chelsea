package com.codingblackfemales;

public class FindRates {
    public Double findValue(String checkCodeGetValue){
        CurrenciesGBP currenciesgbp = new CurrenciesGBP();
        Double rate = currenciesgbp.getAllExchangeRates().get(checkCodeGetValue);
            
        if(rate != null){
            return rate;
        }else{

            throw new  ExchangeRateUnavailable ("I'm sorry, we are unable to provide details for that code.");
        }
    }
}
