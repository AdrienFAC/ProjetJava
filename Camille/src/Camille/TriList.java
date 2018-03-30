package Camille;

import java.util.List;

import Adrien.ImageModel;
import Adrien.MainModel;
import Guillaume.Afficheurtri;

public class TriList {
	
	public List<ImageModel> choixImg;
	
	public TriList(MainModel lst, Afficheurtri appli) {
		
		this.choixImg = lst.lst_images; 
		
		for(int i = 0; i < choixImg.size(); i++) {
			
			// Adaptation de la liste a la taille.
			if(choixImg.get(i).taille.equals(appli.taille) == false) {
				choixImg.remove(i);
			}
		
			// Aux titres
			if(choixImg.get(i).titre.equals(appli.titre) == false ) {
				choixImg.remove(i);
			}
			
			// Aux tags
				// Parcourt des tags de l'image.
			int j = 0;
			boolean estPresent = false;
			while(j < choixImg.get(i).lst_tags.size() && estPresent == false) {
				if(choixImg.get(i).lst_tags.get(j).equals(appli.tag)) { // regarde si le tag sélectionner est associé a l'image.
					estPresent = true;
				}
			}
				// Suppression de l'image si le tag n'est pas prèsent.
			if(estPresent == false) {
				choixImg.remove(i);
			}
			
		}
		
	}
	
	
	
	
}
