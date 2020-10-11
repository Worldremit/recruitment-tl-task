package com.worldremit.credit.validator.model;

import lombok.Data;

import java.util.List;

@Data
public class CreditCardVendor {
    private String name;
    private List<Integer> lengths;
    private List<IssuerIdentificationNumber> iins;
}
