package jeu;

import java.util.Random;

public class Joueur {
	private int id;
	private float timer;
	private int score;
	protected int [][] tableau = new int [4][4];
	
	
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
	
	
	

	public Joueur(int id, float timer, int score) {
		this.id = id;
		this.timer = timer;
		this.score = score;
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
        tableau[i][e] = random();
	}
	
	public void affichageTableau() {
		int i;
		for(i = 0; i < 4; i++){
				System.out.println(tableau[i][0]  +"	 "+ tableau[i][1] +" 	"+ tableau[i][2] +" 	"+ tableau[i][3]) ;
		}
	}
}
