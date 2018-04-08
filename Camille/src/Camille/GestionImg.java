package Camille;

import java.util.List;

import Adrien.ImageModel;
import Guillaume.AfficheurImage;
import Guillaume.Afficheurtri;

public class GestionImg  {
	
	public List<ImageModel> changementImg; 
	AfficheurImage imageActuelle;
	int  suivant;
	int precedent;
	
	public GestionImg(TriList listImg, Afficheurtri boutton ) {
		
		this.changementImg = (List<ImageModel>) listImg; 	
		suivant = changementImg.indexOf(imageActuelle.im_default) + 1;
		precedent = changementImg.indexOf(imageActuelle.im_default) - 1;
		
	}
	
	public int gestionSuivant() {
		
		if(suivant == changementImg.size()) {
			return  0;
		} else {
			return changementImg.indexOf(imageActuelle.im_default) + 1; 
		}
		
	}
	
	public void changeImgSuivant() {
		imageActuelle.im_default = "images/" + changementImg.get(suivant).titre + "jpg";
		suivant = gestionSuivant();
	}
	
	public int gestionPrecedent() {
		
		if(precedent == 0) {
			return  changementImg.size() - 1;
		} else {
			return changementImg.indexOf(imageActuelle.im_default) - 1; 
		}
		
	}
	
	public void changeImgPrecedent() {
		System.out.println("coucou" );
		//appli.im_default = "images/" +  changementImg.get(precedent).titre +".jpg";
		//precedent = gestionPrecedent();
	}
	
	
}
