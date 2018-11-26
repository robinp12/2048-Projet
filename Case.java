package jeu;

import java.util.Random;

public class Case {
	private int valeur = 0;
	
	public Case(int valeur) {
		
	}
	public int random() {
		Random r = new Random();
        int n = r.nextInt(2);
        if(n == 1) {
        	n = 2;
        }
        else if( n == 0){
        	n = 4;
        }
       return n;
	}	
	public void multiplication() {
		Math.pow(valeur,2);
	}
	public void division() {
		Math.pow(valeur,1/2);
	}

}
