package com.codingblackfemales;

import java.util.Arrays;
import java.util.Set;

public class GetCodes {
   
        public final String[] currencyCode() {
            // making the string final so it cannot be changed unless the getAllExchangeRates method is changed
         CurrenciesGBP currenciesgbp = new CurrenciesGBP();
                // System.out.println(currenciesgbp.getAllExchangeRates());

                Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                // creates a set of keys from the available currency codes in getAllExchangeRates, if list is updated the set auto-updates.
                
                String[] currencyCodes = new String[keys.size()];
                // creates a string array called currencies and initializes it with the size of the keys array.
                int i = 0;
                // counts the indexes of they keys array. currently set to the zeroeth index.
                for(String key: keys){
                    // iterates through each key in the keys Array
                    currencyCodes[i] = key;
                    // sets each index in the currencyCodes array tot he value of the corresponding key. 
                    i++;
                    // increments each index by one
                    
                }
                return currencyCodes;
                // returns a list of the available currency codes.
    }
   
}