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

    public double setAmount(double inputAmount){
        if(inputAmount <= 0){
            amount = 0;
            throw new InsufficientAmountEntered("Invalid amount entered to be converted, please enter a number greater than 0.");
        }
        return amount;
    }

    public double convertAmount(double amount){
        // // double convertedAmount = 0; getting rid
        // try {
        //       CurrencyConverter currencyConverter = new CurrencyConverter();
              
        //        double transactionExchangeRate = currencyConverter.getExchangeRate(sourceCurrencyCode, destinationCurrencyCode);
        //         // double transactionExchangeRate = currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
        //         // double 
        //         System.out.println("the transaction rate is" + transactionExchangeRate);
        //         setAmount(transactionExchangeRate * amount);
        //          /* if you know the exchange rate currency / exchangeRate
        // * usa/eur exhange rate excample
        // rate may be 0.631 you want to convert 100USD to EUR
        // 100 *  0.631 you get 63.10.
        // */
        //         // System.out.println(amount, sourceCurrencyCode.getKey() + " will convert to " + convertedAmount, destinationCurrencyCode.getKey()+ ", do you wish to proceed?");
        //         System.out.printf("%.2f %s will convert to %.2f %s, do you wish to proceed?%n", amount, sourceCurrencyCode, convertedAmount, destinationCurrencyCode);
        //         // return convertedAmount;
        // } catch (Exception e) {
        //     e.printStackTrace();
        //     System.out.println("Oops, something went wrong");
        // }
        return amount;
       
    }
}