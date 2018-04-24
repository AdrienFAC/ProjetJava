package Controleur;

import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionNote {
	
	MainModel modele = null ;
	GestionChangementImg im = null;
	
	public GestionNote(MainModel mold, GestionChangementImg imChange) {
		
		this.modele = mold;
		this.im = imChange;
	
	}
	
	public void ChangeNote( int n ) {
		
		int i = this.im.indexImg;
		this.modele.lst_images.get(i).setNote(n);
		
		System.out.println(this.modele.lst_images.get(i).getNote());
	}
	
	
}
