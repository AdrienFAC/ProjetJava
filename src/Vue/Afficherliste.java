package Vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Modele.MainModel;
import Modele.ImageModel;

public class Afficherliste extends Panel {

	int taille = 5;

	Panel p = new Panel();
	JPanel lis = null;
	public MainModel mold;
	List<ImageModel> lst;
	public int indexAffiche = 3;


	public Afficherliste(AfficheurImage img) {

		this.mold = img.main;
		this.lst = img.main.lst_images;
		
		this.changeList();
		


	}
	
	public void changeList() {
		
		this.removeAll();
		this.p.removeAll();
		
		this.lis = this.infoImg(this.indexAffiche);
		
		this.p.add(this.lis,BorderLayout.CENTER);

		this.add(this.p);
		
		this.p.repaint();
		this.repaint();
		
	}

	public JPanel infoImg(int depart) {
		
		
		depart = depart - 3 ;
		int index = 0;
		JPanel liste = new JPanel();
		liste.setLayout(new BoxLayout(liste, BoxLayout.LINE_AXIS));
		ImageIcon[] image = new ImageIcon[this.taille];
		ImageIcon[] newimage = new ImageIcon[this.taille];
		JLabel[] img = new JLabel[this.taille];
		JPanel[] pane = new JPanel[this.taille];
		
		for(int i = depart ; i < depart + 5 ; i++) {
			
			if(i < 0) {

				image[index] = new ImageIcon("images/" + this.lst.get(lst.size() + i).getTitre() + ".jpg" );

			} else {
				if(i > lst.size()-1) {

					image[index] = new ImageIcon("images/" + this.lst.get(lst.size() - i).getTitre() + ".jpg" );

				} else {

					image[index] = new ImageIcon("images/" + this.lst.get(i).getTitre() + ".jpg" );

				}
			}
			newimage[index] = new ImageIcon(image[index].getImage().getScaledInstance(image[index].getIconWidth()*1/8,image[index].getIconHeight()*1/8,Image.SCALE_DEFAULT));
			img[index] = new JLabel(newimage[index]);
			pane[index] = new JPanel();
			pane[index].setBorder(BorderFactory.createLineBorder(Color.gray));
			pane[index].add(img[index]);
			liste.add(pane[index]);
			liste.add(Box.createHorizontalStrut(5));
			index++;
		}
		System.out.println();
		
		return liste;
	}
}