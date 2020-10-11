package com.worldremit.credit.validator.service;

import com.worldremit.credit.validator.model.CreditCardVendor;
import com.worldremit.credit.validator.model.IssuerIdentificationNumber;

import java.util.List;
import java.util.stream.IntStream;

public class CreditCardValidator {

    public static boolean checkValidity(CreditCardVendor vendor, String number) {
        List<Integer> chars = vendor.getLengths();
        List<IssuerIdentificationNumber> masks = vendor.getIins();

        boolean isLengthValid = isLengthValid(number, chars);
        boolean isIinValid = isIinValid(number, masks);
        boolean isLuhnAlgorithmValid = isLuhnAlgorithmValid(number);

        return isLengthValid && isIinValid && isLuhnAlgorithmValid;
    }

    private static boolean isLengthValid(String number, List<Integer> chars) {
        Integer numberLength = number.length();
        return chars.stream().anyMatch(i -> i.equals(numberLength));
    }

    private static boolean isIinValid(String number, List<IssuerIdentificationNumber> iins) {
        return iins.stream().anyMatch(iin -> iin.isValidNumber(number));
    }

    private static boolean isLuhnAlgorithmValid(String number) {
        int length = number.length();


        int[] reversed = IntStream.range(0, length).map(i -> Character.digit(number.charAt(length - i - 1), 10)).toArray();

        long sum = IntStream.range(0, length)
                .map(i -> i % 2 == 1 ? reversed[i] * 2 : reversed[i])
                .map(i -> i > 9 ? i - 9 : i)
                .sum();

        return sum % 10 == 0;

    }

}
