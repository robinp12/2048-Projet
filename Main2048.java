package main;

import controller.Controller2048;
import model.Plateau;
import view.VueGUI2048;
import view.VueConsole2048;

public class Main2048 {
	public Main2048() {
		Plateau modele = new Plateau();

		Controller2048 controleurConsole = new Controller2048(modele);
		Controller2048 controleurGui = new Controller2048(modele);
		
		VueConsole2048 vueConsole = new VueConsole2048(modele,controleurConsole);
		VueGUI2048 vueGui = new VueGUI2048(modele,controleurConsole);
		
		controleurConsole.addView(vueConsole);
		controleurGui.addView(vueGui);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new Main2048();
			}
		});
	}

}
