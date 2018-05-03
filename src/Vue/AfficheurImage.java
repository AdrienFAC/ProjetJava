package Vue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controleur.GestionImg;
import Modele.ImageModel;
import Modele.MainModel;


public class AfficheurImage extends Panel {

	Image im = null;
	public String im_default = null;
	public ImageModel mold = null;
	public MainModel main = null;

	public AfficheurImage(ImageModel m, MainModel mm, GestionImg g){
		super();
		this.mold = m;
		this.main = mm;
		this.setPreferredSize(new Dimension(200,200));
		this.setBackground(Color.DARK_GRAY);
		this.im_default = "images/"+this.main.lst_images.get(g.indexActu).getTitre() +".jpg";
		try {
			this.im = ImageIO.read(new File(im_default));
		}catch (IOException e) {
			throw new RuntimeException("L'image" + im_default + "n'est pas dans la banque de données");

		}

	}
	

	public void changeImgDefault(String name) {
		this.removeAll();
		
		this.setPreferredSize(new Dimension(200,200));
		try {
			this.im_default = name;
			this.im = ImageIO.read(new File(this.im_default));
		}catch (IOException e) {
			throw new RuntimeException("L'image" + this.im_default + "n'est pas dans la banque de données");

		}
		
		this.repaint();
	}

	public void paint(Graphics g) {
		g.drawImage(this.im,10, 10, this.getWidth()-20, this.getHeight()-20,this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
