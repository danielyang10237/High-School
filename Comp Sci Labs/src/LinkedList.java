
import static java.lang.System.*;

public class LinkedList
{
	// instance variables (attributes, properties, global)
	private LinkedNode first;
	private LinkedNode last;


	// default constructor
	public LinkedList( )
	{
		// FINISH ME
		// we do not have any objects, 
		// so first and last should both
		// be set to null
		first = null;
		last = null;
	}


	// if letter exists in some node,
	// then the count is incremented by 1
	// otherwise, a new LinkedNode object is created
	// to hold this letter, and the count is set to 1
	public void add(char letter)
	{
		if (first == null)
		{
			// FINISH ME
			// create a new LinkedNode and point both
			// first and last to the new LinkedNode
			// i.e. first should refer to the LinkedNode
			// and last should refer to the LinkedNode
			first = new LinkedNode(letter); // change me ???
			last  = first; // change me ???
			return;
		}
		
		LinkedNode current = indexOf(letter);
		
		if (current == null) // the letter does not exist
		{
			// FINISH ME
			// create a new LinkedNode object
			// to hold the letter
			LinkedNode newLastNode = new LinkedNode(letter); // change me ???
			
			
			// FINISH ME
			// set the nextLinkedNode that last is 
			// referring to so that it points to the
			// newLastNode 
			last.setNextLinkedNode(newLastNode);
			
			
			// FINISH ME
			// point last to the new last node
			last = newLastNode;
			
		}
		else // the letter does exist
		{
			// FINISH ME
			// we found the letter and current is referring
			// to the LinkedNode object that contains the letter
			// increment the count of the LinkedNode object
			// that current is referring to 
			//current = current.getNextLinkedNode();
			current.incrementCount();
		}
		
	}

	public LinkedNode indexOf(char letter)
	{
		// returns the memory address of the LinkedNode
		// that holds the letter or null if the letter
		// does not exist
		
		
		// FINISH ME
		// current should point to where first is pointing
		LinkedNode current = first; // change me ???
		
		
		while(current != null)
		{
			// FINISH ME
			// see if the letter inside the LinkedNode
			// is the letter that we are looking for
			// and if so we will break out of the loop
			
			if (current.getLetter() == letter)
			{
				break;
			}
			
			// FINISH ME
			// make current refer to the nextLinkedNode
			current = current.getNextLinkedNode();
		}
		

		// FINISH ME		
		// return the LinkedNode referred to by current
		return current;  // change me ???
		
	}
	
	
	
	
	public String toString()
	{
		String output = "[";
		
		LinkedNode current = first;

		while(current != null)
		{
			// FINISH ME
			// get the letter and count of the current
			// LinkedNode object
			// uncomment and
			// replace the ??? below
			output = output + current.getLetter() + "-" + current.getCount();
			
			// FINISH ME
			// see if the nextLinkedNode field is null
			if (current.getNextLinkedNode() == null)
			{
				// we are on the last node of the list
				// so we will add the "]" to our output
				output += "]";				
			}
			else
			{
				// we are NOT on the last node of the list
				// so we will add the ", " to our output
				output += ", ";				
			}
			
			
			// FINISH ME
			// make current refer to the nextLinkedNode object
			// uncomment the line below
			current = current.getNextLinkedNode();
		}
		
		// return the output String
		return output;
	}
}