package jeu;

public class Joueur {
	private int id;
	private float timer;
	private int score;
	protected int[][] tableau = { 
			{1, 2, 3, 4},
			{5, 6, 7, 8},
			{9, 10, 11, 12},
			{13, 14, 15, 16}};
	
	
	public void affichageTableau() {
		int i;
		for(i = 0; i < 4; i++){
				System.out.println(tableau[i][0]  +"	 "+ tableau[i][1] +" 	"+ tableau[i][2] +" 	"+ tableau[i][3]) ;
		}
	}

	public Joueur(int id, float timer, int score) {
		this.id = id;
		this.timer = timer;
		this.score = score;
	}
	
	public void deplacement() {
		
	}
}
