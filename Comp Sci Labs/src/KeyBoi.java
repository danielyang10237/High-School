import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyBoi extends JFrame {
    public static void main(String[] args) {
        new KeyBoi();
    }

    @Override
    protected void frameInit() {
        super.frameInit();
        setMinimumSize(new Dimension(200, 200));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addKeyListener(new Listener());
        setVisible(true);
    }
}

class Listener implements KeyListener {

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("ree");
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}