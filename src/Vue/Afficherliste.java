package Vue;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.io.IOException;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.GestionTriImg;
import Modele.ImageModel;
import Modele.MainModel;


public class Afficherliste extends Panel {

	JPanel lis;
	Panel p;
	ImageIcon[] image1 = new ImageIcon[5];
	public MainModel mold;
	List<ImageModel> lst;

	public Afficherliste(AfficheurImage img) throws IOException {

		this.mold = img.main;
		this.p = new Panel();
		this.p.setPreferredSize(new Dimension(900,100));
		this.p.setLayout(new BorderLayout());
		this.lis = new JPanel();
		this.lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));
		this.lst = img.main.lst_images;
		affiche(3);



	}

	public void affiche(int depart) {

		this.removeAll();
		depart = depart - 3 ;

		for(int i = depart ; i < depart + 5 ; i++) {

			JPanel pane = new JPanel();
			int index = 0;
			JLabel image = null;
			ImageIcon newimage1 = null;
			if(i < 0) {

				image1[index] = new ImageIcon("images/" + lst.get(lst.size() + i).getTitre() + ".jpg" );

			} else {
				if(i > lst.size()-1) {

					image1[index] = new ImageIcon("images/" + lst.get(lst.size() - i).getTitre() + ".jpg" );

				} else {

					image1[index] = new ImageIcon("images/" + lst.get(i).getTitre() + ".jpg" );

				}
			}

			newimage1 = new ImageIcon(image1[index].getImage().getScaledInstance(image1[index].getIconWidth()*1/8,image1[index].getIconHeight()*1/8,Image.SCALE_DEFAULT));
			index++;
			image = new JLabel( newimage1);
			pane.setBorder(BorderFactory.createLineBorder(Color.gray));
			pane.add(image);
			lis.add(pane);
			lis.add(Box.createHorizontalStrut(5));


			p.add(lis,BorderLayout.CENTER);
			this.add(p);

		}
	}

	public void afficherIndex(int[] tab) {
		
		this.removeAll();

		for(int i = 0 ; i < 5 ; i++) {

			JPanel pane = new JPanel();
			int index = 0;
			JLabel image = null;
			ImageIcon newimage1 = null;
			image1[i] = new ImageIcon("images/" + lst.get(tab[i]).getTitre() + ".jpg" );
			newimage1 = new ImageIcon(image1[i].getImage().getScaledInstance(image1[i].getIconWidth()*1/8,image1[i].getIconHeight()*1/8,Image.SCALE_DEFAULT));
			image = new JLabel( newimage1);
			pane.setBorder(BorderFactory.createLineBorder(Color.gray));
			pane.add(image);
			lis.add(pane);
			lis.add(Box.createHorizontalStrut(5));


			p.add(lis,BorderLayout.CENTER);
			this.add(p);
			}

	}


}
