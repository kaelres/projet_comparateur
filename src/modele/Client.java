package modele;

import java.util.ArrayList;

import controleur.MaConnexion;

/**
 * Cette classe permet de représenter sous forme d'objet les lignes de la table "Client" de la base de données.
 * Les clients sont créés manuellement par les administrateurs qui distribuent ainsi des comptes.<br>
 * Le client n'a pas a être modifié dans la base de données depuis l'application, ainsi il n'existe que des getters et pas de setters
 * pour les attributs correspondant à une colonne de la base.<br>
 * La liste des réservation est un attribut supplémentaire non présent dans la table "Client", celui-ci dspose donc d'un setter en plus du getter.
 * @author Francois
 * @see controleur.ClientDAO
 */
public class Client {

	/**
	 * Nom du client.
	 */
	private String nom;
	/**
	 * Prénom du client.
	 */
	private String prenom;
	/**
	 * Mail du client sous la forme XXX@XXX.
	 */
	private String mail;
	/**
	 * Login du client.
	 */
	private String login;
	/**
	 * Ensemble des réservations du client.
	 */
	private ArrayList<Reservation> resas;
	
	/**
	 * Constructeur permettant de créer un client. Les réservatiosn sont ajoutées par la suite et le login est récupéré dans la classe MaConnexion.
	 * @param n Nom du client
	 * @param p Prénom du client
	 * @param m Adresse e-mai ldu client
	 * @see controleur.MaConnexion
	 */
	public Client(String n, String p, String m) {
		login = MaConnexion.getUsr();
		nom = n;
		prenom = p;
		mail = m;
	}

	/**
	 * Permet l'obtention du nom du client.
	 * @return Renvoie l'attribut "nom".
	 */
	public String getNom() { return nom;}
	
	/**
	 * Permet l'obtention du prénom du client.
	 * @return Renvoie l'attribut "prenom".
	 */
	public String getPrenom() { return prenom;}

	/**
	 * Permet l'obtention de l'adresse e-mail du client.
	 * @return Renvoie l'attribut "mail".
	 */
	public String getMail() { return mail;}

	/**
	 * Permet l'obtention du login du client.
	 * @return Renvoie l'attribut "login".
	 */
	public String getLogin() { return login;}

	/**
	 * Renvoie la liste des reservations sous forme d'ArrayList.
	 * @return Renvoie l'attribut resas.
	 */
	public ArrayList<Reservation> getResas() { return resas;}
	/**
	 * Permet de fixer l'attribut résas de l'objet.
	 * @param resas Liste de reservation à affilier à ce client.
	 */
	public void setResas(ArrayList<Reservation> resas) { this.resas = resas;}
}
