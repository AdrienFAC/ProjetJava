package Controleur;

import java.io.IOException;
import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;
import Vue.AfficheurImage;
import Vue.GestionGr;

public class GestionImg {

	public List<Modele.ImageModel> choixImg;
	GestionGr imgActu;
	ImageModel m;
	MainModel lst;
	String titre;
	int index;


	public GestionImg() throws IOException {

		this.lst  = new MainModel();
		this.choixImg = lst.lst_images;

	}


	public int indexOfImg() {

		this.titre = this.imgActu.img.replaceAll("imges/", "");
		this.titre = this.imgActu.img.replaceAll(".jpg", "");
		return lst.IsPresentInList(this.choixImg, this.titre);

	}

	public String nameImg(int i) {

		return lst.IsPresentInList(this.choixImg, i);

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

	public List<String> tagImg(int i) {

		return this.choixImg.get(i).lst_tags;

	}

	public void changeImg(String t) {

		this.titre = "images/" + t + ".jpg";
		imgActu.img = this.titre ;

	}


}
