package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Deplacement extends JFrame implements KeyListener {

    JLabel label;

    public Deplacement(String s) {
        super(s);
        JPanel p = new JPanel();
        label = new JLabel("Key Listener!");
        p.add(label);
        add(p);
        addKeyListener(this);
        setVisible(true);

    }

/*    @Override
   public void keyTyped(KeyEvent e) {
    	 int key = e.getKeyCode();
        if (key == KeyEvent.VK_RIGHT) {
            System.out.println("Right key typed");
        }
        if (key == KeyEvent.VK_LEFT) {
            System.out.println("Left key typed");
        }

    }*/

    @Override
    public void keyPressed(KeyEvent e) {
    	 int key = e.getKeyCode();
    	 if (key == KeyEvent.VK_LEFT) {
 	    	System.out.println("Gauche");
 	    }

 	    if (key == KeyEvent.VK_RIGHT) {
 	    	System.out.println("Droite");
 	    }

 	    if (key == KeyEvent.VK_UP) {
 	    	System.out.println("Haut");
 	    }

 	    if (key == KeyEvent.VK_DOWN) {
 	    	System.out.println("Bas");
 	    }

    }

   @Override
    public void keyReleased(KeyEvent e) {
   
    }

    public static void main(String[] args) {
        new Deplacement("Key Listener Tester");
    }
}