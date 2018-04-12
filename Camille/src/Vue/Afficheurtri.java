package Vue;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import Controleur.GestionImg;
import Modele.ImageModel;
import Modele.MainModel;


public class Afficheurtri extends Panel implements ActionListener, ItemListener, TextListener {

	TextField rat ;
	Choice taille = new Choice();
	Choice titre = new Choice();
	Choice tag = new Choice();
	Choice sup= new Choice();

	String[] choixTaille = {"Grande","Moyenne", "Petite", "Supérieure à ","Inférieure à "};
	List<String> choixTitre;
	List<String> choixTag;
	HashSet<Taille>  h =  new HashSet<Taille>();

	ImageModel modl;
	GestionImg mm;


	public Afficheurtri () throws IOException{

		this.modl = new ImageModel();
		this.mm = new GestionImg();

		Panel p = new Panel();
		BoxLayout layout = new BoxLayout(p,BoxLayout.PAGE_AXIS);
		p.setLayout(layout);
		layout.preferredLayoutSize(p);
		p.setPreferredSize(new Dimension(300,800));

		JButton precedent = new JButton();
		precedent.setBounds(250,550 , 150, 50);
		precedent.setText("precedent");

		rat = new TextField();



		/*for(int j=0;j<m.titre.length();j++){
				if (m.getTitre().contains((CharSequence) titre)){
					titre.add(m.getTitre());
				}
			}

			for(int k=0;k<m.lst_tags.size();k++){
				if (m.lst_tags.contains(tag)){
					tag.add(m.lst_tags.get(k));
				}
			}*/

		if (mm.choixImg==null){
			System.out.println("pas d'images");
		}
		else{
			for (ImageModel img : mm.choixImg){
				int largeur=img.image.getWidth();
				int longueur=img.image.getHeight();
				h.add(new Taille(largeur,longueur));
			}

			Iterator<Taille> it = this.h.iterator();
			while (it.hasNext()) {
				sup.add(it.next().toString());
			}

			taille.add(choixTaille[0]);
			taille.add(choixTaille[1]);
			taille.add(choixTaille[2]);
			taille.add(choixTaille[3] + sup);
			taille.add(choixTaille[4] + sup);


			p.add(taille);
			p.add(Box.createVerticalStrut(50));
			p.add(rat);
			p.add(sup);
			p.add(titre);
			p.add(tag);

			p.add(precedent);

			for( ImageModel img : mm.choixImg) {
				titre.add(img.getTitre());
				List<String> choixTag = img.getTags();
			}

			this.add(p);

			precedent.addActionListener(this);
			taille.addItemListener(this);
			rat.addTextListener(this);
			sup.addItemListener(this);
			titre.addItemListener(this);
			tag.addItemListener(this);

		}
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void textValueChanged(TextEvent e) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void itemStateChanged(ItemEvent e) {
		// TODO Auto-generated method stub
		
	}

}
