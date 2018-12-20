package controller;

import javax.swing.JPanel;

import model.Plateau;
import view.Vue2048;

public class Controller2048 {

	Plateau model;
	Vue2048 vue;
	private boolean estDemarrer = false;

	public Controller2048(Plateau model) {
		this.model = model;
	}

	public boolean estBloquer() {
		return model.getEstBloquer();

	}

	public void addView(Vue2048 vue) {
		this.vue = vue;

	}

	public void viderTableau(JPanel tableau[][]) {
		for (int i = 0; i < model.getDimension(); i++) {
			for (int e = 0; e < model.getDimension(); e++) {
				tableau[i][e].setVisible(false);
			}
		}
	}

	public boolean estGagner() {
		for (int i = 0; i < model.getDimension(); i++) {
			for (int e = 0; e < model.getDimension(); e++) {
				if (model.getTableau(i, e) == 128) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean estPerdu() {
		int compteur = 0;
		int compteur2 = 0;

		for (int i = 0; i < model.getDimension(); i++) {
			for (int e = 0; e < model.getDimension(); e++) {

				if (model.getTableau(i, e) != 0) {
					compteur++;
				}
			}
		}
		if (compteur == Math.pow(model.getDimension(), 2)) {

			for (int i = 0; i < model.getDimension() - 1; i++) {
				for (int e = 0; e < model.getDimension(); e++) {
					if (model.getTableau(i, e) != model.getTableau(i + 1, e)) {
						compteur2++; // max grandeur * grandeur-1
					}
				}
			}
			for (int e = 0; e < model.getDimension() - 1; e++) {
				for (int i = 0; i < model.getDimension(); i++) {
					if (model.getTableau(i, e) != model.getTableau(i, e + 1)) {
						compteur2++; // max grandeur * grandeur-1
					}
				}
			}
		}
		if (compteur2 == 2 * model.getDimension() * (model.getDimension() - 1)) {
			return true;
		}else {
			return false;
		}
	}
	
	public void setEstDemarrer(boolean x) {
		estDemarrer = x;
	}
	public boolean getEstDemarrer() {
		return estDemarrer;
	}
}
