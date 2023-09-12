package com.codingblackfemales;

import com.codingblackfemales.Exceptions.InsufficientAmountEntered;

public class ConvertCurrencyInh extends InheritedConverter{

    private double amount;
    
// do you need another variable that will show what the amount converts to? and use a getter to show it.
    public ConvertCurrencyInh(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
        super(sourceCurrencyCode, destinationCurrencyCode);
        this.setAmount(amount);
    }

    public double getAmount(){
        return amount;
    }

    public double setAmount(double amount){
        if(amount <= 0){
            throw new InsufficientAmountEntered("Invalid request for conversion. Please enter an amount greater than 0.");
        }
        return 0;
    }

    public double convertAmount(double amount){
        try {
             CurrencyConverter currencyConverter = new CurrencyConverter();
              CurrenciesGBP currenciesGBP = new CurrenciesGBP();
              
               double sourceRate = currenciesGBP.getAllExchangeRates().get(sourceCurrencyCode);
               double destinationRate = currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
               double convertedTransaction = amount * (destinationRate / sourceRate);
               return convertedTransaction;       
    }finally{
        System.out.println("Thank you for using the currency converter!");
    }
}
}