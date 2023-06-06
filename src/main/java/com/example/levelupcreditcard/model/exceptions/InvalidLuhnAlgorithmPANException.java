package com.example.levelupcreditcard.model.exceptions;

public class InvalidLuhnAlgorithmPANException extends RuntimeException {
    public InvalidLuhnAlgorithmPANException(String cardNumber) {
        super(String.format("Invalid PAN number: %s -> checked by Luhn's Algorithm", cardNumber));
    }
}
