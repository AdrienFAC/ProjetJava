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

public class Afficherliste extends Panel {

	GestionTriImg m;

	public Afficherliste() throws IOException {

		this.m = new GestionTriImg();

		Panel p = new Panel();
		p.setPreferredSize(new Dimension(900,100));
		p.setLayout(new BorderLayout());

		JButton suivant = new JButton();
		suivant.setBounds(1400,0 , 80, 20);
		suivant.setText("suivant");

		JPanel lis = new JPanel();
		lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));


		for(int i = 0; i < m.lst_triee.size() ; i++) {

			JPanel pane = new JPanel();
			ImageIcon image1 = new ImageIcon("images/" + m.lst_triee.get(i).getTitre() + ".jpg");
			ImageIcon newimage1 = new ImageIcon(image1.getImage().getScaledInstance(image1.getIconWidth()*1/8,image1.getIconHeight()*1/8,Image.SCALE_DEFAULT));
			JLabel image = new JLabel( newimage1);
			pane.add(image);

			lis.add(pane);
			lis.add(Box.createHorizontalStrut(5));

		}

		System.out.println(m.lst_triee.size()/2);
		System.out.println(m.lst_triee.get(m.lst_triee.size()/2).getTitre());


		p.add(suivant);
		p.add(lis,BorderLayout.CENTER);

		this.add(p);


	}

}
