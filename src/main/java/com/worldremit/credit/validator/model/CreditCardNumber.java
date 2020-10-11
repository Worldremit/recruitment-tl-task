package com.worldremit.credit.validator.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CreditCardNumber {
    private final String vendor;
    private final String number;
}
