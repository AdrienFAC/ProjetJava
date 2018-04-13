package Vue;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Controleur.GestionImg;
import Modele.ImageModel;


public class AfficheurImage extends Panel {

	Image im = null;
	public String im_default = "images/espace.jpg";

	ImageModel modl;

	public AfficheurImage(ImageModel m){
		super();
		this.setPreferredSize(new Dimension(200,200));
		try {
			im = ImageIO.read(new File(im_default));
		}catch (IOException e) {
			throw new RuntimeException("L'image" + im_default + "n'est pas dans la banque de données");

		}

	}
	



	public void paint(Graphics g) {
		g.drawImage(im,50, 50, this.getWidth(), this.getHeight(),this);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
