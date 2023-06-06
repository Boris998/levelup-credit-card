package com.example.levelupcreditcard.model.exceptions;

public class InvalidAmericanExpressPANException extends RuntimeException {
    public InvalidAmericanExpressPANException(String cardNumber) {
        super(String.format("AmericanExpress's Card PAN (card number): " +
                "%s is not valid. It must be 15 digits, and it must stat with 34 or 39!", cardNumber));
    }
}