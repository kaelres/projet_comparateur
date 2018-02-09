package controleur;

public class Controleur {
	
	public Controleur(){}
	
	public OrdiDAO getOrdiDAO() {
		if (MaConnexion.IsAdmin()) return new OrdiDAO_Admin();
		else return new OrdiDAO();
	}
	
	public ClientDAO getClientDAO() {
		return new ClientDAO();
	}
	
	public ReservationDAO getReservationDAO() {
		return new ReservationDAO();
	}
}
