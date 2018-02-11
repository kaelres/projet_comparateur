package modele;

/**
 * Classe permettant de donner un score à un ordinateur avec des critères pesées pour une 
 * personne souhaitant jouer avec son ordinateur. Elle implémente l'interface Juge.
 * @author Francois
 * @see Juge
 */
public class JugeBureautique extends Juge {
	
	/**
	 * Ce contructeur passe la main au constructeur de sa classe abstraite mère, Juge.
	 * @param o Ordinateur idéal souhaité par le client.
	 * @see Juge#Juge(Ordinateur)
	 */
	public JugeBureautique(Ordinateur o) {
		super(o);
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
	 * <li>La ram existe en valeur de 2, 4, 8, 16 et 32 Go. Si l'ordinateur possède la ram demandée il obtient tous les points, mais 
	 * s'il possède une RAM deux fois plus elevée ou moins élevée que celle souhaitée il n'obtient qu'une fraction des points.  
	 * Si les deux précédantes conditions sont fausses il n'obtient aucun point.</li>
	 * </ul>
	 * @param o L'Ordinateur qui doit être noté
	 */
	public void juger(Ordinateur o) {
		double score = 0;
		
		//prix;
		double marge = Math.max(50, 0.15*o.getPrix());
		if (souhait.getPrix() >= o.getPrix()) score += 40;
		else if (souhait.getPrix() >= marge+o.getPrix()) score += 15;
		
		//ram
		if (souhait.getRAM() == o.getRAM()) score += 5;
		else if ( (souhait.getRAM() == 2*o.getRAM()) || (2*souhait.getRAM() == o.getRAM()) ) score += 2;
		
		//disque
		if (souhait.getDisque().equals(o.getDisque())) score += 10;
		else if (disque.get(souhait.getDisque()).contains(o.getDisque())) score += 5;		
		
		//type
		if (souhait.getType().equals(o.getType())) score += 30;
		else if (type.get(souhait.getType()).contains(o.getType())) score += 15;
		
		//cg
		if (souhait.getCg().equals(o.getCg())) score += 5;
		else if (CG.get(souhait.getCg()).contains(o.getCg())) score += 2;
		
		//cm
		if (souhait.getCm().equals(o.getCm())) score += 15;
		else if (CM.get(souhait.getCm()).contains(o.getCm())) score += 8;
		
		//conclusion
		o.setScore(score);
	}

}
