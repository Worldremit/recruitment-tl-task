package com.worldremit.credit.validator.model;

import lombok.Data;

@Data
public class IssuerIdentificationNumber {
    private Integer start;
    private Integer end;

    public boolean isValidNumber(String number) {
        int numberOfChars = start.toString().length();
        Integer identification = Integer.valueOf(number.substring(0, numberOfChars));

        if (end == null) {
            return identification.equals(start);
        } else {
            return identification >= start && identification <= end;
        }
    }
}
