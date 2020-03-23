
/*
 * 1) The argument myFactory for the constructor indicates which factory we will use.
 *    Note that its type is the abstract superclass IncomeTaxFactory.
 * 2) Using myFactory, generate the objects to create 
 * 		i) the date to be computed by dateObject, 
 *      ii) the date and the address to be used in the letter, generated using 
 *          the object myDateAddress,
 *      iii) the salutation  generated using the object mySalutation,
 *      iv) the body of the letter which will include the amount of 
 *          tax which will be computed by the object myTaxComputer. This
 *          is generated by the object myLetterBody.
 *          
 * 3) A method generateLetter which will actually call the appropriate methods from
 *    the above objects to create the letter.
 * 
 */

public class TaxMaster {
	private MyDate dateObject;
	private TaxComputer myTaxComputer;
	private Salutation mySalutation;
	private LetterBody myLetterBody;
	private DateAddress myDateAddress;
	public TaxMaster(IncomeTaxFactory myFactory){
		dateObject = myFactory.dateFactory();
		myDateAddress = myFactory.createDateAddress();
		myTaxComputer = myFactory.computeTax();
		mySalutation = myFactory.displaySalutation();
		myLetterBody = myFactory.displayBodyLetter();
		
	}
	public String generateLetter(String name, String address, String gender, double income){
		double incomeTax;
		String outputString;
		outputString = myDateAddress.displayDateAddress(dateObject, 
				                                        name,
				                                        address);			     	                                                      
		outputString += "\n\n" + mySalutation.salutationGenerator(name, gender);
		incomeTax = myTaxComputer.calculateTax(income);
		outputString += "\n" + myLetterBody.generateLetterBody(incomeTax);
		return outputString;
	}
}
