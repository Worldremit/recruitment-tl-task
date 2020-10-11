package com.worldremit.credit.validator.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CreditCardNumberValidationResponse {
    private boolean valid;
}
