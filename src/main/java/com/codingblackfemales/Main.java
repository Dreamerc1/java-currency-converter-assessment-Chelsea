// responsible for starting the application.

package com.codingblackfemales;

import java.io.IOException;
import java.util.Scanner;

// import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        Currencies currencies = new CurrenciesGBP();
        BasicCurrencyConverter basicConverter = new BasicCurrencyConverter(currencies);
        OriginalUI ui = new OriginalUI();
        clientInteractions using = new clientInteractions();
        Scanner scanner = new Scanner(System.in);


        System.out.println("Welcome to the currency converter!\n");
        using.timeDelay(1000);

        System.out.println("Here are a list of the currencies codes currently available on the original converter\n");
        using.timeDelay(500);
        using.originalCurrencies(basicConverter);
        using.timeDelay(1250);

        System.out.println("Please note that other currencies may be available on our live rate converter, we can search for these rates when you make your selection.\n");
        using.timeDelay(400);    

        

        using.timeDelay(500);
        System.out.println("Please type the number of conversions you would like to make.");
        System.out.println("You can convert a maximum number of 10 currencies at once. Note that for more than one conversion you will need to use the live rates converter.");
        int numberOfConversions = scanner.nextInt();

        if(numberOfConversions != 1){
            using.numConversions(numberOfConversions);
        }else{
            using.selectConverter(scanner, numberOfConversions);
        }




        // apiUi.startLiveConverter(2, scanner);
    }
}