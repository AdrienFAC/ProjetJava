package Vue;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.Panel;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import Controleur.GestionChangementImg;
import Controleur.GestionImg;
import Controleur.GestionTriImg;
import Modele.ImageModel;
import Modele.MainModel;

public class AfficheurInfo extends Panel implements ActionListener {

	GestionImg mm = null;
	MainModel mold = null;
	AfficheurImage imDef = null;
	GestionChangementImg chanIm = null;
	Color [] c = {Color.blue,Color.red,Color.green,Color.yellow,Color.pink,Color.orange,Color.magenta,Color.cyan};
	String [] co ={"bleu","rouge","vert","jaune","rose","orange","magenta","cyan"};
	Panel p = null;
	Afficheurtri afftri =null;
		
	public AfficheurInfo(Afficheurtri tri) throws IOException {

		this.mm = tri.mm;
		this.mold = tri.mold;
		this.imDef = tri.imDef;
		this.chanIm = tri.chanIm;
		this.afftri = tri;
		
		p = new Panel();
		BoxLayout layout = new BoxLayout(p,BoxLayout.PAGE_AXIS);
		p.setLayout(layout);
		layout.preferredLayoutSize(p);
		p.setPreferredSize(new Dimension(300,550));
		p.setBackground(new Color(153,153,153));
		ImageModel img = tri.mold.lst_images.get(tri.chanIm.indexImg);

		JLabel info = new JLabel();
		info.setText("INFORMATIONS");
		info.setBorder(BorderFactory.createLineBorder(Color.white));
		
		TextField Taille = new TextField("");
		Taille.setText(new Taille(img.getHeight(),img.getWidth()).toString());
		TextField Couleur = new TextField("");
		for(int i=0;i<c.length;i++) {
		if( img.FindColor(c[i])) {
			Couleur.setText(Couleur.getText() +" "+ co[i]);
			
		}
		
		}
		
		TextField sup = new TextField("");
		sup.setText(new Sup(new Taille(img.getHeight(),img.getWidth())).toString());
		TextField tit = new TextField();
		tit.setText(img.getTitre().toString());
		TextField tag = new TextField();
		tag.setText(img.lst_tags.toString());
		TextField not = new TextField();
		not.setText(new Note(img.getNote()).toString());
		JButton suivant = new JButton();
		suivant.setBounds(1400,0 , 80, 20);
		suivant.setText("suivant");
		suivant.addActionListener(this);
		p.add(info);
		p.add(Taille);
		p.add(Box.createVerticalStrut(5));
		p.add(Couleur);
		p.add(Box.createVerticalStrut(5));
		p.add(sup);
		p.add(Box.createVerticalStrut(5));
		p.add(tit);
		p.add(Box.createVerticalStrut(5));
		p.add(tag);
		p.add(Box.createVerticalStrut(5));
		p.add(not);
		p.add(Box.createVerticalStrut(5));

		p.add(suivant);



		this.add(p);

	}

	@Override
	public void actionPerformed(ActionEvent evt) {
		
		if(evt.getActionCommand() == "suivant") {
			String name = this.chanIm.nameImgSuivant(mm, mold, imDef);
			this.imDef.changeImgDefault(name);
			
		}
		this.repaint();

	}

}
