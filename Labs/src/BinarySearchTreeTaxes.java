// NOTES:
// You can replace PersonRecord.java, and TreeNode.java
// with your solutions from the first assignment.
// BinarySearchTree.java can also be replaced, but you 
// must add a getter method that returns the root of the tree.

// You will be reading in data from a file call treedata.txt
// You will be writing back data to this file as well, and thus
// you could destroy the original data.  A copy of the 
// original file is provided for you.


import java.util.*;
import java.io.*;

import static java.lang.System.*;

public class BinarySearchTreeTaxes
{

 public static void preorderSave(BufferedWriter bw, TreeNode tree)
 {
	 if (tree != null)
  {
   // first we will write this TreeNode object
   // to the file
   try
   {
          // here we write the person's ss# to the file
          // and write a blank line
          bw.write(tree.getPerson().getSSNumber());
          bw.newLine();

          // FINISH ME
          // write the person's name to the file
          // and write a blank line
          bw.write(tree.getPerson().getPersonName());
          bw.newLine();
          

          // FINISH ME
          // write the person's date of birth to the file
          // and write a blank line
          bw.write(tree.getPerson().getDateOfBirth());
          bw.newLine();
         


          // FINISH ME
          // write the person's taxable income to the file
          // (it must be converted to a String)
          // and write a blank line
          bw.write("" + tree.getPerson().getTaxableIncome());
          bw.newLine();
          
          // FINISH ME
          // write a blank line
          
   }
   catch(Exception e)
   {
          System.out.println("Error writing Data to treedata.txt in pre-order traversal");    
   }
   
   
   // now we save the left subtree
   preorderSave(bw, tree.getLeft());


   // FINISH ME
   // now save the right subtree
   preorderSave(bw, tree.getRight());

   
  }
  
 }
 
 
 public static void saveFile(TreeNode tree)
 {
  // save the file

  try
     {
      // this will open the file so that we can
      // write data to it (all data int the file
      // will be destroyed!)
        FileWriter fw = new FileWriter("treedata.txt");
        BufferedWriter bw = new BufferedWriter(fw);
         
       // FINISH ME
       // we will be moving through (traversing) 
       // all PersonRecord objects in our tree
       // using a pre-order traversal
       // call preorderSave and pass it bw and tree
      preorderSave(bw, tree);
      
      
        bw.close();
     }
     catch (IOException e1)    
     {
         System.out.println("Error writing Data to treedata.txt");
     }
     catch (Exception e2)    
     {
         System.out.println("Error writing Data to treedata.txt");
     }
  
   
 }

 
 public static void main(String[] args)
 {
  // FINISH ME
  // put your name on it
  System.out.println("BinarySearchTreeTaxes 2 written by Harvey Li");
  System.out.println();
  System.out.println();
  
  
  // FINISH ME
  // create a BinarySearchTree object
  BinarySearchTree bsTree = new BinarySearchTree();
  
  
  
  // FINISH ME
  // Read from a file
  // open the file treedata.txt to see the
  // format of the file
  // useful methods of the Scanner class:
  // hasNextLine()
  // nextLine()
  try
  {
   // FINISH ME
   // create a new Scanner object to read in the 
   // data from the file called treedata.txt
   // (you will need to create a new File object and
   // pass it "treedata.txt") and then pass this to
   // the Scanner constructor
   Scanner file = new Scanner("treedata.txt");
  
   // FINISH ME
   // while the file has a next line, we will
   // go through the loop and read in the next record
   while (file.hasNextLine())
   {
    String ss = file.nextLine();

    // FINISH ME
    // read in the person's name
    // read in the person's birthDate
    String name = file.nextLine();
    String birthDate = file.nextLine();

    

    double taxableIncome = file.nextDouble();
    file.nextLine(); // move to next line after the taxable income
    file.nextLine(); // skip blank line

    // FINISH ME
    // create a PersonRecord object with the 
    // social security #, name, birth date,
    // and taxable income as arguments to
    // the initializer constructor
    PersonRecord person = new PersonRecord(ss, name, birthDate, taxableIncome);
    

    // FINISH ME
    // add the TreeNode object to the 
    // BinarySearchTree object
    bsTree.add(person);
   
   }
  } // end of try block
  catch(Exception e)
  {
   System.out.println("Error reading in file treedata.txt");
  }


  // FINISH ME
  // add the following 2 PersonRecord objects
  // to the BinarySearchTree
  
  // 
  // 588-22-3858
  // Ally Baker
  // 09/14/1702
  // 2000000


  // 477-62-2934
  // Tom Baker
  // 03/12/1704
  // 1000000

  // do the following for both records
  // create a PersonRecord object with the 
  // social security #, etc. as arguments to
  // the initializer constructor
  // call the BinarySearchTree object's add method

  // FINISH ME
  // create a new PersonRecord for Ally Baker and then
  // add her to the bsTree    
  PersonRecord person = new PersonRecord("588-22-3858","Ally Baker","09/14/1702",2000000);
  bsTree.add(person);
  
  // FINISH ME
  // create a new PersonRecord for Tom Baker    
  // and add him to the bsTree    
  person = new PersonRecord("477-62-2934","Tom Baker","03/2/1704",1000000);
  bsTree.add(person);

  person = new PersonRecord("507-22-8458","Bill Adams","02/22/1731",60000);
  bsTree.add( person );
  
  
  person = new PersonRecord("518-26-7345","Tom Adams","05/26/1733",100000);
  bsTree.add( person );
  
  person = new PersonRecord("549-22-2858","Alice Adams","07/18/1734",500000);
  bsTree.add( person );
 

  person = new PersonRecord("588-22-3858","Sally Adams","09/14/1736",600000);
  bsTree.add( person );
  
  // we now print out the tree data (inorder)
  System.out.println(bsTree);


 
  // write all of the PersonRecord objects to the file
  // treedata.txt (don't wipe out your back up in case
  // something goes wrong)
  // call saveFile and pass it your bsTree
  saveFile(bsTree.getRoot());
  
  
  // we now print out the tree data (inorder)
  System.out.println(bsTree);
  
  System.out.println();
  System.out.println();

 }
}