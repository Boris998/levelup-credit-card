package com.example.levelupcreditcard.model.exceptions;

public class InvalidDiscoverPANException extends RuntimeException{
    public InvalidDiscoverPANException(String cardNumber) {
        super(String.format("Mastercard PAN (card number): %s is not valid. It must be 16 digits," +
                " and it must stat with 6011, 622126 to 622925, 644, 645, 646, 647, 648, 649 or 65!", cardNumber));
    }
}