package validator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreditCardVendorsReader implements CreditCardVendorReading {
	@Override
	public ArrayList<CreditCardVendor> returnVendorArray() {
		ArrayList<CreditCardVendor> list = new ArrayList<CreditCardVendor>();//diamon operator should be used the the type of variable list should be List.
		//also the name should be descriptive (e.g. VendorsList ?)

		try(BufferedReader br = new BufferedReader(new FileReader("Base_of_credit_card_vendors.txt"))) {
			// as mentioned in comments.txt the data of the Vendors should not be stored in the text file. I would suggest to store it in the config
			// also in order to decrease level of complexity (with list of rules (card number length + mask) - we might have a few records for the same vendor but with different rules
			// example
			// MasterCard 16 2221-2720
			// MasterCard 14 51-55
		    for(String line; (line = br.readLine()) != null; ) {
		        String[] values = line.split(" ");
		        
		        String vendorName = values[0];
		        ArrayList<Integer> vendorNumbersOfChars = new ArrayList<Integer>();
		        ArrayList<String> vendorMasks = new ArrayList<String>();
		        
		        parseLengths(values[1], vendorNumbersOfChars);
		        parseMasks(values[2], vendorMasks);
		        
		        list.add(new CreditCardVendor(vendorName,vendorNumbersOfChars,vendorMasks));
		        
		    }
		} catch (FileNotFoundException e) {
			e.printStackTrace();// the error should be logged and either continue the flow (if it's possible) or fail
			// instead of printing the stacktrace into the command line - it should be logged with some logger
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	private void parseLengths(String value, ArrayList<Integer> vendorNumbersOfChars){ // Method should not take the vendomNumberOfChars and update it - it should just return the parsed length
		String[] values = value.split("/");
		for(int i=0; i<values.length; i++){
        	vendorNumbersOfChars.add(Integer.parseInt(values[i]));
        }
	}

	private void parseMasks(String value,  ArrayList<String> vendorMasks){ // the same as above method should return data instead of updating the vendorMasks
	     String[] masks = value.split("/");
	     for(int i=0;i<masks.length; i++){
	     	if (masks[i].split("-").length == 1){
	     		vendorMasks.add(masks[i]);
	     	}else{
	     		long min= Long.parseLong((masks[i].split("-"))[0]); // It's redundant to use Long here
	     		long max= Long.parseLong((masks[i].split("-"))[1]);// It's redundant to use Long here
	     		for (long j = min; j<=max;j++)
	     			vendorMasks.add(""+j);
	     	}
	     }
	}
	
}
