package com.codingblackfemales;

import java.io.FileInputStream;
import java.math.BigDecimal;
import java.util.Properties;

import com.codingblackfemales.exchangeRateAPI.OpenExchangeRates;

public class UseRatesAPI {
    public void useRatesAPI(String checkCode){
         try {
                        String configFilePath = "src/config.properties";
                        FileInputStream propsInput = new FileInputStream(configFilePath);

                        Properties prop = new Properties();
                        prop.load(propsInput);
                        System.out.println(prop.getProperty("DB_USER"));
                        OpenExchangeRates openExchangeRates = new OpenExchangeRates(prop.getProperty("app_id"));
                        openExchangeRates.currency(checkCode);
                    } catch (Exception e) {
                        // TODO: handle exception
                    }

                    // this returns a big decimal, it will need to be converted to a double with this formula
//                     BigDecimal bd; // the value you get
// double d = bd.doubleValue(); // The double you want
                    
    }
}
