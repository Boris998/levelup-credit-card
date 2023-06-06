package com.example.levelupcreditcard.model.exceptions;


public class InvalidDinersClubPANException extends RuntimeException{
    public InvalidDinersClubPANException(String cardNumber) {
        super(String.format("Diners Club PAN (card number): %s is not valid. It must be 14 digits," +
                " and it must stat with 36, 38, 300, 301, 302, 303, 304, 305, 306 or 309!", cardNumber));
    }
}