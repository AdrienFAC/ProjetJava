import java.awt.BorderLayout;
import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class GestionGr extends Frame implements WindowListener{
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new GestionGr("/ilm");
	}
	
	ImageModel modl;
	
	public GestionGr(String d){
		
		this.setLayout(new BorderLayout());
		
		AfficheurRating panneauG = new AfficheurRating(modl);
		this.add(panneauG, BorderLayout.NORTH);
		
		AfficheurImage panneauH = new AfficheurImage(modl);
		this.add(panneauH, BorderLayout.NORTH);
		
		Afficheurtri panneaug = new Afficheurtri(modl);
		this.add(panneaug , BorderLayout.WEST);
		
		this.addWindowListener(this);
		this.pack();
		this.setVisible(true);

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
