package validator;

import java.util.ArrayList;

public class CreditCardValidator implements CreditCardValidityChecking {
	
	private ArrayList<CreditCardValidityChecking> checkingComponents = new ArrayList<CreditCardValidityChecking>();

	@Override
	public boolean checkValidity(CreditCardVendor vendor, String number) {
		if (checkingComponents.size() == 0)
			return false;

		for (int i = 0; i < checkingComponents.size(); i++) {
			if (!checkingComponents.get(i).checkValidity(vendor, number)) {
				return false;
			}
		}
		return true;
	}

	public void addCheckingComponent(CreditCardValidityChecking checker) {
		checkingComponents.add(checker);
	}

}
