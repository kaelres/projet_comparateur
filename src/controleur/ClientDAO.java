package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.PSQLException;

import modele.Client;

/**
 * Cette classe à pour but la recherche dans la base de donnée du client actuellement connecté.
 * Toute recherche en base de données de la table Client est déléguée à cette classe.
 * @author Francois
 * @see modele.Client
 */
public class ClientDAO {
	
	public ClientDAO(){}
	
	/**
	 *  Permet de récuperer les informations du client connecté sous forme d'objet "Client".
	 * @param nom Correspond au login du client avec lequel il se connecte.
	 * @return Un objet client formé à l'aide des informations de la base de données et correspondant au client connecté.
	 * @throws PSQLException Exception PSQL potentielle à l'utilisation de méthode de la JDBC
	 * @throws SQLException Exception SQL potentielle à l'utilisation de méthode de la JDBC
	 * @see modele.Client
	 */
	public Client search(String nom) throws PSQLException, SQLException {
		//Obligation de placer un throws, impossible de return le client sinon
		
		String query = "SELECT * FROM \"Client\" WHERE login = \'"+nom+"\'";
		Statement st= MaConnexion.getInstance().createStatement();
		ResultSet result = st.executeQuery(query);
		result.next();
		return new Client(result.getString(2), result.getString(3), result.getString(4));		
		
	}
}
