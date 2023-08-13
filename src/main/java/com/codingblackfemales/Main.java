package com.codingblackfemales;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        for (Map.Entry<String,double> entry : CurrenciesGBP){
            System.out.println("Key = " + entry.getKey() +
                                 ", Value = " + entry.getValue());
        }
    }
}
