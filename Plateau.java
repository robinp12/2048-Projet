package model;

import java.util.Observable;
import java.util.Random;


public class Plateau extends Observable {
	protected int score = 0;
	protected boolean estBloquer = true;	
	protected int dimension = 4;
	protected int[][] tableau = new int[10][10];

	public Plateau() {
	}

	public int getScore() {
		return score;
	}

	public void setDimension(int x) {
		dimension = x;
		/*setChanged();
		notifyObservers();*/

	}

	public int getDimension() {
		return dimension;
	}

	public boolean getEstBloquer() {
		return estBloquer;
	}

	public void setEstBloquer(boolean x) {
		estBloquer = x;
		setChanged();
		notifyObservers();
	}

	public int getTableau(int i, int e) {
		return tableau[i][e];
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
		setChanged();
		notifyObservers();
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
