package validator;

import java.util.ArrayList;
import java.util.List;

public class CreditCardMaskValidityChecker implements CreditCardValidityChecking {

	@Override
	public boolean checkValidity(CreditCardVendor vendor, String number) {
		ArrayList<String> availableIINmasks = vendor.getIINs();
		return checkIINStartingMaskCorrectness(number, availableIINmasks);
	}

	private boolean checkIINStartingMaskCorrectness(String number, List<String> availableStartingMasks) {
		boolean result = false;
		for (int i = 0; i < availableStartingMasks.size(); i++) {
			if (number.startsWith(availableStartingMasks.get(i)))
				result = true;
		}
		return result;
	}
}
