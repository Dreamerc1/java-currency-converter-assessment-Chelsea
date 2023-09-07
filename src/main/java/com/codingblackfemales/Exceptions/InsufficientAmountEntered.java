package com.codingblackfemales.Exceptions;

public class InsufficientAmountEntered extends IllegalArgumentException {

    public InsufficientAmountEntered(){}
    public InsufficientAmountEntered(String message){
        super(message);
    }

    public InsufficientAmountEntered(Throwable cause){
        super(cause);
        }
    
    public InsufficientAmountEntered(String message, Throwable cause){
        super(message, cause);
        }
    }
    

