package Vue;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JPanel;

import Controleur.GestionNote;
import Modele.ImageModel;

public class AfficheurRating extends Panel implements ActionListener, TextListener{
		
	TextField t1;
	int note ;
	GestionNote nota;
	AfficheurImage defIm = null;
	List<ImageModel> lst = null;

	public AfficheurRating(ImageModel m, GestionNote mm){
		
		this.nota = mm;
		
		JPanel p = new JPanel();
		p.setLayout(new FlowLayout(FlowLayout.LEFT));
		p.setPreferredSize(new Dimension(1000,50));
		JPanel p1 = new JPanel();
		p1.setLayout(new FlowLayout(FlowLayout.LEFT));
		p1.setPreferredSize(new Dimension(400,50));
		t1 = new TextField(" ");
		Label not = new Label();
		not.setText("note sur 20");
		
		JButton ajouter = new JButton();
		ajouter.setText("ajouter");
		
		JButton enregistrement = new JButton();
		enregistrement.setText("enregistrement");
		
		p1.add(ajouter);
		p1.add(enregistrement);
		p.add(p1);
		p.add(not);
		p.add(t1);
		
		
		this.add(p);
		t1.addTextListener(this);
		enregistrement.addActionListener(this);
		
		}



	@Override
	public void actionPerformed(ActionEvent evt) {
		if(evt.getActionCommand() == "enregistrement") {
			if(this.note <= 20 || this.note >= 0 ) {
				this.nota.ChangeNote(this.note );
			}
		}
	}



	@Override
	public void textValueChanged(TextEvent txt) {
		
		String source =  ((TextField)txt.getSource()).getText();
		this.note =  Integer.parseInt(source);
		
	}

		
	}