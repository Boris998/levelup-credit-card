package com.example.levelupcreditcard.model.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.time.LocalDate;

@Data
@NoArgsConstructor
public class CreditCardDTO {

    private String cardHolderName;

    private String cardNumber;

    private Integer CVV;

    private LocalDate expirationDate;

    private String type;

    public CreditCardDTO(@NonNull String cardHolderName, @NonNull String cardNumber, @NonNull Integer CVV, @NonNull LocalDate expirationDate, String type) {
        this.cardHolderName = cardHolderName;
        this.cardNumber = cardNumber;
        this.CVV = CVV;
        this.expirationDate = expirationDate;
        this.type = type;
    }
}
