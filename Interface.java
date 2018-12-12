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
	Plateau joueur1 = new Plateau();
	int x = joueur1.getDimension();

	JFrame frame = new JFrame("Projet 2048");
	
	public void tuiles(int x) {	
		
		Color couleurNoir = new Color(180,180,180);
		
		
		JPanel [][] panel = new JPanel[x][x];
		JLabel [][] labe = new JLabel[x][x];
		for(int i= 0; i<x; i++) {
			for(int e= 0; e<x; e++) {
			panel[i][e] = new JPanel();
			panel[i][e].setSize(100, 100);
			panel[i][e].setBackground(Color.orange);
			panel[i][e].setLocation(110*i+20, 110*e+20);
			frame.add(panel[i][e]);
			
			labe[i][e] = new JLabel();
			labe[i][e].setSize(100, 100);
			labe[i][e].setText(String.valueOf(0));
			labe[i][e].setFont(new Font("Arial", Font.PLAIN, 80));
			labe[i][e].setForeground(Color.DARK_GRAY);
			panel[i][e].add(labe[i][e]);
			}
		}
		
		
		
	}
	
	public void dPad(int position) {
		 JButton upBut = new JButton("U");
	        upBut.setSize(50, 40);
	        upBut.setLocation(540, 250+position);
	        upBut.addActionListener(actionUp);
	        upBut.setBackground(Color.LIGHT_GRAY);
	        upBut.setForeground(Color.BLUE);
	        frame.add(upBut);
	        
	        JButton downBut = new JButton("D");
	        downBut.setSize(50, 40);
	        downBut.setLocation(540, 300+position);
	        downBut.addActionListener(actionDown);
	        downBut.setBackground(Color.LIGHT_GRAY);
	        downBut.setForeground(Color.BLUE);
	        frame.add(downBut);
	        
	        JButton leftBut = new JButton("L");
	        leftBut.setSize(50, 40);
	        leftBut.setLocation(480, 300+position);
	        leftBut.addActionListener(actionLeft);
	        leftBut.setBackground(Color.LIGHT_GRAY);
	        leftBut.setForeground(Color.BLUE);
	        frame.add(leftBut);
	        
	        JButton rightBut = new JButton("R");
	        rightBut.setSize(50, 40);
	        rightBut.setLocation(600, 300+position);
	        rightBut.addActionListener(actionRight);
	        rightBut.setBackground(Color.LIGHT_GRAY);
	        rightBut.setForeground(Color.BLUE);
	        frame.add(rightBut);
	}
	
	AbstractAction actionDemarrer = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
            joueur1.initialisation(6);
            
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
    
	public Interface(String s) {
		super(s);
		frame.setVisible(true);
		frame.setSize(700,515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		
		
		tuiles(x);
		
		JSeparator separateurHor = new JSeparator();
		frame.add(separateurHor);
		
		JLabel label = new JLabel("2048");
		label.setForeground(Color.ORANGE);
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
        
        JSeparator separateurVer2 = new JSeparator(getHeight());
		frame.add(separateurVer2);
        
		dPad(100);
        
	}
	public String texte() {

		return "<html><center>Bienvenue dans notre 2048 Perso"
				+ "<br>en JAVA !"
				+ "<br>Â© Tristan Pestiaux"
				+ "<br> Robin Paquet"
				+ "<br> Ludo Van Den Dorpe</center></html>";
	}
public static void main(String[] args) {
	
    new Interface("");

	
    System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n"
			+ " Â©Tristan Pestiaux\n"
			+ "  Robin Paquet\n"
			+ "  Ludo Van Den Dorpe\n"
			+ "appuyer sur 2,3,4,5,6,7,8 ou 9 pour choisir la dimension du plateau et dÃƒÂ©marrer le 2048\n");
    

	}

}
