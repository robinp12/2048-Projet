package jeu;

public class Main {

	public static void main(String[] args) {
		Joueur joueur1 = new Joueur();
		joueur1.initialisation();
		joueur1.affichageTableau();
		System.out.println("Haut");
		joueur1.deplacement("H");
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		System.out.println("Bas");
		joueur1.deplacement("B");
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		System.out.println("Gauche");
		joueur1.deplacement("G");
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		System.out.println("Droite");
		joueur1.deplacement("D");
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		

	}

}
