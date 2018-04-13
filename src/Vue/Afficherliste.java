package Vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.io.IOException;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.GestionTriImg;
import Modele.MainModel;

public class Afficherliste extends Panel {

	JPanel lis = null;

	public Afficherliste(MainModel lst) throws IOException {

		Panel p = new Panel();
		p.setPreferredSize(new Dimension(900,100));
		p.setLayout(new BorderLayout());

		JButton suivant = new JButton();
		suivant.setBounds(1400,0 , 80, 20);
		suivant.setText("suivant");

		lis = new JPanel();
		lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));

		if(lst==null) {
			System.out.println("merde");
		} else {
			affiche(lst);
		}


		p.add(suivant);
		p.add(lis,BorderLayout.CENTER);

		this.add(p);


	}

	public void affiche(MainModel lst) {

		if(lst.lst_images.size() > 1) {

			for(int i = 0; i < lst.lst_images.size() ; i++) {

				if(i < 5) {
					
					JPanel pane = new JPanel();
					ImageIcon image1 = new ImageIcon("images/" + lst.lst_images.get(i).getTitre() + ".jpg");
					ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
					JLabel image = new JLabel( newimage1);
					pane.add(image);

					lis.add(pane);
					lis.add(Box.createHorizontalStrut(5));

				}
			}
			
		} else {
			
			JPanel pane = new JPanel();
			ImageIcon image1 = new ImageIcon("images/" + lst.lst_images.get(0).getTitre() + ".jpg");
			ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
			JLabel image = new JLabel( newimage1);
			pane.add(image);

			lis.add(pane);
			lis.add(Box.createHorizontalStrut(5));
			
		}
	}

}
