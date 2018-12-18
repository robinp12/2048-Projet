package controller;

import javax.swing.JPanel;

import model.Plateau;
import view.Vue2048;

public class Controller2048 {

	Plateau model; 
	Vue2048 vue;
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
		for(int i = 0; i < model.getDimension(); i++) {
			for(int e = 0; e < model.getDimension(); e++) {
				tableau[i][e].setVisible(false);
			}
		}
	}
}
