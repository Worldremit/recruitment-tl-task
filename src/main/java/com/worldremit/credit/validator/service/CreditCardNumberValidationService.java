package com.worldremit.credit.validator.service;

import com.worldremit.credit.validator.model.CreditCardNumber;

public interface CreditCardNumberValidationService {
    boolean validate(CreditCardNumber number);
}
