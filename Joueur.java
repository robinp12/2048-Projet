package jeu;

import java.util.Random;

public class Joueur extends Case {
	/*
	 * private int id; private float timer; private int score;
	 */

	public Joueur() {
	}

	public void deplacement() {

	}

	public void initialisation() {
		estBloquer = false;
		int a;
		for (a = 0; a < 4; a++) {
			int b;
			for (b = 0; b < 4; b++) {
				tableau[a][b] = 0;
			}
		}
		ajouteRandom();
		affichageTableau();
	}

	public void affichageTableau() {
		Object affi = "";
		 boolean estGagner = false;
		 boolean estPerdu = false;
		if(!estBloquer) {
			int i;
			for (i = 0; i < 4; i++) {
				for(int e = 0; e < 4; e++) {
					if(tableau[i][e] == 64) {
						estGagner = true;
					}
				}
				
				affi += tableau[i][0] + "\t" + tableau[i][1] + "\t" + tableau[i][2] + "\t" + tableau[i][3] + "\n";
			}
		}else {
			int compteur = 0;
			int compteur2 = 0;
			
			for(int i = 0; i < 4; i++) {
				for(int e = 0; e < 4; e++) {
					if(tableau[i][e] == 64) {
						estGagner = true;
						estBloquer = true;

					}
					if(tableau[i][e] != 0) {
							compteur++;
						}
					}
				}
			if(compteur == 16) {
			
				for(int i = 0; i < 3; i++) {
					for(int e = 0; e < 4; e++) {
						if(tableau[i][e] != tableau[i+1][e]) {
							compteur2++;	//max 12			
						}
					}
				}
				for(int e = 0; e < 3; e++) {
					for(int i = 0; i < 4; i++) {
						if(tableau[i][e] != tableau[i][e+1]) {
							compteur2++;	//max 12			
						}
					}
				}
			}
			
			
			
			if(compteur2 == 24) {
				estPerdu = true;
				estBloquer = true;

			}
		}
		if(estGagner) {
			System.out.println("Gagné !");
		}else if(estPerdu) {
			System.out.println("Perdu !\n appuyer sur enter pour redémarrer");
		}else {
		System.out.println(affi);
		}
	}
	public void ajouteRandom() {
		if (!estBloquer) {
			int i, e;
			do {
				Random r1 = new Random();
				i = r1.nextInt(4);
				Random r2 = new Random();
				e = r2.nextInt(4);
			} while (tableau[i][e] != 0);
			tableau[i][e] = super.random();
		}

	}
}
