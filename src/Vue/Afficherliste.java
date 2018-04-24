package Vue;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.io.IOException;
import java.util.List;

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

	JPanel lis = null;

	public Afficherliste(MainModel lst) throws IOException {

		Panel p = new Panel();
		p.setPreferredSize(new Dimension(900,100));
		p.setLayout(new BorderLayout());



		lis = new JPanel();
		lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));

		affiche(lst.lst_images, 3);

		p.add(lis,BorderLayout.CENTER);

		this.add(p);


	}

	public void affiche(List<ImageModel> lst, int depart) {
		
		this.removeAll();
		
		if(lst.size() >= 1) {
			
			for(int i = depart - 3 ; i < depart + 2 ; i++) {
				if(i < 0) {
					JPanel pane = new JPanel();
					ImageIcon image1 = new ImageIcon("images/" + lst.get(lst.size() + i).getTitre() + ".jpg" );
					ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
					JLabel image = new JLabel( newimage1);
					pane.add(image);
					
					lis.add(pane);
					lis.add(Box.createHorizontalStrut(5));
				} else {
					if(i > lst.size()) {
						JPanel pane = new JPanel();
						ImageIcon image1 = new ImageIcon("images/" + lst.get(lst.size() - i).getTitre() + ".jpg" );
						ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
						JLabel image = new JLabel( newimage1);
						pane.add(image);
						
						lis.add(pane);
						lis.add(Box.createHorizontalStrut(5));
					} else {
						JPanel pane = new JPanel();
						ImageIcon image1 = new ImageIcon("images/" + lst.get(i).getTitre() + ".jpg" );
						ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
						JLabel image = new JLabel( newimage1);
						pane.add(image);
						
						lis.add(pane);
						lis.add(Box.createHorizontalStrut(5));
					}
				}
			}
		}
		
		this.repaint();
	}

}
