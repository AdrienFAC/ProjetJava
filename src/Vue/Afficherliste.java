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

	ImageIcon[] image = null;
	ImageIcon[] newimage = null;
	JLabel[] img = null;
	Panel p = null;
	JPanel lis = null;
	JPanel[] pane = null;
	public MainModel mold;
	List<ImageModel> lst;
	public int indexAffiche;


	public Afficherliste(AfficheurImage img) {

		this.mold = img.main;
		this.lst = img.main.lst_images;
		
		this.p = new Panel();
	
		this.image = new ImageIcon[this.taille];
		this.newimage = new ImageIcon[this.taille];
		this.img = new JLabel[this.taille];
		this.pane = new JPanel[this.taille];


		this.lis = new JPanel();
		this.lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));
		
		this.infoImg(3);
		
		this.p.add(lis,BorderLayout.CENTER);

		this.add(p);


	}
	
	public void changeList(int indexAffiche) {
		
		this.removeAll();
		
		this.p = new Panel();
		
		this.image = new ImageIcon[this.taille];
		this.newimage = new ImageIcon[this.taille];
		this.img = new JLabel[this.taille];
		this.pane = new JPanel[this.taille];


		this.lis = new JPanel();
		this.lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));
		
		this.infoImg(indexAffiche);
		
		this.p.add(lis,BorderLayout.CENTER);

		this.add(p);
		
		this.repaint();
	}

	public void infoImg(int depart) {
		
		this.remove(this.lis);
		
		depart = depart - 3 ;
		int index = 0;

		for(int i = depart ; i < depart + 5 ; i++) {

			if(i < 0) {

				this.image[index] = new ImageIcon("images/" + this.lst.get(lst.size() + i).getTitre() + ".jpg" );

			} else {
				if(i > lst.size()-1) {

					this.image[index] = new ImageIcon("images/" + this.lst.get(lst.size() - i).getTitre() + ".jpg" );

				} else {

					this.image[index] = new ImageIcon("images/" + this.lst.get(i).getTitre() + ".jpg" );

				}
			}
			this.newimage[index] = new ImageIcon(this.image[index].getImage().getScaledInstance(this.image[index].getIconWidth()*1/8,this.image[index].getIconHeight()*1/8,Image.SCALE_DEFAULT));
			this.img[index] = new JLabel(this.newimage[index]);
			this.pane[index] = new JPanel();
			this.pane[index].setBorder(BorderFactory.createLineBorder(Color.gray));
			this.pane[index].add(this.img[index]);
			this.lis.add(this.pane[index]);
			this.lis.add(Box.createHorizontalStrut(5));
			index++;
		}
		
	}
}