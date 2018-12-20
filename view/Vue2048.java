package view;

import java.util.Observer;

import controller.Controller2048;
import model.Plateau;

public abstract class Vue2048 implements Observer{

	protected Plateau model;
	protected Controller2048 controller;
	
	public Vue2048(Plateau model, Controller2048 controller) {
		this.model = model;
		this.controller = controller;
		model.addObserver(this);
	}

	public abstract void affiche() ;
	
}
