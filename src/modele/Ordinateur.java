package modele;

import java.util.ArrayList;
import java.util.ListIterator;

import IHM.Fenetre_resultat;

public class Ordinateur {

	private double prix;
	private int ram;
	private String disque;
	private String type;
	private String cg;
	private String cm;
	private String nom;
	private int id;
	
	private double score;
	
	public Ordinateur(double p, int r, String d, String t, 
					  String c, String m, String n, int i) {
		
		setPrix(p);
		setRAM(r);
		setDisque(d);
		setType(t);
		setCg(c);
		setCm(m);
		setNom(n);
		setId(i);
		setScore(0);
	}
	
	public double getPrix() { return prix;}
	public void setPrix(double prix) { this.prix = prix;}

	public int getRAM() { return ram;}
	public void setRAM(int rAM) { ram = rAM;}

	public String getDisque() { return disque;}
	public void setDisque(String disque) { this.disque = disque;}

	public String getType() { return type;}
	public void setType(String type) { this.type = type;}

	public String getCm() { return cm;}
	public void setCm(String cm) { this.cm = cm;}

	public String getCg() { return cg;}
	public void setCg(String cg) { this.cg = cg;}

	public String getNom() { return nom;}
	public void setNom(String nom) { this.nom = nom;}
	
	public int getId() { return id;}
	public void setId(int i) { id = i;}

	public double getScore() { return score;}
	public void setScore(double score) { this.score = score;}
	
	public static void main(String[] args) {
		ArrayList<Ordinateur> a = new ArrayList<>();
		a.add(new Ordinateur(40.0, 8, "Mécanique", "Fixe", "ASUS", "mini_ITX", "1a6", 3));
		a.add(new Ordinateur(100.0, 16, "SSD", "Fixe", "ASUS", "mini_ITX", "1a6", 2));
		a.add(new Ordinateur(10.0, 2, "Mécanique", "Portable", "ASUS", "mini_ITX", "1a6", 4));
		JugeOrdinateur juge = new JugeOrdinateur(new Ordinateur(10.0, 2, "Mécanique", "Portable", "ASUS", "mini_ITX", "1a6", 4));
		for (Ordinateur o : a) juge.juger(o);
		a.sort(new ComparateurOrdi());
		new Fenetre_resultat(a);
	}
}
