package modele;

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
					  String g, String m, String n, int i) {
		prix = p;
		ram = r;
		disque = d;
		type = t;
		cg = g;
		cm = m;
		nom = n;
		id = i;
		score = 0;
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
}
