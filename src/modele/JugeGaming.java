package modele;

/**
 * Classe permettant de donner un score à un ordinateur avec des critères pesées pour une personne souhaitant faire de la bureautique avec son ordinateur.
 * @author Francois
 * @see Juge
 */
public class JugeGaming extends Juge {
	
	
	/**
	 * Ce contructeur passe la main au constructeur de sa classe abstraite mère, Juge.
	 * @param o Ordinateur idéal souhaité par le client.
	 * @see Juge#Juge(Ordinateur)
	 */
	public JugeGaming (Ordinateur o) {
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
	 * s'il possède une RAM deux ou quatre fois plus élevée que celle souhaitée il n'obtient qu'une fraction des points. 
	 * Si les deux précédantes conditions sont fausses il n'obtient aucun point.</li>
	 * </ul>
	 * @param o L'Ordinateur qui doit être noté
	 */
	public void juger(Ordinateur o) {
		
		double score = 0;
		//prix;
		double marge = Math.max(50, 0.15*souhait.getPrix());
		if (souhait.getPrix() >= o.getPrix()) score += 5;
		else if (souhait.getPrix()+marge < o.getPrix()) score += -5;
		
		//ram
		if (souhait.getRAM() == o.getRAM()) score += 18;
		else if ( (2*souhait.getRAM() == o.getRAM()) || (4*souhait.getRAM() == o.getRAM()) ) score += 12;
		//Le gamer ne veut que autant ou plus de ram qu'il ne demande
		
		//disque
		if (souhait.getDisque().equals(o.getDisque())) score += 20;
		else if (disque.get(souhait.getDisque()).contains(o.getDisque())) score += 15;
		else score += -5;
		//un m�canique est un malus par rapport � un ssd
		
		
		//type
		if (souhait.getType().equals(o.getType())) score += 10;
		else if (type.get(souhait.getType()).contains(o.getType())) score += 5;
		
		
		
		//cg
		if (souhait.getCg().equals(o.getCg())) score += 30;
		else if (CG.get(souhait.getCg()).contains(o.getCg())) score += 20;
		
		//cm
		if (souhait.getCm().equals(o.getCm())) score += 20;
		else if (CM.get(souhait.getCm()).contains(o.getCm())) score += 15;
		
		//conclusion
		o.setScore(score);
	}

}
