package jeu;

public class Main {

	public static void main(String[] args) {
		
		new Deplacement("");
		System.out.println("Bienvenue dans notre 2048 Perso ! \n"
				+ " ©Tristan Pestiaux\n"
				+ "  Robin Paquet\n"
				+ "  Ludo Van Den Dorpe\n"
				+ "Appuyer sur le pavé numérique pour démarrer !");
		Joueur joueur1 = new Joueur();
		joueur1.initialisation();

	}

}
