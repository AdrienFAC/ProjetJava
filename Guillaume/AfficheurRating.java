package test;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import projet.ImageModel;

public class AfficheurRating extends Panel {
		TextField t1;
	


	public AfficheurRating(ImageModel m){
		this.setLayout(new FlowLayout());
		Panel p = new Panel();
		t1 = new TextField("  ");
		Label not = new Label();
		not.setText("note sur 20");
		
		add(t1);
		add(not);
		this.add(p);
		}

		
	}