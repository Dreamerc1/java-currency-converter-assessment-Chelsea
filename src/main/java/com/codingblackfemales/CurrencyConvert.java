package com.codingblackfemales;

import java.util.Arrays;

public class CurrencyConvert {
    
    public void getCurrencyCodes(){
        GetCodes getCodes = new GetCodes();
        System.out.println("Please select a currency to convert to "+ Arrays.toString(getCodes.currencyCode()));
        // getCodes.currencyCode();
    }
    

}
