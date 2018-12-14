package jeu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;

public class Interface extends Deplacement{
	
	Plateau joueur1 = new Plateau();
	int x = joueur1.getDimension();
	
	JFrame frame;
	JPanel tuiles [][];
	JLabel numeroCase [][];
	
	JLabel labelTitre;
	JLabel score;
	JLabel nombreCaseLabel;
	JSlider nombreCaseSlider;
	JButton bouttonDemarrer;
	JButton bouttonCredit;
	JDialog fenetreCredit;
	
	JButton bouttonHaut;
	JButton bouttonBas;
	JButton bouttonGauche;
	JButton bouttonDroite;
	
	public void tuiles(int x) {	
		
		Color couleurNoir = new Color(180,180,180);
		int valeur[] = {2,4,8,16,32,64,128};
		tuiles = new JPanel[x][x];
		numeroCase = new JLabel[x][x];
		for(int i= 0; i<x; i++) {
			for(int e= 0; e<x; e++) {
				switch(x) {
				case 2 :
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(200,200);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(210*i+30, 210 * e+30);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-10*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 3 : 
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(130,130);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(140*i+25, 140 * e+25);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-10*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 4 : 
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(100,100);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(110*i+20, 110 * e+20);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(valeur[6]));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-5*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 5 : 
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(80,80);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(90*i+20, 90 * e+20);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-3*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 6 :
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(65,65);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(75*i+15, 75 * e+15);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-3*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 7 :
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(55,55);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(62*i+10, 62 * e+10);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-2*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 8 :
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(46,46);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(53*i+12, 53* e+12);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-2*x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 9 : 
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setSize(42,42);
					tuiles[i][e].setBackground(couleurNoir);
					tuiles[i][e].setLocation(50*i+12, 50* e+12);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(0));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-x));
					tuiles[i][e].add(numeroCase[i][e]);
					break;	
				}
			}
		}
	}
	public void panneauDroit(int position) {
			
			labelTitre = new JLabel("2048");
			labelTitre.setForeground(Color.ORANGE);
			labelTitre.setSize(180,60);
			labelTitre.setLocation(490, 20);
			labelTitre.setFont(new Font("Arial", Font.BOLD, 70));
	        frame.add(labelTitre);
	        
	        score = new JLabel("Score: " + String.valueOf(0));
	        score.setForeground(Color.ORANGE);
	        score.setSize(180,60);
	        score.setLocation(500, 75);
	        score.setFont(new Font("Arial", Font.BOLD, 20));
	        frame.add(score);
	        
	        nombreCaseLabel = new JLabel("Nombre de case:(Par defaut 4)");
	        nombreCaseLabel.setSize(180,60);
	        nombreCaseLabel.setLocation(490, 100+position);
	        nombreCaseLabel.setFont(new Font("Arial", Font.PLAIN, 11));
	        frame.add(nombreCaseLabel);
	        
	        
	        
	        nombreCaseSlider = new JSlider(JSlider.HORIZONTAL, 2, 9, x);
	        nombreCaseSlider.setMinorTickSpacing(2);  
	        nombreCaseSlider.setMajorTickSpacing(9);
	        nombreCaseSlider.setLocation(490, 140+position);
	        nombreCaseSlider.setSize(155,20);
	        nombreCaseSlider.addChangeListener(null);
	        frame.add(nombreCaseSlider);
	        
			bouttonDemarrer = new JButton("Demarrer");
			bouttonDemarrer.setSize(150,40);
	        bouttonDemarrer.setLocation(490, 180+position);
	        bouttonDemarrer.setBackground(Color.LIGHT_GRAY);
	        bouttonDemarrer.addActionListener(actionDemarrer);
			frame.add(bouttonDemarrer);
			
			bouttonCredit = new JButton("Credit");
			bouttonCredit.setSize(150,40);
	        bouttonCredit.setLocation(490, 230+position);
	        bouttonCredit.setBackground(Color.LIGHT_GRAY);
	        bouttonCredit.addActionListener(actionCredit);
	        frame.add(bouttonCredit);
        
			bouttonHaut = new JButton("\u21e7");
	        bouttonHaut.setSize(50, 40);
	        bouttonHaut.setLocation(540, 300+position);
	        bouttonHaut.addActionListener(actionHaut);
	        bouttonHaut.setBackground(Color.LIGHT_GRAY);
	        bouttonHaut.setForeground(Color.BLUE);
	        frame.add(bouttonHaut);
	        
	        bouttonBas = new JButton("\u21e9");
	        bouttonBas.setSize(50, 40);
	        bouttonBas.setLocation(540, 350+position);
	        bouttonBas.addActionListener(actionBas);
	        bouttonBas.setBackground(Color.LIGHT_GRAY);
	        bouttonBas.setForeground(Color.BLUE);
	        frame.add(bouttonBas);
	        
	        bouttonGauche = new JButton("\u21e6");
	        bouttonGauche.setSize(50, 40);
	        bouttonGauche.setLocation(480, 350+position);
	        bouttonGauche.addActionListener(actionGauche);
	        bouttonGauche.setBackground(Color.LIGHT_GRAY);
	        bouttonGauche.setForeground(Color.BLUE);
	        frame.add(bouttonGauche);
	        
	        bouttonDroite = new JButton("\u21e8");
	        bouttonDroite.setSize(50, 40);
	        bouttonDroite.setLocation(600, 350+position);
	        bouttonDroite.addActionListener(actionDroite);
	        bouttonDroite.setBackground(Color.LIGHT_GRAY);
	        bouttonDroite.setForeground(Color.BLUE);
	        frame.add(bouttonDroite);
	}
	public String texte() {
		return "<html><center>Bienvenue dans notre Projet 2048"
				+ "<br>en JAVA !"
				+ "<br> Tristan Pestiaux"
				+ "<br> Robin Paquet"
				+ "<br> Ludo Van Den Dorpe</center></html>";
	}
	public void creditConsole() {
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n"
				+ " ©Tristan Pestiaux\n"
				+ "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "appuyer sur 2,3,4,5,6,7,8 ou 9 pour choisir la dimension du plateau et demarrer le 2048\n");
	}
	
	AbstractAction actionDemarrer = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
            joueur1.initialisation(x);
            
        }
    };
    AbstractAction actionCredit = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
            fenetreCredit = new JDialog();
            fenetreCredit.setTitle("Credit©");
            fenetreCredit.setSize(240, 200);
            fenetreCredit.setLocationRelativeTo(null);
            fenetreCredit.setLayout(new GridBagLayout());
            fenetreCredit.setResizable(false);
            fenetreCredit.add(new JLabel(texte()));
            fenetreCredit.setVisible(true);
        }
    };
    
    AbstractAction actionHaut = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Haut");
			joueur1.deplacement("H");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };    
    AbstractAction actionBas = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Bas");
			joueur1.deplacement("B");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };
    AbstractAction actionGauche = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Gauche");
			joueur1.deplacement("G");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };
    AbstractAction actionDroite = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			System.out.println("Droite");
			joueur1.deplacement("D");
			joueur1.ajouterAleatoire();
			joueur1.affichageTableau();
        }
    };
    
	public Interface() {
		frame = new JFrame("Projet 2048");
		frame.setSize(700,515);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.addKeyListener(this);
		frame.setLayout(null);
		frame.setVisible(true);
		
		tuiles(x);
        
		panneauDroit(20);
		
		creditConsole();
	
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
	
		        public void run() {	
		              new Interface();
		        }
		});
	}
}
