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

import Controleur.GestionChangementImg;
import Controleur.GestionImg;
import Modele.MainModel;
import Modele.ImageModel;

public class Afficherliste extends Panel {

	int taille = 5;

	Panel p = new Panel();
	JPanel lis = null;
	public MainModel mold;
	List<ImageModel> lst;
	int indexAffiche;
	int[] choixIndex = null;

	GestionChangementImg chan = null ;
	GestionImg ges = null;


	public Afficherliste(AfficheurImage img, GestionChangementImg gesImg, GestionImg g) {

		this.mold = img.main;
		this.ges = g;
		this.chan = gesImg;

		this.lst = img.main.lst_images;
		this.indexAffiche = this.ges.indexActu;
		this.choixIndex = this.chan.indexImg;

		this.changeList();



	}

	public void changeList() {

		this.p.removeAll();

		this.lis = this.infoImg();

		this.p.add(this.lis,BorderLayout.CENTER);

		this.add(this.p);

		this.p.repaint();

	}

	public int[] indexAffiche() {

		int taille;
		if(this.chan.indexImg.length >= 5) {
			taille = 5;
		} else {
			taille = this.chan.indexImg.length; 

		}
		
		int[] index = new int[taille];
		int depart = this.ges.indexActu - 2;
		for(int i = 0; i < taille; i++) {
			if(depart < 0) {
				index[i] = this.choixIndex.length + depart;
			} else {
				if(depart > this.choixIndex.length - 1) {
					index[i] = this.choixIndex.length - 1 - depart;
				} else {
					index[i] = depart;
				}
			}
			if(depart > this.choixIndex[this.choixIndex.length -2] ) {
				depart--;
			} else {
				if(i > 0 && index[i-1] == this.choixIndex.length) {
					depart = this.choixIndex[0] ;
				} else {
					depart++;
				}
					
			}	
		}
		return index;
	}

	public JPanel infoImg() {


		int[] indexImg = this.indexAffiche();
		JPanel liste = new JPanel();
		liste.setLayout(new BoxLayout(liste, BoxLayout.LINE_AXIS));
		ImageIcon[] image = new ImageIcon[this.taille];
		ImageIcon[] newimage = new ImageIcon[this.taille];
		JLabel[] img = new JLabel[this.taille];
		JPanel[] pane = new JPanel[this.taille];

		for(int i = 0 ; i < indexImg.length ; i++) {

			image[i] = new ImageIcon("images/" + this.lst.get(indexImg[i]).getTitre() + ".jpg" );
			newimage[i] = new ImageIcon(image[i].getImage().getScaledInstance(image[i].getIconWidth()*1/8,image[i].getIconHeight()*1/8,Image.SCALE_DEFAULT));
			img[i] = new JLabel(newimage[i]);
			pane[i] = new JPanel();
			pane[i].setBorder(BorderFactory.createLineBorder(Color.gray));
			pane[i].add(img[i]);
			liste.add(pane[i]);
			liste.add(Box.createHorizontalStrut(5));
		}

		return liste;
	}
}