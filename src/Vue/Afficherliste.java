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

	public Afficherliste(AfficheurImage img) throws IOException {

		this.mold = img.main;
		this.p = new Panel();
		this.p.setPreferredSize(new Dimension(900,100));
		this.p.setLayout(new BorderLayout());
		this.lis = new JPanel();
		this.lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));

		affiche(this.mold.lst_images, 3);



	}

	public void affiche(List<ImageModel> lst, int depart) {

		this.removeAll();
		depart = depart - 3 ;
		
		if(lst.size() >= 1) {

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
				System.out.println(image1[index]);
				index++;
				image = new JLabel( newimage1);
				pane.setBorder(BorderFactory.createLineBorder(Color.gray));
				pane.add(image);
				lis.add(pane);
				lis.add(Box.createHorizontalStrut(5));
			}

			p.add(lis,BorderLayout.CENTER);
			this.add(p);

		}
	}





}
