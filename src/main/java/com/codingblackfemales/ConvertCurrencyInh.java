package com.codingblackfemales;

public class ConvertCurrencyInh extends Converter{

    double amount;
// do you need another variable that will show what the amount converts to? and use a getter to show it.
    public ConvertCurrencyInh(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
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
            System.out.println("Invalid amount, please try again");
            convertedAmount = 0;
            }
        // } catch(/*custom exception */){
    //create custom exception to throw 
        } catch (Exception e){
        e.printStackTrace();
        }

        try {
             if(amount > 0){
                CurrenciesGBP currenciesGBP = new CurrenciesGBP();
                // currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
                double transactionExchangeRate = currenciesGBP.getAllExchangeRates().get(destinationCurrencyCode);
                // above should be how we get the to the exchange rate held in the hashmap
                convertedAmount = transactionExchangeRate * amount;
                 /* if you know the exchange rate currency / exchangeRate
        * usa/eur exhange rate excample
        rate may be 0.631 you want to convert 100USD to EUR
        100 *  0.631 you get 63.10.
        */
                System.out.println(amount, sourceCurrencyCode.getKey() + " will convert to " + convertedAmount, destinationCurrencyCode.getKey()+ ", do you wish to proceed?");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }
           
        
        
        
    }


}