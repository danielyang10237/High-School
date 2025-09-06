import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class Square
{
	// no instance variables are needed
	
	
	public static void main(String[] args) throws IOException
	{

		// print out your first and last name
		
		
		// reads in the square.dat file and puts it
		// in a Scanner object 	
		Scanner input = new Scanner(new File("square.dat")); 	

		//Scanner input = new Scanner(System.in); for keyboard 	


		// Sample file
		// 3
		// one 
		// three
		// fifteen
			
		int numDataSets = input.nextInt();  
		input.nextLine(); // move to the next line in the data file
		
		
		// loop through each data set		
		for(int i = 0; i < numDataSets; i++) 
		{
			String word = input.nextLine();
			ArrayList<Character> wordArray = new ArrayList<Character>();
			for (int x = 0; x < word.length(); x++)
			{
				wordArray.add(word.charAt(x));
			}
			System.out.println(word);
			int length = word.length();
			int x = length-1;
			for (int y = 1; y < length-1; y++)
			{
				
			}
			System.out.println()
		}		
			
			
		input.close();

	} // end of main method

} // end of class

