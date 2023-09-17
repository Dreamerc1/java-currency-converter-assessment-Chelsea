package com.codingblackfemales;

import java.util.Arrays;

import com.codingblackfemales.Exceptions.CountryCodeUnavailableException;
import com.codingblackfemales.exchangeRates.ConvertCurrencyInh;
import com.codingblackfemales.exchangeRates.FindRates;
import com.codingblackfemales.exchangeRates.GetCodes;

public class BasicCurrencyConverter implements CurrencyConverter{

    @Override
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {
        ConvertCurrencyInh convertCurrencyInh = new ConvertCurrencyInh(sourceCurrencyCode, destinationCurrencyCode, amount);
        return convertCurrencyInh.convertAmount(sourceCurrencyCode, destinationCurrencyCode, amount);
    
    }

    @Override
    public String[] getCurrencyCodes() {
        CurrenciesGBP currenciesGBP = new CurrenciesGBP();
        GetCodes getCodes = new GetCodes(currenciesGBP);
        // return Arrays.toString(getCodes.currencyCode());
        return getCodes.currencyCode();
    }

    public void checkCode(String destinationCurrencyCode, String sourceCurrencyCode){
        if(!getCurrencyCodes().contains(destinationCurrencyCode)){
            throw new CountryCodeUnavailableException("I'm sorry" +destinationCurrencyCode + "is not currently a currency that we carry. Please try another currency");
        }else if(!getCurrencyCodes().contains(sourceCurrencyCode)){
            throw new CountryCodeUnavailableException("I'm sorry " +sourceCurrencyCode + "is not a currency that we currently carry. Please select another currency.");
        }
    }

    @Override
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
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
