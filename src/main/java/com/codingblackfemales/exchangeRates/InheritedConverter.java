package com.codingblackfemales.exchangeRates;

abstract class InheritedConverter {
    protected String sourceCurrencyCode;
    protected String destinationCurrencyCode; 

    public InheritedConverter(String sourceCurrencyCode, String destinationCurrencyode){
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.sourceCurrencyCode = destinationCurrencyCode;
    }

    public void getCurrencyCodes(){
        return;
    }
    
}
