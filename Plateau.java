package model;

import java.util.Observable;
import java.util.Random;


public class Plateau extends Observable {
	protected int score = 0;
	protected boolean estBloquer;	
	protected int dimension = 4;
	protected int[][] tableau = new int[10][10];

	public Plateau() {
	}
	/*
	 * Retourne le score du joueur
	 * @return le score du joueur
	 */
	public int getScore() {
		return score;
	}
	/*
	 * Mise à jour de la dimension du tableau
	 * @param x la nouvelle dimension du tableau
	 */
	public void setDimension(int x) {
		dimension = x;

	}
	/*
	 * Retourne la dimension du tableau
	 * @return la dimension du tableau
	 */
	public int getDimension() {
		return dimension;
	}
	/*
	 * Retourne le fait que le jeu soit bloqué ou non
	 * @return estBloquer
	 */
	public boolean getEstBloquer() {
		return estBloquer;
	}


	/*
	 * Retourne la valeur de la case demandée
	 * @param la ligne et la colonne de la case souhaitée
	 * @return la valeur de la case aux indices donnés
	 */
	public int getTableau(int i, int e) {
		return tableau[i][e];
	}

	/*
	 * Multiplie la valeur de la case entrée par 2
	 * Addition du score
	 * @return valeur multipliée par 2
	 */
	public int multiplication(int valeur) {
		score += valeur * 10;
		return valeur * 2;
	}
	/*
	 * Fait le déplacement souhaité par le joueur
	 * @param le choix de déplacement du joueur (bas, gauche, haut ou droite)
	 */
	public void deplacement(String choix) {
		estBloquer = true;
		int ligne;
		int colonne;
		int c = 0;
		boolean[] changement = { false, false, false, false, false, false, false, false, false, false };
		switch (choix) {
		case "H":
			while (c < dimension - 1) {
				for (colonne = 0; colonne < dimension; colonne++) {
					for (ligne = 1; ligne < dimension; ligne++) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne - 1][colonne] == 0) {
								tableau[ligne - 1][colonne] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;

							} else if (tableau[ligne][colonne] == tableau[ligne - 1][colonne] && !changement[colonne]) {

								tableau[ligne - 1][colonne] = multiplication(tableau[ligne - 1][colonne]);
								tableau[ligne][colonne] = 0;
								changement[colonne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;

		case "B":

			while (c < dimension - 1) {
				for (colonne = 0; colonne < dimension; colonne++) {
					for (ligne = dimension - 2; ligne >= 0; ligne--) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne + 1][colonne] == 0) {
								tableau[ligne + 1][colonne] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;
							} else if (tableau[ligne][colonne] == tableau[ligne + 1][colonne] && !changement[colonne]) {
								tableau[ligne + 1][colonne] = multiplication(tableau[ligne + 1][colonne]);
								tableau[ligne][colonne] = 0;
								changement[colonne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;
		case "G":

			while (c < dimension - 1) {
				for (ligne = 0; ligne < dimension; ligne++) {
					for (colonne = 1; colonne < dimension; colonne++) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne][colonne - 1] == 0) {
								tableau[ligne][colonne - 1] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;

							} else if (tableau[ligne][colonne] == tableau[ligne][colonne - 1] && !changement[ligne]) {
								tableau[ligne][colonne - 1] = multiplication(tableau[ligne][colonne - 1]);
								tableau[ligne][colonne] = 0;
								changement[ligne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;
		case "D":

			while (c < dimension - 1) {
				for (ligne = 0; ligne < dimension; ligne++) {
					for (colonne = dimension - 2; colonne >= 0; colonne--) {
						if (tableau[ligne][colonne] != 0) {
							if (tableau[ligne][colonne + 1] == 0) {
								tableau[ligne][colonne + 1] = tableau[ligne][colonne];
								tableau[ligne][colonne] = 0;
								estBloquer = false;

							} else if (tableau[ligne][colonne] == tableau[ligne][colonne + 1] && !changement[ligne]) {
								tableau[ligne][colonne + 1] = multiplication(tableau[ligne][colonne + 1]);
								tableau[ligne][colonne] = 0;
								changement[ligne] = true;
								estBloquer = false;

							}

						}
					}

				}
				c++;
			}
			break;
		}
		ajouterAleatoire();
		setChanged();
		notifyObservers();

	}
/*
 * Generation du chiffre 2 ou 4
 * @return nombre aleatoire généré  
 */
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
/*
 * Initialisation de toutes les cases a 0.
 * @param les dimension du tableau
 */
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
		setChanged();
		notifyObservers();
	}
	/*
	 * Ajout d'un nombre aleatoire
	 */
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
