import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class CD
{
	// no instance variables are needed
	
	
	public static void main(String[] args) throws IOException
	{

		// print out your first and last name
		System.out.println("Daniel Yang");
		
		
		// reads in the cd.dat file and puts it
		// in a Scanner object 	
		Scanner input = new Scanner(new File("gift.dat")); 	
		
		
		//Scanner input = new Scanner(System.in); for keyboard 
		
		
		
		// Sample file
			
			
		int numDataSets = input.nextInt();  
		input.nextLine(); // move to the next line in the data file
		
		ArrayList<Integer> values = new ArrayList<Integer>();
		ArrayList<String> songs = new ArrayList<String>();
		ArrayList<Integer> alreadyUsed = new ArrayList<Integer>();
		
		
		// loop through each data set		
		for(int i = 0; i < numDataSets; i++) 
		{
			String songList = "";
			int x = 4;
			int sum = 0;
			String maxTime = input.nextLine();
			String withoutSpaces = input.nextLine().replaceAll(" ", "").replaceAll(":", "");
			while (x <= withoutSpaces.length())
			{
				String songLength = withoutSpaces.substring(x-4, x);
				String minutes2 = songLength.substring(0, 2);
				String seconds2 = songLength.substring(2, 4);
				Integer minutes = Integer.parseInt(minutes2);
				Integer seconds = Integer.parseInt(seconds2);
				values.add(minutes * 60 + seconds);
				songs.add(minutes2 + ":" + seconds2);
			}
			Collections.sort(values);
			Collections.sort(songs);
			int maxValue = Integer.parseInt(maxTime.substring(0, 2)) * 60 + Integer.parseInt(maxTime.substring(2, 4));
			int index = 0;
			while (sum <= maxValue)
			{
				if (!alreadyUsed.contains(values.get(index)))
				{
					sum += values.get(index);
					index++;
					songList = songList + songs.get(index) + " ";
					System.out.println("here");
				}
				else
				{
					alreadyUsed.add(values.get(index));
					index++;
					System.out.println("here2");
				}
			}
			System.out.println(songList);
			values.clear();
			songs.clear();
			alreadyUsed.clear();
			input.nextLine();
		}		
			
			
		input.close();

	} // end of main method

} // end of class

