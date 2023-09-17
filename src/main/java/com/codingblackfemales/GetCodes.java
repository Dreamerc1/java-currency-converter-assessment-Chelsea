package com.codingblackfemales;

import java.util.Set;

public class GetCodes {
    public final String[] currencyCode() {
            // uses the data housed in CurrenciesGBP hashmap to generate an array of available currency codes.
        CurrenciesGBP currenciesgbp = new CurrenciesGBP();

                Set<String> keys = currenciesgbp.getAllExchangeRates().keySet();
                
                String[] currencyCodes = new String[keys.size()];
                int i = 0;
                for(String key: keys){
                    currencyCodes[i] = key;
                    i++;
                    
                }
                return currencyCodes;
    }
}
