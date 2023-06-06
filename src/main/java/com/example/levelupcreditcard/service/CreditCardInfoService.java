package com.example.levelupcreditcard.service;

import com.example.levelupcreditcard.model.dto.CreditCardDTO;
import com.example.levelupcreditcard.model.enumerations.CreditCardType;

import java.time.LocalDate;

//@Service
public interface CreditCardInfoService {
/*    Optional<CreditCardInfo> findById(Long id);

    Optional<CreditCardInfo> findByEnumerationType(CreditCardType creditCardType);

    Optional<CreditCardInfo> save(String cardHolderName, String cardNumber, Integer CVV, LocalDate expirationDate, CreditCardType type);

    List<CreditCardInfo> findAllCreditCards();*/

    void validate(LocalDate expirationDate, CreditCardType type, Integer CCV, String cardNumber);
    void validate(CreditCardDTO creditCardDTO);
//    void delete(String id);


}
