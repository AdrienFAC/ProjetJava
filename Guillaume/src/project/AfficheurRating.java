package project;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;

import javax.swing.JButton;
import javax.swing.JPanel;

import project.ImageModel;

public class AfficheurRating extends Panel {
		TextField t1;
	


	public AfficheurRating(ImageModel m){
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.setPreferredSize(new Dimension(1000,50));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.setPreferredSize(new Dimension(400,50));
		t1 = new TextField(" ");
		Label not = new Label();
		not.setText("note sur 20");
		
		JButton ajouter = new JButton();
		ajouter.setText("ajouter");
		
		JButton enregistrement = new JButton();
		enregistrement.setText("enregistrement");
		
		p1.add(ajouter);
		p1.add(enregistrement);
		p.add(p1);
		p.add(not);
		p.add(t1);
		
		
		
		this.add(p);
		}

		
	}