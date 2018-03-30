package Guillaume; 

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import Adrien.ImageModel;

public class GestionGr extends Frame implements WindowListener{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GestionGr();
	}
	
	ImageModel modl;
	
	public GestionGr(){
		
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(1000,1000));
		
		AfficheurImage panneauH = new AfficheurImage(modl);
		this.add(panneauH, BorderLayout.CENTER);
		
		AfficheurRating panneauG = new AfficheurRating(modl);
		this.add(panneauG, BorderLayout.NORTH);

		
		Afficheurtri panneaug = new Afficheurtri(modl);
		this.add(panneaug , BorderLayout.WEST);
		
		Afficherliste panneaub = new Afficherliste(modl);
		this.add(panneaub, BorderLayout.SOUTH);
		
		
		this.addWindowListener(this);
		this.pack();
		this.setVisible(true);
		
		
		this.addWindowListener(new java.awt.event.WindowAdapter() {
	        public void windowClosing(java.awt.event.WindowEvent evt) {
	                dispose();
	                System.exit(0);
	        } 
	} );
	}

	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}

