package com.codingblackfemales;

/*PREP
 * 
 * PERAMETERS
 * currencyConverter()
 * convertCurrency()
 * getCurrency()
 * getExchangeRate()
 * 


RESULTS


EXAMPLES


PSUDOCODE
 */

public class CurrencyConverter {

    protected double amount;
    protected String sourceCurrencyCode;
    protected String destinationCurrencyCode;



    // build out 

    // building a constructor for the currency constructor to support OOP
    public CurrencyConverter(double amount, String sourceCurrencyCode, String destinationCurrencyCode){
        this.amount = amount;
        this.sourceCurrencyCode = sourceCurrencyCode;
        this.destinationCurrencyCode = destinationCurrencyCode;
    };


    public double convertCurrency(String sourceCurrencyCode, String destinationCurrencyCode, double amount){
        // if(sourceCurrencyCode != destinationCurrencyCode){
        //     return amount * getExchangeRate();
        // }else{

        // }
        
        /*
     * PERAMETERS source currency code, destination currency code , amount to convert to.
     *


RESULTS

source currency code is selected,
destination currency code is selected,
user inputs the amount.


EXAMPLES


PSUDOCODE
    //  */
        double convertedAmount = 0;
        // try{

        // }catch{
        //     System.err.println(err);
        // }
        return convertedAmount;
    }


    public String[] getCurrencyCodes(){ //requested method getCurrencyCodes().

        String[] currencyCode = {"GBP","USD","JYP","EUR"}; //array string containing all currency codes being used by the application.
        return currencyCode; //returns the array of codes when the method getCurrencyCodes()
        
        }
         /*
     * PERAMETERS
get currency codes,
an array of currency codes is given to traverse for the user to selec from.

RESULTS
getter that gets the currency code once user has selected it.


EXAMPLES
user selects GBP as a currency and it gets hat currency
user selcets USD as another currency, the code returns that currency


PSUDOCODE
     */
    
//     public double getExchangeRate(String sourceCurrencyCode, String destinationCurrencyCode){

//         double rate = 0;

//             if(sourceCurrencyCode != destinationCurrencyCode){
//                 return rate = ;
//             }else{
//                 System.out.println("Exchange rate unavailable for invalid destination.");
//             }
        

//         // use getAllExchangeRates() and iterate through to find the rate from sourceCurrencyCode to destination. 
//  /*
//      * PERAMETERS
// source currency code
// destination currency code.

// once the two have been selected the code return the exchange rate for the currency conversion

// RESULTS


// EXAMPLES


// PSUDOCODE
//      */
//     }


    
}
