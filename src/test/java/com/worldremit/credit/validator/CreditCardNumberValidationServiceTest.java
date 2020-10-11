package com.worldremit.credit.validator;


import com.worldremit.credit.validator.model.CreditCardNumber;
import com.worldremit.credit.validator.service.CreditCardNumberValidationService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class CreditCardNumberValidationServiceTest {
    @Autowired
    private CreditCardNumberValidationService service;
    private final static String VISA_VENDOR = "Visa";
    private final static String MASTER_CARD_VENDOR = "MasterCard";

    @ParameterizedTest
    @CsvSource({
            "MasterCard,5584239583699571,true",
            "MasterCard,55842395,false",
            "MasterCard,5247041838016349,true",
            "MasterCard,7784239583699571,false",
            "MasterCard,5116716270068043,true",
            "MasterCard,5555555555554444,true"
    })
    public void testLengthOfNumberWhenCorrect(String vendor, String number, boolean result){
        assertEquals(result, service.validate(CreditCardNumber.builder().number(number).vendor(vendor).build()));
    }

    @Test
    public void testAlgo(){
        String number = "5584239583699571";
        int length = number.length();
        IntStream.range(0,length).mapToObj(i-> number.charAt(length-i-1)).forEach(System.out::println);
    }
}
