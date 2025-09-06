import java.util.ArrayList;

public class MajorityRunner {
	public ArrayList<String> john;
	public ArrayList<Integer> yi;
	public String findMajority(String theLine)
	{
		john = new ArrayList<String>();
		yi = new ArrayList<Integer>();
		int biggest = 0;
		for (int i = 0; i < theLine.length(); i++)
		{
			String letter = theLine.substring(i, i+1);
			if (john.contains(letter))
			{
				for (int j = 0; j < john.size(); j ++)
				{
					if (john.get(j).equals(letter))
					{
						int value = yi.get(j);
						yi.set(j, value+1);
					}
				}
			}
			else
			{
				john.add(letter);
				yi.add(1);
			}
		}
		
		for (int v = 0; v < yi.size(); v++)
		{
			if (yi.get(v) > biggest)
				biggest = yi.get(v);
		}
		int half = theLine.length() / 2;
		for (int z = 0; z < yi.size(); z++)
		{
			if ((yi.get(z) == biggest) && (yi.get(z) > half))
				return "" + john.get(z);
		}
		return "NO MAJORITY";
	}

}
