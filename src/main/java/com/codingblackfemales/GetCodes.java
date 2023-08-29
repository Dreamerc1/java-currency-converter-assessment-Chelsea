package com.codingblackfemales;

import java.util.Arrays;
import java.util.Set;

public class GetCodes {
    // final String[] currencyCode = {"GBP","USD","JPY","EUR"};
    // public String[] findCode(){
        public final String[] currencyCode() {
         CurrenciesGBP currenciesgbp = new CurrenciesGBP();
                // System.out.println(currenciesgbp.getAllExchangeRates());

                Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                
                String[] currencyCodes = new String[keys.size()];
                int i = 0;
                
                for(String key: keys){
                    // System.out.println(key);
                    currencyCodes[i] = key;
                    i++;
                    
                }
                // return currencyCodes;
                // System.out.println(Arrays.toString(getCodes.currencyCode()))
                // System.out.println(Arrays.toString(currencyCodes));
                return currencyCodes;
    }
    
   
}