package jeu;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

//pour robin

package tp7.controller;

import tp7.model.Bibliotheque;
import tp7.view.BibliothequeVue;

public class BibliothequeController {
	Bibliotheque model; 
	BibliothequeVue vue;
	public BibliothequeController(Bibliotheque model) {
		this.model = model;
	}


	public void emprunteLivre(int numLivre) {
	
		//TODO 
		if(numLivre < 0 || numLivre > 10) {
			this.vue.affiche(String.format("livre %s inconnu", numLivre));
		}
		else {
			if(this.model.emprunte(numLivre)) {
				this.vue.affiche("ok emprunt " + numLivre);
				//this.vue.affiche(model.toString()):
			}
			else {
				this.vue.affiche("kaput emprunt " + numLivre);
				//this.vue.affiche(model.toString());
			}
		}
	}

	public void rendreLivre(int numLivre) {
		//TODO
		if(numLivre < 0 || numLivre > 10) {
			this.vue.affiche(String.format("livre %s inconnu", numLivre));
		
		}
		else
		{
			this.model.rendre(numLivre);
			this.vue.affiche(String.format("livre %s disponible", numLivre));
		}
	}


	public void addView(BibliothequeVue vue) {
		this.vue = vue;
		
	}

}

