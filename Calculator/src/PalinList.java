//(c) A+ Computer Science
//www.apluscompsci.com

//Name -

import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.LinkedList;

public class PalinList
{
	private Queue<String> queue;
	private Stack<String> stack;
	private ArrayList<String> originalList;
	public PalinList()
	{
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		originalList = new ArrayList<String>();
		
		
		setList("");
	}

	public PalinList(String list)
	{
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		originalList = new ArrayList<String>();
		Scanner line = new Scanner(list);
		while (line.hasNext())
		{
			String element = line.next();
			queue.add(element);
			stack.add(element);
		}
		for (int x = 0; x < stack.size(); x++)
		{
			originalList.add(stack.get(x));
		}
	}
	

	public void setList(String list)
	{
		queue = new LinkedList<String>();
		stack = new Stack<String>();
		originalList = new ArrayList<String>();
		Scanner line = new Scanner(list);
		while (line.hasNext())
		{
			String element = line.next();
			queue.add(element);
			stack.add(element);
		}
		for (int x = 0; x < stack.size(); x++)
		{
			originalList.add(stack.get(x));
		}
	}
	
	
	public boolean isPalin()
	{
		for (int i = 0; i < stack.size(); i++)
		{
			String element1 = stack.pop();
			String element2 = queue.remove();
			if (!element1.equals(element2))
			{
				return false;
			}
		}
		return true;
	}
	
	public String toString()
	{
		if (isPalin()==true)
			return "" + originalList + " is a palinList";
		else
			return "" + originalList + " is not a palinList";
	}

	//write a toString method
}