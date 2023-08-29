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
                // creating a new instance of currency converter
                convert.getCurrencyCodes();
                // invodes the method that gets the array of codes available from currency converter
                
    }
}
