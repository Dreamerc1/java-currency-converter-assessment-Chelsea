package com.codingblackfemales;

public interface CurrencyConverter {
    double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);

    String[] getCurrencyCodes();

    double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);

}
