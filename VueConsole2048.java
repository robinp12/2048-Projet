package view;

import java.util.Observable;
import java.util.Observer;


import controller.Controller2048;
import model.Plateau;

public class VueConsole2048 extends Vue2048 implements Observer{
	boolean estGagner;
	
	public VueConsole2048(Plateau model, Controller2048 controller) {
		super(model, controller);
		//update(null, null);
		}
	@Override
	public void update(Observable o, Object arg) {
		affiche();
	}
	
	
	@Override
	public void affiche() {
		Object affi = "";
		if(!controller.estBloquer()) {
			for (int i = 0; i < model.getDimension(); i++) {
				for(int e = 0; e < model.getDimension(); e++) {
					affi += model.getTableau(i, e) + "\t";
				}
				affi += "\n";
				
			}
		}
		if(controller.estGagner()) {
			System.out.println("score : " + model.getScore() + "\n");
			System.out.println("Gagné !");
		}else if(controller.estPerdu()) {
			System.out.println("score : " + model.getScore() + "\n");
			System.out.println("Perdu !\n appuyer sur enter pour redémarrer");
		}else {
		if(model.getScore() > 0) System.out.println("score : " + model.getScore() + "\n");
		System.out.println(affi);
		}
	}
	


}
