import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class hangmanRunner implements ActionListener{

	
	public static JFrame frame = new JFrame();	
	
	public static JLabel title;
	public static JLabel person;
	public static JLabel lettersNotUsedTitle;
	public static JLabel lettersNotUsed;
	public static JLabel lettersGuessedTitle;
	public static JLabel lettersGuessed;
	public static JLabel guessStatus;
	public static JLabel winOrLose;
	public static JLabel displayLives;
	
	public static JButton start;
	public static JButton start2;
	public static JButton reset;
	public static JButton options;
	public static JButton easyMode;
	public static JButton mediumMode;
	public static JButton hardMode;
	
	public static JButton options2;
	public static JButton fiveMistakes;
	public static JButton nineMistakes;
	public static JButton fourteenMistakes;
	
	public static JTextField enterLetter;
	
	public static ArrayList<String> wordList = new ArrayList<String>();
	public static ArrayList<String> lettersLeftList = new ArrayList<String>();
	public static ArrayList<String> lettersGuessedList = new ArrayList<String>();
	public static ArrayList<JLabel> displayRectangles = new ArrayList<JLabel>();
	public static ArrayList<JLabel> displayLetters = new ArrayList<JLabel>();
	
	public static ArrayList<letter> letters = new ArrayList<letter>();
	public static ArrayList<ImageIcon> human = new ArrayList<ImageIcon>();
	
	public static String wordChosen;
	
	public static ImageIcon emptyv1;
	public static Image emptyImg;
	public static ImageIcon empty;
	
	public static ImageIcon headv1;
	public static Image headImg;
	public static ImageIcon head;
	
	public static ImageIcon headbodyv1;
	public static Image headbodyImg;
	public static ImageIcon headbody;
	
	public static ImageIcon headbodyarmv1;
	public static Image headbodyarmImg;
	public static ImageIcon headbodyarm;
	
	public static ImageIcon headbodyarm2v1;
	public static Image headbodyarm2Img;
	public static ImageIcon headbody2;
	
	public static ImageIcon headbodyarm2legv1;
	public static Image headbodyarm2legImg;
	public static ImageIcon headbody2leg;
	
	public static ImageIcon headbodyarm2leg2v1;
	public static Image headbodyarm2leg2Img;
	public static ImageIcon headbody2leg2;
	
	public static ImageIcon headbodyarm2leg2eyev1;
	public static Image headbodyarm2leg2eyeImg;
	public static ImageIcon headbody2leg2eye;
	
	public static ImageIcon headbodyarm2leg2eye2v1;
	public static Image headbodyarm2leg2eye2Img;
	public static ImageIcon headbody2leg2eye2;
	
	public static ImageIcon fullv1;
	public static Image fullImg;
	public static ImageIcon full;
	
	public static ImageIcon hatv1;
	public static Image hatImg;
	public static ImageIcon hat;
	
	public static ImageIcon hatHandv1;
	public static Image hatHandImg;
	public static ImageIcon hatHand;
	
	public static ImageIcon hatHand2v1;
	public static Image hatHand2Img;
	public static ImageIcon hatHand2;
	
	public static ImageIcon hatHand2Bootv1;
	public static Image hatHand2BootImg;
	public static ImageIcon hatHand2Boot;
	
	public static ImageIcon hatHand2Boot2v1;
	public static Image hatHand2Boot2Img;
	public static ImageIcon hatHand2Boot2;
	
	public static ImageIcon blackrectanglev1;
	public static Image blackRectImg;
	public static ImageIcon blackLine;
	
	public static int livesCount = 0;
	public static int correctGuesses = 0;
	public static int difficulty = 0;
	public static int guessAmount = 14;
	
	public static boolean gameWon = false;
	public static boolean hasSpace = false;
	public static boolean alreadyPressed = false;
	
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		
		
	}
	
	public static void main(String[] args)
	{
		blackrectanglev1 = new ImageIcon("brectangle.png");
		blackRectImg = blackrectanglev1.getImage();
		blackLine = new ImageIcon(blackRectImg.getScaledInstance(45, 5, java.awt.Image.SCALE_SMOOTH));
		
		emptyv1 = new ImageIcon("Empty.JPG");
		emptyImg = emptyv1.getImage();
		empty = new ImageIcon(emptyImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headv1 = new ImageIcon("Empty1.JPG");
		headImg = headv1.getImage();
		head = new ImageIcon(headImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyv1 = new ImageIcon("Empty2.JPG");
		headbodyImg = headbodyv1.getImage();
		headbody = new ImageIcon(headbodyImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyarmv1 = new ImageIcon("Empty3.JPG");
		headbodyarmImg = headbodyarmv1.getImage();
		headbodyarm = new ImageIcon(headbodyarmImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyarm2v1 = new ImageIcon("Empty4.JPG");
		headbodyarm2Img = headbodyarm2v1.getImage();
		headbody2 = new ImageIcon(headbodyarm2Img.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyarm2legv1 = new ImageIcon("Empty5.JPG");
		headbodyarm2legImg = headbodyarm2legv1.getImage();
		headbody2leg = new ImageIcon(headbodyarm2legImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyarm2leg2v1 = new ImageIcon("Empty6.JPG");
		headbodyarm2leg2Img = headbodyarm2leg2v1.getImage();
		headbody2leg2 = new ImageIcon(headbodyarm2leg2Img.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyarm2leg2eyev1 = new ImageIcon("Empty7.JPG");
		headbodyarm2leg2eyeImg = headbodyarm2leg2eyev1.getImage();
		headbody2leg2eye = new ImageIcon(headbodyarm2leg2eyeImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		headbodyarm2leg2eye2v1 = new ImageIcon("Empty8.JPG");
		headbodyarm2leg2eye2Img = headbodyarm2leg2eye2v1.getImage();
		headbody2leg2eye2 = new ImageIcon(headbodyarm2leg2eye2Img.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		hatv1 = new ImageIcon("Empty14.JPG");
		hatImg = hatv1.getImage();
		hat = new ImageIcon(hatImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		hatHandv1 = new ImageIcon("Empty10.JPG");
		hatHandImg = hatHandv1.getImage();
		hatHand = new ImageIcon(hatHandImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		hatHand2v1 = new ImageIcon("Empty11.JPG");
		hatHand2Img = hatHand2v1.getImage();
		hatHand2 = new ImageIcon(hatHand2Img.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		hatHand2Bootv1 = new ImageIcon("Empty12.JPG");
		hatHand2BootImg = hatHand2Bootv1.getImage();
		hatHand2Boot = new ImageIcon(hatHand2BootImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		hatHand2Boot2v1 = new ImageIcon("Empty13.JPG");
		hatHand2Boot2Img = hatHand2Boot2v1.getImage();
		hatHand2Boot2 = new ImageIcon(hatHand2Boot2Img.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		fullv1 = new ImageIcon("Empty9.JPG");
		fullImg = fullv1.getImage();
		full = new ImageIcon(fullImg.getScaledInstance(380, 400, java.awt.Image.SCALE_SMOOTH));
		
		gameMechanics gm = new gameMechanics();
		
		gm.format();
		
	
	}
	
	
}