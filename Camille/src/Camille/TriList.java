package Camille;

import java.util.List;

import Adrien.ImageModel;
import Adrien.MainModel;
import Guillaume.Afficheurtri;

public class TriList {

	public List<ImageModel> choixImg;
	Afficheurtri appli;


	public TriList(MainModel lst) {

		this.choixImg = lst.lst_images; 
	}

	public void choixTaille() {

		for(int i = 0; i < choixImg.size(); i++) {
			if(this.choixImg.get(i).taille.equals(appli.taille) == false) {
				this.choixImg.remove(i);
			}	
		}

	}

	public void choixTitre() {

		for(int i = 0; i < this.choixImg.size(); i++) {
			if(this.choixImg.get(i).titre.contains((CharSequence) appli.titre) == false ) {
				this.choixImg.remove(i);
			}
		}
	}

	public void choixTag() {
		for(int i = 0; i < this.choixImg.size(); i++) {
			if(this.choixImg.get(i).lst_tags.contains(appli.tag) == false) {
				this.choixImg.remove(i);
			}
		}
	}



}
