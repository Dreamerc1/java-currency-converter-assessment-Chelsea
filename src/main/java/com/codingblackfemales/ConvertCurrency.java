package com.codingblackfemales;

public interface ConvertCurrency {
    String sourceCurrencyCode; 
    String destinationCurrencyCode; 
    double amount;
    void convertCurrency();
}
