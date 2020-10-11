package com.worldremit.credit.validator.controller;

import com.worldremit.credit.validator.model.CreditCardNumber;
import com.worldremit.credit.validator.model.CreditCardNumberValidationResponse;
import com.worldremit.credit.validator.service.CreditCardNumberValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CreditCardNumberController {

    @Autowired
    private final CreditCardNumberValidationService validationService;

    public CreditCardNumberController(CreditCardNumberValidationService validationService) {
        this.validationService = validationService;
    }

    @PostMapping ("credit_card/number/validate")
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public CreditCardNumberValidationResponse validateCreditCardNumber(@RequestBody CreditCardNumber number){
        return new CreditCardNumberValidationResponse(validationService.validate(number));
    }
}
