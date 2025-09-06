
import static java.lang.System.*;

public class LuckySevens
{
	/* luckySevens will return a count of the 7s in the number
	 *    unless the 7s are side by side in which case they are worth 14
	 *
	 * 1087171  would return 2 as there are 2 7s
	 * 1077171  would return 15 as 2 7s side by side count as 14 + 1 = 15
	 * 77077  would return 28 ( 14 + 14 )
	 * 97171771707797 would return 32 ( 1 + 1 + 14 + 1 + 14 + 1 )
	 * 1089651234 would return 0
	 *
	 * the solution to this problem must use recursion
	 */
	public static int count = 0;
	
	public void reset()
	{
		count = 0;
	}
	
	public static int luckySevens( long number )
	{
		
		if (number > 1)
		{
		long digit = number % 10;
		
		if (digit == 7)
		{
			if ((number / 10) % 10 == 7)
			{
				count +=14;
				luckySevens(number / 100);
			}
			else
			{
				count++;
				luckySevens(number / 10);
			}
		}
		else
		{ 
			luckySevens(number / 10);
		}
		}
		return count;
 	}
}