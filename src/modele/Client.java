package modele;

import java.util.ArrayList;

import controleur.MaConnexion;

public class Client {

	private String nom;
	private String prenom;
	private String mail;
	private String login;
	private ArrayList<Reservation> resas;
	
	public Client(String n, String p, String m) {
		login = MaConnexion.getUsr();
		nom = n;
		prenom = p;
		mail = m;
	}

	public String getNom() { return nom;}
	public void setNom(String nom) { this.nom = nom;}

	public String getPrenom() { return prenom;}
	public void setPrenom(String prenom) { this.prenom = prenom;}

	public String getMail() { return mail;}
	public void setMail(String mail) { this.mail = mail;}

	public String getLogin() { return login;}
	public void setLogin(String login) { this.login = login;}

	public ArrayList<Reservation> getResas() { return resas;}
	public void setResas(ArrayList<Reservation> resas) { this.resas = resas;}
}
