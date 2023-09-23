package com.codingblackfemales;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Properties;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UseRatesAPI {
    // this class uses an API to fetch the exchange rate from a live database
    public double useApi(String sourceCurrencyCode, String destinationCurrencyCode) throws ParseException{

        double transactionExchangeRate = 0.0;
        // exchange rate is initially set to 0.0;

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
 
                            ObjectMapper mapper = new ObjectMapper();
                            JsonNode rootNode = mapper.readTree(informationString.toString());

                                if(rootNode.has("conversion_rates")){
                                    JsonNode conversionRateNode = rootNode.get("conversion_rates");

                                    if(conversionRateNode.has(destinationCurrencyCode)){
                                    // JsonNode destinationNode = rootNode.get(destinationCurrencyCode);
                                    transactionExchangeRate = conversionRateNode.get(destinationCurrencyCode).asDouble();
                                        }else{
                                            System.out.println("I'm sorry, we can not offer an exchange rate the destination currency at the moment.");
                                        }
                                    }else{
                                        System.out.println("We apologies, the rate for this transaction cannot be found");
                                    }
                                }
                            } catch (IOException e) {
                                System.out.println("I'm sorry, a problem occurred while trying to read your response from server.");
                                System.out.println("we are currently unable to carry out you request");
                                e.printStackTrace();
                            }

                        return transactionExchangeRate;        
                    }

        }

    public double apiConversion(double transactionExchangeRate, double amount) throws ExchangeRateUnavailable, InsufficientAmountEntered {
        double convertedTransaction = amount * transactionExchangeRate;
        return convertedTransaction;
    }
    
}
