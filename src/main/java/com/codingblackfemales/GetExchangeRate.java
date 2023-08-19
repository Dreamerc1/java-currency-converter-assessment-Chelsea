package com.codingblackfemales;

public class GetExchangeRate extends CurrencyConverterAbs {

    @Override
    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount) {

        if(code.getCurrencyCode(code.setCurrencyCode) != code.getCurrencyCode(code.setCurrencyCode)){
            return amount;
        }
        // This method must accept a source currency code, a destination currency code, and an amount. It will return the converted amount (i.e. the value of the destination currency once converted from the provided amount in the source currency).
        try(

       ){

       }catch(){

       }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'convertCurrency'");
    }

    @Override
    public String[] getCurrencyCodes() {
        
        try( String[] currencyCode = {"GBP","USD","JYP","EUR"};){

        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Invalid array index");
        }
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCurrencyCodes'");
    }
  
    @Override
    public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode) {
        double rate = 0;
// delete
        try {
            if(sourceCurrencyCode != destinationCurrencyCode){
                return rate = /*find how to get exchange rate */;
            }else{
                System.out.println("Exchange rate unavailable for invalid destination.");
            }
        } catch (Exception e) {
            // TODO: handle exception
        }finally{
            return rate;
        }

        throw new UnsupportedOperationException("Unimplemented method 'getExchangeRate'");
    }

    
    
}
