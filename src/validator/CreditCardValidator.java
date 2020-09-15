package validator;

import java.util.ArrayList;

public class CreditCardValidator implements CreditCardChecking { // I doubt we need an interface for the checkValidity method. Lets just have validation method without interface

	@Override
	public boolean checkValidity(CreditCardVendor vendor, String cardNumber) { // checkValidity -> validate(CreditCardVendor vendor, String cardNumber)
		// also I believe that validate logic is strictly domain logic. and domain should be responsible for validatin the card with it's own rules. We do need to move this functionality to the CreditCartdVendor
		ArrayList<Integer> chars = vendor.getAllowedCardLengths();
		//
		ArrayList<String> masks = vendor.getCardMasks();
		
		boolean result1 = checkLengthCorrectness(cardNumber, chars);
		boolean result2 = checkIINMaskCorrectness (cardNumber, masks);
		boolean result3 = isValidByLuhnAlgorithm(cardNumber);
		// all the variables should have meaningful names. resultX...  gives us nothing to understand what's there
		return result1 && result2 && result3; // validation should be consequent and fail-fast. Once we know that some of the results is false - should return that instantly
	}
	
	private boolean checkLengthCorrectness(String number, ArrayList<Integer> chars){ // I'd call it isCardLengthValid()
		boolean result = false;
		for (int i = 0; i<chars.size();i++){
			if (chars.get(i) == number.length())
				result = true;
		}
		return result;
	}
	
	private boolean checkIINMaskCorrectness (String number, ArrayList<String> masks){ // name -> isCardNumberValid
		boolean result = false;
		for (int i = 0; i<masks.size();i++){
			if (number.startsWith(masks.get(i)))
				result = true;
		}
		return result;
	}
	
	private boolean isValidByLuhnAlgorithm(String number){ // I'm not fully familiar with Luhn algoritm to validate the card number but the solution might be simplified
//		boolean result = false;
//
//		String[] characters = number.split("");
//		int[] intCharsReverse = new int[characters.length];
//		int sum = 0;
//
//		for(int i = 0;i<characters.length;i++){
//			intCharsReverse[characters.length-1-i] = Integer.parseInt(characters[i]);
//		}
//
//		for(int i = 0;i<intCharsReverse.length;i++){
//			intCharsReverse[i] = (i%2==1) ? 2*intCharsReverse[i] : intCharsReverse[i];
//		}
//
//		for(int i = 0;i<intCharsReverse.length;i++){
//			sum += (intCharsReverse[i]<10) ? intCharsReverse[i] : (intCharsReverse[i]%10 + intCharsReverse[i]/10);
//		}
//
//		if(sum%10==0)
//			result = true;
//
//		return result;

		int nDigits = number.length();

		int nSum = 0;
		boolean isSecond = false;
		for (int i = nDigits - 1; i >= 0; i--) {
			int d = number.charAt(i) - '0';

			if (isSecond) {
				d = d * 2;
			}
			nSum += d / 10;
			nSum += d % 10;

			isSecond = !isSecond;
		}
		return (nSum % 10 == 0);
	}

}
