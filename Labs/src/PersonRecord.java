
public class PersonRecord
{
 // instance variables (attributes, properties, fields, global variables)
 
 
 private String ssNumber;  // (must be unique)
 
 private String personName; 
  
 private String dateOfBirth;
 
 private double taxableIncome;
 
 private double taxesOwed;

  
 
 // init constructor
 public PersonRecord(String ssNumber, String personName, String dateOfBirth, double taxableIncome)
 {
  // FINISH ME
this.ssNumber = ssNumber;
this.personName = personName;
this.dateOfBirth = dateOfBirth;
this.taxableIncome = taxableIncome;


  
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
  
  double taxesOwed = 0;
  
  // FINISH ME
 
   
  if(taxableIncome <= 10000)
    taxesOwed = 0;
  
  else if (10000 < taxableIncome && taxableIncome <= 40000)
  {
    double a = taxableIncome - 10000;
   taxesOwed = a * 0.1;
   
  }
  // FINISH ME
  
  else if (40000 < taxableIncome && taxableIncome <= 70000)
  {
    double b = taxableIncome - 10000;
    
    double c = b - 30000;
    taxesOwed = c * 0.15 + (30000 * 0.1);
  }
  
  else if (70000 < taxableIncome && taxableIncome <= 100000)
  {
    double d = taxableIncome - 10000;
    double e = d - 30000;
    double f = e - 30000;
    taxesOwed = f * 0.20 + (30000 * 0.15) + (30000 * 0.10);
  }
  
  else if (100000 < taxableIncome && taxableIncome <= 500000)
  {
    double g = taxableIncome - 100000;
    
    taxesOwed = (g * 0.25) + (30000 * 0.20) + (30000 * 0.15) + (30000 * 0.1);
  }
  
  else if (taxableIncome > 500000)
  {
    double h = taxableIncome - 500000;
    
    taxesOwed = (h * 0.28) + (400000 * 0.25) + (30000 * 0.20) + (30000 *0.15) + (30000 * 0.1);
  }
  
  
  return taxesOwed; // change me ???
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
personName = this.personName;
 }


 public void setDateOfBirth(String dateOfBirth)
 {
  // FINISH ME
dateOfBirth = this.dateOfBirth;
 }


 public void setTaxableIncome(double taxableIncome)
 {
  // FINISH ME
taxableIncome = this.taxableIncome;
 }




 // FINISH ME
 // WRITE A toString() method
 public String toString()
 {
  // FINISH ME
  // return all values of instance variables with a label
  return " Person Name:     " + personName + "\n" + " SS Number:       " + ssNumber + "\n" + "Date of Birth:      " + dateOfBirth + "\n" + "Income:    " + taxableIncome + "\n" + "Taxes Owned:    " + taxesOwed + "\n\n";
 }


}


