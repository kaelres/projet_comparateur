package controleur;

/**
 * <p>Cette classe à pour but de fournir aisément à l'utilisateur les différents DAO. 
 * Celui-ci peut créer un objet Controleur et savoir quels sont les différents types de DAO disponible.</p>
 * Elle donne ainsi accès aux classes suivantes :
 * <ul>
 * <li>OrdiDAO</li>
 * <li>OrdiDAO_Admin</li>
 * <li>ClientDAO</li>
 * <li>ReservationDAO</li>
 * </ul>
 * 
 * @author Francois
 * @see OrdiDAO
 * @see OrdiDAO_Admin
 * @see ClientDAO
 * @see ReservationDAO 
 */
public class Controleur {
	
	public Controleur(){}
	
	/**
	 * Fonction associé à l'obtention d'un DAO pour l'objet "Ordinateur".
	 * @return Renvoie un OrdiDAO ou OrdiDAO_Admin en fonction des privilèges de l'utilisateur.
	 * @see OrdiDAO
	 * @see OrdiDAO_Admin
	 */
	public static OrdiDAO getOrdiDAO() {
		if (MaConnexion.IsAdmin()) return new OrdiDAO_Admin();
		else return new OrdiDAO();
	}
	
	/**
	 * Fonction associé à l'obtention d'un DAO pour l'objet  "Client"
	 * @return Renvoie un objet de type ClientDAO
	 * @see ClientDAO
	 */
	public static ClientDAO getClientDAO() {
		return new ClientDAO();
	}
	
	/**
	 * Fonction associé à l'obtention d'un DAO pour l'objet "Reservation"
	 * @return Renvoie un objet de type ReservationDAO
	 * @see ReservationDAO
	 */
	public static ReservationDAO getReservationDAO() {
		return new ReservationDAO();
	}
}
