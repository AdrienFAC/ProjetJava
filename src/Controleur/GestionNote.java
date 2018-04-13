package Controleur;

import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionNote {
	
	MainModel modele;
	int notation ; 
	
	public GestionNote(MainModel mold) {
		
		this.modele = mold;
	
	}
	
	public void ChangeNote( int n, AfficheurImage img ) {
		
		int index = 0;
		
		while(index < this.modele.lst_images.size()) {
			
			if(this.modele.lst_images.get(index).titre.contains(img.im_default)) {
				
				this.notation = n ;
				
			} else {
				
				this.notation = this.modele.lst_images.get(index).note ;
				
			}
			
		}
		
		this.modele.lst_images.get(index).note = this.notation ;
		
	}
	
	
}
