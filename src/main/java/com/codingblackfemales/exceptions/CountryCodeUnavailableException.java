package com.codingblackfemales.exceptions;

public class CountryCodeUnavailableException extends IllegalArgumentException {
    public CountryCodeUnavailableException(){}
    public CountryCodeUnavailableException(String message){
        super(message);
    }

public CountryCodeUnavailableException(Throwable cause){
    super(cause);
    }

    public CountryCodeUnavailableException(String message, Throwable cause){
        super(message, cause);
    }
}
