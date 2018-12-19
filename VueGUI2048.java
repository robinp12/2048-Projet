package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Observable;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

import controller.Controller2048;
import model.Plateau;

public class VueGUI2048 extends Vue2048 implements KeyListener{

	private int miliseconde = 0, seconde = 0, minute = 0;
	public int getMiliseconde() {
		return miliseconde;
	}
	public void setMiliseconde(int miliseconde) {
		this.miliseconde = miliseconde;
	}
	public int getSeconde() {
		return seconde;
	}
	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}

	int x = model.getDimension();
	private Color couleurGris = new Color(180,180,180);

	private JFrame 	frame;
	private JPanel 	tuiles[][];
	private JLabel 	numeroCase[][];

	private JLabel 	labelTitre;
	private JLabel 	labelScore;
	private JLabel	labelTemps;
	private Timer	timer;
	private JLabel 	nombreCaseLabel;
	private JComboBox<Object> nombreCaseCombo;
	private JButton bouttonDemarrer;
	private JButton bouttonCredit;
	private JDialog fenetreCredit;
	private JDialog fenetreChoix;


	private JButton bouttonHaut;
	private JButton bouttonBas;
	private JButton bouttonGauche;
	private JButton bouttonDroite;

	public VueGUI2048(Plateau model, Controller2048 controller) {
		super(model, controller);
		frame = new JFrame("Projet 2048");
		frame.setSize(680, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setLayout(null);
		frame.setVisible(true);
		
		tuiles(x);
		
		choixTuiles();
		
		boiteDialogue("Comment jouer ?", "<html><div>D'abord choisissez le nombre de case pour jouer,"
				+ "ensuite vous pouvez cliquer sur '(Re)Initialiser' et jouer avec les fleches.</div></html>");

		panneauDroit();

		creditConsole();
	}
	public JPanel getTuile(int i, int e) {
		return tuiles[i][e];
	}

	@Override
	public void affiche() {
		x = model.getDimension();
		tuiles(x);
	}
	@Override
	public void update(Observable o, Object arg) {
		affiche();
	}
	@Override
	public void keyTyped(KeyEvent e) {

	}
	@Override
	public void keyPressed(KeyEvent e) {

		int key = e.getKeyCode();
		if (key == KeyEvent.VK_LEFT) {
			System.out.println("Gauche");
			model.deplacement("G");

		}

		if (key == KeyEvent.VK_RIGHT) {
			System.out.println("Droite");
			model.deplacement("D");
		}

		if (key == KeyEvent.VK_UP) {
			System.out.println("Haut");
			model.deplacement("H");
		}

		if (key == KeyEvent.VK_DOWN) {
			System.out.println("Bas");
			model.deplacement("B");
		}
		

		else {
			System.setErr(null);
		}

	}
	@Override
	public void keyReleased(KeyEvent e) {

	}
	
	public void choixTuiles(){
		fenetreChoix = new JDialog();
		fenetreChoix.setTitle("Choix des tuiles");
		fenetreChoix.setSize(240, 200);
		fenetreChoix.setLocationRelativeTo(null);
		fenetreChoix.setLayout(new GridBagLayout());
		fenetreChoix.setVisible(true);
        
		nombreCaseLabel = new JLabel("<html>Choix du nombre de case : <br>(Par defaut: 4x4) </html>");
		nombreCaseLabel.setSize(180, 60);
		nombreCaseLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		fenetreChoix.add(nombreCaseLabel);
		
		String valeurNombreCase[] = {"2","3","4","5","6","7","8","9"};
		nombreCaseCombo = new JComboBox<Object>(valeurNombreCase);
		nombreCaseCombo.setSelectedIndex(2);
		nombreCaseCombo.setSize(50, 20);
		nombreCaseCombo.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				controller.viderTableau(tuiles);
				model.setDimension(Integer.valueOf((String)nombreCaseCombo.getSelectedItem()));
				model.initialisation((Integer.valueOf((String)nombreCaseCombo.getSelectedItem())));
			}
		});
		fenetreChoix.add(nombreCaseCombo);
	}
	public void boiteDialogue(String titre, String texte) {
		fenetreCredit = new JDialog();
        fenetreCredit.setTitle(titre);
        fenetreCredit.setSize(240, 200);
        fenetreCredit.setLocationRelativeTo(null);
        fenetreCredit.setLayout(new GridBagLayout());
        fenetreCredit.add(new JLabel(texte));
        fenetreCredit.setVisible(true);
	}
	public void tuiles(int x) {
		int valeur;
		tuiles = new JPanel[x][x];
		numeroCase = new JLabel[x][x];
		for (int i = 0; i < x; i++) {
			for (int e = 0; e < x; e++) {
				valeur = model.getTableau(e, i);
				tuiles[i][e] = new JPanel();
				tuiles[i][e].setBackground(Color.LIGHT_GRAY);
				
				numeroCase[i][e] = new JLabel();
				switch (x) {
				case 2:
					
					tuiles[i][e].setSize(200, 200);
					tuiles[i][e].setLocation(210 * i + 30, 210 * e + 30);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN,170));
					numeroCase[i][e].setSize(200, 200);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 3:
					tuiles[i][e].setSize(130, 130);
					tuiles[i][e].setLocation(140 * i + 25, 140 * e + 25);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 110));
					numeroCase[i][e].setSize(130, 130);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 4:
					tuiles[i][e].setSize(100, 100);
					tuiles[i][e].setLocation(110 * i + 20, 110 * e + 20);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 80));
					numeroCase[i][e].setSize(100, 100);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 5:
					tuiles[i][e].setSize(80, 80);
					tuiles[i][e].setLocation(90 * i + 20, 90 * e + 20);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 60));
					numeroCase[i][e].setSize(80, 80);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 6:
					tuiles[i][e].setSize(65, 65);
					tuiles[i][e].setLocation(75 * i + 15, 75 * e + 15);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 50));
					numeroCase[i][e].setSize(65, 65);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 7:
					tuiles[i][e].setSize(55, 55);
					tuiles[i][e].setLocation(62 * i + 10, 62 * e + 10);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 40));
					numeroCase[i][e].setSize(55, 55);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 8:
					tuiles[i][e].setSize(46, 46);
					tuiles[i][e].setLocation(53 * i + 12, 53 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 30));
					numeroCase[i][e].setSize(46, 46);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 9:
					tuiles[i][e].setSize(42, 42);
					tuiles[i][e].setLocation(50 * i + 12, 50 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 28));
					numeroCase[i][e].setSize(42, 42);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				}
				switch (valeur) {
				case 2 : 
					tuiles[i][e].setBackground(new Color(0xeee4da));
					break;
				case 4 : 
					tuiles[i][e].setBackground(new Color(0xede0c8));
					break;
				case 8 : 
					tuiles[i][e].setBackground(new Color(0xf2b179));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 16 : 
					tuiles[i][e].setBackground(new Color(0xf59563));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 32 : 
					tuiles[i][e].setBackground(new Color(0xf67c5f));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 64 : 
					tuiles[i][e].setBackground(new Color(0xf65e3b));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 128 : 
					tuiles[i][e].setBackground(new Color(0xedcf72));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;					
				}
			}
		}
	}
	public void timer() {
		 timer = new Timer(10, new ActionListener() {
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
					labelScore.setText("Score: " + model.getScore());
					labelTemps.setText("Temps: " + getMinute() + ":" + getSeconde() + ":" + getMiliseconde());
					
					if(couleurMin < 255 && couleurMax > 0) {
						Color rain = new Color(couleurMin++,couleurMin++/2,couleurMax--/2);
						labelTitre.setForeground(rain);
					}
					else {
						labelTitre.setForeground(Color.orange);
					}
					
				}
			});
	}
	
	public void panneauDroit() {

		labelTitre = new JLabel("2048");
		labelTitre.setSize(180, 60);
		labelTitre.setLocation(490, 20);
		labelTitre.setFont(new Font("Arial", Font.BOLD, 70));
		frame.add(labelTitre);

        labelScore = new JLabel("Score: ");
        labelScore.setForeground(couleurGris);
        labelScore.setSize(180,60);
        labelScore.setLocation(490, 90);
        labelScore.setFont(new Font("Arial", Font.BOLD, 25));
        frame.add(labelScore);

        timer();
	
        labelTemps = new JLabel();
        labelTemps.setText("Temps: ");
        labelTemps.setForeground(Color.RED);
        labelTemps.setSize(180,60);
        labelTemps.setLocation(490, 150);
        labelTemps.setFont(new Font("Arial", Font.BOLD, 18));
        frame.add(labelTemps);	
        
		bouttonDemarrer = new JButton("(Re)Initialiser");
		bouttonDemarrer.setSize(150, 40);
		bouttonDemarrer.setLocation(490,225);
		bouttonDemarrer.setBackground(Color.LIGHT_GRAY);
		bouttonDemarrer.addActionListener(actionDemarrer);
		bouttonDemarrer.addKeyListener(this);
		frame.add(bouttonDemarrer);

		bouttonCredit = new JButton("Credit");
		bouttonCredit.setSize(150, 40);
		bouttonCredit.setLocation(490, 275);
		bouttonCredit.setBackground(Color.LIGHT_GRAY);
		bouttonCredit.addActionListener(actionCredit);
		frame.add(bouttonCredit);

		bouttonHaut = new JButton("\u21e7");
        bouttonHaut.setSize(45, 35);
        bouttonHaut.setLocation(542, 350);
		bouttonHaut.addActionListener(actionHaut);
		bouttonHaut.setBackground(Color.LIGHT_GRAY);
		bouttonHaut.setForeground(Color.BLUE);
		frame.add(bouttonHaut);

		bouttonBas = new JButton("\u21e9");
        bouttonBas.setSize(45, 35);
        bouttonBas.setLocation(542, 390);
		bouttonBas.addActionListener(actionBas);
		bouttonBas.setBackground(Color.LIGHT_GRAY);
		bouttonBas.setForeground(Color.BLUE);
		frame.add(bouttonBas);

		bouttonGauche = new JButton("\u21e6");
        bouttonGauche.setSize(46, 35);
        bouttonGauche.setLocation(490, 390);
		bouttonGauche.addActionListener(actionGauche);
		bouttonGauche.setBackground(Color.LIGHT_GRAY);
		bouttonGauche.setForeground(Color.BLUE);
		frame.add(bouttonGauche);

		bouttonDroite = new JButton("\u21e8");
        bouttonDroite.setSize(46, 35);
        bouttonDroite.setLocation(592, 390);
		bouttonDroite.addActionListener(actionDroite);
		bouttonDroite.setBackground(Color.LIGHT_GRAY);
		bouttonDroite.setForeground(Color.BLUE);
		frame.add(bouttonDroite);
	}

	public String texte() {
		return "<html><center>Bienvenue dans notre Projet 2048" + "<br>en JAVA !" + "<br> Tristan Pestiaux"
				+ "<br> Robin Paquet" + "<br> Ludo Van Den Dorpe</center></html>";
	}
	public void creditConsole() {
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n" + " Ã‚Â©Tristan Pestiaux\n" + "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "appuyer sur 2,3,4,5,6,7,8 ou 9 pour choisir la dimension du plateau et demarrer le 2048\n");
	}

	AbstractAction actionDemarrer = new AbstractAction() {
		

		private static final long serialVersionUID = 1L;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			model.initialisation((Integer.valueOf((String)nombreCaseCombo.getSelectedItem())));
			timer.start();
            setMiliseconde(0);
            setSeconde(0);
            setMinute(0);
		}
	};
	AbstractAction actionCredit = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			boiteDialogue("Credit ©",texte());
		}
	};

	AbstractAction actionHaut = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Haut");
			model.deplacement("H");
		}
	};
	AbstractAction actionBas = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Bas");
			model.deplacement("B");
		}
	};
	AbstractAction actionGauche = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Gauche");
			model.deplacement("G");
		}
	};
	AbstractAction actionDroite = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Droite");
			model.deplacement("D");
		}
	};
