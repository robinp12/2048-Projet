package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Deplacement extends JFrame implements KeyListener {

	JLabel label;
	Joueur joueur1 = new Joueur();


    public Deplacement(String s) {
    	super(s);
    	addKeyListener(this);
    }

	@Override
	public void keyTyped(KeyEvent e) {

	}

	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			System.out.println("Gauche");
			joueur1.deplacement("G");
			joueur1.ajouteRandom();
			joueur1.affichageTableau();

		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("Droite");
			joueur1.deplacement("D");
			joueur1.ajouteRandom();
			joueur1.affichageTableau();
		}

		if (key == KeyEvent.VK_UP) {
			System.out.println("Haut");
			joueur1.deplacement("H");
			joueur1.ajouteRandom();
			joueur1.affichageTableau();
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("Bas");
			joueur1.deplacement("B");
			joueur1.ajouteRandom();
			joueur1.affichageTableau();
		}
		if (key == KeyEvent.VK_ENTER) {
			System.out.println("Initialisation - Reset");
			joueur1.initialisation();
		}

		else {
			System.setErr(null);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
