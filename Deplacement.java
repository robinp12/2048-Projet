package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Deplacement extends JFrame implements KeyListener{

	private static final long serialVersionUID = 1L;
	
	 Plateau joueur1 = new Plateau();

	public Deplacement(String s) {
    	super(s);
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
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();

		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("Droite");
			joueur1.deplacement("D");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
		}

		if (key == KeyEvent.VK_UP) {
			System.out.println("Haut");
			joueur1.deplacement("H");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("Bas");
			joueur1.deplacement("B");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
		}
		/*if (key == KeyEvent.VK_ENTER) {
			System.out.println("Initialisation - Reset");
			joueur1.initialisation(4);
		}*/
		if (key == KeyEvent.VK_NUMPAD2) {
			System.out.println("Initialisation 2X2 - Reset");
			joueur1.initialisation(2);
		}
		if (key == KeyEvent.VK_NUMPAD3) {
			System.out.println("Initialisation 3X3 - Reset");
			joueur1.initialisation(3);
		}
		if (key == KeyEvent.VK_NUMPAD4) {
			System.out.println("Initialisation 4X4 - Reset");
			joueur1.initialisation(4);
		}		
		if (key == KeyEvent.VK_NUMPAD5) {
			System.out.println("Initialisation 5X5 - Reset");
			joueur1.initialisation(5);
		}
		if (key == KeyEvent.VK_NUMPAD6) {
			System.out.println("Initialisation 6X6 - Reset");
			joueur1.initialisation(6);
		}
		if (key == KeyEvent.VK_NUMPAD7) {
			System.out.println("Initialisation 7X7 - Reset");
			joueur1.initialisation(7);
		}
		if (key == KeyEvent.VK_NUMPAD8) {
			System.out.println("Initialisation 8X8 - Reset");
			joueur1.initialisation(8);
		}
		if (key == KeyEvent.VK_NUMPAD9) {
			System.out.println("Initialisation 9X9 - Reset");
			joueur1.initialisation(9);
		}


		else {
			System.setErr(null);
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {

	}

}
