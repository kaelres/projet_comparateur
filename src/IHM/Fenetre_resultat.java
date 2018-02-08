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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Ordinateur> a = new ArrayList<>();
		a.add(new Ordinateur(1.0, 2, "3", "4", "5", "6", "1a6", 1));
		a.add(new Ordinateur(7.0, 8, "9", "10", "11", "12", "7a12", 2));
		a.add(new Ordinateur(13.0, 14, "15", "16", "17", "18", "13a18", 3));
		new Fenetre_resultat(a);
	}

}
