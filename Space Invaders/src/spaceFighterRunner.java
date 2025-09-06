import java.awt.*;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.lang.Math;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.awt.event.*;
import java.awt.event.KeyEvent;
import javax.swing.*;

public class spaceFighterRunner extends Canvas
{
	static GraphicsConfiguration gc;
	public static JFrame frame = new JFrame(gc);	
	public static ArrayList<bulletActions> bulletList;
	public static ArrayList<tierOneAlien> alienList = new ArrayList<tierOneAlien>();
	public static ArrayList<tierTwoAlien> alienList2 = new ArrayList<tierTwoAlien>();
	public static ArrayList<tierThreeAlien> alienList3 = new ArrayList<tierThreeAlien>();
	public static ArrayList<tierFourAlien> alienList4 = new ArrayList<tierFourAlien>();
	public static ArrayList<alienBullets> alienBulletList = new ArrayList<alienBullets>();
	public static ArrayList<powerUps> powerUpList = new ArrayList<powerUps>();
	
	public static ArrayList<tierOneAlien> alienList1Deaths = new ArrayList<tierOneAlien>();
	public static ArrayList<tierTwoAlien> alienList2Deaths = new ArrayList<tierTwoAlien>();
	public static ArrayList<tierThreeAlien> alienList3Deaths = new ArrayList<tierThreeAlien>();
	public static ArrayList<tierFourAlien> alienList4Deaths = new ArrayList<tierFourAlien>();
	public static ArrayList<JLabel> extraHearts = new ArrayList<JLabel>();
	
	public static JLabel killCount;
	public static JLabel gameOverSign;
	public static JLabel title;
	public static JLabel heartIcon;
	public static JLabel score;
	public static JButton startButton;
	
	public static boolean levelComplete = false;
	public static boolean incrementWave = false;
	public static int levelCount = 1;
	public static int gameIndex = 0;
	public static int gameOverIndex = 0;
	private static int alienCount = 8;
	public static boolean isInTransition = false;
	public static boolean introOver = false;
	public static boolean firstTime = true;
	public static int isExtraLife = 0;
	
	public static ImageIcon alienimagev1;
	public static Image img;
	public static ImageIcon alienimage;
	
	public static ImageIcon alienimageT2v1;
	public static Image imgT2;
	public static ImageIcon alienimageT2;
	
	public static ImageIcon alienimageT2TwoHeartsv1;
	public static Image imgT2H2;
	public static ImageIcon alienimageT2TwoHearts;
	
	public static ImageIcon alienimageT2OneHeartv1;
	public static Image imgT2H1;
	public static ImageIcon alienimageT2OneHeart;
	
	public static ImageIcon alienBulletv1;
	public static Image tempAlienBullet;
	public static ImageIcon alienBulletv2;
	
	public static ImageIcon alienimageT3v1;
	public static Image imgT3;
	public static ImageIcon alienimageT3;
	
	public static ImageIcon alienimageT3FourHeartsv1;
	public static Image imgT3H4;
	public static ImageIcon alienimageT3FourHearts;
	
	public static ImageIcon alienimageT3ThreeHeartsv1;
	public static Image imgT3H3;
	public static ImageIcon alienimageT3ThreeHearts;
	
	public static ImageIcon alienimageT3TwoHeartsv1;
	public static Image imgT3H2;
	public static ImageIcon alienimageT3TwoHearts;
	
	public static ImageIcon alienimageT3OneHeartv1;
	public static Image imgT3H1;
	public static ImageIcon alienimageT3OneHeart;
	
	public static ImageIcon alienimageT4TwoHeartsv1;
	public static Image imgT4H2;
	public static ImageIcon alienimageT4TwoHearts;
	
	public static ImageIcon alienimageT4OneHeartv1;
	public static Image imgT4H1;
	public static ImageIcon alienimageT4OneHeart;
	
	public static ImageIcon alienimageT1Dyingv1;
	public static Image imgT1H0;
	public static ImageIcon alienimageT1Dying;
	
	public static ImageIcon alienimageT2Dyingv1;
	public static Image imgT2H0;
	public static ImageIcon alienimageT2Dying;
	
	public static ImageIcon alienimageT3Dyingv1;
	public static Image imgT3H0;
	public static ImageIcon alienimageT3Dying;
	
	public static ImageIcon alienimageT4Dyingv1;
	public static Image imgT4H0;
	public static ImageIcon alienimageT4Dying;
	
	public static ImageIcon reloadPowerUpv1;
	public static Image imgReload;
	public static ImageIcon reloadPowerUp;
	
	public static ImageIcon shootingPowerUpv1;
	public static Image imgCircleShoot;
	public static ImageIcon shootingPowerUp;
	
	public static ImageIcon extraLifePowerUpv1;
	public static Image extraLife;
	public static ImageIcon extraLifePowerUp;
	
	public static ImageIcon heartv1;
	public static Image heartimg;
	public static ImageIcon heart;
	
	public static ImageIcon fasterMovementv1;
	public static Image movementimg;
	public static ImageIcon fasterMovement;
	
	public static ImageIcon bullet2;
	public static Image tempImg;
	public static int gameScore = 0;
	
	public static void main(String[] args)
	{
		alienimagev1 = new ImageIcon("images/T1Alien.JPG");
		img = alienimagev1.getImage();
		alienimage = new ImageIcon(img.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT2v1 = new ImageIcon("images/T2H3.PNG");
		imgT2 = alienimageT2v1.getImage();
		alienimageT2 = new ImageIcon(imgT2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT2TwoHeartsv1 = new ImageIcon("images/T2H2.PNG");
		imgT2H2 = alienimageT2TwoHeartsv1.getImage();
		alienimageT2TwoHearts = new ImageIcon(imgT2H2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT2OneHeartv1 = new ImageIcon("images/T2H1.PNG");
		imgT2H1 = alienimageT2OneHeartv1.getImage();
		alienimageT2OneHeart = new ImageIcon(imgT2H1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT3v1 = new ImageIcon("images/T3H5.PNG");
		imgT3 = alienimageT3v1.getImage();
		alienimageT3 = new ImageIcon(imgT3.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT3FourHeartsv1 = new ImageIcon("images/T3H4.PNG");
		imgT3H4 = alienimageT3FourHeartsv1.getImage();
		alienimageT3FourHearts = new ImageIcon(imgT3H4.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT3ThreeHeartsv1 = new ImageIcon("images/T3H3.PNG");
		imgT3H3 = alienimageT3ThreeHeartsv1.getImage();
		alienimageT3ThreeHearts = new ImageIcon(imgT3H3.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT3TwoHeartsv1 = new ImageIcon("images/T3H2.PNG");
		imgT3H2 = alienimageT3TwoHeartsv1.getImage();
		alienimageT3TwoHearts = new ImageIcon(imgT3H2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT3OneHeartv1 = new ImageIcon("images/T3H1.PNG");
		imgT3H1 = alienimageT3OneHeartv1.getImage();
		alienimageT3OneHeart = new ImageIcon(imgT3H1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT4TwoHeartsv1 = new ImageIcon("images/T4H2.PNG");
		imgT4H2 = alienimageT4TwoHeartsv1.getImage();
		alienimageT4TwoHearts = new ImageIcon(imgT4H2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT4OneHeartv1 = new ImageIcon("images/T4H1.PNG");
		imgT4H1 = alienimageT4OneHeartv1.getImage();
		alienimageT4OneHeart = new ImageIcon(imgT4H1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienBulletv1 = new ImageIcon("images/redsquare.png");
		tempAlienBullet = alienBulletv1.getImage();
		alienBulletv2 = new ImageIcon(tempAlienBullet.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT4Dying = new ImageIcon("images/T4H2.PNG");
		imgT4H2 = alienimageT4TwoHeartsv1.getImage();
		alienimageT4TwoHearts = new ImageIcon(imgT4H2.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT4OneHeartv1 = new ImageIcon("images/T4H1.PNG");
		imgT4H1 = alienimageT4OneHeartv1.getImage();
		alienimageT4OneHeart = new ImageIcon(imgT4H1.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienBulletv1 = new ImageIcon("images/redsquare.png");
		tempAlienBullet = alienBulletv1.getImage();
		alienBulletv2 = new ImageIcon(tempAlienBullet.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT1Dyingv1 = new ImageIcon("images/T1AlienDeath.jpg");
		imgT1H0 = alienimageT1Dyingv1.getImage();
		alienimageT1Dying = new ImageIcon(imgT1H0.getScaledInstance(50, 50, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT2Dyingv1 = new ImageIcon("images/T2AlienDeath.png");
		imgT2H0 = alienimageT2Dyingv1.getImage();
		alienimageT2Dying = new ImageIcon(imgT2H0.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT3Dyingv1 = new ImageIcon("images/T3AlienDeath.png");
		imgT3H0 = alienimageT3Dyingv1.getImage();
		alienimageT3Dying = new ImageIcon(imgT3H0.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		alienimageT4Dyingv1 = new ImageIcon("images/T4AlienDeath.png");
		imgT4H0 = alienimageT4Dyingv1.getImage();
		alienimageT4Dying = new ImageIcon(imgT4H0.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		
		reloadPowerUpv1 = new ImageIcon("images/reloadPowerUp.png");
		imgReload = reloadPowerUpv1.getImage();
		reloadPowerUp = new ImageIcon(imgReload.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		
		shootingPowerUpv1 = new ImageIcon("images/scattershot.JPG");
		imgCircleShoot = shootingPowerUpv1.getImage();
		shootingPowerUp = new ImageIcon(imgCircleShoot.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		
		extraLifePowerUpv1 = new ImageIcon("images/heart.JPG");
		extraLife = extraLifePowerUpv1.getImage();
		extraLifePowerUp = new ImageIcon(extraLife.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		
		heartv1 = new ImageIcon("images/heartv2.JPG");
		heartimg = heartv1.getImage();
		heart = new ImageIcon(heartimg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		
		fasterMovementv1 = new ImageIcon("images/movement.JPG");
		movementimg = fasterMovementv1.getImage();
		fasterMovement = new ImageIcon(movementimg.getScaledInstance(40, 40, java.awt.Image.SCALE_SMOOTH));
		
		bullet2 = new ImageIcon("images/greensquare.jpg");
		tempImg = bullet2.getImage();
		bullet2 = new ImageIcon(tempImg.getScaledInstance(8, 8, java.awt.Image.SCALE_SMOOTH));
		
		spaceFighterRunner a = new spaceFighterRunner();
		a.start();
		gameControl c = new gameControl();
		bulletList = new ArrayList<bulletActions>();
		startNextWave nw = new startNextWave();
		waveOne wo = new waveOne();
		
		bulletCooldown cooldown = new bulletCooldown();
		movement ship = new movement();
		
		
		
		while(true)
    	{
    	try {
			Thread.sleep(16);
		} catch (InterruptedException e1) 
    		{
			// TODO Auto-generated catch block
    	}
		if (c.getGameOver() == true)
		{
			
			if (gameIndex == ship.getMovementIndex())
			{
				ship.resetSpeed();
			}
			
			if (powerUpList.size() == 1)
			{
				powerUpList.get(0).moveIcon();
			}
			
			if (levelComplete == false && incrementWave == false)
			{
				nw.startNewWave("Wave " + levelCount);
				incrementWave = true;
			}
			else if (incrementWave == true && introOver == false)
			{
				
				
				if (nw.hasItReachedMiddle() == true)
				{
					if (nw.getDelayCount() != 0)
					{
						nw.decrease();
					}
					else
					{
						nw.setMiddle(false);
					}
				}
				else
				{
					nw.moveNewWave();
				}
				
				if (nw.isItOver() == true)
				{
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e1) 
			    		{
						// TODO Auto-generated catch block
			    	}
					introOver = true;
					nw.setMiddle(false);
					incrementWave = false;
					levelComplete = true;
					nw.reset();
				}
			}
			else
			{
			
				
			if (isInTransition == false)
			{
				if (gameIndex >= 0 && gameIndex <  alienCount)
				{
					wo.spawnAliens(gameIndex, levelCount, alienCount, 1);
				}
			
			
				if (gameIndex >= 140 && gameIndex < 140 + alienCount)
				{
					wo.spawnAliens(gameIndex, levelCount, alienCount, 2);
				}
			
				
				if (gameIndex >= 280 && gameIndex < 280 + alienCount)
				{
					System.out.println("wave level: " + levelCount);
					wo.spawnAliens(gameIndex, levelCount, alienCount, 3);
				}
			
				if (gameIndex >= 420 && gameIndex < 420 + alienCount)
				{
					wo.spawnAliens(gameIndex, levelCount, alienCount, 4);
				}
			
				if (gameIndex >= 560 && gameIndex < 560 + alienCount)
				{
					wo.spawnAliens(gameIndex, levelCount, alienCount, 5);
				}
			
				if (gameIndex == (int) (1150 * Math.pow(1.1, levelCount)))
				{
					gameIndex = -1;
					levelCount++;
					isInTransition = true;
					alienCount = 8;
					if (levelCount == 3)
						alienCount = 5;
				}
			}
			
			if (isInTransition == true)
			{
				if (incrementWave == false)
				{
					nw.startNewWave("Wave " + levelCount);
					incrementWave = true;
				}
				else if (incrementWave == true)
				{
					
					if (nw.hasItReachedMiddle() == true)
					{
						if (nw.getDelayCount() != 0)
						{
							nw.decrease();
						}
						else
						{
							nw.setMiddle(false);
						}
					}
					else
					{
						nw.moveNewWave();
					}
					
					if (nw.isItOver() == true)
					{
						introOver = true;
						nw.setMiddle(false);
						incrementWave = false;
						levelComplete = true;
						nw.reset();
						isInTransition = false;
					}
				}
			}
			
			if (isInTransition == false)
			{
				gameIndex++;
			
				wo.updateAlienPositions();
			
			
				Point p = MouseInfo.getPointerInfo().getLocation();
			
				killCount.setText("kills: " + wo.getBodyCount());
				score.setText("score: " + gameScore);
			
				if (cooldown.isItShooting() == true)
				{
					if (cooldown.getCount() == 0)
					{
						if ((p.x != (ship.getSpaceShipX() + 40)) && (p.y != (ship.getSpaceShipY() + 40)))
						{
							bulletActions b = new bulletActions();
							b.drawBullet();
							b.calculateMovement(p.x - 223, p.y -46);
							bulletList.add(b);
						}
					}
			
			
					cooldown.deductOne();
				}
			
			
	    		if (c.shipMoveLeft() == true)
	    		{
	    			c.spaceshipMoveLeft();
	    		}
	    		if (c.shipMoveRight() == true)
	    		{
	    			c.spaceshipMoveRight();
	    		}
	    		if (c.shipMoveUp() == true)
	    		{
	    			c.spaceshipMoveUp();
	    		}
	    		if (c.shipMoveDown() == true)
	    		{
	    			c.spaceshipMoveDown();
	    		}
	    		
	    		
	    		for (int i = 0; i < bulletList.size(); )
	    		{
	    			if (bulletList.get(i).inBounds() == true)
	    			{
	    				bulletList.get(i).moveBullet();
	    				i++;
	    			}
	    			else
	    			{
	    				bulletList.get(i).deleteBullet();
	    				bulletList.remove(i);
	    			}
	    		}
	    		
			}
			
	    	}
			
			
		}
		else if (c.getGameOver() == false && firstTime == false)
		{
			if (gameOverIndex == 0)
			{
            	gameOverSign = new JLabel();
    		
				gameOverSign.setText("Game Over");
				gameOverSign.setForeground(Color.WHITE);
				gameOverSign.setBounds(390, 360, 240, 150);

				gameOverSign.setFont(new Font("Game Over", Font.PLAIN, 40));
    	    
				gameOverSign.setVisible(true);
			
				frame.add(gameOverSign);
    	    
				gameOverSign.setFocusable(true);
				gameOverSign.addKeyListener(new Listener());
				frame.repaint();
				
				levelComplete = false;
				incrementWave = false;
				levelCount = 1;
				gameIndex = 0;
				gameOverIndex = 0;
				alienCount = 8;
				isInTransition = false;
				introOver = false;
				
				
				bulletList.clear();
				alienList.clear();
				alienList2.clear();
				alienList3.clear();
				alienList4.clear();
				alienBulletList.clear();
				powerUpList.clear();
			
			}
			
			gameOverIndex++;
			
			if (gameOverIndex == 200)
			{
				frame.setVisible(false);
				frame = new JFrame();
				gameControl board = new gameControl();
				board.setGameOver(false);
				movement m = new movement();
				
				bulletCooldown bc = new bulletCooldown();
				
				frame.setTitle("Space Invaders");
				frame.setSize(1000, 2000);
				frame.getContentPane().setBackground(Color.BLACK);
				frame.setLocationRelativeTo(null);
			    frame.setLayout(null);
			    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			    frame.addKeyListener(new Listener());
			    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
		        manager.addKeyEventDispatcher(new MyDispatcher());
		        
			    
				title = new JLabel();
				
				title.setText("Demo Phase");
			    title.setForeground(Color.WHITE);
			    title.setBounds(405, 240, 440, 260);

				title.setFont(new Font("Demo Phase", Font.PLAIN, 30));
			    
			    title.setVisible(true);
			    
			    title.setFocusable(true);
			    title.addKeyListener(new Listener());
			    
			    
			    startButton = new JButton();
			    startButton.setText("Start Game");
			    
			    startButton.setForeground(Color.BLACK);
			    startButton.setFont(new Font("Start Game", Font.PLAIN, 30));
			    
			    startButton.setBounds(400, 390, 190, 40);
			    startButton.setVisible(true);
			    frame.setLayout(null);
			    frame.add(title);
			    frame.add(startButton);
			    
			    startButton.setFocusable(true);
			    startButton.addKeyListener(new Listener());
			    
			    
			    frame.getContentPane().addMouseListener(new MouseAdapter() {            
			    	   @Override
			    	   public void mouseClicked(MouseEvent e) {
			    		   if (board.getGameOver() == true)
			    		   {   
			    			   if (bc.isItShooting() == true)
			    			   {
			    				   bc.setShooting(false);
			    			   }
			    			   else
			    			   {
			    				   bc.setShooting(true);
			    			   }
			    		   }
			    	   }
			    	});
			    frame.setVisible(true);

			    
			    startButton.addActionListener(new ActionListener(){  
			        
			    	public void actionPerformed(ActionEvent e){  
			            title.setVisible(false);
			            startButton.setVisible(false);
			            
			            killCount = new JLabel();
			    		
			            killCount.setText("Kills: 0");
			            killCount.setForeground(Color.WHITE);
			            killCount.setBounds(880, -20, 120, 150);

			            killCount.setFont(new Font("Kills: 0", Font.PLAIN, 20));
			    	    
			            killCount.setVisible(true);
			    	    
			            killCount.setFocusable(true);
			    	    killCount.addKeyListener(new Listener());
			    	    
			    	    frame.add(killCount);
			    	    
			    	    score = new JLabel();
			    	    
			    	    score.setText("Score: 0");
			    	    score.setForeground(Color.WHITE);
			    	    score.setBounds(880, 40, 120, 150);

			    	    score.setFont(new Font("Kills: 0", Font.PLAIN, 20));
			    	    
			    	    score.setVisible(true);
			    	    
			    	    score.setFocusable(true);
			    	    score.addKeyListener(new Listener());
			    	    
			    	    frame.add(score);
			            
			            frame.getContentPane().remove(startButton);
			            board.setGameOver(true);
			            m.spawn(450, 400, 80, 80);
			            
			           firstTime = false;
			           gameOverIndex = 0;
			           
			    		}
				
			    });
			
			    gameOverSign.setVisible(false); 
			    frame.repaint();
			    wo.setBodyCount(0);
			    
			}
		
		}
		
	}
		
		
	}
	
	public void showHeartIcon()
	{
		heartIcon = new JLabel(heart);
		heartIcon.setBounds(960 - 40 * (isExtraLife - 1), 760, 40, 40);
		frame.add(heartIcon);
		heartIcon.setVisible(true);
		frame.repaint();
		extraHearts.add(heartIcon);
	}
	
	public void deleteHeartIcon()
	{
		extraHearts.get(extraHearts.size() - 1).setVisible(false);
		extraHearts.remove(extraHearts.size() - 1);
	}
	
	public void start()
	{
		gameControl board = new gameControl();
		board.setGameOver(false);
		movement m = new movement();
		
		bulletCooldown bc = new bulletCooldown();
		
		frame.setTitle("Space Invaders");
		frame.setSize(1000, 2000);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.addKeyListener(new Listener());
	    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
        manager.addKeyEventDispatcher(new MyDispatcher());
        
	    
		title = new JLabel();
		
		title.setText("Demo Phase");
	    title.setForeground(Color.WHITE);
	    title.setBounds(405, 240, 440, 260);

		title.setFont(new Font("Demo Phase", Font.PLAIN, 30));
	    
	    title.setVisible(true);
	    
	    title.setFocusable(true);
	    title.addKeyListener(new Listener());
	    
	    
	    startButton = new JButton();
	    startButton.setText("Start Game");
	    
	    startButton.setForeground(Color.BLACK);
	    startButton.setFont(new Font("Start Game", Font.PLAIN, 30));
	    
	    startButton.setBounds(400, 390, 190, 40);
	    startButton.setVisible(true);
	    frame.setLayout(null);
	    frame.add(title);
	    frame.add(startButton);
	    
	    startButton.setFocusable(true);
	    startButton.addKeyListener(new Listener());
	    
	    
	    frame.getContentPane().addMouseListener(new MouseAdapter() {            
	    	   @Override
	    	   public void mouseClicked(MouseEvent e) {
	    		   if (board.getGameOver() == true)
	    		   {   
	    			   if (bc.isItShooting() == true)
	    			   {
	    				   bc.setShooting(false);
	    			   }
	    			   else
	    			   {
	    				   bc.setShooting(true);
	    			   }
	    		   }
	    	   }
	    	});
	    frame.setVisible(true);

	    
	    startButton.addActionListener(new ActionListener(){  
	        public void actionPerformed(ActionEvent e){  
	            title.setVisible(false);
	            startButton.setVisible(false);
	            
	            killCount = new JLabel();
	    		
	            killCount.setText("Kills: 0");
	            killCount.setForeground(Color.WHITE);
	            killCount.setBounds(880, -20, 120, 150);

	            killCount.setFont(new Font("Kills: 0", Font.PLAIN, 20));
	    	    
	            killCount.setVisible(true);
	    	    
	            killCount.setFocusable(true);
	    	    killCount.addKeyListener(new Listener());
	    	    
	    	    frame.add(killCount);
	    	    
	    	    score = new JLabel();
	    	    
	    	    score.setText("Score: 0");
	    	    score.setForeground(Color.WHITE);
	    	    score.setBounds(880, 40, 120, 150);

	    	    score.setFont(new Font("Kills: 0", Font.PLAIN, 20));
	    	    
	    	    score.setVisible(true);
	    	    
	    	    score.setFocusable(true);
	    	    score.addKeyListener(new Listener());
	    	    
	    	    frame.add(score);
	            
	            frame.getContentPane().remove(startButton);
	            board.setGameOver(true);
	            m.spawn(450, 400, 80, 80);
	            
	           firstTime = false;
	            
	    }
	        
	      
	    });
	 
	
	}

	
        
}




class Listener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        //System.out.println("typed");
    }

    @Override
    public void keyPressed(KeyEvent e) {
    	//System.out.println("press");
    }

    @Override
    public void keyReleased(KeyEvent e) {
    	//System.out.println("release");
    }
}

class MyDispatcher implements KeyEventDispatcher {
    
    spaceFighterRunner gameCommand = new spaceFighterRunner();
    gameControl run = new gameControl();
    movement move = new movement();
    
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
        	if (e.getKeyCode() == 37 && run.getGameOver() == true)
        	{
        		run.setMoveShipLeft(true);
        	}
        	else if (e.getKeyCode() == 39 && run.getGameOver() == true)
        	{
        		run.setMoveShipRight(true);
        	}
        	else if (e.getKeyCode() == 38 && run.getGameOver() == true)
        	{
        		//System.out.println("down");
        		run.setMoveShipDown(true);
        	}
        	else if (e.getKeyCode() == 40 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipUp(true);
        	}
        	else if (e.getKeyCode() == 65 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipLeft(true);
        	}
        	else if (e.getKeyCode() == 68 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipRight(true);
        	}
        	else if (e.getKeyCode() == 83 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipUp(true);
        	}
        	else if (e.getKeyCode() == 87 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipDown(true);
        	}
        	
        
        	
        } else if (e.getID() == KeyEvent.KEY_RELEASED) {
            //System.out.println(e.getKeyCode());
        	if (e.getKeyCode() == 37 && run.getGameOver() == true)
        	{
        		run.setMoveShipLeft(false);
        	}
        	else if (e.getKeyCode() == 39 && run.getGameOver() == true)
        	{
        		run.setMoveShipRight(false);
        	}
        	else if (e.getKeyCode() == 38 && run.getGameOver() == true)
        	{
        		//System.out.println("down");
        		run.setMoveShipDown(false);
        	}
        	else if (e.getKeyCode() == 40 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipUp(false);
        	}
        	else if (e.getKeyCode() == 65 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipLeft(false);
        	}
        	else if (e.getKeyCode() == 68 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipRight(false);
        	}
        	else if (e.getKeyCode() == 83 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipUp(false);
        	}
        	else if (e.getKeyCode() == 87 && run.getGameOver() == true)
        	{
        		//System.out.println("up");
        		run.setMoveShipDown(false);
        	}
        } else if (e.getID() == KeyEvent.KEY_TYPED) {
            // System.out.println("3test3");
        }
        return false;
    }
}

class movement extends spaceFighterRunner
{
	public static ImageIcon spaceshipimage;
	public static Image img;
	public static JLabel spaceship;
	private static int x1 = 450;
	private static int y1 = 400;
	private static int movementSpeed = 2;
	private static int movementGameIndex = -500;
	
	public void spawn(int x1, int x2, int y1, int y2)
	{
		spaceshipimage = new ImageIcon("images/spaceship2.png");
 		img = spaceshipimage.getImage();
 		spaceshipimage = new ImageIcon(img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
 		spaceship = new JLabel(spaceshipimage);
 		spaceship.setBounds(x1, x2, y1, y2);
 		frame.add(spaceship);
 		spaceship.setVisible(true);
 		this.x1 = x1;
 		this.y1 = x2;
	}
	
	public void resetSpeed()
	{
		movementSpeed = 2;
		movementGameIndex = -500;
	}
	
	public void setSpeed(int a)
	{
		movementSpeed = a;
		movementGameIndex = gameIndex + 800;
	}
	
	public int getMovementIndex()
	{
		return movementGameIndex;
	}
	
	public int getSpaceShipX()
	{
		return x1;
	}
	
	public int getSpaceShipY()
	{
		return y1;
	}
	
	public void moveShipHorizontally(int dx)
	{
		// System.out.println(x1);
		// System.out.println(movement.x1 + " " + movement.y1 + " " + dx);
		if (x1 + 80 >= 1000 && dx > 0)
		{
			spaceship.setBounds(movement.x1, movement.y1, 80, 80);
		}
		else if (x1 <= 0 && dx < 0)
		{
			spaceship.setBounds(movement.x1, movement.y1, 80, 80);
		}
		else
		{
			spaceship.setBounds(movement.x1 + dx, movement.y1, 80, 80);
			if (dx > 0)
				movement.x1 = movement.x1 + movementSpeed;
			else
				movement.x1 = movement.x1 - movementSpeed;
		}
	}
	
	public void moveShipDiagonally(int dx, int dy)
	{
		int tempX;
		int tempY;
		
		if (dx < 0)
			tempX = -movementSpeed;
		else 
			tempX = movementSpeed;
		
		if (dy < 0)
			tempY = -movementSpeed;
		else 
			tempY = movementSpeed;
		
		if (x1 + 80 >= 1000 && dx > 0)
		{
			if (y1 + 80 >= 2000 && dy > 0)
			{
				spaceship.setBounds(this.x1, this.y1, 80, 80);
			}
			else
			{
				spaceship.setBounds(this.x1, this.y1 + tempY, 80, 80);
			}
		}
		else if (y1 + 80 >= 2000 && dy > 0)
		{
			if (x1 + 80 >= 1000 && dx > 0)
			{
				spaceship.setBounds(this.x1, this.y1, 80, 80);
			}
			else
			{
				spaceship.setBounds(this.x1 + tempX, this.y1, 80, 80);
			}
		}
		else
		{
			spaceship.setBounds(this.x1 + tempX, this.y1 + tempY, 80, 80);
		}
	}
	
	public void moveShipvertically(int dy)
	{
		//System.out.println(x1);
		//System.out.println(y1);
		if (y1 + 80 >= 2000 && dy > 0)
		{
			spaceship.setBounds(movement.x1, movement.y1, 80, 80);
		}
		else if (y1 <= 0 && dy < 0)
		{
			spaceship.setBounds(movement.x1, movement.y1, 80, 80);
		}
		else
		{
			spaceship.setBounds(movement.x1, movement.y1 + dy, 80, 80);
			if (dy > 0)
				movement.y1 = movement.y1 + movementSpeed;
			else
				movement.y1 = movement.y1 - movementSpeed;
		}
		
	}
	
	public void rotateShip(int cx, int cy)
	{
		int diffX = cx - (getSpaceShipX() + 40);
		int diffY = cy - (getSpaceShipY() + 40);
		
		double temp = ((double) Math.abs(diffX) / (double) Math.abs(diffY));
		double cursorAngle = Math.atan(temp);
		
		if (diffX < 0 && diffY < 0)
		{
			
		}
		else if (diffX > 0 && diffY > 0)
		{
			
		}
		else if (diffX < 0 && diffY > 0)
		{
			
		}
		else if (diffX > 0 && diffY < 0)
		{
			
		}
	}
	
}

class bulletActions extends movement
{
	
	private JLabel bullet;
	private double x = 0.0;
	private double y = 0.0;
	private double changeX = 1;
	private double changeY = 1;
	private double angle = 0;
	private double tempX = 50.0;
	private double tempY = 50.0;
	
	movement ship = new movement();
	
	public int getX()
	{
		return (int) x;
	}
	
	public int getY()
	{
		return (int) y;
	}
	
	public void drawBullet()
	{

			bullet = new JLabel(bullet2);
			bullet.setBounds(getSpaceShipX()+36, getSpaceShipY()+36, 8, 8);
			bullet.setVisible(true);
			frame.add(bullet);
			frame.repaint();
			this.x = getSpaceShipX()+36;
			this.y = getSpaceShipY()+36;
	}
	
	public void calculateMovement(int a, int b)
	{
		tempX = a - (getSpaceShipX() + 40);
		tempY = b - (getSpaceShipY() + 40);
		
		if (b != 440)
		{
			double temp = ((double) Math.abs(tempY) / (double) Math.abs(tempX));
			angle = Math.atan(temp);
		}
		else
		{
			angle = 90;
		}
		

		
		if (tempX < 0 && tempY < 0)
		{
			changeX = Math.cos(angle) * 10.0 * -1;
			changeY = Math.sin(angle) * 10.0 * -1;
		}
		else if (tempX > 0 && tempY > 0)
		{
			changeY = Math.sin(angle) * 10.0;
			changeX = Math.cos(angle) * 10.0;
		}
		else if (tempX < 0 && tempY > 0)
		{
			changeY = Math.sin(angle) * 10.0;
			changeX = Math.cos(angle) * 10.0 * -1;
		}
		else if (tempX > 0 && tempY < 0)
		{
			changeY = Math.sin(angle) * 10.0 * -1;
			changeX = Math.cos(angle) * 10.0;
		}
		else if (tempX == 0 && tempY > 0)
		{
			changeX = 0.0;
			changeY = 10.0;
		}
		else if (tempX == 0 && tempY < 0)
		{
			changeX = 0.0;
			changeY = -10.0;
		}
		else if (tempY == 0 && tempX > 0)
		{
			changeX = 10.0;
			changeY = 0.0;
		}
		else
		{
			changeY = 0.0;
			changeX = -10.0;
		}
		
		
	}
	
	public void calculateMovement(int a)
	{
		
		angle = a;
		
		if (angle < 360 && angle > 270)
		{
			changeX = Math.cos(360-angle) * 10.0;
			changeY = Math.sin(360-angle) * 10.0;
		}
		else if (angle > 90 && angle < 180)
		{
			changeY = Math.sin(180-angle) * -10.0;
			changeX = Math.cos(180-angle) * -10.0;
		}
		else if (angle > 0 && angle < 90)
		{
			changeY = Math.sin(angle) * 10.0 * -1;
			changeX = Math.cos(angle) * 10.0;
		}
		else if (angle > 180 && angle < 270)
		{
			changeY = Math.sin(angle-180) * 10.0;
			changeX = Math.cos(angle-180) * 10.0 * -1;
		}
		else if (angle == 0)
		{
			changeX = 10.0;
			changeY = 0.0;
		}
		else if (angle == 90)
		{
			changeX = 0.0;
			changeY = -10.0;
		}
		else if (angle == 180)
		{
			changeX = -10.0;
			changeY = 0.0;
		}
		else if (angle == 270)
		{
			changeY = 10.0;
			changeX = 0.0;
		}
		
		
	}
	
	public boolean inBounds()
	{
		if (x >= 0 && x <= 1000)
		{
			if (y >= 0 && y <= 2000)
			{
				return true;
			}
		}
		return false;
	}
	
	public void moveBullet()
	{
		bullet.setBounds((int) Math.round(x + changeX), (int) Math.round(y + changeY), 8, 8);
		x = ((double)x + changeX);
		y = ((double)y + changeY);
	}
	
	public void deleteBullet()
	
	{
		bullet.setVisible(false);
	}
}


