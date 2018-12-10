package jeu;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;

public class Interface extends Deplacement{
	private static final long serialVersionUID = 1L;
	Joueur joueur1 = new Joueur();
	JFrame frame = new JFrame("Projet 2048");
	
	public void tuiles(int tailleCase) {	
		
		//Color couleurGris = new Color(200,200,200);
		Color couleurNoir = new Color(100,100,100);
		
		JPanel [] rangee1 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee1[i] = new JPanel();
			rangee1[i].setBackground(couleurNoir);
			rangee1[i].setSize(tailleCase, tailleCase);
			rangee1[i].setLocation(110*i+20, 20);
			rangee1[i].setVisible(true);
			frame.add(rangee1[i]);
		}
		JPanel [] rangee2 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee2[i] = new JPanel();
			rangee2[i].setBackground(couleurNoir);
			rangee2[i].setSize(tailleCase, tailleCase);
			rangee2[i].setLocation(110*i+20, 130);
			rangee2[i].setVisible(true);
			frame.add(rangee2[i]);
		}
		JPanel [] rangee3 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee3[i] = new JPanel();
			rangee3[i].setBackground(couleurNoir);
			rangee3[i].setSize(tailleCase, tailleCase);
			rangee3[i].setLocation(110*i+20, 240);
			rangee3[i].setVisible(true);
			frame.add(rangee3[i]);
		}
		JPanel [] rangee4 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee4[i] = new JPanel();
			rangee4[i].setBackground(couleurNoir);
			rangee4[i].setSize(tailleCase, tailleCase);
			rangee4[i].setLocation(110*i+20, 350);
			rangee4[i].setVisible(true);
			frame.add(rangee4[i]);
		}
		
	}
	AbstractAction actionDemarrer = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
            joueur1.initialisation();
        }
    };
    AbstractAction actionCredit = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
            JFrame frameCredit = new JFrame("Credit");
            JLabel labelCredit = new JLabel();
            frameCredit.setSize(240, 280);
            frameCredit.setVisible(true);
            frameCredit.setLocationRelativeTo(null);
            frameCredit.add(labelCredit);
            labelCredit.setText(texte());
            labelCredit.setFont(new Font("Arial", Font.PLAIN, 15));
        }
    };
    
    AbstractAction actionUp = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Haut");
			joueur1.deplacement("H");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };    
    AbstractAction actionDown = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Bas");
			joueur1.deplacement("B");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };
    AbstractAction actionLeft = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Gauche");
			joueur1.deplacement("G");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };
    AbstractAction actionRight = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Droite");
			joueur1.deplacement("D");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };
    
	public Interface(int tailleCase, String s) {
		super(s);
		frame.setVisible(true);
		frame.setSize(700,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		
		tuiles(tailleCase);
		
		JSeparator separateurHor = new JSeparator(getWidth());
		frame.add(separateurHor);
		
		JLabel label = new JLabel("2048");
        label.setSize(200,100);
        label.setLocation(490, 30);
        label.setFont(new Font("Arial", Font.BOLD, 70));
        frame.add(label);
        
        JSeparator separateurVer1 = new JSeparator(getHeight());
		frame.add(separateurVer1);
		
		JButton demarrer = new JButton("Demarrer");
		demarrer.setSize(150,40);
        demarrer.setLocation(490, 150);
        demarrer.setBackground(Color.LIGHT_GRAY);
        demarrer.addActionListener(actionDemarrer);
		frame.add(demarrer);
		
		JButton credit = new JButton("Credit");
		credit.setSize(150,40);
        credit.setLocation(490, 200);
        credit.setBackground(Color.LIGHT_GRAY);
        credit.addActionListener(actionCredit);
        frame.add(credit);
        
        JButton console = new JButton("Console");
        console.setSize(150,40);
        console.setLocation(490, 250);
        console.setBackground(Color.LIGHT_GRAY);
        console.addActionListener(actionCredit);
        frame.add(console);
        
        JSeparator separateurVer2 = new JSeparator(getHeight());
		frame.add(separateurVer2);
        
        JButton upBut = new JButton("U");
        upBut.setSize(50, 40);
        upBut.setLocation(540, 250+70);
        upBut.addActionListener(actionUp);
        frame.add(upBut);
        
        JButton downBut = new JButton("D");
        downBut.setSize(50, 40);
        downBut.setLocation(540, 300+70);
        downBut.addActionListener(actionDown);
        frame.add(downBut);
        
        JButton leftBut = new JButton("L");
        leftBut.setSize(50, 40);
        leftBut.setLocation(480, 300+70);
        leftBut.addActionListener(actionLeft);
        frame.add(leftBut);
        
        JButton rightBut = new JButton("R");
        rightBut.setSize(50, 40);
        rightBut.setLocation(600, 300+70);
        rightBut.addActionListener(actionRight);
        frame.add(rightBut);
        
	}
	public String texte() {

		return "<html><center>Bienvenue dans notre 2048 Perso"
				+ "<br>en JAVA !"
				+ "<br>© Tristan Pestiaux"
				+ "<br> Robin Paquet"
				+ "<br> Ludo Van Den Dorpe</center></html>";
	}
public static void main(String[] args) {
	int tailleCase = 100;
    new Interface(tailleCase,"");
	
    System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n"
			+ " ©Tristan Pestiaux\n"
			+ "  Robin Paquet\n"
			+ "  Ludo Van Den Dorpe\n"
			+ "appuyer sur une ENTER pour démarrer le 2048\n");
    

	}

}
