import java.awt.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.*;

public class gameControl extends movement
{
	
	private static boolean gameOver = false;
	
	public void setGameOver(boolean a)
	{
		gameOver = a;
	}
	
	public boolean getGameOver()
	{
		return gameOver;
	}
	
	public static boolean moveShipLeft = false;
	public static boolean moveShipRight = false;
	public static boolean moveShipDown = false;
	public static boolean moveShipUp = false;
	
	public boolean shipMoveLeft()
	{
		return moveShipLeft;
	}
	public boolean shipMoveRight()
	{
		return moveShipRight;
	}
	public boolean shipMoveDown()
	{
		return moveShipDown;
	}
	public boolean shipMoveUp()
	{
		return moveShipUp;
	}
	
	public void setMoveShipLeft(boolean a)
	{
		moveShipLeft = a;
	}
	public void setMoveShipRight(boolean a)
	{
		moveShipRight = a;
	}
	public void setMoveShipUp(boolean a)
	{
		moveShipUp = a;
	}
	public void setMoveShipDown(boolean a)
	{
		moveShipDown = a;
	}
	
	public void spaceshipMoveLeft()
	{
		moveShipHorizontally(-2);
	}
	public void spaceshipMoveRight()
	{
		moveShipHorizontally(2);
	}
	public void spaceshipMoveUp()
	{
		moveShipvertically(2);
	}
	public void spaceshipMoveDown()
	{
		moveShipvertically(-2);
	}
	
	
	
}

class bulletCooldown
{
	private static int countDown = 0;
	private static int powerUpCoolDown = -1;
	private static boolean isShooting = false;
	private static boolean bulFullCooldown = true;
	startNextWave nw = new startNextWave();
	
	public int getCount()
	{
		if (countDown == 0)
		{
			if (bulFullCooldown == true || powerUpCoolDown < 0)
			{
				countDown = 12;
			}
			else
			{
				countDown = 8;
			}
			return 0;
		}
		if (powerUpCoolDown == 0)
		{
			System.out.println("ggdfgfdgdfgd");
			nw.clearPowerUps();
		}
		return countDown;
	}
	
	public void setBulCooldown(int gh)
	{
		powerUpCoolDown = 400;
		bulFullCooldown = false;
	}
	
	public void deductOne()
	{
		countDown = countDown - 1;
		powerUpCoolDown--;
	}
	
	public boolean isItShooting()
	{
		return isShooting;
	}
	
	public void setShooting(boolean a)
	{
		isShooting = a;
	}
}

class startNextWave extends spaceFighterRunner
{
	public JLabel newWave;
	
	private static int newWaveX;
	private static int newWaveY;
	
	private static int newWaveChange = 1;
	
	private static boolean isOver = false;
	private static boolean hasReachedMiddle = false;
	private static boolean hasReachedMiddle2 = false;
	
	public static int delay = 200;
	
	public void reset()
	{
		delay = 200;
		newWaveChange = 1;
		isOver = false;
		hasReachedMiddle = false;
		hasReachedMiddle2 = false;
		
	}
	
	public void clearPowerUps()
	{
		powerUpList.clear();
	}
	
	public void startNextWave()
	{
		newWaveChange = 1;
		hasReachedMiddle = false;
		isOver = false;
		delay = 200;
	}
	
	public boolean isItOver()
	{
		return isOver;
	}
	
	public void startNewWave(String s)
    {
    	newWave = new JLabel(s);
    	newWaveX = newWave.getX();
    	newWaveY= newWave.getY();
    	newWave.setFont(new Font("Serif", Font.BOLD, 48));
    	
    	newWave.setForeground(Color.white);
    	newWave.setBackground(Color.blue);
    	
    	newWave.setBounds(400, 0, 200, 50);
    	newWave.setHorizontalAlignment(JLabel.CENTER);
    	
    	frame.add(newWave);
    	newWave.setVisible(true);
    	frame.repaint();
    }
	
	public int getDelayCount()
	{
		return delay;
	}
	
	public void decrease()
	{
		delay--;
	}
	
	public boolean hasItReachedMiddle()
	{
		return hasReachedMiddle2;
	}
	
	public void setMiddle(boolean a)
	{
		hasReachedMiddle2 = a;
	}
	
	public void moveNewWave()
	{
		if (hasReachedMiddle == false)
		{
			newWave.setBounds(400, newWaveY + newWaveChange, 200, 50);
			newWaveY += newWaveChange;
			if (newWaveY <= 200)
			{
				newWaveChange += 1;
			}
			else
			{
				newWaveChange -= 1;
			}
			
			if (newWaveChange < 1)
			{
				hasReachedMiddle = true;
				hasReachedMiddle2 = true;
			}
		}
		else
		{
			newWave.setBounds(400, newWaveY - newWaveChange, 200, 50);
			newWaveY -= newWaveChange;
			if (newWaveY >= 200)
			{
				newWaveChange += 1;
			}
			else
			{
				newWaveChange -= 1;
			}
			
			if (newWaveChange < 1)
			{
				newWave.setVisible(false);
				isOver = true;
			}
		}
		
	}
	
}

class waveOne extends spaceFighterRunner
{
	private boolean yoov = false;
	public static int bodyCount = 0;
	private int upperGameIndexBound;
	private int spawnIndex = 0;
	private int spawnUpperBound = 0;
	private boolean updated = false;
	
	
	gameControl gc = new gameControl();
	bulletCooldown bc = new bulletCooldown();
	movement shipAspects = new movement();
	
	bulletActions ba;
	
	public void spawnWaveOne(int a, boolean b)
	{
		alienList.add(new tierOneAlien());
		if (b == false)
			alienList.get(alienList.size()-1).spawnTierOneAlien(a);
		else
			alienList.get(alienList.size()-1).spawnTierOneAlienStraight(a);
	}
	
	public void spawnWaveTwo(int a)
	{
		alienList2.add(new tierTwoAlien());
		alienList2.get(alienList2.size()-1).spawnTierTwoAlien(a);
	}
	
	public void spawnWaveThree(int a)
	{
		alienList3.add(new tierThreeAlien());
		alienList3.get(alienList3.size()-1).spawnTierThreeAlien(a);
	}
	
	public void spawnAliens(int gameIndex, int gameLevel, int numberOfAliens, int waveIndex)
	{
		 
		int spawnScale = (int) Math.round(1000.0 / ((double)numberOfAliens));
		
		if (updated == false)
		{
			spawnUpperBound = gameIndex;
			updated = true;
		}
		if (gameLevel == 1)
		{
			if (spawnUpperBound <= gameIndex && gameIndex < numberOfAliens + spawnUpperBound)
			{
				spawnWaveOne(0 + spawnScale * (gameIndex - spawnUpperBound), false);
				
				if (gameIndex == numberOfAliens + spawnUpperBound - 1)
				{
					updated = false;
				}
			} 
		}
		if (gameLevel == 2)
		{
			if (spawnUpperBound <= gameIndex && gameIndex < numberOfAliens + spawnUpperBound)
			{
				System.out.println(waveIndex);
				//if (waveIndex % 2 == 1)
				{
					if (gameIndex % 3 == 0)
					{
						spawnWaveTwo(0 + spawnScale * (gameIndex - spawnUpperBound));
					}
					else
					{
						spawnWaveOne(0 + spawnScale * (gameIndex - spawnUpperBound), true);
					}
				
					if (gameIndex == numberOfAliens + spawnUpperBound - 1)
					{
						updated = false;
					}
				}
			} 
		}
		
		if (gameLevel == 3)
		{
			if (spawnUpperBound <= gameIndex && gameIndex < numberOfAliens + spawnUpperBound)
			{
					
				if (waveIndex % 3 == 1)
				{
					if (gameIndex % 2 == 1)
						spawnWaveThree(0 + spawnScale * (gameIndex - spawnUpperBound));
					else
						spawnWaveTwo(0 + spawnScale * (gameIndex - spawnUpperBound));
				}
					
					
					
					if (gameIndex == numberOfAliens + spawnUpperBound - 1)
					{
						updated = false;
					}
			} 
		}
		
		if (gameLevel == 4)
		{
			if (spawnUpperBound <= gameIndex && gameIndex < numberOfAliens + spawnUpperBound)
			{
					
				if (waveIndex % 3 == 1)
				{
					if (gameIndex % 3 == 1)
						spawnWaveThree(0 + spawnScale * (gameIndex - spawnUpperBound));
					else
						spawnWaveTwo(0 + spawnScale * (gameIndex - spawnUpperBound));
				}
					
					
					
					if (gameIndex == numberOfAliens + spawnUpperBound - 1)
					{
						updated = false;
					}
			} 
		}
		
		if (gameLevel == 5)
		{
			if (spawnUpperBound <= gameIndex && gameIndex < numberOfAliens + spawnUpperBound)
			{
					
				if (waveIndex % 2 == 1)
				{
					if (gameIndex % 2 == 1)
						spawnWaveThree(0 + spawnScale * (gameIndex - spawnUpperBound));
					else
						spawnWaveTwo(0 + spawnScale * (gameIndex - spawnUpperBound));
				}
				if (waveIndex % 2 == 0)
				{
					if (gameIndex % 2 == 1)
						spawnWaveTwo(0 + spawnScale * (gameIndex - spawnUpperBound));
					else
						spawnWaveThree(0 + spawnScale * (gameIndex - spawnUpperBound));
				}
					
					
					
				if (gameIndex == numberOfAliens + spawnUpperBound - 1)
				{
						updated = false;
				}
			} 
		}
		if (gameLevel > 5)
		{
			
		}
		
	}
	
	public void updateAlienPositions()
	{
		
		for (int d = 0; d < alienList1Deaths.size(); d++)
		{
			if (alienList1Deaths.get(d).getDeathCooldown() == false)
			{
				alienList1Deaths.get(d).decDeathCooldown();
			}
			else
			{
				alienList1Deaths.remove(d);
				d--;
				if (d == -1)
				{
					break;
				}
			}
		}
		
		for (int d = 0; d < alienList2Deaths.size(); d++)
		{
			if (alienList2Deaths.get(d).getDeathCooldown() == false)
			{
				alienList2Deaths.get(d).decDeathCooldown();
			}
			else
			{
				alienList2Deaths.remove(d);
				d--;
				if (d == -1)
				{
					break;
				}
			}
		}
		
		for (int d = 0; d < alienList3Deaths.size(); d++)
		{
			if (alienList3Deaths.get(d).getDeathCooldown() == false)
			{
				alienList3Deaths.get(d).decDeathCooldown();
			}
			else
			{
				alienList3Deaths.remove(d);
				d--;
				if (d == -1)
				{
					break;
				}
			}
		}
		
		for (int d = 0; d < alienList4Deaths.size(); d++)
		{
			if (alienList4Deaths.get(d).getDeathCooldown() == false)
			{
				alienList4Deaths.get(d).decDeathCooldown();
			}
			else
			{
				alienList4Deaths.remove(d);
				d--;
				if (d == -1)
				{
					break;
				}
			}
		}
		
		
		for (int i = 0; i < alienList.size(); )
		{
			alienList.get(i).moveTierOneAlien();
			
			if (alienList.get(i).hasHitShip(gc.getSpaceShipX(), gc.getSpaceShipY()) == true)
			{
				if (isExtraLife == 0)
				{
					gc.setGameOver(false);
				}
				else
				{
					isExtraLife--;
					alienList.get(i).setVisible(false);
					alienList.remove(i);
					if (i == alienList.size()-1)
					{
						break;
					}
					else
					{
						i--;
					}
					deleteHeartIcon();
				}
			}
			
			for (int j = 0; j < bulletList.size(); j++)
			{
				if (alienList.get(i).isHitByBullet(bulletList.get(j).getX(), bulletList.get(j).getY()) == true)
				{
					if ((int) (Math.random() * 100) >= 80 && powerUpList.size() == 0)
					{
						int rn = (int) (Math.random() * 4);
						if (rn == 1)
						{
							powerUps pu = new powerUps();
							pu.spawnReloadPowerUp(alienList.get(i).getX() + 5, alienList.get(i).getY() + 50);
							powerUpList.add(pu);
						}
						else if (rn == 0)
						{
							powerUps pu = new powerUps();
							pu.spawnCircleShootingPowerUp(alienList.get(i).getX() + 5, alienList.get(i).getY() + 50);
							powerUpList.add(pu);
						}
						else if (rn == 2)
						{
							powerUps pu = new powerUps();
							pu.spawnExtraLifePowerUp(alienList.get(i).getX() + 5, alienList.get(i).getY() + 50);
							powerUpList.add(pu);
						}
						else if (rn == 3)
						{
							powerUps pu = new powerUps();
							pu.spawnMovementPowerUp(alienList.get(i).getX() + 5, alienList.get(i).getY() + 50);
							powerUpList.add(pu);
						}
					}
					
					
					yoov = true;
					alienList1Deaths.add(alienList.get(i));
					alienList.remove(i);
					bulletList.get(j).deleteBullet();
					bulletList.remove(j);
					bodyCount++;
					gameScore += 10;
					
					if (i == alienList.size() && i !=0)
					{
						i--;
					}
					
					if (i == alienList.size() && i ==0)
					{
						break;
					}
				}
			}
			
			
			
			
			
			if (yoov == false)
			{
				i++;
			}
			else
			{
				yoov = false;
			}
			
			
		}
		
		for (int b = 0; b < alienList.size(); )
		{
			if (alienList.get(b).isOut() == true)
			{
				alienList.get(b).setVisible(false);
				alienList.remove(b);
				if (b == alienList.size())
				{
					break;
				}
			}
			else
			{
				b++;
			}
		}
		
		for (int i = 0; i < alienList4.size(); )
		{
			alienList4.get(i).moveTierFourAlien();
			
			if (alienList4.get(i).hasHitShip(gc.getSpaceShipX(), gc.getSpaceShipY()) == true)
			{
				if (isExtraLife == 0)
				{
					gc.setGameOver(false);
				}
				else
				{
					isExtraLife--;
					alienList4.get(i).setVisible(false);
					alienList4.remove(i);
					if (i == alienList4.size()-1)
					{
						break;
					}
					else
					{
						i--;
					}
					deleteHeartIcon();
				}
			}
			
			for (int j = 0; j < bulletList.size(); j++)
			{
				
				if (alienList4.get(i).isHitByBullet(bulletList.get(j).getX(), bulletList.get(j).getY()) == true)
				{
					
					bulletList.get(j).deleteBullet();
					bulletList.remove(j);
					
					if (alienList4.get(i).getHealth() == 0)
					{
						alienList4Deaths.add(alienList4.get(i));
						alienList4.remove(i);
						bodyCount++;
						gameScore += 20;
						yoov = true;
					}
					
					
					if (i == alienList4.size() && i !=0)
					{
						i--;
					}
					
					if (i == alienList4.size() && i ==0)
					{
						break;
					}
				}
			}
			
			
			
			
			
			
			if (yoov == false)
			{
				i++;
			}
			else
			{
				yoov = false;
			}
			
			
		}
		
		for (int b = 0; b < alienList4.size(); )
		{
			if (alienList4.get(b).isOut() == true)
			{
				alienList4.get(b).setVisible(false);
				alienList4.remove(b);
				if (b == alienList4.size())
				{
					break;
				}
			}
			else
			{
				b++;
			}
		}
		
		
		yoov = false;
		
		for (int T2Count = 0; T2Count < alienList2.size(); )
		{
			
			alienList2.get(T2Count).moveTierTwoAlien();
			alienList2.get(T2Count).willSpawnBullet();
			
			if (alienList2.get(T2Count).hasHitShip(gc.getSpaceShipX(), gc.getSpaceShipY()))
			{
				if (isExtraLife == 0)
				{
					gc.setGameOver(false);
				}
				else
				{
					isExtraLife--;
					alienList2.get(T2Count).setVisible(false);
					alienList2.remove(T2Count);
					if (T2Count == alienList2.size()-1)
					{
						break;
					}
					else if (T2Count != 0)
					{
						T2Count--;
					}
					deleteHeartIcon();
				}
			}
			
			for (int jj = 0; jj < bulletList.size(); jj++)
			{
				if (alienList2.get(T2Count).isHitByBullet(bulletList.get(jj).getX(), bulletList.get(jj).getY()) == true)
				{
					bulletList.get(jj).deleteBullet();
					bulletList.remove(jj);
					
					if (alienList2.get(T2Count).getHealth() == 0)
					{
						if ((int) (Math.random() * 100) >= 75 && powerUpList.size() == 0)
						{
							int rn = (int) (Math.random() * 4);
							if (rn == 0)
							{
								powerUps pu = new powerUps();
								pu.spawnReloadPowerUp(alienList2.get(T2Count).getX() + 20, alienList2.get(T2Count).getY() + 50);
								powerUpList.add(pu);
							}
							else if (rn == 1)
							{
								powerUps pu = new powerUps();
								pu.spawnCircleShootingPowerUp(alienList2.get(T2Count).getX() + 20, alienList2.get(T2Count).getY() + 50);
								powerUpList.add(pu);
							}
							else if (rn == 2)
							{
								powerUps pu = new powerUps();
								pu.spawnExtraLifePowerUp(alienList2.get(T2Count).getX() + 20, alienList2.get(T2Count).getY() + 50);
								powerUpList.add(pu);
							}
							else if (rn == 3)
							{
								powerUps pu = new powerUps();
								pu.spawnMovementPowerUp(alienList2.get(T2Count).getX() + 20, alienList2.get(T2Count).getY() + 50);
								powerUpList.add(pu);
							}
						}	
						
						alienList2Deaths.add(alienList2.get(T2Count));
						alienList2.remove(T2Count);
						bodyCount++;
						gameScore += 70;
						yoov = true;
					}
					
					if (T2Count == alienList2.size() && T2Count !=0)
					{
						T2Count--;
					}
					
					if (T2Count == alienList2.size() && T2Count ==0)
					{
						break;
					}
				}
			}
			
			
			
			if (yoov == false)
			{
				T2Count++;
			}
			else
			{
				yoov = false;
			}
			
		}
		
		for (int b = 0; b < alienList2.size(); )
		{
			if (alienList2.get(b).isOut() == true)
			{
				alienList2.get(b).setVisible(false);
				alienList2.remove(b);
				if (b == alienList2.size())
				{
					break;
				}
			}
			else
			{
				b++;
			}
		}
		
		yoov = false;
		
		for (int T3Count = 0; T3Count < alienList3.size(); )
		{
			
			alienList3.get(T3Count).moveTierThreeAlien();
			alienList3.get(T3Count).willSpawnT4Alien();
			
			
			if (alienList3.get(T3Count).hasHitShip(gc.getSpaceShipX(), gc.getSpaceShipY()))
			{
				if (isExtraLife == 0)
				{
					gc.setGameOver(false);
				}
				else
				{
					isExtraLife--;
					alienList3.get(T3Count).setVisible(false);
					alienList3.remove(T3Count);
					if (T3Count == alienList3.size()-1)
					{
						break;
					}
					else
					{
						T3Count--;
					}
					deleteHeartIcon();
				}
			}
			
			
			for (int jj = 0; jj < bulletList.size(); jj++)
			{
				
				if (alienList3.get(T3Count).isHitByBullet(bulletList.get(jj).getX(), bulletList.get(jj).getY()) == true)
				{
					bulletList.get(jj).deleteBullet();
					bulletList.remove(jj);
					
					if (alienList3.get(T3Count).getHealth() == 0)
					{
						if ((int) (Math.random() * 100) >= 70 && powerUpList.size() == 0)
						{
							int rn = (int) (Math.random() * 4);
							if (rn == 0)
							{
								powerUps pu = new powerUps();
								pu.spawnReloadPowerUp(alienList3.get(T3Count).getX() + 20, alienList3.get(T3Count).getY() + 50);
								powerUpList.add(pu);
							}
							else if (rn == 1)
							{
								powerUps pu = new powerUps();
								pu.spawnCircleShootingPowerUp(alienList3.get(T3Count).getX() + 20, alienList3.get(T3Count).getY() + 50);
								powerUpList.add(pu);
							}
							else if (rn == 2)
							{
								powerUps pu = new powerUps();
								pu.spawnExtraLifePowerUp(alienList3.get(T3Count).getX() + 20, alienList3.get(T3Count).getY() + 50);
								powerUpList.add(pu);
							}
							else if (rn == 3)
							{
								powerUps pu = new powerUps();
								pu.spawnMovementPowerUp(alienList3.get(T3Count).getX() + 20, alienList3.get(T3Count).getY() + 50);
								powerUpList.add(pu);
							}
							else
							{
								powerUps pu = new powerUps();
								pu.spawnReloadPowerUp(alienList3.get(T3Count).getX() + 20, alienList3.get(T3Count).getY() + 50);
								powerUpList.add(pu);
							}
						}
						alienList3Deaths.add(alienList3.get(T3Count));
						alienList3.remove(T3Count);
						bodyCount++;
						gameScore+=100;
						yoov = true;
					}
					
					if (T3Count == alienList3.size() && T3Count !=0)
					{
						T3Count--;
					}
					
					if (T3Count == alienList3.size() && T3Count ==0)
					{
						break;
					}
				}
			}
			
			

			if (yoov == false)
			{
				T3Count++;
			}
			else
			{
				yoov = false;
			}
			
		}
		
		for (int c = 0; c < alienList3.size(); )
		{
			if (alienList3.get(c).isOut() == true)
			{
				alienList3.get(c).setVisible(false);
				alienList3.remove(c);
				if (c == alienList3.size())
				{
					break;
				}
			}
			else
			{
				c++;
			}
		}
		
		
		for (int e = 0; e < bulletList.size(); e++)
		{
			for (int f = 0; f < alienBulletList.size(); )
			{
				if (alienBulletList.get(f).collide(bulletList.get(e).getX(), bulletList.get(e).getY(), 8 , 8) == true)
				{
					alienBulletList.get(f).deleteBullet();
					alienBulletList.remove(f);
				}
				else
				{
					f++;
					if (f == alienBulletList.size())
					{
						break;
					}
				}
			}
			
			if (powerUpList.size() == 1)
			{
				if (powerUpList.get(0).gotPowerUp(bulletList.get(e).getX(), bulletList.get(e).getY()))
				{
					powerUpList.get(0).setSee();
					if (powerUpList.get(0).getType() == 1)
					{
						bc.setBulCooldown(6);
						break;
					}
					else if (powerUpList.get(0).getType() == 2)
					{
						
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(0);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(30);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(45);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(60);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(120);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(135);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(150);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(180);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(210);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(225);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(240);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(270);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(300);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(315);
						bulletList.add(ba);
						ba = new bulletActions();
						ba.drawBullet();
						ba.calculateMovement(330);
						bulletList.add(ba);
						
						
						powerUpList.clear();
						break;
					}
					else if (powerUpList.get(0).getType() == 3)
					{
						isExtraLife++;
						showHeartIcon();
						powerUpList.clear();
						break;
					}
					else if (powerUpList.get(0).getType() == 4)
					{
						shipAspects.setSpeed(3);
						
						powerUpList.clear();
						break;
					}
					else
					{
						System.out.println("This Line Should Not Execute");
					}
				}
			}
		}
		
		for (int d = 0; d < alienBulletList.size(); )
		{
			alienBulletList.get(d).moveAlienBullet();
			
			if (alienBulletList.get(d).hitShip() == true)
			{
				if (isExtraLife == 0)
				{
					gc.setGameOver(false);
				}
				else
				{
					isExtraLife--;
					alienBulletList.get(d).deleteBullet();
					alienBulletList.remove(d);
					if (d == alienBulletList.size()-1)
					{
						break;
					}
					else
					{
						d--;
					}
					deleteHeartIcon();
				}
			}
			
			if (alienBulletList.get(d).inBounds() == false)
			{
				alienBulletList.get(d).deleteBullet();
				alienBulletList.remove(d);
				if (d == alienBulletList.size())
				{
					break;
				}
			}
			else
			{
				d++;
			}
			
			
		}
		
	}
	
	public int getBodyCount()
	{
		return bodyCount;
	}
	
	public void setBodyCount(int a)
	{
		bodyCount = a;
	}
	
	public int getAmountOfAliens()
	{
		return alienList.size() + alienList2.size();
	}
}
