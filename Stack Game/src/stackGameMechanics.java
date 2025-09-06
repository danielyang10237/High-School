import java.awt.Color;



import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class stackGameMechanics extends stackGame {

	public void setUp()
	{
		
		titleLabel = new JLabel();
		titleLabel.setText("Stack Game");
		titleLabel.setForeground(Color.GREEN);
		titleLabel.setBounds(100, 360, 300, 50);
		titleLabel.setFont(new Font("Stack Game", Font.PLAIN, 42));
		titleLabel.setVisible(true);
		titleLabel.setFocusable(true);
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(titleLabel);
		frame.repaint();
		
		gameOverSign = new JLabel(greenRect);
		gameOverSign.setForeground(Color.GREEN);
		gameOverSign.setBounds(90, 350, 320, 70);
		gameOverSign.setVisible(false);
		gameOverSign.setFocusable(true);
		frame.add(gameOverSign);
		frame.repaint();
		
		startGame = new JButton();
		startGame.setText("Play Game");
		startGame.setForeground(Color.WHITE);
		startGame.setBackground(Color.GREEN);
		startGame.setBorderPainted(false);
		startGame.setOpaque(true);
		startGame.setFont(new Font("Play Game", Font.PLAIN, 32));
		startGame.setBounds(110, 420, 280, 40);
		startGame.setVisible(true);
		frame.add(startGame);
		startGame.setFocusable(true);
		frame.repaint();
		
		
		startGame.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 

				
				gameRunning = true;
				override();
				
				try {
					initiateGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		

		
	}

	
	public boolean getGameRunning()
	{
		return gameRunning;
	}
	
	public void initiateGame() throws InterruptedException
	{
		

		Thread thread = new Thread(() -> {
			while (gameRunning) {
				try {
					Thread.sleep(16);
					gameIndex++;
					

					if (wasSuccessful == true)
					{
						int x = 1500 - (40 * level);
						// System.out.println(x);
						
						drawRect(x);
						wasSuccessful = false;
						
					}
					
					if (gameIndex > 5)
						// System.out.println(blockList.size());
					
					if (gameRunning == true)
					{
						
						moveRect(level);
					}
					
					if (gameRunning == true)
					{
						if (fallingBlocks.size() != 0)
						{
							for (int j = 0; j < fallingBlocks.size(); j++)
							{
								fallingBlocks.get(j).setVisible(true);
								int previousHeight = fallingHeights.get(j);
								int newHeight = previousHeight += 5;
								fallingHeights.set(j, newHeight);
								
								int width = fallingWidths.get(j);
								int pos = fallingPoss.get(j);
								
								fallingBlocks.get(j).setBounds(pos, newHeight, width, 40);
							}
						}
					}
					
					if (blockList.get(blockList.size()- 1).getGameEnded() == true)
					{
						gameRunning = false;
						gameEndSequence();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();
		
		// System.out.println("testfdsf");
				
				
	}
	
	public static void moveRect(int x)
	{
		 if (x-1 < blockList.size())
		 {
			blockList.get(x-1).moveBlock();
		 }
		
		/* if (moveRight.get(x - 1) == true)
		{
			stackList.get(x - 1).setBounds(position.get(x - 1) + 3, 780 - (40 * x), 180, 40);
			int y = position.get(x - 1);
			position.set(x - 1, y+3);
		}
		
		if (position.get(x - 1) >= 500)
		{
			moveRight.set(x-1, false);
		}
		

		if (position.get(x - 1) <= -160)
		{
			moveRight.set(x-1, true);
		}
		
		if (moveRight.get(x - 1) == false)
		{
			stackList.get(x - 1).setBounds(position.get(x - 1) - 3, 780 - (40 * x), 180, 40);
			int y = position.get(x - 1);
			position.set(x - 1, y-3);
		} */
	}
	
	public static void drawRect(int b)
	{
		rectangle stackLevel = new rectangle(blackRect);
		
		blockList.add(stackLevel);
		
		stackLevel.start(b);
		stackLevel.setVisible(true);
		frame.add(stackLevel);
		frame.repaint();
		
	}
	
	public void spacePressed()
	{
		if (level == 1)
		{
			level++;
			wasSuccessful = true;
		}
		else
		{
			int xPosition = blockList.get(blockList.size()-2).getX();
			int yPosition = blockList.get(blockList.size()-2).getY(); 
			if (blockList.get(blockList.size()-1).compareTo(xPosition, yPosition, level))
			{
				createFallingBlock();
				
			}
			if (blockList.get(blockList.size()-1).getGameEnded() == true)
			{
				gameEndSequence();
			}
			
			level ++;
			int x = 1500 - (40 * level);
			// System.out.println(x);
			drawRect(x);
		}
	}
	
	public void gameEndSequence()
	{
		gameRunning = false;
		gameOverSign.setVisible(true);
		titleLabel.setVisible(true);
		titleLabel.setText("Game Over");
		
	}
	
	public void createFallingBlock()
	{
		fallingBlock = new JLabel(greenRect);
		int height = blockList.get(blockList.size()-1).getTempHeight();
		int pos = blockList.get(blockList.size()-1).getTempPos();
		int width = blockList.get(blockList.size()-1).getTempWidth();
		fallingBlock.setBounds(100, 100, 100, 20);
		// fallingBlock.setBounds(pos, height, width, 20);
		
		fallingBlock.setVisible(true);
		fallingBlock.setFocusable(true);
		frame.add(fallingBlock);
		frame.repaint();
		
		fallingBlocks.add(fallingBlock);
		fallingHeights.add(height);
		fallingPoss.add(pos);
		fallingWidths.add(width);
	}

}
