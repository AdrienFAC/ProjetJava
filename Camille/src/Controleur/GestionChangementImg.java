package Controleur;

import java.io.IOException;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;

public class GestionChangementImg  {
	
	GestionImg changementImg; 
	AfficheurImage imgActu;
	ImageModel img ;
	MainModel lst;
	int  suivant;
	int precedent;
	String titre;
	GestionImg listImg;
	
	public GestionChangementImg() throws IOException {
		
		this.listImg = new GestionImg();
		this.changementImg = listImg ; 
		
	}
	
	public void changeImgPrecedent() {
		System.out.println("coucou" );
		
		this.precedent = this.changementImg.indexOfImg() - 1;
		
		if (this.precedent < 0) {
			this.precedent = this.changementImg.choixImg.size() - 1;
		} else {
			this.precedent -= 1;
		}
		
		this.listImg.changeImg(this.changementImg.nameImg(this.precedent));
		
	}
	
	public void changeSuivant() {
		
		this.suivant = this.changementImg.indexOfImg() + 1;
		
		if (this.suivant == this.changementImg.choixImg.size() - 1) {
			this.suivant = 0;
		} else {
			this.suivant += 1;
		}
		
		this.listImg.changeImg(this.changementImg.nameImg(this.suivant));
		
	}
	
	
}
