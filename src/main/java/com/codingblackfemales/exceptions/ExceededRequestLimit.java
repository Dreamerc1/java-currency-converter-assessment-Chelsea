package com.codingblackfemales.exceptions;
   
public class ExceededRequestLimit extends IllegalArgumentException {
    public ExceededRequestLimit(){}
    public ExceededRequestLimit(String message){
        super(message);
    }

public ExceededRequestLimit(Throwable cause){
    super(cause);
    }

    public ExceededRequestLimit(String message, Throwable cause){
        super(message, cause);
    }
}