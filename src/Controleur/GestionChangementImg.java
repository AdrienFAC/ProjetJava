package Controleur;

import java.io.IOException;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionChangementImg  {

	public int  suivant;
	int precedent;
	public int indexImg;
	GestionImg listImg;

	public GestionChangementImg(MainModel lst ) throws IOException {
		this.suivant = 2;
		this.precedent = 2;
		this.indexImg = 2;
	}

	public void incrementation(GestionImg changementImg, boolean prece) {
		if(prece == true) {
			if (this.precedent == 0) {
				this.precedent = changementImg.choixImg.size() - 1;
				this.suivant = 0 ;
			} else {
				this.precedent--;
				this.suivant = this.precedent + 2;
				if(this.suivant > changementImg.choixImg.size() - 1 ) {
					this.suivant = 0 ;
				}
			}
			this.indexImg--;
			if(this.indexImg < 0) {
				this.indexImg = changementImg.choixImg.size()-1;
			}
			
		} else {
			if (this.suivant == changementImg.choixImg.size()-1) {
				this.suivant = 0;
				this.precedent = changementImg.choixImg.size()-1 ;
			} else {
				this.suivant ++;
				this.precedent = this.suivant - 2;
				if(this.precedent < 0) {
					this.precedent = changementImg.choixImg.size()-1;
				}
			}
			this.indexImg++;
			if(this.indexImg > changementImg.choixImg.size()-1) {
				this.indexImg = 0;
			}
		}
	}

	public String nameImgPrecedent(GestionImg changementImg, MainModel lst, AfficheurImage img) {


		this.incrementation(changementImg, true);
		return "images/" + changementImg.nameImg(lst, this.precedent) +".jpg";

	}

	public String nameImgSuivant(GestionImg changementImg, MainModel lst, AfficheurImage img) {

		this.incrementation(changementImg, false);
		return "images/" + changementImg.nameImg(lst, this.suivant) +".jpg";		
	}


}
