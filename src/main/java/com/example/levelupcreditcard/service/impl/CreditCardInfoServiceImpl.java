package com.example.levelupcreditcard.service.impl;

import com.example.levelupcreditcard.model.dto.CreditCardDTO;
import com.example.levelupcreditcard.model.enumerations.CreditCardType;
import com.example.levelupcreditcard.model.exceptions.*;
import com.example.levelupcreditcard.service.CreditCardInfoService;
import lombok.NonNull;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CreditCardInfoServiceImpl implements CreditCardInfoService {

//    private final CreditCardRepository creditCardRepository;
//
//    public CreditCardInfoServiceImpl(CreditCardRepository creditCardRepository) {
//        this.creditCardRepository = creditCardRepository;
//    }

    public static boolean validityLuhnsCheck(@NonNull String cardNumber) {
        int sum = 0;
        for (int i = cardNumber.length() - 1; i >= 0; i--) {
            int digit = cardNumber.charAt(i) - '0';

            if (i % 2 == 0) digit *= 2;

            sum += digit / 10;
            sum += digit % 10;
        }
        return (sum % 10 == 0);
    }

    @Override
    public void validate(@NonNull LocalDate expirationDate, @NonNull CreditCardType type, @NonNull Integer CVV, @NonNull String cardNumber) {

        boolean VISA_CONDITION = type == CreditCardType.VISA && (!cardNumber.startsWith("4") || cardNumber.length() != 16);

        boolean MASTERCARD_CONDITION = type == CreditCardType.MASTERCARD &&
                (!(cardNumber.startsWith("51") || cardNumber.startsWith("52") || cardNumber.startsWith("53")
                        || cardNumber.startsWith("54") || cardNumber.startsWith("55")) || cardNumber.length() != 16);

        boolean MAESTRO_CONDITION = type == CreditCardType.MAESTRO &&
                (!(cardNumber.startsWith("50") || cardNumber.startsWith("56") || cardNumber.startsWith("69")) || cardNumber.length() != 16);

        boolean DISCOVER_CONDITION = type == CreditCardType.DISCOVER
                && (!(cardNumber.startsWith("6011") || cardNumber.startsWith("622126") || cardNumber.startsWith("622925")
                || cardNumber.startsWith("644") || cardNumber.startsWith("645") || cardNumber.startsWith("646")
                || cardNumber.startsWith("647") || cardNumber.startsWith("648") || cardNumber.startsWith("649")
                || cardNumber.startsWith("65")) || cardNumber.length() != 16);

        boolean DINERS_CLUB_CONDITION = type == CreditCardType.DINERS_CLUB
                && (!(cardNumber.startsWith("36") || cardNumber.startsWith("38") || cardNumber.startsWith("300")
                || cardNumber.startsWith("301") || cardNumber.startsWith("302") || cardNumber.startsWith("303")
                || cardNumber.startsWith("304") || cardNumber.startsWith("305") || cardNumber.startsWith("306")
                || cardNumber.startsWith("309")) || cardNumber.length() != 14);

        boolean VISA_ELECTRON = type == CreditCardType.VISA_ELECTRON
                && (!(cardNumber.startsWith("4026") || cardNumber.startsWith("417500") || cardNumber.startsWith("4508")
                || cardNumber.startsWith("4844") || cardNumber.startsWith("4913") || cardNumber.startsWith("4917")) || cardNumber.length() != 16);


        if (expirationDate.isAfter(LocalDate.now()))
            throw new InvalidDateException(expirationDate);


        if (type == CreditCardType.AMERICAN_EXPRESS) {
            if (CVV < 999 || CVV > 9999)
                throw new InvalidCVVException(CVV);

            if (!(cardNumber.startsWith("34") || cardNumber.startsWith("37")) || cardNumber.length() != 15)
                throw new InvalidAmericanExpressPANException(cardNumber);
        } else {

            if (CVV < 99 || CVV > 999)
                throw new InvalidCVVException(CVV);


            if (VISA_CONDITION)
                throw new InvalidVisaPANException(cardNumber);
            else if (MASTERCARD_CONDITION)
                throw new InvalidMastercardPANException(cardNumber);
            else if (MAESTRO_CONDITION)
                throw new InvalidMaestroPANException(cardNumber);
            else if (DISCOVER_CONDITION)
                throw new InvalidMaestroPANException(cardNumber);
            else if (DINERS_CLUB_CONDITION)
                throw new InvalidDinersClubPANException(cardNumber);
            else if (VISA_ELECTRON)
                throw new InvalidVisaElectronPANException(cardNumber);
            else if (cardNumber.length() < 16 || cardNumber.length() > 19) //for other cards not covered by the previous conditions
                throw new InvalidCardPANLength(cardNumber);
        }


        if (!validityLuhnsCheck(cardNumber)){
            throw new InvalidLuhnAlgorithmPANException(cardNumber);
        }
    }

    @Override
    public void validate(@NonNull CreditCardDTO creditCardDTO) {

        boolean VISA_CONDITION = creditCardDTO.getType().equals("VISA") &&
                (!creditCardDTO.getCardNumber().startsWith("4") || creditCardDTO.getCardNumber().length() != 16);

        boolean MASTERCARD_CONDITION = creditCardDTO.getType().equals("MASTERCARD") &&
                (!(creditCardDTO.getCardNumber().startsWith("51") || creditCardDTO.getCardNumber().startsWith("52") ||
                        creditCardDTO.getCardNumber().startsWith("53") || creditCardDTO.getCardNumber().startsWith("54") ||
                        creditCardDTO.getCardNumber().startsWith("55")) || creditCardDTO.getCardNumber().length() != 16);

        boolean MAESTRO_CONDITION = creditCardDTO.getType().equals("MAESTRO") &&
                (!(creditCardDTO.getCardNumber().startsWith("50") || creditCardDTO.getCardNumber().startsWith("56") ||
                        creditCardDTO.getCardNumber().startsWith("69")) || creditCardDTO.getCardNumber().length() != 16);

        boolean DISCOVER_CONDITION = creditCardDTO.getType().equals("DISCOVER") &&
                (!(creditCardDTO.getCardNumber().startsWith("6011") || creditCardDTO.getCardNumber().startsWith("622126") ||
                        creditCardDTO.getCardNumber().startsWith("622925") || creditCardDTO.getCardNumber().startsWith("644") ||
                        creditCardDTO.getCardNumber().startsWith("645") || creditCardDTO.getCardNumber().startsWith("646") ||
                        creditCardDTO.getCardNumber().startsWith("647") || creditCardDTO.getCardNumber().startsWith("648") ||
                        creditCardDTO.getCardNumber().startsWith("649") || creditCardDTO.getCardNumber().startsWith("65")) || creditCardDTO.getCardNumber().length() != 16);

        boolean DINERS_CLUB_CONDITION = creditCardDTO.getType().equals("DINERS_CLUB") &&
                (!(creditCardDTO.getCardNumber().startsWith("36") || creditCardDTO.getCardNumber().startsWith("38") || creditCardDTO.getCardNumber().startsWith("300")
                || creditCardDTO.getCardNumber().startsWith("301") || creditCardDTO.getCardNumber().startsWith("302") || creditCardDTO.getCardNumber().startsWith("303")
                || creditCardDTO.getCardNumber().startsWith("304") || creditCardDTO.getCardNumber().startsWith("305") || creditCardDTO.getCardNumber().startsWith("306")
                || creditCardDTO.getCardNumber().startsWith("309")) || creditCardDTO.getCardNumber().length() != 14);

        boolean VISA_ELECTRON = creditCardDTO.getType().equals("VISA_ELECTRON") &&
                (!(creditCardDTO.getCardNumber().startsWith("4026") || creditCardDTO.getCardNumber().startsWith("417500") || creditCardDTO.getCardNumber().startsWith("4508")
                || creditCardDTO.getCardNumber().startsWith("4844") || creditCardDTO.getCardNumber().startsWith("4913") || creditCardDTO.getCardNumber().startsWith("4917")) || creditCardDTO.getCardNumber().length() != 16);


        if (creditCardDTO.getExpirationDate().isBefore(LocalDate.now()))
            throw new InvalidDateException(creditCardDTO.getExpirationDate());


        if (creditCardDTO.getType().equals("AMERICAN_EXPRESS")) {
            if (creditCardDTO.getCVV() < 999 || creditCardDTO.getCVV() > 9999)
                throw new InvalidCVVException(creditCardDTO.getCVV());

            if (!(creditCardDTO.getCardNumber().startsWith("34") || creditCardDTO.getCardNumber().startsWith("37")) || creditCardDTO.getCardNumber().length() != 15)
                throw new InvalidAmericanExpressPANException(creditCardDTO.getCardNumber());
        } else {

            if (creditCardDTO.getCVV() < 99 || creditCardDTO.getCVV() > 999)
                throw new InvalidCVVException(creditCardDTO.getCVV());


            if (VISA_CONDITION)
                throw new InvalidVisaPANException(creditCardDTO.getCardNumber());
            else if (MASTERCARD_CONDITION)
                throw new InvalidMastercardPANException(creditCardDTO.getCardNumber());
            else if (MAESTRO_CONDITION)
                throw new InvalidMaestroPANException(creditCardDTO.getCardNumber());
            else if (DISCOVER_CONDITION)
                throw new InvalidMaestroPANException(creditCardDTO.getCardNumber());
            else if (DINERS_CLUB_CONDITION)
                throw new InvalidDinersClubPANException(creditCardDTO.getCardNumber());
            else if (VISA_ELECTRON)
                throw new InvalidVisaElectronPANException(creditCardDTO.getCardNumber());
            else if (creditCardDTO.getCardNumber().length() < 16 || creditCardDTO.getCardNumber().length() > 19) //for other cards not covered by the previous conditions
                throw new InvalidCardPANLength(creditCardDTO.getCardNumber());
        }


        if (!validityLuhnsCheck(creditCardDTO.getCardNumber())){
            throw new InvalidLuhnAlgorithmPANException(creditCardDTO.getCardNumber());
        }    }

}
