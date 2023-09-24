// responsible for starting the application.

package com.codingblackfemales;

import java.io.IOException;

// import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;

public class Main {
    public static void main(String[] args) throws InterruptedException, IOException {
        UserInterface ui = new UserInterface();
        ui.startApp();
    }
}