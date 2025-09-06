import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Triple {
	public static void main(String[] args) throws FileNotFoundException
	 {
		Scanner scan = new Scanner(new File("gift.dat"));
		int numDataSets = scan.nextInt();
		scan.nextLine();
		for (int i = 0; i < numDataSets; i++)
		{
			boolean bool = true;
			int number = scan.nextInt();
			int temp = number;
			ArrayList<Integer> factors = new ArrayList<Integer>(); 
			for (int factor = 2; factor <= number; factor++)
			{
				if (number % factor == 0)
				{
					factors.add(factor);
					number /= factor;
					factor--;
				}
			}
			if (factors.size() != 3)
			{
				bool = false;
			}
			for (int x = 0; x < factors.size()-1; x++)
			{
				if (factors.get(x) == factors.get(x+1))
				{
					bool = false;
				}
			}
			if (bool)
			{
				System.out.println(temp + " " + factors + " YES");
			}
			else
			{
				System.out.println(temp + " " + factors + " NO");
			}
			System.out.println();
			scan.nextLine();
		}
		scan.close();
	 }
}
