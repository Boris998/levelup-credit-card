package com.example.levelupcreditcard.model.exceptions;

public class InvalidVisaPANException extends RuntimeException{
    public InvalidVisaPANException(String cardNumber) {
        super(String.format("Visa's Card PAN (card number): " +
                "%s is not valid. It must be 16 digits, and it must stat with 4!", cardNumber));
    }
}