package com.codingblackfemales;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicConverter = new BasicCurrencyConverter(currencies);
        basicConverter.getCurrencyCodes();

        // basicConverter.getExchangeRate("JPY", "USD");
        
    }
}
