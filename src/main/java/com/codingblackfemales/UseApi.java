package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;

import javax.management.RuntimeErrorException;

import org.json.simple.parser.ParseException;

public class UseApi {
    //  String configFilePath = "src/main/java/org/openexchangerates/oerjava/config.properties";{
    //     try (FileInputStream propsInput = new FileInputStream(configFilePath)) {
    //         Properties prop = new Properties();
    //         prop.load(propsInput);
    //         String apiKey = prop.getProperty("Key");

    //         URL url =new URL("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, sourceCurrencyCode);

    //         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    //         connection.setRequestMethod("GET");
    //         connection.connect();

    //         int responseCode = connection.getResponseCode();
    //     if(responseCode != 200){
    //         throw new RuntimeErrorException(null, responseCode + "has been found");
    //     } else{
    //        System.out.println("working!!");
    //     }
    //     } catch (IOException e) {
    //         // TODO Auto-generated catch block
    //         e.printStackTrace();
    //     }
        
    // }
    public static void main(String[] args) throws ParseException {
        JSONFile jsonFile = new JSONFile();
        System.out.println(jsonFile.useApi("USD", "BOB"));
    }
    
    
}
