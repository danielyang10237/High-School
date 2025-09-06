import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class objectSpawner {
	
}

class tierOneAlien extends spaceFighterRunner
{
	private int alienX;
	private int alienY;
	JLabel tierOneAlien;
	private int moveAlien = 1;
	private int movementCounter = 0;
	private int deathCooldown = 4;
	private boolean moveStraight = false;

	
	public void spawnTierOneAlien(int bound)
	{
		tierOneAlien = new JLabel(alienimage);
		tierOneAlien.setBounds(bound, 0, 50, 50);
		frame.add(tierOneAlien);
		tierOneAlien.setVisible(true);
		alienX = bound;
		alienY = 0;
		frame.repaint();
		moveStraight = false;
	}
	
	public void spawnTierOneAlienStraight(int bound)
	{
		tierOneAlien = new JLabel(alienimage);
		tierOneAlien.setBounds(bound, 0, 50, 50);
		frame.add(tierOneAlien);
		tierOneAlien.setVisible(true);
		alienX = bound;
		alienY = 0;
		frame.repaint();
		moveStraight = true;
	}
	
	
	public void moveTierOneAlien()
	{
		if (moveStraight == false)
		{
		if (movementCounter <= 35)
		{
			tierOneAlien.setBounds(alienX, alienY + moveAlien, 50, 50);
			movementCounter++;
			alienY = alienY + moveAlien;
		}
		else if (movementCounter > 35 && movementCounter <= 70)
		{
			tierOneAlien.setBounds(alienX + moveAlien, alienY, 50, 50);
			movementCounter++;
			alienX = alienX + moveAlien;
		}
		else if (movementCounter > 70 && movementCounter <= 105)
		{
			tierOneAlien.setBounds(alienX, alienY + moveAlien, 50, 50);
			movementCounter++;
			alienY = alienY + moveAlien;
		}
		else if (movementCounter > 105)
		{
			movementCounter++;
			
			if (movementCounter == 140)
				movementCounter = 0;
			
			tierOneAlien.setBounds(alienX - moveAlien, alienY, 50, 50);
			alienX = alienX - moveAlien;
		}
		}
		else
		{
			tierOneAlien.setBounds(alienX, alienY + moveAlien, 50, 50);
			alienY = alienY + moveAlien;
		}
	}
	
	public boolean isHitByBullet(int a, int b)
	{
		for (int xx = a; xx < a + 8; xx++)
		{
			for (int yy = b; yy < b + 8; yy++)
			{
				if (xx >= alienX && xx < alienX + 50)
				{
					if (yy >= alienY && yy < alienY +50)
					{
						tierOneAlien.setIcon(alienimageT1Dying);
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public boolean isOut()
	{
		if (alienY >= 800)
			return true;
		return false;
	}
	
	public void setVisible(boolean c)
	{
		tierOneAlien.setVisible(c);
	}
	
	public boolean hasHitShip(int shipX, int shipY)
	{
		
		for (int x = alienX; x < alienX + 50; x++)
		{
			for (int y = alienY; y < alienY + 50; y++)
			{
				if (x >= shipX && x < shipX + 80)
				{
					if (y >= shipY && y < shipY + 80)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void decDeathCooldown()
	{
		deathCooldown--;
	}
	
	public boolean getDeathCooldown()
	{
		if (deathCooldown ==0)
		{
			tierOneAlien.setVisible(false);
			return true;
		}
		return false;
	}
	
	public int getX()
	{
		return alienX;
	}
	
	public int getY()
	{
		return alienY;
	}
}

class tierTwoAlien extends spaceFighterRunner
{
	private int alienX;
	private int alienY;
	private int moveAlien = 1;
	private int health = 3;
	private int deathCooldown = 4;
	
	
	public JLabel tierTwoAlien;
	
	public JLabel tierTwoAlienH2;
	
	public JLabel tierTwoAlienH1;
	
	
	public boolean hasHitShip(int shipX, int shipY)
	{
		
		for (int x = alienX; x < alienX + 80; x++)
		{
			for (int y = alienY; y < alienY + 80; y++)
			{
				if (x >= shipX && x < shipX + 80)
				{
					if (y >= shipY && y < shipY + 80)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void spawnTierTwoAlien(int bound)
	{
		
		tierTwoAlien = new JLabel(alienimageT2);
		tierTwoAlien.setBounds(bound, 0, 80, 80);
		frame.add(tierTwoAlien);
		tierTwoAlien.setVisible(true);
		alienX = bound;
		alienY = 0;
		frame.repaint();
	}
	
	
	public void moveTierTwoAlien()
	{
		tierTwoAlien.setBounds(alienX, alienY + moveAlien, 80, 80);
		alienY = alienY + moveAlien;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void willSpawnBullet()
	{
		int random = (int) (Math.random() * 175);
		
		if (random == 50)
		{
			alienBullets abullet = new alienBullets();
			abullet.spawnAlienBullet(alienX +40, alienY+40);
			alienBulletList.add(abullet);
		}
	}
	
	public boolean isHitByBullet(int a, int b)
	{
		for (int x = a; x < a + 8; x++)
		{
			for (int y = b; y < b + 8; y++)
			{
				if (x >= alienX && x < alienX + 80)
				{
					if (y >= alienY && y < alienY + 80)
					{
						health--;
						
						if (health == 2)
						{
							tierTwoAlien.setIcon(alienimageT2TwoHearts);
						}
						else if (health == 1)
						{
							tierTwoAlien.setIcon(alienimageT2OneHeart);
						}
						else if (health == 0)
						{
							tierTwoAlien.setIcon(alienimageT2Dying);
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean isOut()
	{
		if (alienY >= 800)
			return true;
		return false;
	}
	
	public void setVisible(boolean c)
	{
		tierTwoAlien.setVisible(c);
	}
	
	public void decDeathCooldown()
	{
		deathCooldown--;
	}
	
	public boolean getDeathCooldown()
	{
		if (deathCooldown ==0)
		{
			tierTwoAlien.setVisible(false);
			return true;
		}
		return false;
	}
	
	
}

class alienBullets extends spaceFighterRunner
{
	
	private double alienBulletX;
	private double alienBulletY;
	
	
	public JLabel alienBullet;
	
	
	private double moveBulletX;
	private double moveBulletY;
	
	private double tempX;
	private double tempY;
	
	private double angle;
	
	
	movement spaceship = new movement();
	
	public void spawnAlienBullet(int a, int b)
	{
		alienBullet = new JLabel(alienBulletv2);
		alienBullet.setBounds(a, b, 8, 8);
		alienBullet.setVisible(true);
		frame.add(alienBullet);
		frame.repaint();
		
		alienBulletX = a;
		alienBulletY = b;
		
		
		tempX = (spaceship.getSpaceShipX() + 40) - a;
		tempY = (spaceship.getSpaceShipY() + 40) - b;
		
		double temp = ((double) Math.abs(tempY) / (double) Math.abs(tempX));
		angle = Math.atan(temp) + Math.random() - 0.50;
		

		
		if (tempX < 0 && tempY < 0)
		{
			moveBulletY = Math.sin(angle) * 5.0 * -1;
			moveBulletX = Math.cos(angle) * 5.0 * -1;
		}
		else if (tempX < 0 && tempY > 0)
		{
			moveBulletY = Math.sin(angle) * 5.0;
			moveBulletX = Math.cos(angle) * 5.0 * -1;
		}
		else if (tempX > 0 && tempY > 0)
		{
			moveBulletY = Math.sin(angle) * 5.0;
			moveBulletX = Math.cos(angle) * 5.0;
		}
		else if (tempX > 0 && tempY < 0)
		{
			moveBulletY = Math.sin(angle) * 5.0 * -1;
			moveBulletX = Math.cos(angle) * 5.0;
		}
		else if (tempX == 0)
		{
			moveBulletX = 0.0;
			moveBulletY = 10.0;
		}
		else
		{
			moveBulletX = 10.0;
			moveBulletY = 0.0;
		}
	}
	
	public void moveAlienBullet()
	{
		alienBullet.setBounds((int) Math.round(alienBulletX + moveBulletX), (int) Math.round(alienBulletY + moveBulletY), 8, 8);
		alienBulletX = ((double)alienBulletX + moveBulletX);
		alienBulletY = ((double)alienBulletY + moveBulletY);
	}
	
	public boolean inBounds()
	{
		if (alienBulletX >= 0 && alienBulletX <= 1000)
		{
			if (alienBulletY >= 0 && alienBulletY <= 2000)
			{
				return true;
			}
		}
		return false;
	}
	
	
	public void deleteBullet()
	{
		alienBullet.setVisible(false);
	}
	
	public boolean collide(int x, int y, int width, int height)
	{
		for (int i = (int) Math.round(alienBulletX); i < (int) Math.round(alienBulletX) + 8; i++)
		{
			for (int j = (int) Math.round(alienBulletY); j < (int) Math.round(alienBulletY) + 8; j++)
			{
				if (i >= x && i <= x + width)
				{
					if (j >= y && j <= y + height)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public boolean hitShip()
	{
		for (int x = (int) alienBulletX; x < (int) (alienBulletX + 8); x++)
		{
			if (x >= spaceship.getSpaceShipX() + 30 && x < spaceship.getSpaceShipX() + 50)
			{
					for (int y = ((int) alienBulletY); y < ((int) alienBulletY + 8); y++)
					{
						if (y >= spaceship.getSpaceShipY() + 10 && y < spaceship.getSpaceShipY() + 70)
						{
							return true;
						}
					}
			}
		}
		return false;
	}
}

class tierThreeAlien extends spaceFighterRunner
{
	private int alienX;
	private double alienY;
	
	
	public JLabel tierThreeAlien;
	
	public JLabel tierThreeAlienH4;
	
	public JLabel tierThreeAlienH3;
	
	public JLabel tierThreeAlienH2;
	
	public JLabel tierThreeAlienH1;
	
	
	
	private double moveAlien = 0.5;
	private int health = 5;
	private int deathCooldown = 4;
	
	public boolean hasHitShip(int shipX, int shipY)
	{
		
		for (int x = alienX; x < alienX + 100; x++)
		{
			for (int y = (int)alienY; y < alienY + 100; y++)
			{
				if (x >= shipX && x < shipX + 80)
				{
					if (y >= shipY && y < shipY + 80)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void spawnTierThreeAlien(int bound)
	{
		
		tierThreeAlien = new JLabel(alienimageT3);
		tierThreeAlien.setBounds(bound, 0, 100, 100);
		frame.add(tierThreeAlien);
		tierThreeAlien.setVisible(true);
		alienX = bound;
		alienY = 0;
		frame.repaint();
	}
	
	
	public void moveTierThreeAlien()
	{
		tierThreeAlien.setBounds(alienX, (int) Math.round((double)alienY + moveAlien), 100, 100);
		alienY = alienY + moveAlien;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	public void willSpawnT4Alien()
	{
		int random = (int) (Math.random() * 200);
		
		if (random == 50)
		{
			tierFourAlien t4Alien = new tierFourAlien();
			t4Alien.spawnTierFourAlien(alienX + 25, (int) alienY);
			alienList4.add(t4Alien);
		}
	}
	
	public boolean isHitByBullet(int a, int b)
	{
		for (int x = a; x < a + 8; x++)
		{
			for (int y = b; y < b + 8; y++)
			{
				if (x >= alienX && x < alienX + 80)
				{
					if (y >= alienY && y < alienY + 80)
					{
						health--;
						
						if (health == 4)
						{
							tierThreeAlien.setIcon(alienimageT3FourHearts);
						}
						else if (health == 3)
						{
							tierThreeAlien.setIcon(alienimageT3ThreeHearts);
						}
						else if (health == 2)
						{
							tierThreeAlien.setIcon(alienimageT3TwoHearts);
						}
						else if (health == 1)
						{
							tierThreeAlien.setIcon(alienimageT3OneHeart);
						}
						else if (health == 0)
						{
							tierThreeAlien.setIcon(alienimageT3Dying);
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean isOut()
	{
		if (alienY >= 800)
			return true;
		return false;
	}
	
	public void setVisible(boolean c)
	{
		tierThreeAlien.setVisible(c);
	}
	
	public void decDeathCooldown()
	{
		deathCooldown--;
	}
	
	public boolean getDeathCooldown()
	{
		if (deathCooldown ==0)
		{
			tierThreeAlien.setVisible(false);
			return true;
		}
		return false;
	}
	
}

class tierFourAlien extends spaceFighterRunner
{
	private int alienX;
	private int alienY;
	
	
	public JLabel tierFourAlien;
	
	public JLabel tierFourAlienH1;
	
	
	private int moveAlien = 4;
	private int health = 2;
	private int deathCooldown = 4;
	
	public boolean hasHitShip(int shipX, int shipY)
	{
		
		for (int x = alienX; x < alienX + 50; x++)
		{
			for (int y = alienY; y < alienY + 50; y++)
			{
				if (x >= shipX && x < shipX + 80)
				{
					if (y >= shipY && y < shipY + 80)
					{
						return true;
					}
				}
			}
		}
		
		return false;
	}
	
	public void spawnTierFourAlien(int xbound, int ybound)
	{
		
		tierFourAlien = new JLabel(alienimageT4TwoHearts);
		tierFourAlien.setBounds(xbound, ybound, 50, 50);
		frame.add(tierFourAlien);
		tierFourAlien.setVisible(true);
		alienX = xbound;
		alienY = ybound;
		frame.repaint();
	}
	
	
	public void moveTierFourAlien()
	{
		tierFourAlien.setBounds(alienX, alienY + moveAlien, 50, 50);
		alienY = alienY + moveAlien;
	}
	
	public int getHealth()
	{
		return health;
	}
	
	
	public boolean isHitByBullet(int a, int b)
	{
		for (int x = a; x < a + 8; x++)
		{
			for (int y = b; y < b + 8; y++)
			{
				if (x >= alienX && x < alienX + 100)
				{
					if (y >= alienY && y < alienY + 100)
					{
						health--;
						
						
						if (health == 1)
						{
							tierFourAlien.setIcon(alienimageT4OneHeart);
						}
						else if (health == 0)
						{
							tierFourAlien.setIcon(alienimageT4Dying);
						}
						return true;
					}
				}
			}
		}
		return false;
	}
	
	
	public boolean isOut()
	{
		if (alienY >= 800)
			return true;
		return false;
	}
	
	public void setVisible(boolean c)
	{
		tierFourAlien.setVisible(c);
	}
	
	public void decDeathCooldown()
	{
		deathCooldown--;
	}
	
	public boolean getDeathCooldown()
	{
		if (deathCooldown ==0)
		{
			tierFourAlien.setVisible(false);
			return true;
		}
		return false;
	}
	
}

class powerUps extends spaceFighterRunner
{
	public JLabel reloadIcon;
	public JLabel circleShootingIcon;
	public JLabel extraLifeIcon;
	public JLabel movementIcon;
	static int typeOfPowerUp = 0;
	private int x;
	private int y;
	
	public void spawnReloadPowerUp(int x1, int y1)
	{
		reloadIcon = new JLabel(reloadPowerUp);
		reloadIcon.setBounds(x, y, 20, 20);
		frame.add(reloadIcon);
		reloadIcon.setVisible(true);
		x = x1;
		y = y1;
		frame.repaint();
		typeOfPowerUp = 1;
	}
	
	public void spawnCircleShootingPowerUp(int x1, int y1)
	{
		circleShootingIcon = new JLabel(shootingPowerUp);
		circleShootingIcon.setBounds(x, y, 20, 20);
		frame.add(circleShootingIcon);
		circleShootingIcon.setVisible(true);
		x = x1;
		y = y1;
		frame.repaint();
		typeOfPowerUp = 2;
	}
	
	public void spawnExtraLifePowerUp(int x1, int y1)
	{
		extraLifeIcon = new JLabel(extraLifePowerUp);
		extraLifeIcon.setBounds(x, y, 20, 20);
		frame.add(extraLifeIcon);
		extraLifeIcon.setVisible(true);
		x = x1;
		y = y1;
		frame.repaint();
		typeOfPowerUp = 3;
	}
	
	public void spawnMovementPowerUp(int x1, int y1)
	{
		x = x1;
		y = y1;
		movementIcon = new JLabel(fasterMovement);
		movementIcon.setBounds(x, y, 40, 40);
		frame.add(movementIcon);
		movementIcon.setVisible(true);
		frame.repaint();
		typeOfPowerUp = 4;
	}
	
	public void moveIcon()
	{
		if (typeOfPowerUp == 1)
			reloadIcon.setBounds(x, y+1, 40, 40);
		else if (typeOfPowerUp == 2)
			circleShootingIcon.setBounds(x, y+1, 40, 40);
		else if (typeOfPowerUp == 3)
			extraLifeIcon.setBounds(x, y+1, 40, 40);
		else if (typeOfPowerUp == 4)
			movementIcon.setBounds(x, y+1, 40, 40);
		
		y+=2;
	}
	
	public int getX()
	{
		return x;
	}
	
	public int getY()
	{
		return y;
	}
	
	public int getType()
	{
		return typeOfPowerUp;
	}
	
	public boolean gotPowerUp(int a, int b)
	{
		for (int i = a-2; i < a + 10; i++)
		{
			for (int j = b-4; j < b + 14; j++)
			{
				if (x-5 <= i && i < x + 25)
					if (y-5 <= j && j < y + 25)
						return true;
			}
		}
		return false;
	}
	public void setSee()
	{
		if (typeOfPowerUp == 1)
			reloadIcon.setVisible(false);
		else if (typeOfPowerUp == 2)
			circleShootingIcon.setVisible(false);
		else if (typeOfPowerUp == 3)
			extraLifeIcon.setVisible(false);
		else if (typeOfPowerUp == 4)
			movementIcon.setVisible(false);
	}
	
}