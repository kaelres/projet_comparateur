package modele;

import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

/**
 * Classe abstraite à étendre par les différents juge qui caractérise chaque profil.<br>
 * Chaque profil de recherche supplémentaire serac représenté par un juge supplémentaire.
 * @author Francois
 * @see modele.JugeGaming
 * @see modele.JugeBureautique
 */
public abstract class Juge {
	
	/**
	 * Ordinateur Idéal souhaité par l'utilisateur, il sert de point de comparaison avec celui donné en paramètre de la fonction juger.
	 * @see JugeBureautique#juger(Ordinateur)
	 */
	protected Ordinateur souhait;
	/**
	 * Ensemble des familles de disque.
	 */
	protected Map<String, ArrayList<String>> disque;
	/**
	 * Ensemble des familles de type d'ordinateur.
	 */
	protected Map<String, ArrayList<String>> type;
	/**
	 * Ensemble des familles de fabricants de carte graphique.
	 */
	protected Map<String, ArrayList<String>> CG;
	/**
	 * Ensemble des familles de format de carte-mère.
	 */
	protected Map<String, ArrayList<String>> CM;
	
	/**
	 * Ce contructeur permet de créer un Juge :<ul>
	 * <li>Il prend un Ordinateur en paramètre et le définit comme le souhait idéal du client.</li>
	 * <li>Il crée chaque famille utilisé par la méthode juger(Ordinateur o).</li>
	 * <li>Il remplit ces familles.</li>
	 * </ul>
	 * @param o Ordinateur idéal souhaité par le client.
	 * @see Juge#juger(Ordinateur)
	 */
	public Juge(Ordinateur o) {
		souhait = o;
		
		ArrayList<String> famille_Mecanique = new ArrayList<>();
		famille_Mecanique.add("SSD");
		ArrayList<String> famille_SSD = new ArrayList<>(); // vide
		disque = new TreeMap<>();
		disque.put("Mécanique", famille_Mecanique);
		disque.put("SSD", famille_SSD);
		
		ArrayList<String> famille_Fixe = new ArrayList<>(); //vide
		famille_Fixe.add("Portable");
		ArrayList<String> famille_Portable = new ArrayList<>();
		type = new TreeMap<>();
		type.put("Fixe", famille_Fixe);
		type.put("Portable", famille_Portable);
		
		ArrayList<String> famille_MSI = new ArrayList<>();
		famille_MSI.add("ASUS");
		ArrayList<String> famille_PNY = new ArrayList<>();
		famille_PNY.add("EVGA");
		famille_MSI.add("MSI");
		famille_MSI.add("ASUS"); 
		ArrayList<String> famille_ASUS = new ArrayList<>();
		ArrayList<String> famille_EVGA = new ArrayList<>();
		famille_EVGA.add("PNY");
		famille_EVGA.add("MSI");
		famille_EVGA.add("ASUS");
		CG = new TreeMap<>();
		CG.put("MSI", famille_MSI);
		CG.put("PNY", famille_PNY);
		CG.put("ASUS", famille_ASUS);
		CG.put("EVGA", famille_EVGA);
		
		ArrayList<String> famille_standard = new ArrayList<>();
		ArrayList<String> famille_micro = new ArrayList<>();
		famille_micro.add("ATX_standard");
		ArrayList<String> famille_mini = new ArrayList<>();
		famille_mini.add("ATX_standard"); famille_mini.add("micro_ATX");
		CM = new TreeMap<>();
		CM.put("ATX_standard", famille_standard);
		CM.put("micro_ATX", famille_micro);
		CM.put("mini_ITX", famille_mini);
	}
	
	/**
	 * Cette méthode donne un score à l'ordinateur passé en paramètre. Chaque critère ajoute au score un montant différent 
	 * plus ou moins grand en fonction de l'importance du critère pour ce mode de recherche.<br> 
	 * De plus les critères : <ul>
	 * <li>Type de disque dur : "Mécaniqueé ou "SSD".</li>
	 * <li>Type d'ordinateur : "Fixe" ou "Portable".</li>
	 * <li>Fabricant de carte graphique : "PNY", "MSI", "EVGA" ou "ASUS".</li>
	 * <li>Format de carte mère : "mini_ITX", "micro_ATX" ou "ATX_standard".</li>
	 * </ul> voient chacun de leur valeurs posséder une famille.
	 * <br> Le calcul du score se fait ainsi :<ul>
	 * <li>Si l'ordinateur comparé possède la même valeur pour un de ces critère que celui souhaité alors il obtient tous les points, 
	 * sinon s'il à une valeur présente dans la famille de la valeur idéale du critère il obtient une fraction des points.
	 * Si les deux précédantes conditions sont fausses il n'obtient aucun points.</li>
	 * <li>Le prix onctionne sur un principe de marge, si l'ordinateur est en dessous du budget renseignée il obtient tous les poinsts, 
	 * si celui-ci est compris entre le budget et le budget additionné à la marge il n'obtient qu'une fraction des points. Sinon il 
	 * n'obtient rien.</li>
	 * <li>Le calcul du score pour la ram est différent pour les profils.</li>
	 * </ul>
	 * @param o L'Ordinateur qui doit être noté
	 */
	public void juger(Ordinateur o) {};
}
