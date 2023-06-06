package com.example.levelupcreditcard.model.exceptions;

public class InvalidMaestroPANException extends RuntimeException{
    public InvalidMaestroPANException(String cardNumber) {
        super(String.format("Maestro's Card PAN (card number): " +
                "%s is not valid. It must be 16-19 digits, and it must stat with 50,56 or 69!", cardNumber));
    }
}