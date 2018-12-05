package jeu;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface extends JFrame{
	JFrame frame;
	JLabel label;
    Joueur joueur1 = new Joueur();

	public Interface(String s) {
		super(s);
		frame = new JFrame("2048");
		frame.setTitle("2048");
        label = new JLabel("2048");
        setSize(500,500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
public static void main(String[] args) {
		
		new Deplacement("");
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n"
				+ " ©Tristan Pestiaux\n"
				+ "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "appuyer sur une ENTER pour démarrer le 2048\n");
		Joueur joueur1 = new Joueur();
		

	}

}
