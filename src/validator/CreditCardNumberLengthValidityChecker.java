package validator;

import java.util.ArrayList;
import java.util.List;

public class CreditCardNumberLengthValidityChecker implements CreditCardValidityChecking {

	@Override
	public boolean checkValidity(CreditCardVendor vendor, String number) {
		ArrayList<Integer> validLengthsOfCardNumber = vendor.getNumberOfChars();
		return checkLengthCorrectness(number, validLengthsOfCardNumber);
	}

	private boolean checkLengthCorrectness(String number, List<Integer> lengths) {
		boolean result = false;
		for (int i = 0; i < lengths.size(); i++) {
			if (lengths.get(i) == number.length())
				result = true;
		}
		return result;
	}

}
