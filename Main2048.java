package main;

import controller.Controller2048;
import model.Plateau;
import view.VueGUI2048;
import view.VueConsole2048;
import java.lang.Runnable;

public class Main2048 extends Thread {

	public synchronized void run() {

		Plateau modele = new Plateau();

		{

			Controller2048 controleurConsole = new Controller2048(modele);
			Controller2048 controleurGui = new Controller2048(modele);

			VueConsole2048 vueConsole = new VueConsole2048(modele, controleurConsole);
			VueGUI2048 vueGui = new VueGUI2048(modele, controleurConsole);

			controleurConsole.addView(vueConsole);
			controleurGui.addView(vueGui);
		}
	}

	public static void main(String[] args) {

		Main2048 a = new Main2048();

		/*
		 * This thread will pause for 1000 milliseconds after printing each number.
		 */

		Main2048 b = new Main2048();

		a.start();
		System.out.println("Joueur1");
		b.run();
		System.out.println("Joueur2");

	}

}
