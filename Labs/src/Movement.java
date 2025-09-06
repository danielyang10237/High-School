import java.util.ArrayList;

public class Movement {
	public void shiftLeft(String [] array)
	 {
		 ArrayList<String> output = new ArrayList<String>();
		 for (int a = 0; a < array.length-1; a++)
		  {
			 if (array[a].equals("*"))
			 {
				 
			 }
			else if (array[a].equals(array[a+1]))
			  {
				  String num = "" + array[a];
				  int add = 2 * Integer.parseInt(num);
				  output.add("" + add);
				  a++;
			  }
			  else if (!array[a].equals("*"))
			  {
				  output.add("" + array[a]);
			  }
		  }
		 while (output.size() != 4)
		 {
			 output.add("*");
		 }
		 for (int i = 0; i < output.size(); i++)
		 {
			 System.out.print(output.get(i) + " ");
		 }
	 }
	public void shiftRight(String [] array)
	 {
		 ArrayList<String> output = new ArrayList<String>();
		 for (int a = array.length-1; a >= 0; a--)
		  {
			 if (array[a].equals("*"))
			 {
				 
			 }
			else if ((a != 0) && (array[a].equals(array[a-1])))
			  {
				  String num = "" + array[a];
				  int add = 2 * Integer.parseInt(num);
				  output.add("" + add);
				  a--;
			  }
			  else
			  {
				  output.add("" + array[a]);
			  }
		  }
		 while (output.size() != 4)
		 {
			 output.add("*");
		 }
		 for (int i = output.size()-1; i >= 0; i--)
		 {
			 System.out.print(output.get(i) + " ");
		 }
	 }
	public ArrayList<String> shiftUp(String [] array)
	 {
		 ArrayList<String> output = new ArrayList<String>();
		 for (int a = 0; a <= array.length-1; a++)
		  {
			 if (array[a].equals("*"))
			 {
				 
			 }
			else if ((a != array.length-1) && array[a].equals(array[a+1]))
			  {
				  String num = "" + array[a];
				  int add = 2 * Integer.parseInt(num);
				  output.add("" + add);
				  a++;
			  }
			else if ((a != array.length-1) && array[a].equals(array[3]))
			  {
				  String num = "" + array[a];
				  int add = 2 * Integer.parseInt(num);
				  output.add("" + add);
				  break;
			  }
			  else if (!array[a].equals("*"))
			  {
				  output.add("" + array[a]);
			  }
		  }
		 while (output.size() != 4)
		 {
			 output.add("*");
		 }
		 return output;
	 }
	public ArrayList<String> shiftDown(String [] array)
	 {
		ArrayList<String> output = new ArrayList<String>();
		 for (int a = array.length-1; a >= 0; a--)
		  {
			 if (array[a].equals("*"))
			 {
				 
			 }
			 else if ((a != 0) && array[a].equals(array[0]))
			  {
				  String num = "" + array[a];
				  int add = 2 * Integer.parseInt(num);
				  output.add("" + add);
				  break;
			  }
			else if ((a != 0) && (array[a].equals(array[a-1])))
			  {
				  String num = "" + array[a];
				  int add = 2 * Integer.parseInt(num);
				  output.add("" + add);
				  a--;
			  }
			  else
			  {
				  output.add("" + array[a]);
			  }
		  }
		 while (output.size() != 4)
		 {
			 output.add("*");
		 }
		
		 return output;
	 }
}
