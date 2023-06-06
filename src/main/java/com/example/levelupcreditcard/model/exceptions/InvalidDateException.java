package com.example.levelupcreditcard.model.exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class InvalidDateException extends RuntimeException {
    public InvalidDateException(LocalDate ld) {
        super(String.format("Credit card date: %s has expired", ld.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
    }
}
