import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.File;

public class Majority {
	
	
	public static void main(String[] args) throws Exception {
		Scanner scan = new Scanner(new File("Majority-ExtraCredit.txt"));
		int numberOfLines = scan.nextInt();
		scan.nextLine();
		MajorityRunner test = new MajorityRunner();
		for (int i = 0; i < numberOfLines; i++)
		{
			String line = scan.nextLine();
			System.out.println(test.findMajority(line));
			line = "";
		}
		
	}
}
