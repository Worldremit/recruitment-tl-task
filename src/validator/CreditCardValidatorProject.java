package validator;

public class CreditCardValidatorProject {

	private static ReadingCreditCardVendors reader = new CreditCardVendorsFileReader();
	private static CreditCardVendor vendor;
	private static CreditCardValidatorCreating creator = new CreditCardValidatorCreator();
	private static CreditCardValidityChecking validator = creator.createCreditCardValidator();

	public static void main(String[] args) {
		if (!validateNumberOfArguments(args)) {
			System.out.println("Argumets should be 2: VendorName CardNumber");
			return;
		}
		vendor = reader.getVendorByName(args[0]);
		tryToCheckValidity(args);
	}

	static private boolean validateNumberOfArguments(String[] args) {
		return args.length == 2;
	}

	static private void printResultOfValidation(boolean result) {
		if (result) {
			System.out.println("\n\nCard number is valid.\n");
		} else {
			System.out.println("\n\nCard number is invalid!\n");
		}
	}
	
	private static void tryToCheckValidity(String[] args) {
		if(vendor == null) {
			System.out.println("No vendor in our base!");
			return;
		}
		boolean result = validator.checkValidity(vendor, args[1]);
		printResultOfValidation(result);
	}
}
