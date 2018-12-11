package jeu;


public abstract class Joueur {
	/*
	 * private int id; private float timer; private int score;
	 */
	
	protected int score = 0;

	protected boolean estBloquer = true;
	int grandeur = 4;
	protected int[][] tableau = new int[grandeur][grandeur];
	


	public Joueur() {

	}
	public int getScore() {
		return score;
	}




	public int multiplication(int valeur) {
		score += valeur * 10;
		return valeur * 2;
	}

	public int division(int valeur) {
		return valeur / 2;
	}

	public void deplacement(String choix) {
		estBloquer = true;
		int ligne;
		int colonne;
		int c = 0;
		boolean[] changement = { false, false, false, false, false, false, false, false, false, false };
		switch (choix) {
		case "H":
			while (c < grandeur -1) {
				for (colonne = 0; colonne < grandeur; colonne++) {
					for (ligne = 1; ligne < grandeur; ligne++) {
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

			while (c < grandeur-1) {
				for (colonne = 0; colonne < grandeur; colonne++) {
					for (ligne = grandeur-2; ligne >= 0; ligne--) {
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

			while (c < grandeur-1) {
				for (ligne = 0; ligne < grandeur; ligne++) {
					for (colonne = 1; colonne < grandeur; colonne++) {
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

			while (c < grandeur-1) {
				for (ligne = 0; ligne < grandeur; ligne++) {
					for (colonne = grandeur-2; colonne >= 0; colonne--) {
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
	}
}
