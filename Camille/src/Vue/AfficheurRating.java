package Vue;


import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;

import Modele.ImageModel;

public class AfficheurRating extends Panel {
		TextField t1;
	


	public AfficheurRating(ImageModel m){
		Panel p = new Panel();
		p.setPreferredSize(new Dimension(900,50));
		t1 = new TextField(" ");
		Label not = new Label();
		not.setText("note sur 20");
		
		JButton ajouter = new JButton();
		ajouter.setText("ajouter");
		
		JButton enregistrement = new JButton();
		enregistrement.setText("enregistrement");
		
		p.add(enregistrement);
		p.add(ajouter);
		p.add(not);
		p.add(t1);
		
		
		this.add(p);
		}

		
	}