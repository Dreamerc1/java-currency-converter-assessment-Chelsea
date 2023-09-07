package com.codingblackfemales.Exceptions;

public class ExchangeRateUnavilable extends IllegalArgumentException{
    public ExchangeRateUnavilable(){}
    public ExchangeRateUnavilable(String message){
        super(message);
    }

    public ExchangeRateUnavilable(Throwable cause){
        super(cause);
        }
    
    public ExchangeRateUnavilable(String message, Throwable cause){
        super(message, cause);
        }
}
