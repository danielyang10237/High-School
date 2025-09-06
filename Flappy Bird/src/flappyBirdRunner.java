import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class flappyBirdRunner {
	
	public static JButton play;
	public static JButton newGame;
	public static JButton easy;
	public static JButton moderate;
	public static JButton difficult;
	
	public static mainFrame frame;
	
	public static JLabel title;
	public static JLabel flappyBird;
	public static JLabel scoreLabel;
	public static JLabel menuTab;
	public static JLabel displayScore;
	public static JLabel gameOverMessage;
	
	public static int gameIndex = 0;
	public static int score = 0;
	public static int secondFlap, thirdFlap, fourthFlap, fifthFlap, sixthFlap = -1;
	public static int gap = 300;
	public static int criticalIndex = -1;
	
	public static double speed = 0.0;
	
	public static boolean gameStarted = false;
	public static boolean gameRunning = true;
	public static boolean temp = true;
	
	public static ArrayList<pipe1> topPipes;
	public static ArrayList<pipe2> bottomPipes;
	public static ArrayList<pipe1> pipeList;
	public static ArrayList<pipeTop> topPipeList;
	
	public static ImageIcon greenv1;
	public static Image greenImg;
	public static ImageIcon green;
	
	public static ImageIcon bluev1;
	public static Image blueImg;
	public static ImageIcon blue;
	
	public static ImageIcon redv1;
	public static Image redImg;
	public static ImageIcon red;
	
	public static ImageIcon darkGreenv1;
	public static Image darkGreenImg;
	public static ImageIcon darkGreen;
	
	public static void main(String[] args)
	{
		
		greenv1 = new ImageIcon("Green.png");
		greenImg = greenv1.getImage();
		green = new ImageIcon(greenImg.getScaledInstance(80, 700, java.awt.Image.SCALE_SMOOTH));
		
		bluev1 = new ImageIcon("blue.jpg");
		blueImg = bluev1.getImage();
		blue = new ImageIcon(blueImg.getScaledInstance(80, 700, java.awt.Image.SCALE_SMOOTH));
		
		redv1 = new ImageIcon("Red Square.jpg");
		redImg = redv1.getImage();
		red = new ImageIcon(redImg.getScaledInstance(280, 400, java.awt.Image.SCALE_SMOOTH));
		
		darkGreenv1 = new ImageIcon("DGreen.png");
		darkGreenImg = darkGreenv1.getImage();
		darkGreen = new ImageIcon(darkGreenImg.getScaledInstance(100, 30, java.awt.Image.SCALE_SMOOTH));
		
		flappyBirdMechanics fmb = new flappyBirdMechanics();
		
		frame = new mainFrame(fmb);
		
		title = new JLabel();
		
		newGame = new JButton();
		newGame.setText("Play Again");
		newGame.setForeground(Color.WHITE);
		newGame.setBackground(Color.BLUE);
		newGame.setBorderPainted(false);
		newGame.setOpaque(true);
		newGame.setFont(new Font("Play", Font.PLAIN, 30));
		newGame.setBounds(390, 330, 240, 40);
		newGame.setVisible(false);
		frame.add(newGame);
		newGame.setFocusable(true);
		frame.repaint();
		
		easy = new JButton();
		easy.setText("Easy");
		easy.setForeground(Color.WHITE);
		easy.setBackground(Color.BLUE);
		easy.setBorderPainted(false);
		easy.setOpaque(true);
		easy.setFont(new Font("Play", Font.PLAIN, 30));
		easy.setBounds(390, 280, 240, 40);
		easy.setVisible(false);
		frame.add(easy);
		easy.setFocusable(true);
		frame.repaint();
		
		moderate = new JButton();
		moderate.setText("Moderate");
		moderate.setForeground(Color.WHITE);
		moderate.setBackground(Color.BLUE);
		moderate.setBorderPainted(false);
		moderate.setOpaque(true);
		moderate.setFont(new Font("Play", Font.PLAIN, 30));
		moderate.setBounds(390, 330, 240, 40);
		moderate.setVisible(false);
		frame.add(moderate);
		moderate.setFocusable(true);
		frame.repaint();
		
		difficult = new JButton();
		difficult.setText("Difficult");
		difficult.setForeground(Color.WHITE);
		difficult.setBackground(Color.BLUE);
		difficult.setBorderPainted(false);
		difficult.setOpaque(true);
		difficult.setFont(new Font("Play", Font.PLAIN, 30));
		difficult.setBounds(390, 380, 240, 40);
		difficult.setVisible(false);
		frame.add(difficult);
		difficult.setFocusable(true);
		frame.repaint();
		
		gameOverMessage = new JLabel();
		gameOverMessage.setText("Game Over");
		gameOverMessage.setForeground(Color.BLUE);
		gameOverMessage.setBounds(360, 210, 280, 50);
		gameOverMessage.setFont(new Font("Hangman", Font.PLAIN, 40));
		gameOverMessage.setVisible(false);
		gameOverMessage.setFocusable(true);
		gameOverMessage.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(gameOverMessage);
		frame.repaint();
		
		displayScore = new JLabel();
		displayScore.setText("Final Score: " + score);
		displayScore.setForeground(Color.BLUE);
		displayScore.setBounds(360, 250, 280, 50);
		displayScore.setFont(new Font("Hangman", Font.PLAIN, 30));
		displayScore.setVisible(false);
		displayScore.setFocusable(true);
		displayScore.setHorizontalAlignment(SwingConstants.CENTER);
		frame.add(displayScore);
		frame.repaint();
		
		menuTab = new JLabel(red);
		menuTab.setBounds(360, 150, 280, 300);
		menuTab.setVisible(false);
		frame.add(menuTab);
		frame.repaint();
		
		topPipes = new ArrayList<pipe1>();
		bottomPipes = new ArrayList<pipe2>();
		pipeList = new ArrayList<pipe1>();
		topPipeList = new ArrayList<pipeTop>();
		
		fmb.initiateGame();
		
	}
	
	
}
