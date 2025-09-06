import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class Puddle
{
	// no instance variables are needed
	
	
	public static void main(String[] args) throws IOException
	{

		// print out your first and last name
		
		
		// reads in the puddle.dat file and puts it
		// in a Scanner object 	
		Scanner input = new Scanner(new File("puddle.dat"));

					
		int numRows = input.nextInt(); 
		int numCols = input.nextInt(); 
		input.nextLine(); // move to the next line in the data file
		
		// create your 2D Array
		char[][] board = new char[numRows][numCols];
		
		
		// loop through each row by column by column and fill your 2D array		
		for(int i = 0; i < numRows; i++) 
		{	
			String value = input.next();
			for (int j =0; j < numCols; j++)
			{
				board[i][j] = value.charAt(j);
			}
			input.nextLine();
			// move to the next line in the data file
		}		
		// finished reading in board data
		
		// now read in the number of moves
		int count = input.nextInt();
		// move to the next line in your data file
		input.nextLine();
		// now loop through all of the moves
		
		for(int z = 0; z < count; z++) 
		{	
			int x = input.nextInt();
			int y = input.nextInt();
			if (board[x][y] == 'G')
			{
				System.out.println("OK");
			}
			else if (board[x][y] == 'W')
			{
				System.out.println("PUDDLE");
			}
			else
			{
				System.out.println("OOPS");
			}
			input.nextLine();
		}
			
			
		input.close();

	} // end of main method

} // end of class
