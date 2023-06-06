//package com.example.levelupcreditcard.model;
//
//import com.example.levelupcreditcard.model.enumerations.CreditCardType;
//import jakarta.persistence.*;
//import lombok.Data;
//import lombok.NoArgsConstructor;
//import lombok.NonNull;
//
//import java.time.LocalDate;
//
//@Data
//@NoArgsConstructor(force = true)
////@Entity
//public class CreditCard {
//
////    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
//
//    @NonNull
//    private String cardHolderName;
//
//    @NonNull
//    private String cardNumber;
//
//    @NonNull
//    private Integer CVV;
//
//    @NonNull
//    private LocalDate expirationDate;
//
//    @Enumerated(EnumType.STRING)
//    private CreditCardType type;
//
//    public CreditCard(@NonNull String cardHolderName, @NonNull String cardNumber, @NonNull Integer CVV, @NonNull LocalDate expirationDate, CreditCardType type) {
//        this.id = id;
//        this.cardHolderName = cardHolderName;
//        this.cardNumber = cardNumber;
//        this.CVV = CVV;
//        this.expirationDate = expirationDate;
//        this.type = type;
//    }
//
//}
