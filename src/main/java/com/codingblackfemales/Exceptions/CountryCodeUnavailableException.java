package com.codingblackfemales.Exceptions;

// public class CountryCodeUnavailableException extends Exception {
    public class CountryCodeUnavailableException extends IllegalArgumentException {
        // try to extend the argument as close to the one you already available as possible

    // by convention extend exception rather than error or throwable

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

// in main wehn you have an example like
// it(age < 0){
// throw new CustomrExceptionName("Your message here", new RuntimeException());
// }