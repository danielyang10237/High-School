package net.codejava.sound;

import java.io.IOException;

public class pianoBoard extends pianoRunner {
	
	private int index;
	private int index2;
	
	public void playKey(Integer i)
	{
		index = i;
		try {
			keys.get(index).play();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void endKey(Integer i) throws IOException
	{
		System.out.println("stopped2");
		index2 = i;
		keys.get(index2).end();
	}

}
