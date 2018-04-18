package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextField;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

import Modele.ImageModel;
import Modele.MainModel;

public class AfficheurInfo extends Panel {
	
	


	public AfficheurInfo(ImageModel m,MainModel g,Taille t,AfficheurImage a) throws IOException {

		Panel p = new Panel();
		BoxLayout layout = new BoxLayout(p,BoxLayout.PAGE_AXIS);
		p.setLayout(layout);
		layout.preferredLayoutSize(p);
		p.setPreferredSize(new Dimension(300,550));
		ImageModel img = g.lst_images.get(1);
		

			TextField Taille = new TextField("");
			Taille.setText(new Taille(img.getHeight(),img.getWidth()).toString());
			TextField Couleur = new TextField("");
			Couleur.setText("couleur");
			TextField sup = new TextField("");
			sup.setText(new Sup(new Taille(img.getHeight(),img.getWidth())).toString());
			TextField tit = new TextField();
			tit.setText(img.getTitre().toString());
			TextField tag = new TextField();
			tag.setText(img.lst_tags.toString());
			TextField not = new TextField();
			not.setText(new Note(img.getNote()).toString());
			JButton suivant = new JButton();
			suivant.setBounds(1400,0 , 80, 20);
			suivant.setText("suivant");
			p.add(Taille);
			p.add(Box.createVerticalStrut(5));
			p.add(Couleur);
			p.add(Box.createVerticalStrut(5));
			p.add(sup);
			p.add(Box.createVerticalStrut(5));
			p.add(tit);
			p.add(Box.createVerticalStrut(5));
			p.add(tag);
			p.add(Box.createVerticalStrut(5));
			p.add(not);
			p.add(Box.createVerticalStrut(5));
			
			p.add(suivant);
			
			
		
		this.add(p);

	}

}
