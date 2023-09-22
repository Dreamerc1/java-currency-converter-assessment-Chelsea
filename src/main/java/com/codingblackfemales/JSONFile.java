package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;
import java.util.Properties;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSONFile {
    // this class uses an API to fetch the exchange rate from a live database
    public double useApi(String sourceCurrencyCode, String destinationCurrencyCode) throws ParseException{

        double exchangeRate = 0.0;
        // exchange rate is intially set to 0.0;

        String configFilePath = "src/main/java/com/codingblackfemales/config.properties";{
            // declaring a string that has the location of the config.properties file.
            try (FileInputStream propsInput = new FileInputStream(configFilePath)) {
                
                Properties prop = new Properties();
                prop.load(propsInput);
                String apiKey = prop.getProperty("Key");
                // Please note that I will leave Api key exposed for the purpose of this assignment and for the use of the assessor. However, usually my config.properties file would then be put inside of my gitIgnore file.
                String apiUrl = String.format("https://v6.exchangerate-api.com/v6/%s/latest/%s", apiKey, sourceCurrencyCode);
                URL url =new URL(apiUrl);

                // deals with connecting to the api usung a Http url connection and sending a GET request.
                HttpURLConnection connection = (HttpURLConnection) url.openConnection();
                connection.setRequestMethod("GET");
                connection.connect();

                int responseCode = connection.getResponseCode();
                
                    if(responseCode != 200){
                        // retireves the response code and throws an exception if the response is other that ok.
                        throw new RuntimeErrorException(null, "HttpResponseCode:" + responseCode);

                    } else{

                        StringBuilder informationString = new StringBuilder();
                        Scanner scanner = new Scanner(url.openStream());
                        // we prepare to read the stream 

                        while (scanner.hasNext()){
                            informationString.append(scanner.nextLine());
                        }
                            scanner.close();
 
                            JSONParser parse = new JSONParser();
                            // we dealing with the JSON object returned  in the stream

                            JSONObject apiData = (JSONObject) parse.parse(String.valueOf(informationString));
        //                     String s = "the text=text";String s1 = s.substring(s.indexOf("=") + 1);
        // s1.trim(); for each item in array
        // could also create an object that stores all rates ask object for the rates
        // taek string look for substring


                       
                            ObjectMapper mapper = new ObjectMapper();
                            JsonNode rootNode = mapper.readTree(informationString.toString());
                            // ObjectNode node = mapper.readValue(codeData, ObjectNode.class){
                                if(rootNode.has("conversion_rates")){
                                    JsonNode conversionRateNode = rootNode.get("conversion_rates");
                                    if(conversionRateNode.has(destinationCurrencyCode)){
                                    // JsonNode destinationNode = rootNode.get(destinationCurrencyCode);
                                    exchangeRate = conversionRateNode.get(destinationCurrencyCode).asDouble();
                                        }else{
                                            System.out.println("I'm sorry, we can not offer an exchange rate the destination currency at the moment.");
                                        }
                                    }else{
                                        System.out.println("We apologies, the rate for this transaction cannot be found");
                                    }
                                }
                            } catch (IOException e) {
                        // TODO Auto-generated catch block
                                e.printStackTrace();
                            }
                        return exchangeRate;        
                    }

    // // JSONParser jsonParser = new JSONParser();

    // // FileReader reader = new FileReader("/*file location but i will try to parse in the class for api */");

    // // Object obj = jsonParser.parse(reader);

    // // JSONObject namejsonobj=(JSONObject)obj;

    // // namejsonobj.get(destinationCurrencyCode);

    // // HttpRequest getRequest = HttpRequest.newBuilder()
    // // .uri(new URI(""))
    // // .header("nameOfHeader", config.properties.API_Key)
    // // .GET();



    
        
    //     try {
    //         // String key = config.properties.API_Key;
    //         String configFilePath = "src/main/java/com/codingblackfemales/config.properties";
    //         FileInputStream propsInput = new FileInputStream(configFilePath);
    //         Properties prop = new Properties();
    //         prop.load(propsInput);
    //         System.out.println(prop.getProperty("DB_USER"));
    //         // URL url = new URL(`http://api.exchangeRatesapi.io/v1/latest?access_key={key}/latest/{code}`);
    //         // 
    //         // URL url = new URL("http://api.exchangeRatesapi.io/v1/");
        
    //         HttpURLConnection connection = (HttpURLConnection) url.openConnection();
    //         connection.setRequestMethod("GET");
    //         connection.connect();

    //         int responseCode = connection.getResponseCode();
    //     if(responseCode != 200){
    //         throw new RuntimeErrorException(null, responseCode + "has been found");
    //     } else{
    //        System.out.println("working!!");

    //              StringBuilder informationString = new StringBuilder();
    //                 Scanner scanner = new Scanner(url.openStream());

    //                 while (scanner.hasNext()){
    //                     informationString.append(scanner.nextLine());
    //                     scanner.close();

    //                     System.out.println(informationString);

    //                     JSONParser parse = new JSONParser();
    //                     JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
                        
    //     //                 System.out.println(/*drill down into the data */);
                    
           
    //     //     }
    //     // }
    //     } catch (Exception e) {

    //     //     // TODO: handle exception
    //     }
        }
    
}
