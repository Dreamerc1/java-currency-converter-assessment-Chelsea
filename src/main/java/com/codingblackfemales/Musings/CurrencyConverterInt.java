package com.codingblackfemales.Musings;

public interface CurrencyConverterInt {
    double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount); 
    String[] getCurrencyCodes();
    double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
}
