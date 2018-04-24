package Controleur;

import java.io.IOException;
import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;

public class GestionTriImg {
	
	public List<Modele.ImageModel> lst_triee;
	
	public GestionTriImg(MainModel lst) throws IOException {
		
		this.lst_triee = lst.lst_images;
		
	}
	
	public void choixTaille(MainModel m, GestionImg lst, String taille) {
		
		this.lst_triee.clear();
		
		for(int i = 0; i < lst.choixImg.size() ; i++) {
		
			if(lst.tailleImg(m, i).contains(taille) == false) {
			
				lst.choixImg.remove(i);
			
			}
		
		}
		
	}
	
	public void choixTitre(MainModel m, GestionImg lst, String t) {
		
		this.lst_triee.clear();
		
		for(int i = 0; i < lst.choixImg.size() ; i++) {
			
			
			if(lst.choixImg.get(i).getTitre().contains(t)) {
				
				this.lst_triee.add(m.lst_images.get(i));
			
			}	
		
		}	
	
	}
	
	public void choixTag(MainModel m, GestionImg lst, String tag) {
		
		for(int i = 0; i < lst.choixImg.size() ; i++) {
			
			if(lst.tagImg(m, i).contains(tag) == false) {
				
				lst.choixImg.remove(i);
			
			}
		
		}
		
	}

}
