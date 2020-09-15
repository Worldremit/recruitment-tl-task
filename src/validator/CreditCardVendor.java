package validator;

import java.util.ArrayList;

public class CreditCardVendor { // If i would choose to have splitted config for every vendor rule (a few MasterCard rules) I would call this class as CreditCardVendorRule. It would flatten the structure of this object
	private String name; // there are not that many vendors in the world - should be represented as enum
	private ArrayList<Integer> allowedCardLengths; // if data is read from config - all these vars might be final
	// i would try to find better name for this variable (e.g. cardNumberLength? )
	// no need here to use ArrayList, List is enough. I'd call it probably `allowedLengthsOfCard`
	private ArrayList<String> cardMasks;
	// name should be descriptive (e.g. cardNumberMask? )
	// again ArrayList -> List
	public String getName(){
		return name;
	}

	//for cleaning the domain code from standard structures (getters, setters, constructors) we might use the LOmbok for that
	public ArrayList<Integer> getAllowedCardLengths(){
		return allowedCardLengths;
	}
	
	public ArrayList<String> getCardMasks(){
		return cardMasks;
	}
	
	public CreditCardVendor(String vendorName, ArrayList<Integer> charsNumbers, ArrayList<String> masks){
		name = vendorName;
		allowedCardLengths = charsNumbers;
		cardMasks = masks;
	}


	// I suggest to have the method within this object `Verify` - to verify the credit card for validity, it will make easier to validate the card having a stream on the List of CredirCardVendorRules

	
	@Override
	public String toString(){
		return name;
	} // Not sure if there is a requirement for such toSTring method. I would rather include all the details (unless it's prohibited) and generate the method with either IDE or Lombok
}
