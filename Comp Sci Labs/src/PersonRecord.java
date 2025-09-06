
public class PersonRecord
{
 // instance variables (attributes, properties, fields, global variables)
 
 
 private String ssNumber;  // (must be unique)
 
 private String personName; 
  
 private String dateOfBirth;
 
 private double taxableIncome;
 
 private double taxesOwed;
 
 private double temp;

  
 
 // init constructor
 public PersonRecord(String ssNumber, String personName, String dateOfBirth, double taxableIncome)
 {
  // FINISH ME
this.ssNumber = ssNumber;
this.personName = personName;
this.dateOfBirth = dateOfBirth;
this.taxableIncome = taxableIncome;
this.temp = taxableIncome;


  
  this.taxesOwed = getTaxesOwed();
 }


 public String getSSNumber()
 {
  // FINISH ME
   return ssNumber;

 }


 public String getPersonName()
 {
  // FINISH ME
return personName;
 }


 public String getDateOfBirth()
 {
  // FINISH ME
return dateOfBirth;
 }


 public double getTaxableIncome()
 {
  // FINISH ME
return taxableIncome;
 }


 public double getTaxesOwed()
 {
  // FINISH ME
  // You will pay $0.00 for your first 10,000 of taxable income 
  // You will pay 10% for income > 10,000 and <= 40,000 of taxable income 
  // You will pay 15% for income > 40,000 and <= 70,000 of taxable income 
  // You will pay 20% for income > 70,000 and <= 100,000 of taxable income 
  // You will pay 25% for income > 100,000 and <= 500,000 of taxable income 
  // You will pay 28% for income > 500,000 
  taxableIncome = temp;
	 
  double taxesOwed = 0;
  if (taxableIncome <= 10000)
  {
	  return taxesOwed;
  }
  taxableIncome -= 10000;
  if (taxableIncome <= 30000)
  {
	  return 0.1 * taxableIncome;
  }
  taxesOwed += 30000 * 0.1;
  taxableIncome -= 30000;
  if (taxableIncome <= 30000)
  {
	  return taxesOwed + 0.15 * taxableIncome;
  }
  taxesOwed += 30000 * 0.15;
  taxableIncome -= 30000;
  if (taxableIncome <= 30000)
  {
	  return taxesOwed + 0.2 * taxableIncome;
  }
  taxesOwed += 30000 * 0.2;
  taxableIncome -= 30000;
  if (taxableIncome <= 400000)
  {
	  return taxesOwed + 0.25 * taxableIncome;
  }
  taxesOwed += 400000 * 0.25;
  taxableIncome -= 400000;

  return taxesOwed + 0.28 * taxableIncome;
 }



 // ###############################################
 // ###############################################
 // ###############################################
 // setter (modifier or mutator methods)
 // that allow us to change the value of an 
 // instance variable (attribute, property, field, record, ...)
 // but we do not let them change driversLicense (unique)
 // ###############################################
 // ###############################################
 // ###############################################
 

 public void setPersonName(String personName)
 {
  // FINISH ME
	 this.personName = personName;
 }


 public void setDateOfBirth(String dateOfBirth)
 {
  // FINISH ME
	 this.dateOfBirth = dateOfBirth;
 }


 public void setTaxableIncome(double taxableIncome)
 {
  // FINISH ME
	 this.taxableIncome = taxableIncome;
 }




 // FINISH ME
 // WRITE A toString() method
 public String toString()
 {
  // FINISH ME
  // return all values of instance variables with a label
  return " Person Name:     " + personName + "\n" +
               " SS Number:       " + ssNumber + "\n" +
               " Date of Birth: " + dateOfBirth + "\n" +
               " Taxable Income: " + temp  + "\n" +
  				" Taxes Owed: " + getTaxesOwed() + "\n";
 }

}


