package jeu;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Interface extends Deplacement{
	private static final long serialVersionUID = 1L;
	
	private JFrame frame;
	private Container contentPane;
	
	JPanel [] rangee1;
	JPanel [] rangee2;
	JPanel [] rangee3;
	JPanel [] rangee4;
	
	private JButton demarrer;
	private JButton credit;
	private JLabel label;
	
	Color couleurGris = new Color(200,200,200);
	Color couleurNoir = new Color(100,100,100);

	
	public void tuiles(int tailleCase) {	
		
		JPanel [] rangee1 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee1[i] = new JPanel();
			rangee1[i].setBackground(couleurNoir);
			rangee1[i].setSize(tailleCase, tailleCase);
			rangee1[i].setLocation(110*i+10, 10);
			rangee1[i].setVisible(true);
			contentPane.add(rangee1[i]);
		}
		JPanel [] rangee2 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee2[i] = new JPanel();
			rangee2[i].setBackground(couleurNoir);
			rangee2[i].setSize(tailleCase, tailleCase);
			rangee2[i].setLocation(110*i+10, 120);
			rangee2[i].setVisible(true);
			contentPane.add(rangee2[i]);
		}
		JPanel [] rangee3 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee3[i] = new JPanel();
			rangee3[i].setBackground(couleurNoir);
			rangee3[i].setSize(tailleCase, tailleCase);
			rangee3[i].setLocation(110*i+10, 230);
			rangee3[i].setVisible(true);
			contentPane.add(rangee3[i]);
		}
		JPanel [] rangee4 = new JPanel[4];
		for(int i=0; i< 4; i++) {
			rangee4[i] = new JPanel();
			rangee4[i].setBackground(couleurGris);
			rangee4[i].setSize(tailleCase, tailleCase);
			rangee4[i].setLocation(110*i, 200);
			rangee4[i].setVisible(true);
			contentPane.add(rangee4[i]);
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
            frameCredit. setDefaultCloseOperation(EXIT_ON_CLOSE);
            frameCredit.setLocationRelativeTo(null);
            frameCredit.add(labelCredit);
            labelCredit.setText(texte());
            labelCredit.setFont(new Font("Arial", Font.PLAIN, 15));
        }
    };
    
	public Interface() {
		super();
		frame = new JFrame("Projet 2048");
		contentPane = frame.getContentPane();
		frame.setBackground(new Color(200,200,200));
		
		label = new JLabel("2048");
		demarrer = new JButton("Demarrer");
		credit = new JButton("Credit");
		
        frame.setSize(700,550);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.addKeyListener(this);

		demarrer.addActionListener(actionDemarrer);
		credit.addActionListener(actionCredit);
        
        contentPane.add(demarrer);
        contentPane.add(credit);
        contentPane.add(label);
        demarrer.setSize(150,40);
        demarrer.setLocation(500, 150);
        demarrer.setBackground(Color.LIGHT_GRAY);
        
        int tailleCase = 100;
        tuiles(tailleCase);
	    
        credit.setSize(150,40);
        credit.setLocation(500, 200);
        credit.setBackground(Color.LIGHT_GRAY);
	}
	public String texte() {

		return "<html><center>Bienvenue dans notre 2048 Perso"
				+ "<br>en JAVA !"
				+ "<br>© Tristan Pestiaux"
				+ "<br> Robin Paquet"
				+ "<br> Ludo Van Den Dorpe</center></html>";
	}
	
public static void main(String[] args) {
		
		new Interface();
		System.out.println("Bienvenue dans notre 2048 Perso en JAVA !\n"
				+ " ©Tristan Pestiaux\n"
				+ "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "Appuyer sur le pavé numérique pour démarrer !");

	}

}
