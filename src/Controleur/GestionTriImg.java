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
		
		for(int i = 0; i < lst.choixImg.size() ; i++) {
		
			if(lst.tailleImg(m, i).contains(taille) == false) {
			
				lst.choixImg.remove(i);
			
			}
		
		}
		
	}
	
	public List<ImageModel> choixTitre(MainModel m, GestionImg lst, String titre) {
		
		for(int i = 0; i < lst.choixImg.size() ; i++) {
			
			lst.choixImg.clear();
			
		
		}
		
		return lst.choixImg;
	
	}
	
	public void choixTag(MainModel m, GestionImg lst, String tag) {
		
		for(int i = 0; i < lst.choixImg.size() ; i++) {
			
			if(lst.tagImg(m, i).contains(tag) == false) {
				
				lst.choixImg.remove(i);
			
			}
		
		}
		
	}

}
