package IHM;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import controleur.Controleur;
import modele.Ordinateur;

@SuppressWarnings("serial")
public class Fenetre_resultat_admin extends JFrame {
	
	Panneau_resultat_admin panneau;
	
	public Fenetre_resultat_admin(ArrayList<Ordinateur> ordiListe, Controleur C) {
		super();
		this.setTitle("Resultats de recherche");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int largeur=dim.width;
		int hauteur=dim.height;
		this.setSize( largeur/2, hauteur/2);
		this.setLocationRelativeTo(null);
		panneau=new Panneau_resultat_admin(this, ordiListe, C); 
		add(panneau);
		JScrollPane scrollPane = new JScrollPane(panneau);
		add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
}
