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


public class flappyBirdMechanics extends flappyBirdRunner{

	static Graphics gc;
	
	flappy f = new flappy();
	
	public void initiateGame()
	{
		
		scoreLabel = new JLabel();
		score = 0;
		scoreLabel.setText("Score: ");
		scoreLabel.setForeground(Color.GRAY);
		scoreLabel.setBounds(830, 0, 170, 50);
		scoreLabel.setFont(new Font("Score: ", Font.PLAIN, 30));
		scoreLabel.setVisible(true);
		scoreLabel.setFocusable(true);
		scoreLabel.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(scoreLabel);
		frame.repaint();
		

		title = new JLabel();
		title.setText("Flappy Bird");
		title.setForeground(Color.RED);
		title.setBounds(390, 270, 220, 50);
		title.setFont(new Font("Hangman", Font.PLAIN, 40));
		title.setVisible(true);
		title.setFocusable(true);
		title.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(title);
		frame.repaint();

		play = new JButton();
		play.setText("Play");
		play.setForeground(Color.GREEN);
		play.setBackground(Color.RED);
		play.setBorderPainted(false);
		play.setOpaque(true);
		play.setFont(new Font("Play", Font.PLAIN, 40));
		play.setBounds(390, 340, 240, 40);
		play.setVisible(true);
		frame.add(play);
		play.setFocusable(true);
		frame.repaint();


		play.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				f.reset();
				title.setVisible(true);
				play.setVisible(false);
				title.setText("3");
				
				selectDifficulty();

			}
		});

	}
	
	
	public void selectDifficulty()
	{
		
		easy.setVisible(true);
		moderate.setVisible(true);
		difficult.setVisible(true);
		
		easy.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				gap = 400;
				
				easy.setVisible(false);
				moderate.setVisible(false);
				difficult.setVisible(false);
				
				try {
					runGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		moderate.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				gap = 300;
				
				easy.setVisible(false);
				moderate.setVisible(false);
				difficult.setVisible(false);
				
				try {
					runGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		difficult.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				gap = 200;
				
				easy.setVisible(false);
				moderate.setVisible(false);
				difficult.setVisible(false);
				
				try {
					runGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}});
		
		
		
	}
	
	public void runGame() throws InterruptedException
	{
		
		
		Thread thread = new Thread(() -> {
			while (gameRunning) {
				try {
					Thread.sleep(16);
					gameIndex++;

					
					if (gameIndex == 1)
					{
						score = 0;
						displayScore.setText("Final Score: " + score);
						f.reset();
						title.setVisible(true);
						play.setVisible(false);
						title.setText("3");
						speed = 4.0;
					}
					
					
					// System.out.println(f.getY());

					if (gameIndex == 62)
					{
						title.setText("2");
						//System.out.println(gameIndex);
					}


					if (gameIndex == 124)
					{
						title.setText("1");
						//System.out.println(gameIndex);
					}

					if (gameIndex == 186)
					{
						title.setVisible(false);
						gameStarted = true;
						
						frame.newBird();
						flappyBird = frame.getBird();
						flappyBird.setBounds(0, 0, 1000, 700);
						flappyBird.setVisible(true);
						flappyBird.setFocusable(true);
						frame.add(flappyBird);
						frame.setBirdPos(390, 270);
						frame.repaint();
						              
					}
					
					if (gameIndex > 187 && gameIndex % 100 == 0)
					{
						createObstacle();
					}
					
					if (gameIndex > 187 && gameIndex % 10 == 0)
					{
						speed += 0.03;
					}
					
					/* if (topPipes.size() != 0)
					{
						if (topPipes.get(0).getX() == 450)
							System.out.println(gameIndex);
					}
					
					if (topPipes.size() > 2)
					{
						if (topPipes.get(1).getX() == 450)
							System.out.println(gameIndex);
					} */
					
					if (pipeList.size() != 0)
					{
						for (int i = 0; i < pipeList.size(); i++)
						{
							if (pipeList.get(i).getX() < 400)
							{
								score = i + 1;
							}
						}
						
					}
					scoreLabel.setText("Score: " + score);
					
					if (gameIndex > 187)
					{
						updateFrame();
						moveObstacles();
						
						if (ifHit() == true)
						{
							// System.out.println("you lose");
							gameRunning = false;
							
							Thread.sleep(400);
							
							gameOverSequence();
						}
					}
					
					if (gameIndex == secondFlap || gameIndex == thirdFlap || gameIndex == fourthFlap || gameIndex == fifthFlap || gameIndex == sixthFlap)
					{
						f.nextFlap();
					}

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		thread.start();

	}
	
	public void updateFrame()
	{
		f.dropBird();
		f.displayBird();
		frame.repaint();
	}
	
	public boolean getGameStarted()
	{
		return gameStarted;
	}
	
	public boolean ifHit()
	{
		if (f.getY() < 0)
			return true;
		
		if (f.getY() > 700)
			return true;
		
		for (int t = 0; t < topPipes.size(); t++)
		{
			for (int x = 410; x < 465; x++)
			{
				for (int y = f.getY() + 20; y < f.getY() + 70; y++)
				{
					if (x > topPipes.get(t).getX() && x < topPipes.get(t).getX() + 80)
					{
						if (y > 0 && y < topPipes.get(t).getHeight())
						{
							/*
							System.out.println("top");
							JLabel hitbox = new JLabel(blue);
							hitbox.setBounds(410, f.getY() + 20, 55, 60);
							hitbox.setVisible(true);
							frame.add(hitbox);
							frame.repaint();
							
							topPipes.get(t).setVisible(false);
							*/
							gameStarted = false;
							
							return true;
						}
					}
				}
			}
		}
		
		for (int b = 0; b < bottomPipes.size(); b++)
		{
			for (int x = 410; x < 465; x++)
			{
				for (int y = f.getY() + 20; y < f.getY() + 70; y++)
				{
					if (x > bottomPipes.get(b).getX() && x < bottomPipes.get(b).getX() + 80)
					{
						if (y > bottomPipes.get(b).getBottomHeight() + gap && y < 700)
						{
							
							/*
							System.out.println("bottom");
							JLabel hitbox = new JLabel(blue);
							hitbox.setBounds(bottomPipes.get(b).getX(), bottomPipes.get(b).getBottomHeight() + 200, 80, 700 - bottomPipes.get(b).getBottomHeight() - 200);
							hitbox.setVisible(true);
							frame.add(hitbox);
							frame.repaint();
							
							bottomPipes.get(b).setVisible(false);
							
							*/
							
							return true;
						}
					}
				}
			}
		}
		
		return false;
	}
	
	public void flapBird()
	{
		f.flap();
	}
	
	public void createObstacle()
	{
		int height = ((int) (Math.random() * (700 - gap)));
		
		pipeTop topper = new pipeTop(darkGreen, height);
		topper.setVisible(true);
		frame.add(topper);
		frame.repaint();
		topPipeList.add(topper);
		
		pipeTop topper2 = new pipeTop(darkGreen, height + gap + 30);
		topper2.setVisible(true);
		frame.add(topper2);
		frame.repaint();
		topPipeList.add(topper2);
		
		
		pipe1 obstacle = new pipe1(green, height);
		obstacle.setVisible(true);
		frame.add(obstacle);
		frame.repaint();
		topPipes.add(obstacle);
		pipeList.add(obstacle);
		
		pipe2 obstacle2 = new pipe2(green, height, gap);
		obstacle2.setVisible(true);
		frame.add(obstacle2);
		frame.repaint();
		bottomPipes.add(obstacle2);
		
		
	}
	
	public void moveObstacles()
	{
		for(int o = 0; o < topPipes.size(); o++)
		{
			topPipes.get(o).movePipe(speed);
		}
		
		for(int o = 0; o < bottomPipes.size(); o++)
		{
			bottomPipes.get(o).movePipe(speed);
		}
		
		for (int x = 0; x < topPipes.size(); x++)
		{
			if (topPipes.get(x).getX() < -80)
			{
				topPipes.get(x).setVisible(false);
				topPipes.remove(x);
				x--;
			}
		}
		
		for (int x = 0; x < bottomPipes.size(); x++)
		{
			if (bottomPipes.get(x).getX() < -80)
			{
				bottomPipes.get(x).setVisible(false);
				bottomPipes.remove(x);
				x--;
			}
		}
		
		System.out.println(topPipeList.size());
		
		for (int i = 0; i < topPipeList.size(); i+=2)
		{
			topPipeList.get(i).movePipe(speed);
			topPipeList.get(i+1).movePipe(speed);
		}
		
		for (int i = 0; i < topPipeList.size(); i++)
		{
			if (topPipeList.get(i).getX() < - 90)
			{
				topPipeList.get(i).setVisible(false);
				topPipeList.remove(i);
				i--;
			}
		}
		
	}
	
	public void gameOverSequence()
	{
		title.setVisible(true);
		title.setForeground(Color.BLUE);
		title.setText("Game Over");
		
		menuTab.setVisible(true);
		gameOverMessage.setVisible(true);
		displayScore.setText("Final Score: " + score);
		displayScore.setVisible(true);
		
		newGame.setVisible(true);
		
		for (int i = 0; i < topPipes.size(); i++)
		{
			topPipes.get(i).setVisible(false);
			frame.remove(topPipes.get(i));
		}
		
		for (int i = 0; i < bottomPipes.size(); i++)
		{
			bottomPipes.get(i).setVisible(false);
			frame.remove(bottomPipes.get(i));
		}
		
		for (int i = 0; i < topPipeList.size(); i++)
		{
			topPipeList.get(i).setVisible(false);
			frame.remove(topPipeList.get(i));
		}
		
		topPipes.clear();
		bottomPipes.clear();
		pipeList.clear();
		topPipeList.clear();
		
		frame.deleteBird();
		
		gameIndex = 0;
		score = 0;
		secondFlap = -1;
		thirdFlap = -1;
		fourthFlap = -1;
		fifthFlap = -1;
		sixthFlap = -1;
		criticalIndex = -1;
		
		if (temp == true)
		{
		newGame.addActionListener(new ActionListener(){  
			public void actionPerformed(ActionEvent e){ 
				
				title.setVisible(false);
				menuTab.setVisible(false);
				displayScore.setVisible(false);
				newGame.setVisible(false);
				gameOverMessage.setVisible(false);
				
				gameRunning = true;
				
				flappy f = new flappy();
				f.reset();
				
				temp = false;
				
				try {
					runGame();
				} catch (InterruptedException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		}
		);
		}
		
	}
	

}


class flappy extends flappyBirdRunner
{
	private int YCoordinate = 270;
	private double dropBird = 0.5;
	double birdAngle = 0.03;
	
	public void reset()
	{
		YCoordinate = 270;
		dropBird = 0.5;
		birdAngle = 0.03;
	}
	
	public void dropBird()
	{
		YCoordinate = (int) Math.round( (double) YCoordinate + dropBird);
		frame.rotate(birdAngle);
		if (dropBird < 12)
			dropBird +=0.5;
		if (birdAngle < 1.0)
			birdAngle +=0.03;
	}
	
	public int getY()
	{
		return YCoordinate;
	}
	
	public void flap()
	{
		secondFlap = gameIndex +1;
		thirdFlap = gameIndex +2;
		fourthFlap = gameIndex +3;
		fifthFlap = gameIndex +4;
		sixthFlap = gameIndex +5;
		
		YCoordinate -= 17;
		dropBird = 0.5;
		if (birdAngle > -0.4)
			birdAngle -= 0.17;
	}
	
	public void nextFlap()
	{
		YCoordinate -= 17;
		dropBird = 0.5;
		if (birdAngle > -0.4)
			birdAngle -= 0.17;
	}
	
	public void displayBird()
	{
		frame.setBirdPos(390, YCoordinate);
		//flappyBird.setBounds(390, YCoordinate, 90, 75);
	}
	

	
	
}


class pipe1 extends JLabel
{
	private double x = 1000;
	private int height1;
	
	public pipe1(ImageIcon ii, int i)
	{          
		super(ii);
		setBounds(1000, 0, 80, i);
		setVisible(true);
		setFocusable(true);
		height1 = i;
	}
	
	public void movePipe(double s)
	{
		x -= s;
		setBounds((int) Math.round(x), 0, 80, height1);
	}
	
	public int getX()
	{
		return (int) Math.round(x);
	}
	
	public int getHeight()
	{
		return height1;
	}
}


class pipe2 extends JLabel
{
	private double x = 1000;
	private int height2;
	private int gap;
	
	public pipe2(ImageIcon ii, int i, int g)
	{          
		super(ii);
		setBounds(1000, g + i, 80, 700 - g - i);
		setVisible(true);
		setFocusable(true);
		height2 = i;
		gap = g;
	}
	
	public void movePipe(double s)
	{
		
		x -= s;
		setBounds((int) Math.round(x), gap + height2, 80, 700 - gap - height2);
	}
	
	
	public int getX()
	{
		return (int) Math.round(x);
	}
	
	public int getBottomHeight()
	{
		return height2;
	}
}

class pipeTop extends JLabel
{
	private double x = 990;
	private int height2;
	
	public pipeTop(ImageIcon ii, int i)
	{          
		super(ii);
		setBounds(990, i - 30, 100, 30);
		setVisible(true);
		setFocusable(true);
		height2 = i;
	}
	
	public void movePipe(double s)
	{
		x -= s;
		setBounds((int) Math.round(x), height2 - 30, 100, 30);
	}
	
	
	public int getX()
	{
		return (int) Math.round(x);
	}
	
	public int getBottomHeight()
	{
		return height2;
	}
}
