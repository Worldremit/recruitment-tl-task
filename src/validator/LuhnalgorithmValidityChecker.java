package validator;

public class LuhnalgorithmValidityChecker implements CreditCardValidityChecking {

	@Override
	public boolean checkValidity(CreditCardVendor vendor, String number) {

		String[] characters = number.split("");
		int[] intCharsReverse = new int[characters.length];
		int sum = 0;

		for (int i = 0; i < characters.length; i++) {
			intCharsReverse[characters.length - 1 - i] = Integer.parseInt(characters[i]);
		}

		for (int i = 0; i < intCharsReverse.length; i++) {
			intCharsReverse[i] = (i % 2 == 1) ? 2 * intCharsReverse[i] : intCharsReverse[i];
		}

		for (int i = 0; i < intCharsReverse.length; i++) {
			sum += (intCharsReverse[i] < 10) ? intCharsReverse[i] : (intCharsReverse[i] % 10 + intCharsReverse[i] / 10);
		}

		return sum % 10 == 0;
	}

}
