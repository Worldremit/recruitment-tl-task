package validator;

import static org.junit.Assert.*;

import org.junit.Test;

public class ValidationBasicTests {
	
	private static ReadingCreditCardVendors reader = new CreditCardVendorsFileReader();
	private static CreditCardValidityChecking validator;
	private static CreditCardVendor vendorMasterCard = reader.getVendorByName("MasterCard");

	@Test
	public void testLengthOfCardNumberWhenCorrectWithMasterCardStandard() {
		String number = "5584239583699571";
		validator = new CreditCardNumberLengthValidityChecker();
		assertEquals(true, validator.checkValidity(vendorMasterCard, number));
	}

	@Test
	public void testLengthOfCardNumberWhenIncorrectWithMasterCardStandard() {
		String number = "55842395";
		validator = new CreditCardNumberLengthValidityChecker();
		assertEquals(false, validator.checkValidity(vendorMasterCard, number));
	}

	@Test
	public void testValidityCardNumberWhenCorrectWithIINStartingMaskMasterCardStandard() {
		String number = "5584239583699571";
		validator = new CreditCardMaskValidityChecker();
		assertEquals(true, validator.checkValidity(vendorMasterCard, number));
	}

	@Test
	public void testValidityCardNumberWhenIncorrectWithIINStartingMaskMasterCardStandard() {
		String number = "7784239583699571";
		validator = new CreditCardMaskValidityChecker();
		assertEquals(false, validator.checkValidity(vendorMasterCard, number));
	}

	@Test
	public void testLuhnAlghoritmWhenCardNumberCorrect() {
		String number = "5584239583699571";
		validator = new LuhnalgorithmValidityChecker();
		assertEquals(true, validator.checkValidity(vendorMasterCard, number));
	}

	@Test
	public void testLuhnAlghoritmWhenCardNumberIncorrect() {
		String number = "5584239583611111";
		validator = new LuhnalgorithmValidityChecker();
		assertEquals(false, validator.checkValidity(vendorMasterCard, number));
	}

}
