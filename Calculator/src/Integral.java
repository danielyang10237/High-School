import java.util.*; // for Scanner from Java 1.5, 1.6
import java.io.*;   // for file input
import static java.lang.System.*; // so that you don't have to do System.

public class Integral
{
	// no instance variables are needed
	
	
	public static void main(String[] args) throws IOException
	{
		String a = new String("gey");
		String b = "har";
		a = b;
		b = "val";
		System.out.println(a);
		
		int x = 0;
		int y = x;
		x = 6;
		System.out.println(y);
	}

} // end of class