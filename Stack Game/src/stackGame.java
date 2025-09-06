import java.awt.Color;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class stackGame {
	
	public static JButton startGame;
	
	public static mainFrame frame;
	
	public static JLabel titleLabel;
	public static JLabel gameOverSign;
	public static JLabel fallingBlock;
	
	public static boolean gameRunning = false;
	public static boolean moveRect = true;
	
	public static int gameIndex = 0;
	
	public static ArrayList<JLabel> fallingBlocks = new ArrayList<JLabel>();
	public static ArrayList<Boolean> moveRight = new ArrayList<Boolean>();
	public static ArrayList<Integer> fallingHeights = new ArrayList<Integer>();
	public static ArrayList<Integer> fallingPoss = new ArrayList<Integer>();
	public static ArrayList<Integer> fallingWidths = new ArrayList<Integer>();
	public static ArrayList<rectangle> blockList = new ArrayList<rectangle>();
	
	public static ImageIcon blackrectangle;
	public static Image blackRectImg;
	public static ImageIcon blackRect;
	public static ImageIcon blackRect1;
	
	public static ImageIcon greenrectangle;
	public static Image greenRectImg;
	public static ImageIcon greenRect;
	
	public static int level = 1;
	public static boolean wasSuccessful = true;
	
	public static void main(String[] args)
	{
		
		blackrectangle = new ImageIcon("brectangle.png");
		blackRectImg = blackrectangle.getImage();
		blackRect = new ImageIcon(blackRectImg.getScaledInstance(180, 20, java.awt.Image.SCALE_SMOOTH));
		blackRect1 = new ImageIcon(blackRectImg.getScaledInstance(180, 20, java.awt.Image.SCALE_SMOOTH));
		
		greenrectangle = new ImageIcon("38592.png");
		greenRectImg = greenrectangle.getImage();
		greenRect = new ImageIcon(greenRectImg.getScaledInstance(320, 70, java.awt.Image.SCALE_SMOOTH));
		
		stackGameMechanics sgm = new stackGameMechanics();
		
		frame = new mainFrame(sgm);
		
		
		sgm.setUp();
		
		
	}
	
	public static void override()
	{
		startGame.setVisible(false);
		titleLabel.setVisible(false);
	}

}
