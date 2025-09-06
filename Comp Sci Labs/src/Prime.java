import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class Prime
{
	// no instance variables are needed
	
	
	public static void main(String[] args) throws IOException
	{

		// print out your first and last name
		System.out.println("Daniel Yang");
		
		// reads in the prime.dat file and puts it
		// in a Scanner object 	
		Scanner input = new Scanner(new File("prime.dat")); 	

			
			
		int numDataSets = input.nextInt();  
		input.nextLine(); // move to the next line in the data file
		
		
		// loop through each data set		
		for(int i = 0; i < numDataSets; i++) 
		{
			int number = input.nextInt();
			for (int x = 2; x <= number; x ++)
			{
				while (number % x == 0)
				{
					System.out.print(x + " ");
					number /= x;
				}
			}
			System.out.println();
			input.nextLine();
		}		
			
			
		input.close();

	} // end of main method

} // end of class

