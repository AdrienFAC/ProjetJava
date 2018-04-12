package Controleur;

import Modele.MainModel;
import Vue.GestionGr;

public class GestionNote {
	
	MainModel modele;
	GestionGr img;
	int notation ; 
	
	public GestionNote(MainModel mold) {
		
		this.modele = mold;
	
	}
	
	public void ChangeNote( int n ) {
		
		int index = 0;
		
		while(index < this.modele.lst_images.size()) {
			
			if(this.modele.lst_images.get(index).titre.contains(this.img.img)) {
				
				this.notation = n ;
				
			} else {
				
				this.notation = this.modele.lst_images.get(index).note ;
				
			}
			
		}
		
		this.modele.lst_images.get(index).note = this.notation ;
		
	}
	
	
}
