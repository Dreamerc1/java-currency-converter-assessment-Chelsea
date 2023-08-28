package com.codingblackfemales;

abstract class Converter {
    protected String sourceCurrencyCode;
    protected String destinationCurrencyCode; 

    public Converter(String sourceCurrencyCode, String destinationCurrencyode){
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.sourceCurrencyCode = destinationCurrencyCode;
    }

    public void getCurrencyCodes(){
        return;
    }
}
