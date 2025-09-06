// write the missing code for all of the FINISH ME comments


// FINISH ME
// My name is Daniel Yang


import java.util.*;
import java.io.*;

public class FileSearch {
    
    
	// FINISH ME
	// precondition:
	// You are given an ArrayList<FileObject> files that contains at least one object, and a String header
	// postcondition:
	// print out all of the files by calling each objects toString() method
	// DO NOT CALL files.toString(), you should get the object in the ith location
	//    (i.e. call files.get(i).toString()
	public static void printAllFiles(ArrayList<FileObject> files, String header)
	{		
		System.out.println("*******************************************");
		System.out.println();
		System.out.println(header);
		System.out.println();
		
		// put your code here
		
		
		for (int i =0; i < files.size(); i++)
		{
			System.out.println(files.get(i).toString());
		}
		

		System.out.println();
		System.out.println();		
	}    
 

	// FINISH ME
	// precondition:
	// You are given an ArrayList of String objects which contain the name of a band
	// a band name is in the ArrayList once only
	// postcondition:
	// print out all of the band names (the names of the bands, like The Beach Boys)

	public static void printAllBandNames(ArrayList<String> bandNames, String header)
	{		
		System.out.println("*******************************************");
		System.out.println();
		System.out.println(header);
		System.out.println();

		// put your code here
		
		for (int i =0; i < bandNames.size(); i++)
		{
			System.out.println(bandNames.get(i));
		}
		
		
		System.out.println();
		System.out.println();		
	}    
 

    
	// FINISH ME
	// precondition:
	// You are given an ArrayList<FileObject> files that contains at least one object, and a String path
	// postcondition:
	// return a new ArrayList of all FileObjects that match the String path
	public static ArrayList<FileObject> searchForFilesByPath(ArrayList<FileObject> files, String path)
	{
		
		ArrayList<FileObject> paths = new ArrayList<FileObject>();
		
		for (int i =0; i < files.size(); i++)
		{
			if (files.get(i).getPath().equals(path))
			{
				paths.add(files.get(i));
			}
		}
		
		return paths;
		
	}    
 
        

	// FINISH ME
	// precondition:
	// You are given an ArrayList<FileObject> files that contains at least one object, and a String year
	// postcondition:
	// return a new ArrayList of all FileObjects that match the year 
	public static ArrayList<FileObject> searchForFilesByCreationYear(ArrayList<FileObject> files, String year)
	{
		ArrayList<FileObject> paths = new ArrayList<FileObject>();
		
		for (int i =0; i < files.size(); i++)
		{
			if (files.get(i).getYear().equals(year))
			{
				paths.add(files.get(i));
			}
		}
		
		return paths;


	}    



	// FINISH ME
	// precondition:
	// You are given an ArrayList<FileObject> files that contains at least one object, a String month, and a String year
	// postcondition:
	// return a new ArrayList of all FileObjects that match the month and year 
	public static ArrayList<FileObject> searchForFilesByCreationMonthYear(ArrayList<FileObject> files, String month, String year)
	{
		
		ArrayList<FileObject> paths = new ArrayList<FileObject>();
		
		for (int i =0; i < files.size(); i++)
		{
			if (files.get(i).getYear().equals(year) && files.get(i).getMonth().equals(month))
			{
				paths.add(files.get(i));
			}
		}
		
		return paths;

		 		
	}    



	// FINISH ME
	// precondition:
	// You are given an ArrayList<FileObject> files that contains at least one object
	// postcondition:
	// return a new ArrayList that contains the name of each band
	public static ArrayList<String> findAllBandNames(ArrayList<FileObject> files)
	{
		 
		ArrayList<String> names = new ArrayList<String>();
		 
		for (int i =0; i < files.size(); i++)
		{
			if (names.contains(files.get(i).getBandName()) == false)
				names.add(files.get(i).getBandName());
		}
		 
		return names;			
		 		
	}    



	// FINISH ME
	// return an ArrayList of all FileObjects that are in the file
	public static ArrayList<FileObject> readInAllFileObjects(String nameOfFileToBeRead)
	{

		// FINISH ME
		// create an ArrayList of FileObject elements to send back to the caller
		ArrayList<FileObject> list = new ArrayList<FileObject>();

		Scanner scan = null;
		 
		try
		{
			// FINISH ME
			// create a Scanner object and pass it a new File object with the
			// parameter nameOfFileToBeRead, so it can read in our file
			// A File object will read in the file as a String and send it to
			// the Scanner object
			scan = new Scanner(new File(nameOfFileToBeRead));
			
			// FINISH ME
			// while the scan object has a next line, keep looping
			while(scan.hasNextLine())
			{
				// FINISH ME
				// we have found a FileObject so we will read in all of the data
				// and then create a new FileObject to hold the data
				
				// read in: 
				// String filename = 
				// String path = 
				// int size = 
				// flush the input buffer since we read in an int 
				// String date =
				// scan.nextLine(); to skip the blank line 
				//
				// then create a new FileObject to hold this data
				//
				// then add it to your list
				
				// FINISH ME
				// get the data from the file
				String filename = scan.nextLine();
				String path = scan.nextLine();
				int size = Integer.parseInt(scan.nextLine());
				String date = scan.nextLine();
				scan.nextLine(); // gets us past the blank line
				
				
				// FINISH ME
				// put the data that you read into a new FileObject
				FileObject file = new FileObject(filename, path, size, date);
				
				
				// FINISH ME
				// add the file to the list
				list.add(file);
				
			}
			
		}
		catch (Exception e)
		{
			// FINISH ME
			// print out an error message so we know that there was an error reading in the file
			// display the name of the file that was being read
			
			System.out.println("ERROR");
			
		}
		finally
		{
			// close the file
			scan.close();
		} 
		
		
		
		return list;			
	}  // end of public static ArrayList<FileObject> readInAllFileObjects  





	// *******************************************************
	// *******************************************************
	// *******************************************************
	// main method (program)  It all starts here!    
	// *******************************************************
	// *******************************************************
	// *******************************************************
    public static void main(String[] args) 
    {

		// FINISH ME
		// write your name
		System.out.println();
		System.out.println("My name is Daniel Yang");
		System.out.println();
		System.out.println();
	
		
						
		ArrayList<FileObject> theFilesAll = readInAllFileObjects("files.txt");
		printAllFiles(theFilesAll,"All Files");


		ArrayList<FileObject> theFiles = searchForFilesByPath(theFilesAll,"C:/dc5songs/The Dave Clark Five/");
		printAllFiles(theFiles,"All Files with Path=C:/dc5songs/The Dave Clark Five/");


		theFiles = searchForFilesByCreationYear(theFilesAll,"1964");
		printAllFiles(theFiles,"All Files with Year 1964");


		theFiles = searchForFilesByCreationMonthYear(theFilesAll,"04","1964");
		printAllFiles(theFiles,"All Files with Month 04 and Year 1964");


		ArrayList<String> theBandNamesAll = findAllBandNames(theFilesAll);
		 printAllBandNames(theBandNamesAll, "All Band Names");


		FileObject fileObject = theFilesAll.get(0);
		fileObject.setFilename("409.mp3");
		fileObject.setPath("C:/songs/BeachBoys/");
		fileObject.setSize(9000);
		fileObject.setDate("05/30/1967");
		printAllFiles(theFilesAll,"All Files");
		
		
		
		System.out.println();
		System.out.println();
 
    } // end of public static void main(String[] args) 
    
}





	// *******************************************************
	// *******************************************************
	// *******************************************************
	// interface FileObjectInterface
	// *******************************************************
	// *******************************************************
	// *******************************************************

	interface FileObjectInterface
	{
		// the band name is last part of the filename
		// Example:   C:/dc5songs/The Dave Clark Five/
		public abstract String getBandName();
		
		// the date is stored as mm/dd/yyyy
		public abstract String getMonth();
		public abstract String getDay();
		public abstract String getYear();		 
	} // end of interface FileObjectInterface






	// *******************************************************
	// *******************************************************
	// *******************************************************
	// class FileObject implements FileObjectInterface
	// *******************************************************
	// *******************************************************
	// *******************************************************

	class FileObject implements FileObjectInterface
	{
		private String filename;
		
		private String path;  // path of file (Example:  C:\files\)
		
		private int size;     // number of bytes stored
		
		private String date;  // stored as mm/dd/yyyy  Example: 03/20/2017
		
		
	
		// FINISH ME
		// write an init constructor that receives all input values for the instance variables
		public  FileObject(String filename, String path, int size, String date)
		{
			this.filename = filename;
			this.path = path;
			this.size = size;
			this.date = date;
		}



		// FINISH ME
		// write getter and setter methods
		
		
		public String getFileName()
		{
			return filename;
		}
		
		public String getPath()
		{
			return path;
		}
		
		public int getSize()
		{
			return size;
		}
		
		public String date()
		{
			return date;
		}
		
		
		public void setFilename(String a)
		{
			filename = a;
		}
		
		public void setPath(String a)
		{
			path = a;
		}
		
		public void setSize(int a)
		{
			size = a;
		}
		
		public void setDate(String a)
		{
			date = a;
		}
		// FINISH ME
		// implement the methods in the FileObject interface
		// the first one is partially done for you

		public String getBandName()
		{
			// Example:   C:/dc5songs/The Dave Clark Five/
			
			for (int i=path.length()-2; i>0; i--)
			{
				// FINISH ME
				// get the character at the ith position
				// use substring(?,?)
				String chAsString = path.substring(i, i+1);
				
				
				// FINISH ME
				// see if the character (stored in a String)
				// is equal to "/"
				if (chAsString.equals("/"))
				{
					return path.substring(i+1, path.length()-1);
				}
				
			}
			
			
			return "";
		}	
			
				
		// FINISH ME
		// implement the other methods in the FileObject interface



		public String getMonth()
		{
			return date.substring(0, 2);
		}
		
		public String getDay()
		{
			return date.substring(3, 5);
		}
		
		public String getYear()
		{
			return date.substring(6);
		}



		
		
		// FINISH ME
		// write a toString() method
		public String toString()
		{
			return "Filename: " + filename + "  Path: " + path + "  Size: " + size + "  Date: " + date;
		}
		
		
	} // end of class FileObject implements FileObjectInterface  