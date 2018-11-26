package jeu;

import java.util.Random;

public class Joueur extends Case{
	private int id;
	private float timer;
	private int score;
	protected int [][] tableau = new int [4][4];
	
	
	public Joueur() {
		
	}
	
	public void deplacement() {
		
	}
	
	public void initialisation() {
		
		int a;
		for(a = 0; a < 4; a++) {
			int b;
			for(b = 0; b < 4; b++) {
				tableau[a][b] = 0;
			}
		}
		Random r1 = new Random();
        int i = r1.nextInt(4);
        Random r2 = new Random();
        int e = r2.nextInt(4);
        tableau[i][e] = super.random();
	}
	
	public void affichageTableau() {
		Object affi = "";
		int i;
		for(i = 0; i < 4; i++){
			affi += tableau[i][0]  +"\t"+ tableau[i][1] +"\t"+ tableau[i][2] +"\t"+ tableau[i][3] + "\n";
		}
	System.out.println(affi);
	}
	public void ajouteRandom() {
		int i,e;
		do {Random r1 = new Random();
        i = r1.nextInt(4);
        Random r2 = new Random();
        e = r2.nextInt(4);
        }while(tableau[i][e] != 0);
        tableau[i][e] = super.random();
		
	}
}
