package main;

import java.awt.EventQueue;

import controller.Controller2048;
import model.Plateau;
import view.VueConsole2048;
import view.VueGUI2048;

public class Main2048 extends Thread {

	public Main2048(String s) {
		super(s);
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
			
			@Override
			public void run() {
				Main2048 a = new Main2048("Joueur 1");
				Main2048 b = new Main2048("Joueur 2");
				a.start();
				b.start();				
			}
		});	
	}
}
