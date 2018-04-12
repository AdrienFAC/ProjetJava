package Controleur;

import java.io.IOException;
import java.util.List;

public class GestionTriImg {
	
	GestionImg lst;
	public List<Modele.ImageModel> lst_triee;
	
	public GestionTriImg() throws IOException {
		
		this.lst = new GestionImg();
		this.lst_triee = lst.choixImg;
		
	}
	
	public void choixTaille(String taille) {
		
		for(int i = 0; i < this.lst.choixImg.size() ; i++) {
		
			if(this.lst.tailleImg(i).contains(taille) == false) {
			
				this.lst.choixImg.remove(i);
			
			}
		
		}
		
	}
	
	public void choixTitre(String titre) {
		
		for(int i = 0; i < this.lst.choixImg.size() ; i++) {
			
			if(this.lst.nameImg(i).contains(titre) == false) {
			
				this.lst.choixImg.remove(i);
			
			}
		
		}
		
		//this.lst.changeImg(titre);
	
	}
	
	public void choixTag(String tag) {
		
		for(int i = 0; i < this.lst.choixImg.size() ; i++) {
			
			if(this.lst.tagImg(i).contains(tag) == false) {
				
				this.lst.choixImg.remove(i);
			
			}
		
		}
		
	}

}
