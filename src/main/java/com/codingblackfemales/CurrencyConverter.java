package com.codingblackfemales;

import java.util.Arrays;

import com.codingblackfemales.Exceptions.CountryCodeUnavailableException;
import com.codingblackfemales.Exceptions.ExchangeRateUnavilable;

public class CurrencyConverter {
    double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
        double convertedAmount = 0;
        // String formattedConvertedAmount = "";
        try {
            convertedAmount = amount * getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
            // formattedConvertedAmount = String.format("%.2f", formattedConvertedAmount);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // return Double.parseDouble(convertedAmount); 
        return convertedAmount;
    }
    
    public String getCurrencyCodes(){
        // returns an array of currency codes available.
        GetCodes getCodes = new GetCodes();
        return Arrays.toString(getCodes.currencyCode());
    }

    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode){
        double transactionExchangeRate = 0;
        String formatExchangeRate = "";
        try {
            FindRates findRates = new FindRates();
            // double destinationRate = findRates.findValue(destinationCurrencyCode);
            double sourceRate = findRates.findValue(sourceCurrencyCode);
            transactionExchangeRate =  sourceRate;
            formatExchangeRate = String.format("%.2f", transactionExchangeRate);
        } catch (ExchangeRateUnavilable e) {
            System.out.println("We are unable to provide an exchange rate for this transaction.");
        } 
        return Double.parseDouble(formatExchangeRate);
        
    }
    
    

}
