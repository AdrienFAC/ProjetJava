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
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;

import Controleur.GestionChangementImg;
import Controleur.GestionImg;
import Controleur.GestionTriImg;
import Modele.ImageModel;
import Modele.MainModel;


public class Afficheurtri extends Panel implements ActionListener, ItemListener  {

	Choice couleur= new Choice();
	Choice taille = new Choice();
	Choice tit = new Choice();
	Choice tag = new Choice();
	Choice sup= new Choice();
	Choice not = new Choice();
	HashSet<Taille>  h =  new HashSet<Taille>();
	HashSet<Note>  k =  new HashSet<Note>(); 
	String [] col ={"blue","red","green","yellow","pink","orange","magenta","cyan"};
	public GestionImg mm = null;
	GestionTriImg im = null;
	public MainModel mold = null;
	public Afficherliste list = null;
	public AfficheurImage imDef = null;
	ImageModel imm = null;
	GestionChangementImg chanIm = null;


	public Afficheurtri(AfficheurImage def, Afficherliste l, GestionImg ges, GestionTriImg tri, GestionChangementImg imChange){

		this.mold = def.main;
		this.imm = def.mold; 
		
		this.list = l;
		
		this.im = tri;
		this.mm = ges;
		this.imDef = def;
		this.imm = def.mold; 
		this.chanIm = imChange;


		Panel p = new Panel();
		BoxLayout layout = new BoxLayout(p,BoxLayout.PAGE_AXIS);
		p.setLayout(layout);
		layout.preferredLayoutSize(p);
		p.setPreferredSize(new Dimension(300,550));
		p.setBackground(new Color(153,153,153));

		JLabel rech = new JLabel();
		rech.setText("RECHERCHE");
		rech.setBorder(BorderFactory.createLineBorder(Color.white));

		JButton precedent = new JButton();
		precedent.setBounds(250,550 , 150, 50);
		precedent.setText("precedent");

		this.mold.lst_images.get(1).addImageTag("#bretagne");
		this.mold.lst_images.get(1).addImageTag("#mer");
		for (ImageModel img : this.mold.lst_images){
			int note = img.note;
			k.add(new Note(note));
		}
		Iterator<Note> t = this.k.iterator();
		while (t.hasNext()) {
			not.add(t.next().toString());
		}

		for (ImageModel img : this.mold.lst_images){
			String titre = img.titre;
			tit.add(titre);
		}

		for (ImageModel img : this.mold.lst_images){
			for (String str : img.lst_tags){
				tag.add(str.toString());
			}
		}


		if (this.mold.lst_images==null){
			System.out.println("pas d'images");
		}
		else{
			for (ImageModel img : this.mold.lst_images){
				int largeur=img.image.getWidth();
				int longueur=img.image.getHeight();
				h.add(new Taille(largeur,longueur));
			}


			Iterator<Taille> it = this.h.iterator();
			while (it.hasNext()) {
				sup.add(it.next().toString());
			}
			for (int i =0;i<8;i++){
				couleur.add(col[i]);
			}

			taille.add("Grande");
			taille.add("Moyennes");
			taille.add("petit");


			p.add(rech);
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
	public void itemStateChanged(ItemEvent item) {

		String select = (String) item.getItem();

		if(tit.getSelectedItem().equals(select)) {

			String name = "images/"+tit.getSelectedItem()+".jpg";
			imDef.im_default = name;
			imDef.changeImgDefault(name);
			System.out.println(this.mm.indexOfImg(imDef));
			
			
			
		}

		if(couleur.getSelectedItem().equals(select)) {
			/*String col = couleur.getSelectedItem();
			List<ImageModel> lst = im.choixCouleur(Color.col);
			if(lst.size() > 0) {
				String name = "images/"+lst.get(0).getTitre()+".jpg";
				imDef.changeImgDefault(name);
				this.list.affiche(lst, this.chanIm.indexImg);
			}*/
			
		}

		if(taille.getSelectedItem().equals(select)) {
			
			List<ImageModel> lst = im.choixTaille(taille.getSelectedItem());
			if(lst.size() > 0) {
				String name = "images/"+lst.get(0).getTitre()+".jpg";
				imDef.changeImgDefault(name);
				
			}
			this.list.indexAffiche = this.mm.indexActu + 1;
			this.list.changeList();
		}

		if(tag.getSelectedItem().equals(select)) {
			
			List<ImageModel> lst = im.choixTag(tag.getSelectedItem());
			if(lst.size() > 0) {
				String name = "images/"+lst.get(0).getTitre()+".jpg";
				imDef.changeImgDefault(name);
				
			}
			
		}

		if(not.getSelectedItem().equals(select)) {
			
			int note = this.mold.lst_images.get(this.mm.indexActu).getNote();
			List<ImageModel> lst = im.choixNote(note);
			if(lst.size() > 0) {
				String name = "images/"+lst.get(0).getTitre()+".jpg";
				imDef.changeImgDefault(name);
			}

		}

	}

	@Override
	public void actionPerformed(ActionEvent evt) {

		if(evt.getActionCommand() == "precedent") {
			String name = this.chanIm.nameImgPrecedent(mm, imDef);
			this.imDef.changeImgDefault(name);
			
			
		}
	}
}
