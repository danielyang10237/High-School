
public class student {
	private long timeIn = 0;
	private long timeOut = 0;
	private String name = "";
	private int requirement = 60;
	
	private boolean metReq = false;
	
	public void checkIn(long checkedInTime)
	{
		timeIn = checkedInTime;
	}
	
	public void checkOut(long checkedOutTime)
	{
		timeOut = checkedOutTime;
	}
	
	public void setRequirement(int r)
	{
		int rr = r * 60;
		requirement = rr;
	}
	
	public String getDuration()
	{
		if (timeOut != 0)
		{
		long totalTime = timeOut - timeIn;
		totalTime = totalTime /= 1000000000;
		
		int hours = 0;
		int minutes = 0;
		int seconds = 0;
		System.out.println(totalTime);
		
		if (totalTime > requirement)
		{
			metReq = true;
		}
		
		hours = (int) totalTime / 3600;
		totalTime = totalTime % 3600;
		minutes = (int) totalTime / 60;
		totalTime = totalTime % 60;
		seconds = (int) totalTime % 60;
		
		if (hours == 0)
		{
			if (minutes == 0)
			{
				return "" + seconds + " seconds";
			}
			else
			{
				return "" + minutes + " minutes and " + seconds + " seconds";
			}
		}
		else
		{
			if (minutes == 0)
			{
				return "" + hours + " hours and " + seconds + " seconds";
			}
			else
			{
				return "" + hours + " hours and " + minutes + " minutes and "+ seconds + " seconds";
			}
		}
		
	}
	else
	{
		return "debater did not log out";
	}
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean getReq()
	{
		return metReq;
	}
}
