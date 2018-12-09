package jeu;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Interface extends Deplacement{
	Joueur joueur1 = new Joueur();
	private static final long serialVersionUID = 1L;
	private JLabel label;
	JButton demarrer;
	JButton credit;
	
	public Interface() {
		super();
		JFrame frame = new JFrame("2048");
		label = new JLabel("2048");
		demarrer = new JButton("Demarrer");
		credit = new JButton("Credit");
	    frame.add(label);
        frame.setSize(500,500);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);
        
        label.add(demarrer);
        label.add(credit);
        demarrer.setSize(100,40);
        demarrer.setLocation(100, 300);
        demarrer.setBackground(Color.LIGHT_GRAY);
       
	    
        credit.setSize(100,40);
        credit.setLocation(275, 300);
        credit.setBackground(Color.LIGHT_GRAY);
	}
public static void main(String[] args) {
		
		new Interface();
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n"
				+ " ©Tristan Pestiaux\n"
				+ "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "appuyer sur une ENTER pour démarrer le 2048\n");
	
		

	}

}
