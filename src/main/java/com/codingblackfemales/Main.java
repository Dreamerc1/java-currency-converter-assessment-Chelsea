package com.codingblackfemales;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

                // you need to build a constructor that gets the target excahnge rate 
                // CurrenciesGBP currenciesgbp = new CurrenciesGBP();
                // // System.out.println(currenciesgbp.getAllExchangeRates());

                // Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                // for(String key: keys){
                //     System.out.println(key);
                // }

                CurrencyConvert convert = new CurrencyConvert();
                convert.getCurrencyCodes();
                // GetCodes getCodes = new GetCodes();
                // // Accessing the currecy codes class
                // getCodes.currencyCode();
                // // invoking the currencyCode method that returns an array of currency codes
                // System.out.println("these are the code" + Arrays.toString(getCodes.currencyCode()));
                
       
    }
}
