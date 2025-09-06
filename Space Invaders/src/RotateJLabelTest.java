/*
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.geom.Rectangle2D;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class RotateJLabelTest extends JFrame {
	
	public static ImageIcon spaceshipimage;
	public static Image img;
	public static RotateLabel spaceship;
	public static Graphics tempG;
	public static Graphics2D gx;
	
   public void startt() {
	   spaceshipimage = new ImageIcon("images/spaceship.jpeg");
		img = spaceshipimage.getImage();
		spaceshipimage = new ImageIcon(img.getScaledInstance(80, 80, java.awt.Image.SCALE_SMOOTH));
		spaceship = new RotateLabel(spaceshipimage);
   }
   
   public void initiate()
   {
	   spaceship.setBounds(450, 400, 80, 80);
	   spaceship.setVisible(true);
   }
   
   public JLabel getSpaceShip()
   {
	   return spaceship;
   }
   
   public void rotateShip(int n, int m, int u, int y)
   {
	   spaceship.rotate(tempG, n, m, u, y);
   }
   
   class RotateLabel extends JLabel {
      public RotateLabel(ImageIcon i) {
         super(i);
      }
      
      public void setVisible(boolean bb)
      {
    	  super.setVisible(bb);
      }
      
      
      public void rotateLabel(Graphics g) {
    	 tempG = g;
      }
      
      public void paintComponent(Graphics g) {
          gx = (Graphics2D) g;
          super.paintComponent(g);
       }
      
      public void rotate(Graphics g, int cx, int cy, int shipX, int shipY)
      {
    	
    	 int diffX = cx - (shipX + 40);
  		int diffY = cy - (shipY + 40);
  		
  		double temp = ((double) Math.abs(diffX) / (double) Math.abs(diffY));
  		double cursorAngle = Math.atan(temp);
 
  		System.out.println("here");
  		
  		if (diffX < 0 && diffY < 0)
  		{
  			gx.rotate(Math.toRadians(temp), shipX + 40, shipY + 40);
  		}
  		else if (diffX > 0 && diffY > 0)
  		{
  			gx.rotate(Math.PI + Math.toRadians(temp), shipX + 40, shipY + 40);
  		}
  		else if (diffX < 0 && diffY > 0)
  		{
  			gx.rotate((3.0 * Math.PI + Math.toRadians(temp)) / 4.0, shipX + 40, shipY + 40);
  		}
  		else if (diffX > 0 && diffY < 0)
  		{
  			gx.rotate(0.5 * Math.PI + Math.toRadians(temp), shipX + 40, shipY + 40);
  		}

      }
      
   }
}
*/