public class Cat extends Object implements Comparable<Cat>
{
	// Add two instance variables called 
	// name (String)  and age (int)  (private please)
	
	private String name;

	private int age;
	// Write an init constructor.
	// The init constructor should receive a name for the 
	// cat and an age for the cat (in that order)
	public Cat(String a, int b)
	{
		name  =  a;
			
		age  =  b;	
	}

	// Write a getName() method
	public String   getName()
	{
		return name;
	}

	// Write a getAge() method
	public int  getAge()
	{
		return age;
	}

	// This method was declared in the 
	// comparable interface!  We must write it!
	// Sort by age.
	public int compareTo(Cat other)
	{
		// we should return -1 if this cat is less 
		// than the other cat
		if (age < other.age)
			return -1;
		
		// we should return 1 if this cat is greater 
		// than the other cat
		if (age > other.age)
			return 1;

		// we should return 0 if this cat is equal to 
		// the other cat

		return 0;
	}



	// Write a toString() method
	// The toString() method should return the
	// name of the Cat followed by a space followed by the age
	// of the Cat followed by a space followed by the value of
	// the isTame instance variable.

	public String   toString()
	{

		return getAge() + "";

	}

}
