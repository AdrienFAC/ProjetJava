package Vue;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Dimension;
import java.util.List;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import Controleur.GestionImg;
import Controleur.GestionTriImg;
import Modele.ImageModel;
import Modele.MainModel;


public class Afficheurtri extends Panel implements ActionListener, ItemListener, TextListener   {

	Choice couleur= new Choice();
	Choice taille = new Choice();
	Choice tit = new Choice();
	Choice tag = new Choice();
	Choice sup= new Choice();
	Choice not = new Choice();
	HashSet<Taille>  h =  new HashSet<Taille>();
	HashSet<Note>  k =  new HashSet<Note>();
	String [] col ={"bleu","rouge","vert","jaune","violet","rose","marron","orange","magenta","cyan","noir"};
	GestionImg mm = null;
	GestionTriImg im = null;
	MainModel mold = null;
	Afficherliste list = null;
	AfficheurImage imDef = null;
	ImageModel imm = null;


	public Afficheurtri(ImageModel m , MainModel g, GestionImg ges, GestionTriImg tri, Afficherliste l, AfficheurImage def){
		
		this.mold = g;
		this.im = tri;
		this.mm = ges;
		this.list = l;
		this.imDef = def;
		this.imm = m; 
		

		Panel p = new Panel();
		BoxLayout layout = new BoxLayout(p,BoxLayout.PAGE_AXIS);
		p.setLayout(layout);
		layout.preferredLayoutSize(p);
		p.setPreferredSize(new Dimension(300,600));

		JButton precedent = new JButton();
		precedent.setBounds(250,550 , 150, 50);
		precedent.setText("precedent");

		g.lst_images.get(1).addImageTag("#bretagne");
		g.lst_images.get(1).addImageTag("#mer");
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
			tit.add(titre);
		}

		for (ImageModel img : g.lst_images){
			for (String str : img.lst_tags){
				tag.add(str.toString());
			}
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
			for (int i =0;i<10;i++){
				couleur.add(col[i]);
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

			precedent.addActionListener(this);
			taille.addItemListener(this);
			sup.addItemListener(this);
			tit.addItemListener(this);
			tag.addItemListener(this);



		}
	}
	


	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void itemStateChanged(ItemEvent item) {
		
		String select = (String) item.getItem();
		if(tit.getSelectedItem().equals(select)) {
			im.choixTitre(mold, mm, tit.getSelectedItem());
			String name = "images/"+tit.getSelectedItem()+".jpg";
			this.list.removeAll();
			this.list.affiche(this.im.lst_triee);
			imDef.im_default = name;
			imDef = new AfficheurImage(imm);
		}
		if(couleur.getSelectedItem().equals(select)) {
			System.out.println("couleur");
		}
		if(taille.getSelectedItem().equals(select)) {
			System.out.println("taille");
		}
		if(tag.getSelectedItem().equals(select)) {
			System.out.println("tag");
		}
		if(not.getSelectedItem().equals(select)) {
			System.out.println("note");
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

	}
}
