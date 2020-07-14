package validator;

public class CreditCardValidatorCreator implements CreditCardValidatorCreating {

	@Override
	public CreditCardValidator createCreditCardValidator() {
		CreditCardValidator validator = new CreditCardValidator();
		validator.addCheckingComponent(new CreditCardNumberLengthValidityChecker());
		validator.addCheckingComponent(new CreditCardMaskValidityChecker());
		validator.addCheckingComponent(new LuhnalgorithmValidityChecker());
		return validator;
	}

}
