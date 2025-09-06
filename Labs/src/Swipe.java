import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class Swipe
{
 // no instance variables are needed
 
 
 public static void main(String[] args) throws IOException
 {

  // print out your first and last name
   System.out.println("Daniel");
  
  // reads in the swipe.dat file and puts it
  // in a Scanner object  
  Scanner input = new Scanner(new File("gift.dat"));  

  //Scanner input = new Scanner(System.in); for keyboard  


  int numDataSets = input.nextInt();  
  input.nextLine(); // move to the next line in the data file
  
  Movement test = new Movement();
  
  // loop through each data set  
  for(int i = 0; i <= numDataSets; i ++) 
  {
	  String line1 = input.nextLine();
	  String line2 = input.nextLine();
	  String line3 = input.nextLine();
	  String line4 = input.nextLine();
	  String shift = input.nextLine();
	  if (shift.equals("left"))
	  {
		  String[] array1 = line1.split(" ");
		  String[] array2 = line2.split(" ");
		  String[] array3 = line3.split(" ");
		  String[] array4 = line4.split(" ");
		  test.shiftLeft(array1);
		  System.out.println();
		  test.shiftLeft(array2);
		  System.out.println();
		  test.shiftLeft(array3);
		  System.out.println();
		  test.shiftLeft(array4);
		  System.out.println();
		  System.out.println("left");
		  System.out.println();
	  }
	  else if (shift.equals("right"))
	  {
		  String[] array1 = line1.split(" ");
		  String[] array2 = line2.split(" ");
		  String[] array3 = line3.split(" ");
		  String[] array4 = line4.split(" ");
		  test.shiftRight(array1);
		  System.out.println();
		  test.shiftRight(array2);
		  System.out.println();
		  test.shiftRight(array3);
		  System.out.println();
		  test.shiftRight(array4);
		  System.out.println();
		  System.out.println("right");
		  System.out.println();
	  }
	  else if (shift.equals("up"))
	  {
		  String[] array1 = line1.split(" ");
		  String[] array2 = line2.split(" ");
		  String[] array3 = line3.split(" ");
		  String[] array4 = line4.split(" ");
		  String[] arrayOne = new String[] {array1[0], array2[0], array3[0], array4[0]};
		  String[] arrayTwo = new String[] {array1[1], array2[1], array3[1], array4[1]};
		  String[] arrayThree = new String[] {array1[2], array2[2], array3[2], array4[2]};
		  String[] arrayFour = new String[] {array1[3], array2[3], array3[3], array4[3]};
		  ArrayList<String> lineOne = test.shiftUp(arrayOne);
		  ArrayList<String> lineTwo = test.shiftUp(arrayTwo);
		  ArrayList<String> lineThree = test.shiftUp(arrayThree);
		  ArrayList<String> lineFour = test.shiftUp(arrayFour);
		  System.out.println(lineOne.get(0) + " " + lineTwo.get(0) + " " + lineThree.get(0) + " " + lineFour.get(0) + " ");
		  System.out.println(lineOne.get(1) + " " + lineTwo.get(1) + " " + lineThree.get(1) + " " + lineFour.get(1) + " ");
		  System.out.println(lineOne.get(2) + " " + lineTwo.get(2) + " " + lineThree.get(2) + " " + lineFour.get(2) + " ");
		  System.out.println(lineOne.get(3) + " " + lineTwo.get(3) + " " + lineThree.get(3) + " " + lineFour.get(3) + " ");
		  System.out.println("up");
		  System.out.println();
	  }
	  else if (shift.equals("down"))
	  {
		  String[] array1 = line1.split(" ");
		  String[] array2 = line2.split(" ");
		  String[] array3 = line3.split(" ");
		  String[] array4 = line4.split(" ");
		  String[] arrayOne = new String[] {array1[0], array2[0], array3[0], array4[0]};
		  String[] arrayTwo = new String[] {array1[1], array2[1], array3[1], array4[1]};
		  String[] arrayThree = new String[] {array1[2], array2[2], array3[2], array4[2]};
		  String[] arrayFour = new String[] {array1[3], array2[3], array3[3], array4[3]};
		  ArrayList<String> lineOne = test.shiftDown(arrayOne);
		  ArrayList<String> lineTwo = test.shiftDown(arrayTwo);
		  ArrayList<String> lineThree = test.shiftDown(arrayThree);
		  ArrayList<String> lineFour = test.shiftDown(arrayFour);
		  System.out.println(lineOne.get(3) + " " + lineTwo.get(3) + " " + lineThree.get(3) + " " + lineFour.get(3) + " ");
		  System.out.println(lineOne.get(2) + " " + lineTwo.get(2) + " " + lineThree.get(2) + " " + lineFour.get(2) + " ");
		  System.out.println(lineOne.get(1) + " " + lineTwo.get(1) + " " + lineThree.get(1) + " " + lineFour.get(1) + " ");
		  System.out.println(lineOne.get(0) + " " + lineTwo.get(0) + " " + lineThree.get(0) + " " + lineFour.get(0) + " ");
		  System.out.println("down");
		  System.out.println();
	  }
	  else
	  {
		  System.out.println("failed");
	  }
	  input.nextLine();
  }  
   
   
  input.close();

 } // end of main method
 


} // end of class
