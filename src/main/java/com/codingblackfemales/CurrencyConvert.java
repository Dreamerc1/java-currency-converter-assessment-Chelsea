package com.codingblackfemales;

import java.util.Arrays;

public class CurrencyConvert {
    
    public void getCurrencyCodes(){
        // get currency codes method
        GetCodes getCodes = new GetCodes();
        // gets instatiates a new instance of get codess
        System.out.println("Please select a currency to convert to "+ Arrays.toString(getCodes.currencyCode()));
        // returns a list of available currency codes asking user to chose from selection
    }
    

}
