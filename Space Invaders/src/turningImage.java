import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;



class turningImage extends JLabel  {  
	
	
	public static ImageIcon spaceshipimage;
	public static Image img;
	public static JLabel spaceship;
	private static int x1 = 450;
	private static int y1 = 400;
	
	
     public turningImage(int x1, int x2, int y1, int y2)  
     {  
    	spaceshipimage = new ImageIcon("images/spaceship2.png");
 		img = spaceshipimage.getImage();
 		spaceshipimage = new ImageIcon(img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
 		spaceship = new JLabel(spaceshipimage);
 		spaceship.setBounds(x1, x2, y1, y2);
 		add(spaceship);
 		spaceship.setVisible(true);
 		turningImage.x1 = x1;
 		turningImage.y1 = x2;
     }  
    @Override 
    public void paintComponent (Graphics g) {    
    	super.paintComponent(g);  
    	
        Graphics2D g2d = (Graphics2D)g;  
        
        Point p = MouseInfo.getPointerInfo().getLocation();
					
        g2d.rotate(Math.toRadians(180), x1+40, y1+40);  
        
        
        spaceshipimage.paintIcon(this, g2d, 0, 0);
    }    
 } 