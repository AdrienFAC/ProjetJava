package test;
import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Choice;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Observable;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JComponent;

import projet.ImageModel;
import projet.MainModel;
import projet.Taille;

public class Afficheurtri extends Panel  {

		TextField rat ;
		Choice taille = new Choice();
		Choice titre = new Choice();
		Choice tag = new Choice();
		Choice sup= new Choice();
		String[] t= {"400x300","640x480","800x600","1024x768","1600x1200","2272x1704","2816x2112","3264x2448","3648x2736","4096x3072","4480x3360","5120x3840","7216x5412","9600x7200"};
		ArrayList h = new ArrayList();
		Taille v;
		
		
		public Afficheurtri(ImageModel m , MainModel g){
			this.setLayout(new FlowLayout());
			
			
			Panel p = new Panel();
			p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
			p.setPreferredSize(new Dimension(200,200));
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
			/*for (ImageModel img : g.lst_images){
				v=img.getTaille();
				h.add(v);
				}

			for(int i=0 ; i<h.size();i++){
				sup.add((String)h.get(i));
			}*/
			
			
			
			taille.add("Grande");
			taille.add("Moyennes");
			taille.add("petit");
			taille.add("supérieur à " + "sup");
			taille.add("égale à " + "sup");
			
			
			p.add(taille);
			p.add(Box.createVerticalStrut(60));
			p.add(rat);
			p.add(Box.createVerticalStrut(60));
			p.add(sup);
			p.add(Box.createVerticalStrut(20));
			p.add(titre);
			p.add(Box.createVerticalStrut(20));
			p.add(tag);
			p.add(Box.createVerticalStrut(20));
			
			

			
			this.add(p);
			
			
			
			
			
			
			
			
			
				
				
			}



		private int lenght() {
			// TODO Auto-generated method stub
			return 0;
		}
		


		
		
		
		
		
	}
	
	
	
	
	
	


