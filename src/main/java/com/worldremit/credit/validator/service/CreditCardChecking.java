package com.worldremit.credit.validator.service;

public interface CreditCardChecking {
	public boolean checkValidity(CreditCardVendor ccv, String number);
}
