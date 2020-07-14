package validator;

public interface CreditCardValidityChecking {
	public boolean checkValidity(CreditCardVendor ccv, String number);
}
