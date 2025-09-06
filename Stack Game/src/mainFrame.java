import java.awt.Color;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class mainFrame extends JFrame implements KeyListener{
	
	stackGameMechanics sgm;
	
	public mainFrame(stackGameMechanics stackgm)
	{
		sgm = stackgm;
		setTitle("Stack Game");
		setSize(500, 1000);
		getContentPane().setBackground(Color.magenta);
		setLayout(null);
		setLocationRelativeTo(null);
		setFocusable(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		addKeyListener(this);
		setVisible(true);
		setFocusTraversalKeysEnabled(false);
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (sgm.getGameRunning() == true)
		{
			if (e.getID() == 400)
			{
				sgm.spacePressed();
			}
		}
	}
	
}