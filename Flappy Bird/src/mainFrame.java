import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class mainFrame extends JFrame implements KeyListener{

	flappyBirdMechanics fbm;

	public static ImageIcon birdv1;
	public static Image birdImg;
	public static ImageIcon bird;
	
	public static BufferedImage bbird;

	public static flappyBirdIcon flappyBird;
	
	public static double angle = 0.0;

	public mainFrame(flappyBirdMechanics f)
	{
		fbm = f;
		System.out.println("initialized");
		setTitle("Flappy Bird");
		setSize(1000, 700);
		getContentPane().setBackground(Color.cyan);
		setLocationRelativeTo(null);
		setLayout(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);;
	}

	public void keyPressed(KeyEvent e) {
	}

	public void keyReleased(KeyEvent e) {

	}
	public void keyTyped(KeyEvent e) {
		if (fbm.getGameStarted() == true)
		{
			fbm.flapBird();
		}
	}
	
	public void deleteBird()
	{
		getBird().setVisible(false);
	}

	public void newBird()
	{
		birdv1 = new ImageIcon("bird.png");
		birdImg = birdv1.getImage();
		bird = new ImageIcon(birdImg.getScaledInstance(100, 55, java.awt.Image.SCALE_SMOOTH));
		
		try {
			bbird = ImageIO.read(getClass().getResourceAsStream("/bird.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		angle = 0.0;
		
		flappyBird = new flappyBirdIcon();
	}

	public flappyBirdIcon getBird()
	{
		return flappyBird;
	}

	public void setBirdPos(int x, int y) {
		getBird().setPos(x, y);
	}
	
	public void rotate(double d)
	{
		getBird().rotateBird(d);
	}
	
	
	private class flappyBirdIcon extends JLabel {
		private int x, y;
		
		public flappyBirdIcon() {
			super();
		}
		
		public void setPos(int x, int y) {
			this.x = x;
			this.y = y;
		}
		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D gx = (Graphics2D) g;
			gx.rotate(angle, x + 90/2, y + 75/2);
			g.drawImage(bbird, x, y, 90, 75, null);
		}
		
		public void rotateBird(double d)
		{
			angle = d;
		}
		
		
	}

}

