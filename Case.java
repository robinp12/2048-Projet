package jeu;

import java.util.Random;

public abstract class Case {

	protected int [][] tableau = new int [4][4];
	
	
	public Case() {
		
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
	public int multiplication(int valeur) {
		return valeur * 2;
	}
	public int division(int valeur) {
		return valeur/2;
	}
	
	public void deplacement(String choix) {
		
		int i;
		int e;
		int c;
		switch (choix)
		{
		case "H" : 
			boolean fin = true;
			c = 0;
			while(fin && c < 3) {
				for(e = 0; e < 4; e++) {
					for(i = 1; i < 4; i++) {
						if(tableau[i][e] != 0) 
								if(tableau[i-1][e] == 0) {
										tableau [i-1][e] = tableau[i][e];
										tableau[i][e] = 0;
								}else if(tableau[i][e] == tableau[i-1][e]) {
									
									tableau[i-1][e] = multiplication(tableau[i-1][e]);
									tableau[i][e] = 0;
									fin = false;
									
									
						}
					}
				}
				c++;
			}
			break;

		case "B" : 
			fin = true;
			c = 0;
			while(fin && c < 3) {
				for(e = 0; e < 4; e++) {
					for(i = 2; i >=0; i--) {
						if(tableau[i][e] != 0) 
								if(tableau[i+1][e] == 0) {
										tableau [i+1][e] = tableau[i][e];
										tableau[i][e] = 0;
								}else if(tableau[i][e] == tableau[i+1][e]) {
									
									tableau[i+1][e] = multiplication(tableau[i+1][e]);
									tableau[i][e] = 0;
									fin = false;
									
									
						}
					}
				}
				c++;
			}
			break;
		case "G" : 
			fin = true;
			c = 0;
			while(fin && c < 3) {
				for(i = 0; i < 4; i++) {
					for(e = 1; e < 4; e++) {
						if(tableau[i][e] != 0) 
								if(tableau[i][e-1] == 0) {
										tableau [i][e-1] = tableau[i][e];
										tableau[i][e] = 0;
								}else if(tableau[i][e] == tableau[i][e-1]) {
									
									tableau[i][e-1] = multiplication(tableau[i][e-1]);
									tableau[i][e] = 0;
									fin = false;
									
									
						}
					}
				}
				c++;
			}
			break;
		case "D" :
			fin = true;
			c = 0;
			while(fin && c < 3) {
				for(i = 0; i < 4; i++) {
					for(e = 2 ; e >= 0; e--) {
						if(tableau[i][e] != 0) 
								if(tableau[i][e+1] == 0) {
										tableau [i][e+1] = tableau[i][e];
										tableau[i][e] = 0;
								}else if(tableau[i][e] == tableau[i][e+1]) {
									
									tableau[i][e+1] = multiplication(tableau[i][e+1]);
									tableau[i][e] = 0;
									fin = false;
									
									
						}
					}
				}
				c++;
			}
			break;
		}
	}

}
