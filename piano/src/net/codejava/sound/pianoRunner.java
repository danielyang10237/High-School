package net.codejava.sound;

import java.awt.Color;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.io.File;
import java.io.IOException;
 
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;



public class pianoRunner {

	public static JFrame frame;
	
	AudioInputStream audioInput;
	
	public static JLabel pianoIcon;
	public static JLabel aKeyIcon;
	public static JLabel bKeyIcon;
	public static JLabel cKeyIcon;
	public static JLabel dKeyIcon;
	public static JLabel eKeyIcon;
	public static JLabel fKeyIcon;
	public static JLabel gKeyIcon;
	
	public static ImageIcon pianov1;
	public static Image pianoImg;
	public static ImageIcon demoPiano;
	
	public static ArrayList<playSound> keys;
	
	public static void main(String[] args) 
	{
		pianov1 = new ImageIcon("piano.png");
		pianoImg = pianov1.getImage();
		demoPiano = new ImageIcon(pianoImg.getScaledInstance(600, 400, java.awt.Image.SCALE_SMOOTH));
		
		frame = new JFrame();
		keys = new ArrayList<playSound>();
		
		String aKey = "piano-a_A_major.wav";
		playSound ps = new playSound(aKey);
		ps.playSound();
		keys.add(ps);
		
		String bKey = "piano-B_B_major.wav";
		playSound ps2 = new playSound(bKey);
		ps2.playSound();
		keys.add(ps2);
		
		String cKey = "piano-c_C_major.wav";
		playSound ps3 = new playSound(cKey);
		ps3.playSound();
		keys.add(ps3);
		
		String DKey = "piano-d_D_major.wav";
		playSound ps4 = new playSound(DKey);
		ps4.playSound();
		keys.add(ps4);
		
		String EKey = "piano-e_E_major.wav";
		playSound ps5 = new playSound(EKey);
		ps5.playSound();
		keys.add(ps5);
		
		String FKey = "piano-f_F_major.wav";
		playSound ps6 = new playSound(FKey);
		ps6.playSound();
		keys.add(ps6);
		
		String GKey = "piano-g_G_major.wav";
		playSound ps7 = new playSound(GKey);
		ps7.playSound();
		keys.add(ps7);
		
		frame.setTitle("Piano Simulator");
		frame.setSize(700, 600);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    JLabel pianoIcon = new JLabel(demoPiano);
	    pianoIcon.setBounds(50, 50, 600, 400);
	    pianoIcon.setVisible(true);
		frame.add(pianoIcon);
		frame.repaint();
		
		JLabel aKeyIcon = new JLabel();
		aKeyIcon.setBounds(50, 450, 86, 30);
		aKeyIcon.setText("A");
		aKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		aKeyIcon.setForeground(Color.BLUE);
		aKeyIcon.setFont(new Font("A", Font.PLAIN, 30));
		aKeyIcon.setVisible(true);
		aKeyIcon.setFocusable(true);
	    frame.add(aKeyIcon);
	    frame.repaint();
	    
	    JLabel bKeyIcon = new JLabel();
	    bKeyIcon.setBounds(136, 450, 86, 30);
		bKeyIcon.setText("B");
		bKeyIcon.setForeground(Color.BLUE);
		bKeyIcon.setFont(new Font("B", Font.PLAIN, 30));
		bKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
		bKeyIcon.setVisible(true);
		bKeyIcon.setFocusable(true);
	    frame.add(bKeyIcon);
	    frame.repaint();
	    
	    JLabel cKeyIcon = new JLabel();
	    cKeyIcon.setBounds(222, 450, 86, 30);
	    cKeyIcon.setText("C");
	    cKeyIcon.setForeground(Color.BLUE);
	    cKeyIcon.setFont(new Font("B", Font.PLAIN, 30));
	    cKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    cKeyIcon.setVisible(true);
	    cKeyIcon.setFocusable(true);
	    frame.add(cKeyIcon);
	    frame.repaint();
	    
	    JLabel dKeyIcon = new JLabel();
	    dKeyIcon.setBounds(308, 450, 86, 30);
	    dKeyIcon.setText("D");
	    dKeyIcon.setForeground(Color.BLUE);
	    dKeyIcon.setFont(new Font("B", Font.PLAIN, 30));
	    dKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    dKeyIcon.setVisible(true);
	    dKeyIcon.setFocusable(true);
	    frame.add(dKeyIcon);
	    frame.repaint();
	    
	    JLabel eKeyIcon = new JLabel();
	    eKeyIcon.setBounds(394, 450, 86, 30);
	    eKeyIcon.setText("E");
	    eKeyIcon.setForeground(Color.BLUE);
	    eKeyIcon.setFont(new Font("B", Font.PLAIN, 30));
	    eKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    eKeyIcon.setVisible(true);
	    eKeyIcon.setFocusable(true);
	    frame.add(eKeyIcon);
	    frame.repaint();
	    
	    JLabel fKeyIcon = new JLabel();
	    fKeyIcon.setBounds(480, 450, 86, 30);
	    fKeyIcon.setText("F");
	    fKeyIcon.setForeground(Color.BLUE);
	    fKeyIcon.setFont(new Font("B", Font.PLAIN, 30));
	    fKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    fKeyIcon.setVisible(true);
	    fKeyIcon.setFocusable(true);
	    frame.add(fKeyIcon);
	    frame.repaint();
	    
	    JLabel gKeyIcon = new JLabel();
	    gKeyIcon.setBounds(566, 450, 86, 30);
	    gKeyIcon.setText("G");
	    gKeyIcon.setForeground(Color.BLUE);
	    gKeyIcon.setFont(new Font("G", Font.PLAIN, 30));
	    gKeyIcon.setHorizontalAlignment(SwingConstants.CENTER);
	    gKeyIcon.setVisible(true);
	    gKeyIcon.setFocusable(true);
	    frame.add(gKeyIcon);
	    frame.repaint();
	    
	    int xCord = 50;
	    int number = 1;
	    for (int i = 0; i < 7; i++)
	    {
	    	
	    	JLabel newIcon = new JLabel();
	    	
	    	newIcon.setBounds(xCord, 490, 86, 30);
	    	newIcon.setText("" + number);
	    	newIcon.setForeground(Color.RED);
	    	newIcon.setFont(new Font("B", Font.PLAIN, 30));
	    	newIcon.setHorizontalAlignment(SwingConstants.CENTER);
		    newIcon.setVisible(true);
		    newIcon.setFocusable(true);
		    
		    frame.add(newIcon);
		    frame.repaint();
		    
		    number++;
		    xCord += 86;
		    
	    }
	    
	    pianoBoard pianoB = new pianoBoard();
	    
	    KeyboardFocusManager manager = KeyboardFocusManager.getCurrentKeyboardFocusManager();
	    MyDispatcher md = new MyDispatcher();
        manager.addKeyEventDispatcher(md);
        
        while(true)
    	{
    	try {
			Thread.sleep(16);
		} catch (InterruptedException e1) 
    		{
			// TODO Auto-generated catch block
    	}
    		int keyNum = md.getKI();
    		if (keyNum == 1)
        	{
    			pianoB.playKey(1-1);
        	}
        	else if (keyNum == 2)
        	{
        		pianoB.playKey(2-1);
        	}
        	else if (keyNum == 3)
        	{
        		pianoB.playKey(3-1);
        	}
        	else if (keyNum == 4)
        	{
        		pianoB.playKey(4-1);
        	}
        	else if (keyNum == 5)
        	{
        		pianoB.playKey(5-1);
        	}
        	else if (keyNum == 6)
        	{
        		pianoB.playKey(6-1);
        	}
        	else if (keyNum == 7)
        	{
        		pianoB.playKey(7-1);
        	}
    	} 
	}
	
} 

 
class playSound {
	
    private static final int BUFFER_SIZE = 4100;
    private String path;
    
    private int bytesRead;
    
    private byte[] bytesBuffer;
    
    AudioInputStream audio;
    AudioFormat format;
    SourceDataLine audioLine;
    
    private boolean shouldPlay = true;
    
    public void playSound() {
        File audioFile = new File(path);
        try {
        	System.out.println("initialized");
        	
            audio = AudioSystem.getAudioInputStream(audioFile);
            format = audio.getFormat();
            DataLine.Info i = new DataLine.Info(SourceDataLine.class, format);
            audioLine = (SourceDataLine) AudioSystem.getLine(i);
            audioLine.open(format);
            audioLine.start();
             
            bytesBuffer = new byte[BUFFER_SIZE];
            bytesRead = -1;
 
            bytesRead = audio.read(bytesBuffer);
            
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }      
    }
    
    public void play() throws IOException
    {
                	try {
						bytesRead = audio.read(bytesBuffer);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
                	if (bytesRead != -1)
                	{
                	audioLine.write(bytesBuffer, 0, bytesRead);
                	}
    }
             
    
    void end() throws IOException
    {
    	bytesRead = -1;
    }
     
    public playSound(String p) {
       path = p;
    }
 
}

class MyDispatcher implements KeyEventDispatcher {
    
    pianoBoard pb = new pianoBoard();
    private int keyIndex;
    
    public boolean dispatchKeyEvent(KeyEvent e) {
        if (e.getID() == KeyEvent.KEY_PRESSED) {
        	if (e.getKeyCode() == 49)
        	{
        		System.out.println("ki");
        		keyIndex = 1;
        	}
        	if (e.getKeyCode() == 50)
        	{
        		keyIndex = 2;
        	}
        	if (e.getKeyCode() == 51)
        	{
        		keyIndex = 3;
        	}
        	if (e.getKeyCode() == 52)
        	{
        		keyIndex = 4;
        	}
        	if (e.getKeyCode() == 53)
        	{
        		keyIndex = 5;
        	}
        	if (e.getKeyCode() == 54)
        	{
        		keyIndex = 6;
        	}
        	if (e.getKeyCode() == 55)
        	{
        		keyIndex = 7;
        	}
    }
    
        
        if (e.getID() == KeyEvent.KEY_RELEASED) {
        	if (e.getKeyCode() == 49)
        	{
        		keyIndex = 0;
        	}
        	if (e.getKeyCode() == 50)
        	{
        		keyIndex = 0;
        	}
        	if (e.getKeyCode() == 51)
        	{
        		keyIndex = 0;
        	}
        	if (e.getKeyCode() == 52)
        	{
        		keyIndex = 0;
        	}
        	if (e.getKeyCode() == 53)
        	{
        		keyIndex = 0;
        	}
        	if (e.getKeyCode() == 54)
        	{
        		keyIndex = 0;
        	}
        	if (e.getKeyCode() == 55)
        	{
        		keyIndex = 0;
        	}
    } 
		return false;
}
    
    public int getKI()
    {
    	return keyIndex;
    }
    
    public void message()
    {
    	if (keyIndex == 1)
    	{
    		pb.playKey(1-1);
    	}
    	else if (keyIndex == 2)
    	{
    		pb.playKey(2-1);
    	}
    	else if (keyIndex == 3)
    	{
    		pb.playKey(3-1);
    	}
    	else if (keyIndex == 4)
    	{
    		pb.playKey(4-1);
    	}
    	else if (keyIndex == 5)
    	{
    		pb.playKey(5-1);
    	}
    	else if (keyIndex == 6)
    	{
    		pb.playKey(6-1);
    	}
    	else if (keyIndex == 7)
    	{
    		pb.playKey(7-1);
    	}
    }
}

