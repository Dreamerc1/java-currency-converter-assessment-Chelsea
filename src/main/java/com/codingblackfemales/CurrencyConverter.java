// The interface required for the assessment, it tells basic currency converter the methods that it needs to use, but now how to use them.
package com.codingblackfemales;

public interface CurrencyConverter {
    double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);

    String[] getCurrencyCodes();

    double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
}
