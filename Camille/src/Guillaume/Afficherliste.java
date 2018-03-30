package Guillaume;

import java.awt.Dimension;
import java.awt.Panel;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Adrien.ImageModel;

public class Afficherliste extends Panel {
	 
	private ImageIcon image2;
	private ImageIcon image1;
	
	
	public Afficherliste(ImageModel m ) {
		
	
	Panel p = new Panel();
	p.setPreferredSize(new Dimension(200,200));
	
	
	
	JPanel lis = new JPanel();
	lis.setLayout(new BoxLayout(lis, BoxLayout.LINE_AXIS));
	
	
	
	
	JPanel pane = new JPanel(); 
	image1 = new ImageIcon( "images/cellules.jpg");
	JLabel image = new JLabel( image1);
	pane.add(image);
	
	JPanel pane2 = new JPanel(); 
	image2 = new ImageIcon( "images/espace.jpg");
	JLabel imag = new JLabel( image2);
	pane2.add(imag);
	
	
	lis.add(pane);
	lis.add(Box.createHorizontalStrut(20));
	lis.add(pane2);
	
	
    Dimension dim=new Dimension(image1.getIconWidth(), image1.getIconHeight());
    setSize(50,50);


	
	p.add(lis);
	
	
	this.add(p);
	
	}
	
}
