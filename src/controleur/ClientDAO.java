package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.postgresql.util.PSQLException;

import modele.Client;

public class ClientDAO {
	
	public ClientDAO(){}
	
	public Client search(String login) throws PSQLException, SQLException {
		//Obligation de placer un throws, impossible de return le client sinon
		
		String query = "SELECT * FROM \"Client\" WHERE login = \'"+login+"\'";
		Statement st= MaConnexion.getInstance().createStatement();
		ResultSet result = st.executeQuery(query);
		return new Client(result.getString(2), result.getString(3), result.getString(4));		
		
	}
}
