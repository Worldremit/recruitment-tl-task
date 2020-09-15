package validator;

import java.util.ArrayList;

public interface CreditCardVendorReading { // i would remove this interface, it won't have any other implementation
	 ArrayList<CreditCardVendor> returnVendorArray(); // name of the method should not contain `return`, rather `get` keyword
	// public is not required
}
