package com.codingblackfemales;

import java.util.Arrays;

import com.codingblackfemales.Exceptions.CountryCodeUnavailableException;
import com.codingblackfemales.Exceptions.ExchangeRateUnavilable;

// public interface CurrencyConverter {
//     double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount);
//     String[] getCurrencyCodes();
//     double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode);
// }

public class CurrencyConverter {
    
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
    // // ConvertCurrencyInh convertCurrencyInh = new ConvertCurrencyInh(sourceCurrencyCode, destinationCurrencyCode, amount);
    // // convertCurrencyInh.convertAmount(amount);
    // CurrenciesGBP currenciesGBP = new CurrenciesGBP();
    // // currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
    // double transactionExchangeRate = currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
    
    // System.out.println("the trans ex rate is" + transactionExchangeRate);
    // System.out.println("The des exch rate it" +currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode));
    // System.out.println("the source ex rate is" + currenciesGBP.getAllExchangeRates().get(sourceCurrencyCode));
    // return amount;
    
    ConvertCurrencyInh convertCurrencyInh = new ConvertCurrencyInh(sourceCurrencyCode, destinationCurrencyCode, amount);
    return convertCurrencyInh.convertAmount(sourceCurrencyCode, destinationCurrencyCode, amount);
    

    }
    
    public String getCurrencyCodes(){
        // returns an array of currency codes available.
        GetCodes getCodes = new GetCodes();
        return Arrays.toString(getCodes.currencyCode());
    }

    public void checkCode(String destinationCurrencyCode, String sourceCurrencyCode){
        if(!getCurrencyCodes().contains(destinationCurrencyCode)){
            throw new CountryCodeUnavailableException("I'm sorry" +destinationCurrencyCode + "is not currently a currency that we carry. Please try another currency");
        }else if(!getCurrencyCodes().contains(sourceCurrencyCode)){
            throw new CountryCodeUnavailableException("I'm sorry " +sourceCurrencyCode + "is not a currency that we currently carry. Please select another currency.");
        }
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
            return 0;
        } 
        return Double.parseDouble(formatExchangeRate);
        
    }
    
    

}
