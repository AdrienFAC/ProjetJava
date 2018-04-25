package Controleur;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Modele.ImageModel;
import Modele.MainModel;

public class GestionTriImg {

	List<Modele.ImageModel> lst_actu;
	List<Modele.ImageModel> lst_tri;

	public GestionTriImg(MainModel lst) throws IOException {

		this.lst_actu = lst.lst_images;
		this.lst_tri = new ArrayList<>();

	}
	
	public List<ImageModel> choixCouleur(Color couleur){
		
		for(int i = 0; i < this.lst_actu.size() ; i++) {
			
			if(lst_actu.get(i).FindColor(couleur)) {
				
				this.lst_tri.add(this.lst_actu.get(i));
			}
		}
		
		return this.lst_tri;
	}

	public List<ImageModel> choixTaille( String taille) {


		for(int i = 0; i < this.lst_actu.size() ; i++) {

			if(this.lst_actu.get(i).taille.equals(taille)) {

				this.lst_tri.add(this.lst_actu.get(i));

			}

		}
		
		return this.lst_tri;

	}

	public List<ImageModel> choixTitre( String t) {


		for(int i = 0; i < this.lst_actu.size() ; i++) {


			if(this.lst_actu.get(i).getTitre().contains(t)) {

				this.lst_tri.add(this.lst_actu.get(i));

			}	

		}	

		return this.lst_tri;
	}

	public List<ImageModel> choixTag( String tag) {

		for(int i = 0; i < this.lst_actu.size() ; i++) {

			if(this.lst_actu.get(i).getTags().contains(tag)) {

				this.lst_tri.add(this.lst_actu.get(i));

			}

		}
		
		return this.lst_tri;

	}

	public List<ImageModel> choixNote( int n) {

		for(int i = 0; i < this.lst_actu.size() ; i++) {
			
			if(this.lst_actu.get(i).getNote() == n) 

				this.lst_tri.add(this.lst_actu.get(i));

		}
		
		return this.lst_tri;
	}
	
}

