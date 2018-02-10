package modele;

public class Reservation {

	private String loginClient;
	private int idOrdi;
	
	public Reservation(String login, int id) {
		loginClient = login;
		idOrdi = id;

	}

	public String getLogin_client() { return loginClient;}
	public void setLogin_client(String login_client) { this.loginClient = login_client;}

	public int getId_ordi() { return idOrdi;}
	public void setId_ordi(int id_ordi) { this.idOrdi = id_ordi;}

}
