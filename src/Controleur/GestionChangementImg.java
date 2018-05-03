package Controleur;

import java.io.IOException;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionChangementImg  {

	
	public int[] indexImg = null;
	MainModel mold = null;
	GestionImg g = null;

	public GestionChangementImg(GestionImg ges) throws IOException {
		
		this.g = ges;
		this.mold = this.g.mold;
		this.indexImg = new int[this.mold.lst_images.size()-1];
		for(int i = 0; i < this.mold.lst_images.size()-1;i++) {
			this.indexImg[i] = i;
		}
	}

	public void incrementation(boolean prece) {
		if(prece) {
			if(this.g.indexActu > this.indexImg[0]) {
				this.g.indexActu--;
			} else {
				this.g.indexActu = this.indexImg[this.indexImg.length-1];
			}
		} else {
			if(this.g.indexActu < this.indexImg[this.indexImg.length-1]) {
				this.g.indexActu++;
			} else {
				this.g.indexActu = this.indexImg[0];
			}
		}
		System.out.println(this.g.indexActu);
	}
	
	public String nameImgPrecedent(GestionImg changementImg, AfficheurImage img) {


		this.incrementation(true);
		return "images/" + changementImg.nameImg(this.g.indexActu) +".jpg";

	}
	
	public String nameImgSuivant(GestionImg changementImg, AfficheurImage img) {


		this.incrementation(false);
		return "images/" + changementImg.nameImg(this.g.indexActu) +".jpg";

	}



}
