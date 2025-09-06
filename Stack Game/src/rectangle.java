import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class rectangle extends JLabel {
	
	private int x; 
	private int y;
	private int height;
	private static int width = 180;
	
	private boolean movingRight = true;
	private boolean gameEnded = false;
	
	public rectangle(ImageIcon blackRect) {
		// TODO Auto-generated constructor stub
		super(blackRect);
	}
	
	public void start(int b)
	{
		// System.out.println(b);
		
		int startingPoint = (int) (Math.random() * 318) + 1;
		
		setBounds(startingPoint, b, width, 40);
		height = b;
		x = startingPoint;
		// x = 160;
		System.out.print(b);
	}
	
	public void checkDirectionChange()
	{
		if (x > 320)
		{
			movingRight = false;
		}
		if (x < 0)
		{
			movingRight = true;
		}
	}
	
	public int getHeight()
	{
		return height;
	} 
	
	public void moveBlock()
	{
		checkDirectionChange();
		if (movingRight)
		{
			x += 3;
			setBounds(x, height, width, 40);
			// System.out.println(height);
		}
		else
		{
			x -= 3;
			setBounds(x, height, width, 40);
		}
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	private int tempWidth;
	private int tempHeight;
	private int tempPos;
	
	public boolean compareTo(int a, int b, int level)
	{
		if (x < a)
		{
			int difference = a - x;
			width = width -= difference;
			x = a;
			if (width < 0)
			{
				endGame();
				// System.out.println("this");
			}
			setBounds(a, height, width, 40);
			
			tempWidth = difference;
			tempHeight = height;
			tempPos = x;
			
			// System.out.println("executed");
			return true;
			
		}
		if (x > a)
		{
			int difference = x - a;
			width = width -= difference;
			if (width < 0)
			{
				// System.out.println("this");
				endGame();
			}
			setBounds(x, height, width, 40);
			
			width = width -= difference;
			tempWidth = difference;
			tempHeight = height;
			tempPos = x + width - difference;
			
			// System.out.println("executed");
			return true;
		}
		else
		{
			width = width;
			return false;
		}
	} 

	
	
	public int getTempWidth()
	{
		return tempWidth;
	}
	
	public int getTempHeight()
	{
		return tempHeight;
	}
	
	public int getTempPos()
	{
		return tempPos;
	}
	
	public void endGame()
	{
		gameEnded = true;
	}

	public boolean getGameEnded()
	{
		return gameEnded;
	}
	
}

