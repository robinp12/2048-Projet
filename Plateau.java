package jeu;

import java.util.Random;

public class Plateau extends Joueur {

	public Plateau() {

	}

	public void deplacement() {
		
	}
	
	public int generer2ou4() {
		Random r = new Random();
		int n = r.nextInt(2);
		if (n == 1) {
			n = 2;
		} else if (n == 0) {
			n = 4;
		}
		return n;
	}
	

	

	public void initialisation(int x) {
		setDimension(x);
		score = 0;
		estBloquer = false;
		int a;
		for (a = 0; a < dimension; a++) {
			int b;
			for (b = 0; b < dimension; b++) {
				tableau[a][b] = 0;
			}
		}
		ajouterAleatoire();
		affichageTableau();
	}

	public void affichageTableau() {
		Object affi = "";
		 boolean estGagner = false;
		 boolean estPerdu = false;
		if(!estBloquer) {
			int i;
			for (i = 0; i < dimension; i++) {
				for(int e = 0; e < dimension; e++) {
					if(tableau[i][e] == 128) {
						estGagner = true;
					}
				}
				for(int a = 0; a < dimension; a++) {
					affi += tableau[i][a] + "\t";
				}
				affi += "\n";
				
			}
		}else {
			int compteur = 0;
			int compteur2 = 0;
			
			for(int i = 0; i < dimension; i++) {
				for(int e = 0; e < dimension; e++) {
					if(tableau[i][e] == 128) {
						estGagner = true;
						
						estBloquer = true;

					}
					if(tableau[i][e] != 0) {
							compteur++;
						}
					}
				}
			if(compteur == Math.pow(dimension, 2)) {
			
				for(int i = 0; i < dimension-1; i++) {
					for(int e = 0; e < dimension; e++) {
						if(tableau[i][e] != tableau[i+1][e]) {
							compteur2++;	//max grandeur * grandeur-1			
						}
					}
				}
				for(int e = 0; e < dimension-1; e++) {
					for(int i = 0; i < dimension; i++) {
						if(tableau[i][e] != tableau[i][e+1]) {
							compteur2++;	//max grandeur * grandeur-1			
						}
					}
				}
			}
			
			
			
			if(compteur2 == 2*dimension*(dimension-1)) {
				estPerdu = true;
				estBloquer = true;

			}
		}
		if(estGagner) {
			System.out.println("score : " + score + "\n");
			System.out.println("Gagné !");
		}else if(estPerdu) {
			System.out.println("score : " + score + "\n");
			System.out.println("Perdu !\n appuyer sur enter pour redémarrer");
		}else {
		System.out.println("score : " + score + "\n");
		System.out.println(affi);
		}
	}
	public void ajouterAleatoire() {
		if (!estBloquer) {
			int i, e;
			do {
				Random r1 = new Random();
				i = r1.nextInt(dimension);
				Random r2 = new Random();
				e = r2.nextInt(dimension);
			} while (tableau[i][e] != 0);
			tableau[i][e] = generer2ou4();
		}

	}
}
