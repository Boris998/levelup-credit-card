package com.example.levelupcreditcard.model.exceptions;

public class InvalidCardPANLength extends RuntimeException {
    public InvalidCardPANLength(String cardNumber) {
        super(String.format("Card's PAN (card number): %s is not valid. " +
                "It must be 16!", cardNumber));
    }
}
