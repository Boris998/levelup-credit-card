package com.example.levelupcreditcard.model.exceptions;

public class InvalidMastercardPANException extends RuntimeException{
    public InvalidMastercardPANException(String cardNumber) {
        super(String.format("Mastercard PAN (card number): " +
                "%s is not valid. It must be 16 digits, and it must stat with 51, 52, 53, 54 or 55!", cardNumber));
    }
}