package Controleur;

import java.io.IOException;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionChangementImg  {
	 
	int  suivant;
	int precedent;
	String titre;
	GestionImg listImg;
	
	public GestionChangementImg(MainModel lst ) throws IOException {
		
	}
	
	public void changeImgPrecedent(GestionImg changementImg, MainModel lst, AfficheurImage img) {
		System.out.println("coucou" );
		
		this.precedent = changementImg.indexOfImg(lst, img) - 1;
		
		if (this.precedent < 0) {
			this.precedent = changementImg.choixImg.size() - 1;
		} else {
			this.precedent -= 1;
		}
		
		this.listImg.changeImg(lst, img, changementImg.nameImg(lst, this.precedent));
		
	}
	
	public void changeSuivant(GestionImg changementImg, MainModel lst, AfficheurImage img) {
		
		this.suivant = changementImg.indexOfImg(lst, img) + 1;
		
		if (this.suivant == changementImg.choixImg.size() - 1) {
			this.suivant = 0;
		} else {
			this.suivant += 1;
		}
		
		this.listImg.changeImg(lst, img, changementImg.nameImg(lst, this.suivant));
		
	}
	
	
}
