package modele;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
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
					  String g, String m, String n, int i) throws ExceptionPrix, ExceptionNom {
		if (p <= 0) throw new ExceptionPrix();
		if (n.equals("")) throw new ExceptionNom();
		setPrix(p);
		setRAM(r);
		setDisque(d);
		setType(t);
		setCg(g);
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
		
		try {
			ArrayList<Ordinateur> a = new ArrayList<>();
			Ordinateur souhait = new Ordinateur(10.0, 2, "Mécanique", "Portable", "ASUS", "mini_ITX", "1a6", 4);
			
			Ordinateur o1 = new Ordinateur(40.0, 8, "Mécanique", "Fixe", "ASUS", "mini_ITX", "bleh", 3);
			Ordinateur o2 = new Ordinateur(100.0, 16, "SSD", "Fixe", "ASUS", "mini_ITX", "zbeub", 2);
			Ordinateur o3 = new Ordinateur(10.0, 2, "Mécanique", "Portable", "ASUS", "mini_ITX", "ha", 4);
			Ordinateur o4 = new Ordinateur(350.0, 32,"SSD", "Fixe", "MSI", "ATX_standard", "doh!", 1);
			a.add(o1); a.add(o2); a.add(o3); a.add(o4);
			
			JugeGaming juge2 = new JugeGaming(souhait);
			
			Class<?> unjuge = Class.forName("modele.JugeBureautique");
			Constructor<?> ctr = unjuge.getConstructor(Ordinateur.class);
			Object obj = ctr.newInstance(new Object[] {souhait});
			Juge juge = (Juge)obj;
			
			for (Ordinateur o : a) juge.juger(o);
			a.sort(new ComparateurOrdi());
			new Fenetre_resultat(a);
			
			for (Ordinateur o : a) juge2.juger(o);
			a.sort(new ComparateurOrdi());
			new Fenetre_resultat(a);	
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionPrix e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExceptionNom e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
