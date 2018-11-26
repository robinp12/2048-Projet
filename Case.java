package jeu;

public class Case {
	private int valeur;
	
	
	public Case(int valeur) {
		this.valeur = valeur;
	}
	
	public void multiplication() {
		Math.pow(valeur,2);
	}
	public void division() {
		Math.pow(valeur,1/2);
	}
	
}
