package IHM;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;

import modele.Ordinateur;

@SuppressWarnings("serial")
public class Fenetre_resultat extends JFrame {

	private Panneau_resultat panneau;
	
	public Fenetre_resultat(ArrayList<Ordinateur> ordiListe) {
		super();
		this.setTitle("Resultats de recherche");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int largeur=dim.width;
		int hauteur=dim.height;
		this.setSize( largeur/2, hauteur/2);
		this.setLocationRelativeTo(null);
		panneau= new Panneau_resultat(this, ordiListe); 
		add(panneau);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

}
