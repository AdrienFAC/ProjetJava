package Controleur;

import java.io.IOException;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionChangementImg  {
	 
	int  suivant;
	int precedent;
	GestionImg listImg;
	
	public GestionChangementImg(MainModel lst ) throws IOException {
		this.suivant = 4;
		this.precedent = 2;
	}
	
	public String nameImgPrecedent(GestionImg changementImg, MainModel lst, AfficheurImage img) {
		
		if (this.precedent == 0) {
			this.precedent = changementImg.choixImg.size() - 1;
		} else {
			this.precedent -= 1;
		}
		
		return "images/" + changementImg.nameImg(lst, this.precedent) +".jpg";
		
	}
	
	public String nameImgSuivant(GestionImg changementImg, MainModel lst, AfficheurImage img) {
		
		if (this.suivant == changementImg.choixImg.size()-1) {
			this.suivant = 0;
		} else {
			this.suivant += 1;
		}
		return "images/" + changementImg.nameImg(lst, this.suivant) +".jpg";		
	}
	
	
}
