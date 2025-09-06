//� A+ Computer Science  -  www.apluscompsci.com
//Name -
//Date - 
//Class -
//Lab  -

import static java.lang.System.*;

public class LuckySevensRunner
{
	public static void main(String args[])
	{
		LuckySevens seven = new LuckySevens();
		System.out.println(seven.luckySevens(1087171L));
		seven.reset();
		System.out.println(seven.luckySevens(1077171L));
		seven.reset();
		System.out.println(seven.luckySevens(77077L));
		seven.reset();
		System.out.println(seven.luckySevens(97171771707797L));
		seven.reset();
		System.out.println(seven.luckySevens(1089651234));
		seven.reset();
		
	}
}

/*Output:

2
15
28
32
0
*/