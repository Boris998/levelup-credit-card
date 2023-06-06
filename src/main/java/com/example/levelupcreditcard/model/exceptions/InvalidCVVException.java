package com.example.levelupcreditcard.model.exceptions;

public class InvalidCVVException extends RuntimeException {
    public InvalidCVVException(Integer CVV){
        super(String.format(String.format("Card with CVV: %d is not valid, American Express cards should have 4 digit CVV",CVV)));
    }
}
