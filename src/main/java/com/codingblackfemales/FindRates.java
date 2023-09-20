package com.codingblackfemales;

public class FindRates {

    private Currencies currencies;

    public FindRates(Currencies currencies){

        this.currencies = currencies;
        
    }

    public Double findValue(String checkCodeGetValue){

        
        Double rate = currencies.getAllExchangeRates().get(checkCodeGetValue);
        // dependency injection
        
            
        if(rate != null){
            return rate;
        }else{

            throw new  ExchangeRateUnavailable ("I'm sorry, we are unable to provide details for that code.");
        }
    }
}
