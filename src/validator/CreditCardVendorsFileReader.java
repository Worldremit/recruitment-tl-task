package validator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CreditCardVendorsFileReader implements ReadingCreditCardVendors {

	private ArrayList<CreditCardVendor> vendors = new ArrayList<CreditCardVendor>();

	@Override
	public CreditCardVendor getVendorByName(String name) {
		ReadVendorsFromFile();

		for (int i = 0; i < vendors.size(); i++) {
			if (vendors.get(i).getName().equals(name)) {
				return vendors.get(i);
			}
		}
		return null;
	}

	private void ReadVendorsFromFile() {
		try (BufferedReader br = new BufferedReader(new FileReader("Base_of_credit_card_vendors.txt"))) {
			for (String line; (line = br.readLine()) != null;) {
				String[] values = line.split(" ");

				String vendorName = values[0];
				ArrayList<Integer> vendorNumbersOfChars = new ArrayList<Integer>();
				ArrayList<String> vendorMasks = new ArrayList<String>();

				parseLengths(values[1], vendorNumbersOfChars);
				parseMasks(values[2], vendorMasks);

				vendors.add(new CreditCardVendor(vendorName, vendorNumbersOfChars, vendorMasks));
			}
		} catch (IOException e) {
			System.out.println("Problem with reading file with CreditCardVendors!");
		}
	}

	private void parseLengths(String valueReaded, ArrayList<Integer> vendorNumbersOfChars) {
		String[] valuesOfLengths = valueReaded.split("/");
		for (int i = 0; i < valuesOfLengths.length; i++) {
			vendorNumbersOfChars.add(Integer.parseInt(valuesOfLengths[i]));
		}
	}

	private void parseMasks(String valueReaded, ArrayList<String> vendorSartingIINMasks) {
		String[] masksIINUnparsedValues = valueReaded.split("/");
		for (int i = 0; i < masksIINUnparsedValues.length; i++) {
			if (masksIINUnparsedValues[i].split("-").length == 1) {
				vendorSartingIINMasks.add(masksIINUnparsedValues[i]);
			} else {
				long minMaskValue = Long.parseLong((masksIINUnparsedValues[i].split("-"))[0]);
				long maxMaskValue = Long.parseLong((masksIINUnparsedValues[i].split("-"))[1]);
				for (long j = minMaskValue; j <= maxMaskValue; j++)
					vendorSartingIINMasks.add("" + j);
			}
		}
	}

}
