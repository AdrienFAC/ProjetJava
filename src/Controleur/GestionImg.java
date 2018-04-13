package Controleur;

import java.io.IOException;
import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionImg {

	public List<Modele.ImageModel> choixImg;
	String titre;


	public GestionImg(MainModel lst) throws IOException {
		
		this.choixImg = lst.lst_images;
		
	}


	public int indexOfImg(MainModel lst , AfficheurImage imgActu) {

		this.titre = imgActu.im_default.replaceAll("imges/", "");
		this.titre = imgActu.im_default.replaceAll(".jpg", "");
		return lst.IsPresentInList(this.choixImg, this.titre);

	}

	public String nameImg(MainModel lst, int i) {

		return lst.IsPresentInList(this.choixImg, i);

	}

	public String tailleImg(MainModel lst, int i) {

		if (this.choixImg.get(i).taille.width >= 4000) {

			return "Grande";

		}

		if(this.choixImg.get(i).taille.width >= 1000 ) {

			return "Moyen";

		}

		return "Petit";

	}

	public List<String> tagImg(MainModel lst , int i) {

		return this.choixImg.get(i).lst_tags;

	}

	public void changeImg(MainModel lst, AfficheurImage imgActu,  String t) {

		this.titre = "images/" + t + ".jpg";
		imgActu.im_default = this.titre ;

	}


}
