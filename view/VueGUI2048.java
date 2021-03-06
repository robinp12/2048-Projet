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

	/**
	 * Initialisation du timer a 0.
	 */
	private int miliseconde = 0, seconde = 0, minute = 0;
	int x = model.getDimension();
	private Color couleurGris = new Color(180,180,180);
	/**
	 * Definition des elements de la fenetre.
	 */
	private JFrame 	frame;
	private JPanel 	tuiles[][];
	private JLabel 	numeroCase[][];

	private JLabel 	labelTitre;
	private JLabel 	labelScore;
	private JLabel	labelTemps;
	private Timer	timer;
	private JLabel 	nombreCaseLabel;
	private JComboBox<Object> nombreCaseCombo;
	private JButton boutonDemarrer;
	private JButton boutonCredit;
	private JDialog fenetreCredit;
	private JDialog fenetreChoix;

	private JButton boutonHaut;
	private JButton boutonBas;
	private JButton boutonGauche;
	private JButton boutonDroite;

	/**
	 * Initialisation de la fenetre principale.
	 * Appel des methodes pour former la fenetre.
	 * @param Le model parent
	 * @param Le controller parent
	 */
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
		
		boiteDialogue("Comment jouer ?", "<html><p>D'abord choisissez le nombre de case pour jouer,</p>"
				+ "<p>ensuite vous pouvez cliquer sur '(Re)Initialiser' et</p><p>jouer avec les fleches (Haut, Bas, Gauche, Droite).</p></html>");

		panneauDroit();

		creditConsole();
	}
	/**
	 * @return Les milisecondes
	 */
	public int getMiliseconde() {
		return miliseconde;
	}
	public void setMiliseconde(int miliseconde) {
		this.miliseconde = miliseconde;
	}
	/**
	 * @return Les secondes
	 */
	public int getSeconde() {
		return seconde;
	}
	public void setSeconde(int seconde) {
		this.seconde = seconde;
	}
	/**
	 * @return Les minutes
	 */
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
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
	/**
	 * Action quand on appuye sur les fleches.
	 */
	@Override
	public void keyPressed(KeyEvent e) {
		if(!controller.estGagner() && !controller.estPerdu() && controller.getEstDemarrer()) {
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
	}
	@Override
	public void keyReleased(KeyEvent e) {

	}
	/**
	 * Fenetre dialogue pour le choix du nombre de tuiles.
	 */
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
				labelTemps.setVisible(true);
			}
		});
		fenetreChoix.add(nombreCaseCombo);
	}
	/**
	 * Boite de dialogue par defaut.
	 * @param titre
	 * Titre de la boite de dialogue.
	 * @param texte
	 * Texte de la boite de dialogue.
	 */
	public void boiteDialogue(String titre, String texte) {
		fenetreCredit = new JDialog();
        fenetreCredit.setTitle(titre);
        fenetreCredit.setSize(300, 220);
        fenetreCredit.setLocationRelativeTo(null);
        fenetreCredit.setLayout(new GridBagLayout());
        fenetreCredit.add(new JLabel(texte));
        fenetreCredit.setVisible(true);
	}
	/**
	 * Creation des tuiles.
	 */
	public void tuiles(int x) {
		int valeur;
		tuiles = new JPanel[x][x];
		numeroCase = new JLabel[x][x];
		
		if(controller.estPerdu()){
			boiteDialogue("Perdu", "<html><div>Vous avez perdu !</div><div>Votre score : " + model.getScore() + "</div><div>Temps : " 
					+ getMinute() +":"+getSeconde() +":" + getMiliseconde() + "</div><div>Appuyez sur 'Re(Initialiser)' </div><div>pour recommencer.  </div></html>");
			timer.stop();
			labelTemps.setVisible(false);
		}
		if(controller.estGagner()){
			boiteDialogue("Gagné", "<html><div>Bravo, vous avez gagné !</div><div>Votre score : " 
			+ model.getScore() + "</div><div>Temps : " 
			+ getMinute() +":"+getSeconde() +":" + getMiliseconde() + "</div><div>Appuyez sur 'Re(Initialiser)' </div><div>pour recommencer.  </div></html>");
			timer.stop();
			labelTemps.setVisible(false);
		}
		
		for (int i = 0; i < x; i++) {
			for (int e = 0; e < x; e++) {
				valeur = model.getTableau(e, i);
				tuiles[i][e] = new JPanel();
				tuiles[i][e].setBackground(Color.LIGHT_GRAY);
				numeroCase[i][e] = new JLabel();
				
				/**
				 * Creation des tailles, position et valeur de la case.
				 */
				switch (x) {
				case 2:
					tuiles[i][e].setSize(210, 210);
					tuiles[i][e].setLocation(218 * i + 20, 218 * e + 20);
					frame.add(tuiles[i][e]);
					labelTitre.setText(" 16");

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN,170));
					numeroCase[i][e].setSize(210, 210);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 3:
					tuiles[i][e].setSize(138, 138);
					tuiles[i][e].setLocation(148 * i + 20, 148 * e + 20);
					frame.add(tuiles[i][e]);
					labelTitre.setText("128");

					numeroCase[i][e].setText(String.valueOf(valeur));
					numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 110));
					numeroCase[i][e].setSize(138, 138);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 4:
					tuiles[i][e].setSize(100, 100);
					tuiles[i][e].setLocation(110 * i + 20, 110 * e + 20);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					if(valeur > 512) {
						numeroCase[i][e].setFont(new Font("Microsoft Himalaya", Font.PLAIN, 80));
					}else {
						numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 80));
					}
					numeroCase[i][e].setSize(100, 100);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 5:
					tuiles[i][e].setSize(79, 79);
					tuiles[i][e].setLocation(88 * i + 20, 88 * e + 20);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					if(valeur > 512) {
						numeroCase[i][e].setFont(new Font("Microsoft Himalaya", Font.PLAIN, 60));
					}else {
						numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 60));
					}
					numeroCase[i][e].setSize(79, 79);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 6:
					tuiles[i][e].setSize(65, 65);
					tuiles[i][e].setLocation(75 * i + 15, 75 * e + 15);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					if(valeur > 512) {
						numeroCase[i][e].setFont(new Font("Microsoft Himalaya", Font.PLAIN, 50));
					}else {
						numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 50));
					}
					
					numeroCase[i][e].setSize(65, 65);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 7:
					tuiles[i][e].setSize(57, 57);
					tuiles[i][e].setLocation(64 * i + 12, 64 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					if(valeur > 512) {
						numeroCase[i][e].setFont(new Font("Microsoft Himalaya", Font.PLAIN, 40));
					}else {
						numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 40));
					}
					numeroCase[i][e].setSize(57, 57);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 8:
					tuiles[i][e].setSize(49, 49);
					tuiles[i][e].setLocation(56 * i + 12, 56 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					if(valeur > 512) {
						numeroCase[i][e].setFont(new Font("Microsoft Himalaya", Font.PLAIN, 32));
					}else {
						numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 32));
					}
					numeroCase[i][e].setSize(49, 49);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				case 9:
					tuiles[i][e].setSize(44, 44);
					tuiles[i][e].setLocation(50 * i + 12, 50 * e + 12);
					frame.add(tuiles[i][e]);

					numeroCase[i][e].setText(String.valueOf(valeur));
					if(valeur > 512) {
						numeroCase[i][e].setFont(new Font("Microsoft Himalaya", Font.PLAIN, 28));
					}else {
						numeroCase[i][e].setFont(new Font("Arial", Font.PLAIN, 28));
					}
					numeroCase[i][e].setSize(44, 44);
					tuiles[i][e].add(numeroCase[i][e]);
					break;
				}
				/**
				 * Creation des couleurs pour chaque tuiles.
				 */
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
				case 256 : 
					tuiles[i][e].setBackground(new Color(0xdeff82));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 512 : 
					tuiles[i][e].setBackground(new Color(0xadff92));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 1024 : 
					tuiles[i][e].setBackground(new Color(0x9dcfa2));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;
				case 2048 : 
					tuiles[i][e].setBackground(new Color(0x7dcfb2));
					numeroCase[i][e].setForeground(Color.WHITE);
					break;				}
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
						boiteDialogue("Perdu","Vous avez perdu");
					}
					labelScore.setText("Score: " + model.getScore());
					labelTemps.setText("Temps: " + getMinute() + ":" + getSeconde() + ":" + getMiliseconde());
					/**
					 * Changement de couleur du titre.
					 */
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
	/**
	 * Creation des elements dans la fenetre laterale droite.
	 */
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
        
		boutonDemarrer = new JButton("(Re)Initialiser");
		boutonDemarrer.setSize(150, 40);
		boutonDemarrer.setLocation(490,225);
		boutonDemarrer.setBackground(Color.LIGHT_GRAY);
		boutonDemarrer.addActionListener(actionDemarrer);
		boutonDemarrer.addKeyListener(this);
		frame.add(boutonDemarrer);

		boutonCredit = new JButton("Credit");
		boutonCredit.setSize(150, 40);
		boutonCredit.setLocation(490, 275);
		boutonCredit.setBackground(Color.LIGHT_GRAY);
		boutonCredit.addActionListener(actionCredit);
		frame.add(boutonCredit);
		
		/**
		 *Creation des 4 Boutons directionnels.
		 */
		boutonHaut = new JButton("\u21e7");
        boutonHaut.setSize(45, 35);
        boutonHaut.setLocation(542, 350);
		boutonHaut.addActionListener(actionHaut);
		boutonHaut.setBackground(Color.LIGHT_GRAY);
		boutonHaut.setForeground(Color.BLUE);
		frame.add(boutonHaut);

		boutonBas = new JButton("\u21e9");
        boutonBas.setSize(45, 35);
        boutonBas.setLocation(542, 390);
		boutonBas.addActionListener(actionBas);
		boutonBas.setBackground(Color.LIGHT_GRAY);
		boutonBas.setForeground(Color.BLUE);
		frame.add(boutonBas);

		boutonGauche = new JButton("\u21e6");
        boutonGauche.setSize(46, 35);
        boutonGauche.setLocation(490, 390);
		boutonGauche.addActionListener(actionGauche);
		boutonGauche.setBackground(Color.LIGHT_GRAY);
		boutonGauche.setForeground(Color.BLUE);
		frame.add(boutonGauche);

		boutonDroite = new JButton("\u21e8");
        boutonDroite.setSize(46, 35);
        boutonDroite.setLocation(592, 390);
		boutonDroite.addActionListener(actionDroite);
		boutonDroite.setBackground(Color.LIGHT_GRAY);
		boutonDroite.setForeground(Color.BLUE);
		frame.add(boutonDroite);
	}
	/**
	 * Texte s'affichant dans le dialogue du credit.
	 * 
	 * @return Un string de texte allant s'afficher dans boite de dialogue. 
	 */
	public String texteCredit() {
		return "<html><center>Bienvenue dans notre Projet 2048" + "<br>en JAVA !" + "<br> Tristan Pestiaux"
				+ "<br> Robin Paquet" + "<br> Ludo Van Den Dorpe</center></html>";
	}
	public void creditConsole() {
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n" + " Ã‚Â©Tristan Pestiaux\n" + "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "appuyer sur 2,3,4,5,6,7,8 ou 9 pour choisir la dimension du plateau et demarrer le 2048\n");
	}
	/**
	 * Action au clique sur le bouton demarrer.
	 */
	AbstractAction actionDemarrer = new AbstractAction() {
		

		private static final long serialVersionUID = 1L;
		
		@Override
		public void actionPerformed(ActionEvent e) {
			model.initialisation((Integer.valueOf((String)nombreCaseCombo.getSelectedItem())));
			fenetreChoix.dispose();
			setMiliseconde(0);
            setSeconde(0);
            setMinute(0);
			timer.start();
			controller.setEstDemarrer(true);
			/**
			 * Reinitialisation du temps a 0.
			 */
			labelTemps.setVisible(true);
		}
	};
	/**
	 * Action au clique sur le bouton credit.
	 */
	AbstractAction actionCredit = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			boiteDialogue("Credit ©",texteCredit());
		}
	};
	/**
	 * Action au clique sur le bouton directionnel Haut.
	 */
	AbstractAction actionHaut = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Haut");
			model.deplacement("H");
		}
	};
	/**
	 * Action au clique sur le bouton directionnel Bas.
	 */
	AbstractAction actionBas = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Bas");
			model.deplacement("B");
		}
	};
	/**
	 * Action au clique sur le bouton directionnel Gauche.
	 */
	AbstractAction actionGauche = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Gauche");
			model.deplacement("G");
		}
	};
	/**
	 * Action au clique sur le bouton directionnel Droit.
	 */
	AbstractAction actionDroite = new AbstractAction() {

		private static final long serialVersionUID = 1L;

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("Droite");
			model.deplacement("D");
		}
	};

}
