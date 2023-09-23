package com.codingblackfemales.exceptions;

public class ExchangeRateUnavailable extends IllegalArgumentException{
    public ExchangeRateUnavailable(){}
    public ExchangeRateUnavailable(String message){
        super(message);
    }

    public ExchangeRateUnavailable(Throwable cause){
        super(cause);
        }
    
    public ExchangeRateUnavailable(String message, Throwable cause){
        super(message, cause);
        }
}