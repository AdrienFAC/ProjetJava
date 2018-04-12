package Vue;

import java.awt.List;
import java.util.ArrayList;

public class Taille {

	public int largeur;
	public int longueur;
	
	
	public Taille (int t, int g){
		this.largeur =t;
		this.longueur=g;
		
		
		
	}
	
	public String toString() {
		return String.valueOf(largeur) + " x " + String.valueOf(longueur);
		
	}
	
	@Override
	public int hashCode() {
		return this.largeur+this.longueur;
	}
	
	@Override
	public boolean equals(Object o) {
		Taille t = (Taille)o;
		return t.largeur==this.largeur && t.longueur==this.longueur;
	}


}		
