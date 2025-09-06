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

import net.codejava.sound.playSound;

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

public class piano {

	public static JFrame frame;
	
	public static ArrayList<playSound> notes;
	
	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, LineUnavailableException 
	{
		frame = new JFrame();
		notes = new ArrayList<playSound>();
		
		String aKey = "piano-a_A_major.wav";
		playSound ps = new playSound(aKey);
		notes.add(ps);
		
		String bKey = "piano-B_B_major.wav";
		playSound ps2 = new playSound(bKey);
		notes.add(ps2);
		
		String cKey = "piano-c_C_major.wav";
		playSound ps3 = new playSound(cKey);
		notes.add(ps3);
		
		String DKey = "piano-d_D_major.wav";
		playSound ps4 = new playSound(DKey);
		notes.add(ps4);
		
		String EKey = "piano-e_E_major.wav";
		playSound ps5 = new playSound(EKey);
		notes.add(ps5);
		
		String FKey = "piano-f_F_major.wav";
		playSound ps6 = new playSound(FKey);
		notes.add(ps6);
		
		String GKey = "piano-g_G_major.wav";
		playSound ps7 = new playSound(GKey);
		notes.add(ps7);
		
		frame.setTitle("PianoTyper Simulator");
		frame.setSize(500, 400);
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setLocationRelativeTo(null);
	    frame.setLayout(null);
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    frame.setVisible(true);
	    
	    JLabel title = new JLabel();
	    title.setBounds(100, 150, 300, 80);
	    title.setText("Piano Note Typer");
		title.setHorizontalAlignment(SwingConstants.CENTER);
		title.setForeground(Color.BLUE);
		title.setFont(new Font("A", Font.PLAIN, 30));
		title.setVisible(true);
		title.setFocusable(true);
	    frame.add(title);
	    frame.repaint();
	    
	    JTextField enterNotes = new JTextField("Enter Notes");
	    enterNotes.setBounds(200, 230, 100, 50);
	    enterNotes.setVisible(true);
	    enterNotes.setFocusable(true);
		frame.add(enterNotes);
		frame.repaint();
	    
		
		enterNotes.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				
				String notesInSong = enterNotes.getText();
				enterNotes.setText("");
				
				if (notesInSong.equals("") == false)
				{
					// System.out.println("works");
					for (int i = 0; i < notesInSong.length(); i++)
					{
						char note = notesInSong.charAt(i);
						// System.out.println(note);
						if (note == 'A')
						{
							notes.get(0).play();
						}
						else if (note == 'B')
						{
							notes.get(1).play();
						}
						else if (note == 'C')
						{
							notes.get(2).play();
						}
						else if (note == 'D')
						{
							notes.get(3).play();
						}
						else if (note == 'E')
						{
							notes.get(4).play();
						}
						else if (note == 'F')
						{
							notes.get(5).play();
						}
						else if (note == 'G')
						{
							notes.get(6).play();
						}
					}
				}
			}
		});
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
    
    void play() {
        File audioFile = new File(path);
        try {
            AudioInputStream audio = AudioSystem.getAudioInputStream(audioFile);
            AudioFormat format = audio.getFormat();
            DataLine.Info i = new DataLine.Info(SourceDataLine.class, format);
            SourceDataLine audioLine = (SourceDataLine) AudioSystem.getLine(i);
            audioLine.open(format);
            audioLine.start();
             
            byte[] bytesBuffer = new byte[BUFFER_SIZE];
            int bytesRead = -1;
 
            while ((bytesRead = audio.read(bytesBuffer)) != -1) {
                audioLine.write(bytesBuffer, 0, bytesRead);
            }
             
            audioLine.drain();
            audioLine.close();
            audio.close();
             
            System.out.println("Playback completed.");
             
        } catch (UnsupportedAudioFileException ex) {
            ex.printStackTrace();
        } catch (LineUnavailableException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
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
