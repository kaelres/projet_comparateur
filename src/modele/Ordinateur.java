package modele;

/**
 * Cette classe à pour but de représenter les lignes de la tables "Ordinateur" de la base de données.<br>
 * Afin de représenter un ordinateur on lui donne les attributs suivants :<ul>
 * <li>Un prix en €, il doit être supérieur strictement à 0.</li>
 * <li>Une quantitée de ram en Go, elle peut prendre les valeurs suivantes : 2, 4, 8, 16 ou 32.</li>
 * <li>Le type de disque dur, qui peut prendre les valeurs "SSD" ou "Mécanique".</li>
 * <li>Le type d'ordinateur, qui peut prendre les valeurs "Fixe" ou "portable".</li>
 * <li>Le frabricant de la carte graphique, qui peut prendre les valeurs "MSI", "PNY", "EVGA" ou "ASUS".</li>
 * <li>Le format de la carte-mère, qui peut prendre les valeurs "mini_ITX", "micro_ATX" ou "ATX_standard".</li>
 * <li>Le nom de l'ordinateur, long de 30 charactères maximum.</li>
 * <li>Un identifiant unique à chaque ordinateur, qui représente la clef privé de la table.</li>
 * <li>Un attribut "score" qui ne représente aucune des colonnes de la table associé est ajoutée afin d'effectuer des omparaisons.</li>
 * </ul>
 * @author Francois
 */
public class Ordinateur {

	/**
	 * Prix de l'ordinateur, doit être supérieur strictement à 0.
	 */
	private double prix;
	/**
	 * ram de l'ordinateur : 2, 4, 8, 16 ou 32.
	 */
	private int ram;
	/**
	 * Type de disque dur de l'ordinateur : SSD ou Mécanique.
	 */
	private String disque;
	/**
	 * Type d'ordinateur : Fixe ou Portable.
	 */
	private String type;
	/**
	 * Fabricant de la carte graphique : MSI, PNY, EVGA ou ASUS
	 */
	private String cg;
	/**
	 * Format de la carte mère : mini_ITX, micro_ATX ou ATX_standard
	 */
	private String cm;
	/**
	 * Le nom de l'ordinateur : maximum de 30 charactères.
	 */
	private String nom;
	/**
	 * Identifiant unique de l'ordinateur.
	 */
	private int id;
	/**
	 * score de l'ordinateur
	 */
	private double score;
	
	/**
	 * Ce constructeur crée un ordinateur en initialisant son score à 0 et en initialisant les auters arguments avec les paramètres fournis.
	 * @param p Prix de l'ordinateur.
	 * @param r Ram de l'ordinateur.
	 * @param d Type de disque dur.
	 * @param t Type de l'ordinateur.
	 * @param g Fabricant de la carte graphique.
	 * @param m Format de la carte-mère.
	 * @param n Nom de l'ordinateur.
	 * @param i identifiant de l'ordinateur.
	 */
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
	
	/**
	 * Cette méthode permet d'ovbtenir le prix de l'ordinateur.
	 * @return Renvoie l'attribut prix.
	 */
	public double getPrix() { return prix;}
	/**
	 * Cette méthode permet de modifier le prix de l'ordinateur.
	 * @param prix Nouveau prix.
	 */
	public void setPrix(double prix) { this.prix = prix;}

	/**
	 * Cette méthode permet d'obtenir la ram de l'ordinateur.
	 * @return Renvoie l'attribut ram.
	 */
	public int getRAM() { return ram;}
	/**
	 * Cette méthode permet de modifier la quantitée de ram de l'ordinateur.
	 * @param rAM Nouvelle valeur de ram.
	 */
	public void setRAM(int rAM) { ram = rAM;}

	/**
	 * Cette méthode permet d'obtenir le type de disque de l'ordinateur.
	 * @return Renvoie l'attribut disque.
	 */
	public String getDisque() { return disque;}
	/**
	 * Cette méthode permet de modifier le type de disque de l'ordinateur.
	 * @param disque Nouveau type de disque.
	 */
	public void setDisque(String disque) { this.disque = disque;}

	/**
	 * Cette méthode permet d'obtenir le type de l'ordinateur.
	 * @return Renvoie l'attribut type.
	 */
	public String getType() { return type;}
	/**
	 * Cette méthode permet de modifier le type de l'ordinateur.
	 * @param type Nouveau type d'ordinateur.
	 */
	public void setType(String type) { this.type = type;}

	/**
	 * Cette méthode permet d'obtenir le format de la carte mère.
	 * @return Renvoie l'attribue cm.
	 */
	public String getCm() { return cm;}
	/**
	 * Cette méthode permet de modifier le format de carte mère. 
	 * @param cm Nouveau format de carte mère.
	 */
	public void setCm(String cm) { this.cm = cm;}

	/**
	 * Cette méthode permet d'obtenir le nom du fabricant de la carte graphique.
	 * @return Renvoie l'attribut cg.
	 */
	public String getCg() { return cg;}
	/**
	 * Cette méthode permet de modifier le nom du fabricant de carte graphique.
	 * @param cg Nouveau nom du constructeur de carte graphique.
	 */
	public void setCg(String cg) { this.cg = cg;}
	
	
	
	/**
	 * Cette méthode permet d'obtenir le nom de l'ordinateur.
	 * @return Renvoie l'attribut nom.
	 */
	public String getNom() { return nom;}
	/**
	 * Cette méthode permet de modifier le nomde l'ordinateur.
	 * @param nom Nouveau nom de l'ordinateur.
	 */
	public void setNom(String nom) { this.nom = nom;}
	
	/**
	 * Cette méthode permet d'obtenir l'identifiant unique de l'ordinateur.
	 * @return Renvoie l'attribut id.
	 */
	public int getId() { return id;}
	/**
	 * Cette méthode permet de modifier l'identifiant de l'ordinateur.
	 * @param i Nouvel identifiant.
	 */
	public void setId(int i) { id = i;}
	
	/**
	 * Cette méthode permet d'obtenir le score de l'ordinateur.
	 * @return Renvoie l'attribut score.
	 */
	public double getScore() { return score;}
	/**
	 * Cette méthode permet de modifier le score de l'ordinateur.
	 * @param score Nouveau score.
	 */
	public void setScore(double score) { this.score = score;}
}
