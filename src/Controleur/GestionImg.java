package Controleur;

import java.io.IOException;
import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionImg {

	public List<Modele.ImageModel> choixImg;
	public MainModel mold = null;
	public int indexActu;
	String titre;


	public GestionImg(MainModel lst) throws IOException {
		
		this.mold = lst;
		this.choixImg = lst.lst_images;
		this.indexActu = this.choixImg.size()/2;
		
	}


	public int indexOfImg(AfficheurImage imgActu) {

		this.titre = imgActu.im_default.replaceAll("imges/", "");
		this.titre = imgActu.im_default.replaceAll(".jpg", "");
		return this.mold.IsPresentInList(this.choixImg, this.titre);

	}

	public String nameImg(int i) {

		return this.mold.IsPresentInList(this.choixImg, i);

	}

	public String tailleImg(int i) {

		if (this.choixImg.get(i).taille.width >= 4000) {

			return "Grande";

		}

		if(this.choixImg.get(i).taille.width >= 1000 ) {

			return "Moyen";

		}

		return "Petit";

	}

	public List<String> tagImg( int i) {

		return this.choixImg.get(i).lst_tags;

	}

	public void changeImg( AfficheurImage imgActu,  String t) {

		this.titre = "images/" + t + ".jpg";
		imgActu.im_default = this.titre ;

	}


}
