package jeu;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.Timer;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Interface extends Deplacement implements ChangeListener{
	
	Plateau joueur1 = new Plateau();
	int x = joueur1.getDimension();
	Color couleurGris = new Color(180,180,180);
	
	private JFrame frame;
	private JPanel tuiles [][];
	private JLabel numeroCase [][];
	
	private JLabel labelTitre;
	private JLabel labelScore;
	private JLabel labelTemps;
	private Timer timer;
	private JLabel nombreCaseLabel;
	private JSlider nombreCaseSlider;
	private JButton bouttonDemarrer;
	private JButton bouttonCredit;
	private JDialog fenetreCredit;
	
	private JButton bouttonHaut; 
	private JButton bouttonBas;
	private JButton bouttonGauche;
	private JButton bouttonDroite;
	
	@Override
	public void stateChanged(ChangeEvent arg0) {
		joueur1.setDimension(nombreCaseSlider.getValue());
		System.out.println(joueur1.getDimension());
		
	}
	
	public void tuiles(int nombreTuiles) {	
		
		int i;
		int e;
		int valeur[] = {0,2,4,8,16,32,64,128};
		tuiles = new JPanel[nombreTuiles][nombreTuiles];
		numeroCase = new JLabel[nombreTuiles][nombreTuiles];
	
		for(i= 0; i<nombreTuiles; i++) {
			for(e= 0; e<nombreTuiles; e++) {
				
					tuiles[i][e] = new JPanel();
					tuiles[i][e].setBackground(couleurGris);
					frame.add(tuiles[i][e]);
					
					numeroCase[i][e] = new JLabel();
					numeroCase[i][e].setText(String.valueOf(valeur[1]));
					tuiles[i][e].add(numeroCase[i][e]);
					
				switch(nombreTuiles) {
				case 2 :
					tuiles[i][e].setSize(200,200);
					tuiles[i][e].setLocation(210*i+30, 210 * e+30);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-10*nombreTuiles));
					break;
				case 3 : 
					tuiles[i][e].setSize(130,130);
					tuiles[i][e].setLocation(140*i+25, 140 * e+25);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-10*nombreTuiles));
					break;
				case 4 : 
					tuiles[i][e].setSize(100,100);
					tuiles[i][e].setLocation(110*i+20, 110 * e+20);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-5*nombreTuiles));
					break;
				case 5 : 
					tuiles[i][e].setSize(80,80);
					tuiles[i][e].setLocation(90*i+20, 90 * e+20);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-3*nombreTuiles));
					break;
				case 6 :
					tuiles[i][e].setSize(65,65);
					tuiles[i][e].setLocation(75*i+15, 75 * e+15);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-3*nombreTuiles));
					break;
				case 7 :
					tuiles[i][e].setSize(55,55);
					tuiles[i][e].setLocation(62*i+10, 62 * e+10);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-2*nombreTuiles));
					break;
				case 8 :
					tuiles[i][e].setSize(46,46);
					tuiles[i][e].setLocation(53*i+12, 53* e+12);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-2*nombreTuiles));
					break;
				case 9 : 
					tuiles[i][e].setSize(42,42);
					tuiles[i][e].setLocation(50*i+12, 50* e+12);
					
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, tuiles[i][e].getHeight()-nombreTuiles));
					break;	
				}
			}
		}
	}
	public void panneauDroit() {
			
			labelTitre = new JLabel("2048");
			labelTitre.setForeground(Color.ORANGE);
			labelTitre.setSize(180,60);
			labelTitre.setLocation(490, 20);
			labelTitre.setFont(new Font("Arial", Font.BOLD, 70));
	        frame.add(labelTitre);

	        labelScore = new JLabel("Score: ");
	        labelScore.setForeground(couleurGris);
	        labelScore.setSize(180,60);
	        labelScore.setLocation(490, 71);
	        labelScore.setFont(new Font("Arial", Font.BOLD, 25));
	        frame.add(labelScore);
	        
	        timer = new Timer(10, new ActionListener() {
				private int miliseconde = 0;
				private int seconde = 0; 
				private int minute = 0;
				private int couleurMin = 0;
				private int couleurMax = 255;
				@Override 
				public void actionPerformed(ActionEvent e) {
					miliseconde++;
					if(miliseconde == 60)
					{
						miliseconde = 0;
						seconde++;
					}
					if(seconde == 60)
					{
						seconde = 0;
						minute++;
					}
					if(minute == 60)
					{
						miliseconde = 0;
						seconde = 0;
						minute = 0;
						boiteDialogue("Message","Vous avez perdu");
					}
					labelScore.setText("Score: " + joueur1.getScore());
					labelTemps.setText("Temps: " + minute + ":" + seconde + ":" + miliseconde);
					joueur1.setDimension(nombreCaseSlider.getValue());
					//tuiles(x);
					if(couleurMin < 255 && couleurMax > 0) {
					Color rain = new Color(couleurMin++,couleurMin++/2,couleurMax--);
					labelTitre.setForeground(rain);
					}
					else {
						labelTitre.setForeground(Color.orange);
					}
					
				}
			});
									        
	        labelTemps = new JLabel();
	        labelTemps.setText("Temps: ");
	        labelTemps.setForeground(Color.RED);
	        labelTemps.setSize(180,60);
	        labelTemps.setLocation(490, 105);
	        labelTemps.setFont(new Font("Arial", Font.BOLD, 15));
	        frame.add(labelTemps);

	        
	        nombreCaseLabel = new JLabel("Nombre de case:(Par defaut 4)");
	        nombreCaseLabel.setSize(180,60);
	        nombreCaseLabel.setLocation(490, 140);
	        nombreCaseLabel.setFont(new Font("Arial", Font.PLAIN, 11));
	        frame.add(nombreCaseLabel);
	        
	        nombreCaseSlider = new JSlider(JSlider.HORIZONTAL, 2, 9, x);
	        nombreCaseSlider.setMinorTickSpacing(2);  
	        nombreCaseSlider.setMajorTickSpacing(9);
	        nombreCaseSlider.addChangeListener(this);
	        nombreCaseSlider.setLocation(490, 185);
	        nombreCaseSlider.setSize(155,20);
	        frame.add(nombreCaseSlider);
	        
			bouttonDemarrer = new JButton("(Re)Initialiser");
			bouttonDemarrer.setSize(150,40);
	        bouttonDemarrer.setLocation(490, 225);
	        bouttonDemarrer.setBackground(Color.LIGHT_GRAY);
	        bouttonDemarrer.addActionListener(actionDemarrer);
			frame.add(bouttonDemarrer);
			
			bouttonCredit = new JButton("Credit");
			bouttonCredit.setSize(150,40);
	        bouttonCredit.setLocation(490, 275);
	        bouttonCredit.setBackground(Color.LIGHT_GRAY);
	        bouttonCredit.addActionListener(actionCredit);
	        frame.add(bouttonCredit);
        
			bouttonHaut = new JButton("\u21e7");
	        bouttonHaut.setSize(45, 35);
	        bouttonHaut.setLocation(542, 330);
	        bouttonHaut.addActionListener(actionHaut);
	        bouttonHaut.setBackground(Color.LIGHT_GRAY);
	        bouttonHaut.setForeground(Color.BLUE);
	        frame.add(bouttonHaut);
	        
	        bouttonBas = new JButton("\u21e9");
	        bouttonBas.setSize(45, 35);
	        bouttonBas.setLocation(542, 370);
	        bouttonBas.addActionListener(actionBas);
	        bouttonBas.setBackground(Color.LIGHT_GRAY);
	        bouttonBas.setForeground(Color.BLUE);
	        frame.add(bouttonBas);
	        
	        bouttonGauche = new JButton("\u21e6");
	        bouttonGauche.setSize(46, 35);
	        bouttonGauche.setLocation(490, 370);
	        bouttonGauche.addActionListener(actionGauche);
	        bouttonGauche.setBackground(Color.LIGHT_GRAY);
	        bouttonGauche.setForeground(Color.BLUE);
	        frame.add(bouttonGauche);
	        
	        bouttonDroite = new JButton("\u21e8");
	        bouttonDroite.setSize(46, 35);
	        bouttonDroite.setLocation(592, 370);
	        bouttonDroite.addActionListener(actionDroite);
	        bouttonDroite.setBackground(Color.LIGHT_GRAY);
	        bouttonDroite.setForeground(Color.BLUE);
	        frame.add(bouttonDroite);
	}	
	public void boiteDialogue(String titre, String texte) {
		fenetreCredit = new JDialog();
		fenetreCredit.setTitle(titre);
		fenetreCredit.setSize(240, 200);
		fenetreCredit.setLocationRelativeTo(null);
		fenetreCredit.setLayout(new GridBagLayout());
		fenetreCredit.setResizable(false);
		fenetreCredit.add(new JLabel(texte));
		fenetreCredit.setVisible(true);
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
            timer.start();             
        }
    };
    AbstractAction actionCredit = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
        public void actionPerformed(ActionEvent e) {
			boiteDialogue("Credit©",texte());
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
		frame.setSize(680,500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.addKeyListener(null);
		frame.setLayout(null);
		frame.setVisible(true);
		
        tuiles(x);
        
		panneauDroit();
		
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
