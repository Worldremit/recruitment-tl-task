package validator;

public interface CreditCardChecking { // Not sure if this interface is required here (we dont have any other implementation for that, and probably will not have). If it is - The name should be either adjective or noun, maybe
	boolean checkValidity(CreditCardVendor ccv, String number); // i would call the method just - validate
	// modifier public is redundant on the interface methods, since it's already public
}
