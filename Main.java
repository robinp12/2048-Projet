package jeu;

public class Main {

	public static void main(String[] args) {
		Joueur joueur1 = new Joueur();
		joueur1.initialisation();
		joueur1.affichageTableau();
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		joueur1.ajouteRandom();
		joueur1.affichageTableau();
		joueur1.deplacement("H");
		joueur1.affichageTableau();
		
		
		


	}

}
