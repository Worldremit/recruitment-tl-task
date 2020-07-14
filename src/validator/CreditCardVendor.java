package validator;

import java.util.ArrayList;

public class CreditCardVendor {
	private String name;
	private ArrayList<Integer> numberOfChars;
	private ArrayList<String> availableIINs;
	
	public CreditCardVendor(String vendorName, ArrayList<Integer> charsNumbers, ArrayList<String> masks) {
		name = vendorName;
		numberOfChars = charsNumbers;
		availableIINs = masks;
	}

	public String getName() {
		return name;
	}

	public ArrayList<Integer> getNumberOfChars() {
		return numberOfChars;
	}

	public ArrayList<String> getIINs() {
		return availableIINs;
	}

	@Override
	public String toString() {
		return name;
	}
}
