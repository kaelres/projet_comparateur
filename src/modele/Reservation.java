package modele;

/**
 * Cette classe a pour but de représenter les lignes de la table "Reservation" de la base de données.
 * Une Réservation est une association entre un client et un ordinateur.<br>
 * @author Francois
 */
public class Reservation {
	
	/**
	 * Login du client effectuant la reservation.
	 */
	private String loginClient;
	/**
	 * Identifiant de l'ordi reservé.
	 */
	private int idOrdi;
	
	/**
	 * Constructeur permettant de créer une réservation contenant les deux informations nécessaires à la création d'une réservation: <ul>
	 * <li>Le login du client ayant effectué la commande.</li>
	 * <li>L'identifiant de l'ordinateur qu'il a commandé.</li>
	 * </ul>
	 * @param login Login du client effectuant une commande.
	 * @param id Identifiant du produit commandé.
	 */
	public Reservation(String login, int id) {
		loginClient = login;
		idOrdi = id;

	}

	/**
	 * Cette méthode permet de récupérer le login du client ayant effectué cette commande.
	 * @return Renvoie l'attribut "loginClient".
	 */
	public String getLogin_client() { return loginClient;}

	/**
	 * Cette méthode permet de récupérer l'identifiant de l'ordinateur commandé.
	 * @return Renvoie l'attribut "idOrdi".
	 */
	public int getId_ordi() { return idOrdi;}

}
