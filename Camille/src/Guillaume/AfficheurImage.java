package Guillaume; 
import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import Adrien.ImageModel;

public class AfficheurImage extends Canvas {

	Image im = null;
	String im_default="images/bretagne.jpg";
	ImageModel modl;

	public AfficheurImage(ImageModel m ){
		super();
		this.setPreferredSize(new Dimension(200,200));

		try {
			im = ImageIO.read(new File(im_default));
		}catch (IOException e) {
			throw new RuntimeException("L'image" + im_default + "n'est pas dans la banque de données");

		}


	}

	public void paint(Graphics g) {
		g.drawImage(im,50, 50, this.getWidth(), this.getHeight(), this);
	}





























	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
