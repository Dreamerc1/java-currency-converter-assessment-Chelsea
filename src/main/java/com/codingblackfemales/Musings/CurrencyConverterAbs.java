package com.codingblackfemales.Musings;

public abstract class CurrencyConverterAbs {
    public abstract double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount); 
    public abstract String[] getCurrencyCodes();
    public abstract double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
}
