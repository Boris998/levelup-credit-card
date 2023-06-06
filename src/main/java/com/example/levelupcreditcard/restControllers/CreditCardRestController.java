package com.example.levelupcreditcard.restControllers;

import com.example.levelupcreditcard.model.dto.CreditCardDTO;
import com.example.levelupcreditcard.model.exceptions.*;
import com.example.levelupcreditcard.service.CreditCardInfoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


@RestController
@CrossOrigin(origins = {"http://localhost:3000", "http://localhost:3001"})
@RequestMapping("/api/card")
public class CreditCardRestController {
    private final CreditCardInfoService creditCardInfoService;

    public CreditCardRestController(CreditCardInfoService creditCardInfoService) {
        this.creditCardInfoService = creditCardInfoService;
    }



    @PostMapping("/validate")
    public ResponseEntity<Map<String, String>> validate(@RequestBody CreditCardDTO creditCardDTO) {
        try {
            creditCardInfoService.validate(creditCardDTO);
            return ResponseEntity.ok().build();
        } catch (InvalidDateException | InvalidCVVException | InvalidAmericanExpressPANException |
                 InvalidVisaPANException |
                 InvalidMastercardPANException | InvalidMaestroPANException | InvalidDinersClubPANException |
                 InvalidVisaElectronPANException | InvalidCardPANLength | InvalidLuhnAlgorithmPANException e) {
            Map<String, String> errorResponse = new HashMap<>();
            errorResponse.put("error", e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
    }


    //first try
    /*@PostMapping("/validate")
    public ResponseEntity<CreditCardDTO> validate(@RequestBody CreditCardDTO creditCardDTO) {
        try {

            *//*String typeString = creditCardDTO.getType();
            CreditCardType type = Enum.valueOf(CreditCardType.class, typeString);*//*

            CreditCardDTO creditCard = new CreditCardDTO(creditCardDTO.getCardHolderName(), creditCardDTO.getCardNumber(),
                    creditCardDTO.getCVV(), creditCardDTO.getExpirationDate(), creditCardDTO.getType());

            creditCardInfoService.validate(creditCard);

            return ResponseEntity.ok(creditCard);

        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }*/

    //second try
    /*//create CreditCardDTO and requestbody it
    @PostMapping("/validate")
    public ResponseEntity<?> validate(@RequestBody CreditCardDTO creditCardDTO) {
        try {
            creditCardInfoService.validate(creditCardDTO);
            return ResponseEntity.ok().build();
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }*/
}
