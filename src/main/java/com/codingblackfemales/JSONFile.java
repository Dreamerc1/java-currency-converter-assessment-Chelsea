package com.codingblackfemales;

import java.io.FileReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.http.HttpRequest;

import javax.management.RuntimeErrorException;

import org.json.simple.parser.JSONParser;

public class JSONFile {

    // JSONParser jsonParser = new JSONParser();

    // FileReader reader = new FileReader("/*file location but i will try to parse in the class for api */");

    // Object obj = jsonParser.parse(reader);

    // JSONObject namejsonobj=(JSONObject)obj;

    // namejsonobj.get(destinationCurrencyCode);

    // HttpRequest getRequest = HttpRequest.newBuilder()
    // .uri(new URI(""))
    // .header("nameOfHeader", config.properties.API_Key)
    // .GET();



    
        
        try {
            URL url = new URL("http://api.exchangeratesapi.io/v1/latest?access_key={key}");
            // 
            // URL url = new URL("http://api.exchangeratesapi.io/v1/");
        
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            int responseCode = connection.getResponseCode();
        if(responseCode != 200){
            throw new RuntimeErrorException(null, responseCode + "has been found");
        } else{
           System.out.println("working!!");

        //          StringBuilder informationString = new StringBuilder();
        //             Scanner scanner = new Scanner(url.openStream());

        //             while (scanner.hasNext()){
        //                 informationString.append(scanner.nextLine());
        //                 scanner.close();

        //                 System.out.println(informationString);

        //                 JSONParser parse = new JSONParser();
        //                 JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));
                        
        //                 System.out.println(/*drill down into the data */);
                    
           
        //     }
        // }
        } catch (Exception e) {

        //     // TODO: handle exception
        }
        }
    
}
