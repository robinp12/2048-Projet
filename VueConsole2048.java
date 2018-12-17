package view;

import java.util.Observable;
import java.util.Observer;


import controller.Controller2048;
import model.Plateau;

public class VueConsole2048 extends Vue2048 implements Observer{
	
	public VueConsole2048(Plateau model, Controller2048 controller) {
		super(model, controller);
		update(null, null);
		}
	@Override
	public void update(Observable o, Object arg) {
		affiche();
		
		
	}

	
	
	@Override
	public void affiche() {
		Object affi = "";
		 boolean estGagner = false;
		 boolean estPerdu = false;
		if(!controller.estBloquer()) {
			int i;
			for (i = 0; i < model.getDimension(); i++) {
				for(int e = 0; e < model.getDimension(); e++) {
					if(model.getTableau(i, e) == 128) {
						estGagner = true;
					}
				}
				for(int a = 0; a < model.getDimension(); a++) {
					affi += model.getTableau(i, a) + "\t";
				}
				affi += "\n";
				
			}
		}else {
			int compteur = 0;
			int compteur2 = 0;
			
			for(int i = 0; i < model.getDimension(); i++) {
				for(int e = 0; e < model.getDimension(); e++) {
					if(model.getTableau(i, e) == 128) {
						estGagner = true;
						
						model.setEstBloquer(true);

					}
					if(model.getTableau(i, e) != 0) {
							compteur++;
						}
					}
				}
			if(compteur == Math.pow(model.getDimension(), 2)) {
			
				for(int i = 0; i < model.getDimension()-1; i++) {
					for(int e = 0; e < model.getDimension(); e++) {
						if(model.getTableau(i, e) != model.getTableau(i+1, e)) {
							compteur2++;	//max grandeur * grandeur-1			
						}
					}
				}
				for(int e = 0; e < model.getDimension()-1; e++) {
					for(int i = 0; i < model.getDimension(); i++) {
						if(model.getTableau(i, e) != model.getTableau(i, e+1)) {
							compteur2++;	//max grandeur * grandeur-1			
						}
					}
				}
			}
			
			
			
			if(compteur2 == 2*model.getDimension()*(model.getDimension()-1)) {
				estPerdu = true;
				model.setEstBloquer(true);

			}
		}
		if(estGagner) {
			System.out.println("score : " + model.getScore() + "\n");
			System.out.println("GagnÃ© !");
		}else if(estPerdu) {
			System.out.println("score : " + model.getScore() + "\n");
			System.out.println("Perdu !\n appuyer sur enter pour redémarrer");
		}else {
		System.out.println("score : " + model.getScore() + "\n");
		System.out.println(affi);
		}
	}
	


}
