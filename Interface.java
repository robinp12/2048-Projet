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
			rangee1[i].setLocation(110*i+10, 10);
			rangee1[i].setVisible(true);
			frame.add(rangee1[i]);
		}
		JPanel [] rangee2 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee2[i] = new JPanel();
			rangee2[i].setBackground(couleurNoir);
			rangee2[i].setSize(tailleCase, tailleCase);
			rangee2[i].setLocation(110*i+10, 120);
			rangee2[i].setVisible(true);
			frame.add(rangee2[i]);
		}
		JPanel [] rangee3 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee3[i] = new JPanel();
			rangee3[i].setBackground(couleurNoir);
			rangee3[i].setSize(tailleCase, tailleCase);
			rangee3[i].setLocation(110*i+10, 230);
			rangee3[i].setVisible(true);
			frame.add(rangee3[i]);
		}
		JPanel [] rangee4 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee4[i] = new JPanel();
			rangee4[i].setBackground(couleurNoir);
			rangee4[i].setSize(tailleCase, tailleCase);
			rangee4[i].setLocation(110*i+10, 340);
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
    
	public Interface(int tailleCase, String s) {
		super(s);
		frame.setVisible(true);
		frame.setSize(700,550);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.addKeyListener(this);
		
		tuiles(tailleCase);
		
		JLabel label = new JLabel("2048");
        label.setSize(200, 100);
        label.setLocation(485, 30);
        label.setFont(new Font("Arial", Font.PLAIN, 70));
        frame.add(label);
        
		JSeparator sep = new JSeparator(getWidth());
		frame.add(sep);
		
        
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
