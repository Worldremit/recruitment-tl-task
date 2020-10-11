package com.worldremit.credit.validator.service;

import com.worldremit.credit.validator.model.CreditCardNumber;
import com.worldremit.credit.validator.model.CreditCardVendor;
import com.worldremit.credit.validator.model.CreditCardVendors;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CreditCardNumberValidatorServiceImpl implements CreditCardNumberValidationService {
    private final static CreditCardValidator validator = new CreditCardValidator();

    @Resource
    private  CreditCardVendors creditCardVendors;


    @Override
    public boolean validate(CreditCardNumber number) {
        String vendor = number.getVendor();
        CreditCardVendor creditCardVendor = creditCardVendors.getVendors().stream().
                filter(c -> c.getName().equalsIgnoreCase(vendor)).findFirst().
                orElseThrow(() -> new IllegalArgumentException("Vendor:" + vendor + "is not supported"));
        return validator.checkValidity(creditCardVendor, number.getNumber());
    }
}
