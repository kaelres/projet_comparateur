package controleur;

public class Controleur {
	
	public OrdiDAO getOrdiDAO() {
		if (MaConnexion.IsAdmin()) return new OrdiDAO_Admin();
		else return new OrdiDAO();
	}
}
