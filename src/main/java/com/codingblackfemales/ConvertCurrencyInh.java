package com.codingblackfemales;

public class ConvertCurrencyInh extends Converter{

    double amount;
// do you need another variable that will show what the amount converts to? and use a getter to show it.
    public ConvertCurrencyInh(String sourceCurrencyCode; String destinationCurrencyCode; double amount){
        super(sourceCurrencyCode, destinationCurrencyCode);
        this.setAmount(inputAmount);
    }

    public double getAmount(){
        return amount;
    }

    public void setAmount(double inputAmount){
        amount = inputAmount;
    }

    public void convertAmount(double amount){
        double convertedAmount = 0;
        try {
            if( amount <= 0){
            System.out.println("Invalid amount, please try again")
            convertedAmount = 0;
            }
        } catch (Exception e) 
        //create custom exception to throw 
        {
            // TODO: handle exception
        }

        try {
             if(amount > 0){
                sourceCurrencyCode.getKey() * 
                 /* if you know the exchange rate currency / exchangeRate
        * usa/eur exhange rate excample
        rate may be 0.631 you want to convert 100USD to EUR
        100 *  0.631 you get 63.10.
        */

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
           
        
        
        
    }


}