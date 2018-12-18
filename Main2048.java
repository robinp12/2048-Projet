package main;

import java.awt.EventQueue;

import controller.Controller2048;
import model.Plateau;
import view.VueConsole2048;
import view.VueGUI2048;

public class Main2048 implements Runnable {

	public synchronized void run() {

		Plateau modele = new Plateau();
		
		Controller2048 controleurConsole = new Controller2048(modele);
		Controller2048 controleurGui = new Controller2048(modele);

		VueConsole2048 vueConsole = new VueConsole2048(modele, controleurConsole);
		VueGUI2048 vueGui = new VueGUI2048(modele, controleurConsole);

		controleurConsole.addView(vueConsole);
		controleurGui.addView(vueGui);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

            public void run() {
            	Thread a = new Thread(new Main2048());
				Thread b = new Thread(new Main2048());
				/*
				 * This thread will pause for 1000 milliseconds after printing each number.
				 */
				a.run();
				b.run();
            }
		});
	}

}
