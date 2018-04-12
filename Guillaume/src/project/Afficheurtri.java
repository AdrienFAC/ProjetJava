package project;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;


public class Afficheurtri extends Panel  {

	Choice couleur= new Choice();
	Choice taille = new Choice();
	Choice tit = new Choice();
	Choice tag = new Choice();
	Choice sup= new Choice();
	Choice not = new Choice();
	HashSet<Taille>  h =  new HashSet<Taille>();
	HashSet<Note>  k =  new HashSet<Note>();



	public Afficheurtri(ImageModel m , MainModel g){

		Panel p = new Panel();
		BoxLayout layout = new BoxLayout(p,BoxLayout.PAGE_AXIS);
		p.setLayout(layout);
		layout.preferredLayoutSize(p);
		p.setPreferredSize(new Dimension(300,600));

		JButton precedent = new JButton();
		precedent.setBounds(250,550 , 150, 50);
		precedent.setText("precedent");

		for (ImageModel img : g.lst_images){
			Color coul = img.couleur;
			couleur.add(coul.toString());
			
		}
		
		for (ImageModel img : g.lst_images){
			int note = img.note;
			k.add(new Note(note));
		}
		Iterator<Note> t = this.k.iterator();
		while (t.hasNext()) {
			not.add(t.next().toString());
		}

		for (ImageModel img : g.lst_images){
			String titre = img.titre;
			String tt=titre.substring(45,titre.length());
			tit.add(tt);
			}
		
		for (ImageModel img : g.lst_images){
			java.util.List<String> ta = img.lst_tags;
			tag.add(ta.toString());
		}


		if (g.lst_images==null){
			System.out.println("pas d'images");
		}
		else{
			for (ImageModel img : g.lst_images){
				int largeur=img.image.getWidth();
				int longueur=img.image.getHeight();
				h.add(new Taille(largeur,longueur));
			}


			Iterator<Taille> it = this.h.iterator();
			while (it.hasNext()) {
				sup.add(it.next().toString());
			}

			taille.add("Grande");
			taille.add("Moyennes");
			taille.add("petit");
			taille.add("supérieur à");
			taille.add("égale à ");

			
			
			p.add(taille);
			p.add(couleur);
			p.add(sup);
			p.add(tit);
			p.add(tag);
			p.add(not);

			p.add(precedent);



			this.add(p);
	
	

		}
	}
}
