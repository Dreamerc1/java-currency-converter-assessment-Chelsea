package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Properties;

import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;
import com.codingblackfemales.exchangeRateAPI.UnavailableExchangeRateException;

public class UseRatesAPI {
    public double useRatesAPI(String checkCode){
        
        String configFilePath = "src/config.properties";
        try (FileInputStream propsInput = new FileInputStream(configFilePath)) {
            Properties prop = new Properties();
            prop.load(propsInput);

            OpenExchangeRates openExchangeRates = new OpenExchangeRates(prop.getProperty("app_id"));
                    // openExchangeRates.currency(checkCode);

            BigDecimal rate = openExchangeRates.latest().get(checkCode);
                    
        
                if(rate != null){
                    double returnedValue = rate.doubleValue();
                    return returnedValue;
                }else{
                    System.out.println("I'm sorry, we are unable to provide details for that code.");                        return 0.0;
                }
                        
        } catch (IOException | UnavailableExchangeRateException e) {
            System.out.println("I'm sorry, we are unable to provide details for that code.");
            e.printStackTrace();
            return 0.0;
        }                    
                    
    }
}
