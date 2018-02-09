package modele;

public class Reservation {

	private String loginClient;
	private int idOrdi;
	private double prixTransaction;
	private String nomOrdi;
	private String nomClient;
	
	public Reservation(String login, int id, double prix, String ordinateur, String client) {
		loginClient = login;
		idOrdi = id;
		prixTransaction = prix;
		nomOrdi = ordinateur;
	}

	public String getLogin_client() { return loginClient;}
	public void setLogin_client(String login_client) { this.loginClient = login_client;}

	public int getId_ordi() { return idOrdi;}
	public void setId_ordi(int id_ordi) { this.idOrdi = id_ordi;}

	public double getPrix() { return prixTransaction;}
	public void setPrix(double prix_transaction) { this.prixTransaction = prix_transaction;}

	public String toString() {
		String str = "Client : "+nomClient+"\n";
		str += "Ordinateur : "+nomOrdi+"\n";
		str += "Identifiant produit : "+idOrdi+"\n";
		str += "Prix de la transaction : "+prixTransaction+"\n";
		str += "Rservé sous le login : "+loginClient+"\n";
		return str;
	}
}
