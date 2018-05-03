package Controleur;

import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionNote {
	
	GestionImg g = null ;
	MainModel mold = null;
	GestionChangementImg im = null;
	
	public GestionNote(GestionImg ges) {
		
		this.g = ges;
		this.mold = this.g.mold;
		//this.im = imChange;
	
	}
	
	public void ChangeNote( int n ) {
		
		this.mold.lst_images.get(this.g.indexActu).setNote(n);
		
	}
	
	
}
