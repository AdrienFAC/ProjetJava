package project;

import java.awt.Choice;
import java.awt.Dimension;
import java.awt.Panel;
import java.awt.TextField;
import java.util.HashSet;
import java.util.Iterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;


public class Afficheurtri extends Panel  {

	TextField rat ;
	Choice taille = new Choice();
	Choice titre = new Choice();
	Choice tag = new Choice();
	Choice sup= new Choice();
	String[] t= {"400x300","640x480","800x600","1024x768","1600x1200","2272x1704","2816x2112","3264x2448","3648x2736","4096x3072","4480x3360","5120x3840","7216x5412","9600x7200"};
	HashSet<Taille>  h =  new HashSet<Taille>();



	public Afficheurtri(ImageModel m , MainModel g){

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
		if (g.lst_images==null){
			System.out.println("pas d'images");
		}
		else{
			for (ImageModel img : g.lst_images){
				int largeur=img.image.getWidth();
				int longueur=img.image.getHeight();
				h.add(new Taille(largeur,longueur));
			}

			System.out.println(h);

			Iterator<Taille> it = this.h.iterator();
			while (it.hasNext()) {
				sup.add(it.next().toString());
			}

			taille.add("Grande");
			taille.add("Moyennes");
			taille.add("petit");
			taille.add("supérieur à " + "sup");
			taille.add("égale à " + "sup");


			p.add(taille);
			p.add(Box.createVerticalStrut(50));
			p.add(rat);
			p.add(sup);
			p.add(titre);
			p.add(tag);

			p.add(precedent);



			this.add(p);



		}
	}
}
