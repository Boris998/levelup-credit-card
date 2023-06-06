package com.example.levelupcreditcard.model.exceptions;

public class InvalidVisaElectronPANException extends RuntimeException{
    public InvalidVisaElectronPANException(String cardNumber) {
        super(String.format("Visa Electron PAN (card number): %s is not valid. It must be 16 digits," +
                " and it must stat with 4026, 417500, 4508, 4844, 4913, 4917, 4917!", cardNumber));
    }
}