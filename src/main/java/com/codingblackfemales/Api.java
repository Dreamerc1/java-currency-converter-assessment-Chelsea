package com.codingblackfemales;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

import org.json.simple.JSONArray;
import org.json.simple.parser.JSONParser;

public class Api {
    public static void main(String[] args) throws IOException {
        
            // check js docs on how to get code we are searching for instead of usd as a base rate;
            // URL url = new URL("http://api.exchangeratesapi.io/v1/");
        
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();

            InputStream in = url.openStream();
Scanner scan = new Scanner(in);
 
int line = 1;
while (scan.hasNext()){
    String str = scan.nextLine();
    System.out.println((line++) + str);
    // System.out.println( (line++) + &quot;: &quot; + str);
}
scan.close();

//             int responseCode = connection.getResponseCode();
//         if(responseCode != 200){
//             System.out.println("uh ohhh");
//     }    else{
//         System.out.println(("yay, its working."));
//                   StringBuilder informationString = new StringBuilder();
//                     Scanner scanner = new Scanner(url.openStream());

//                     while (scanner.hasNext()){
//                         informationString.append(scanner.nextLine());
//                         scanner.close();

//                         System.out.println(informationString);
//     }
// }
}
}
