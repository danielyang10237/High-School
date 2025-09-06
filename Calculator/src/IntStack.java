import java.util.ArrayList;

class IntStack
{
   //pick your storage for the stack
   //you can use the an array or an ArrayList

   //option 1

   //option 2
   private ArrayList<Integer> listOfInts;

   public IntStack(){
	   
	   listOfInts = new ArrayList<Integer>();
   }

   public void push(int item){
	   listOfInts.add(item);
   }

   public int pop(){
	return listOfInts.remove(listOfInts.size()-1);
   }

   public boolean isEmpty(){
 	return listOfInts.isEmpty();
   }

   public int peek(){
	return listOfInts.get(listOfInts.size()-1);
   }

   public String toString(){
	return "" + listOfInts;
   }
}