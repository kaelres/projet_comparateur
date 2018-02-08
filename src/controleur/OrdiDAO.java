package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.postgresql.util.PSQLException;

import modele.Ordinateur;

public class OrdiDAO {
	
	public OrdiDAO() {}
	
	public ArrayList<Ordinateur> search(String data) throws PSQLException, SQLException {

		ArrayList<Ordinateur> array = new ArrayList<>();
		String query = "SELECT * FROM \"Ordinateur\" WHERE ";
		query += data;
		
		
		Statement st = MaConnexion.getInstance().createStatement();
		ResultSet result = st.executeQuery(query);
		
		while (result.next()) {
			array.add(new Ordinateur (result.getDouble(1), result.getInt(2), result.getString(3),
										result.getString(4), result.getString(5), result.getString(6), 
										result.getString(7), result.getInt(8)));
		}
		
		return array;
	}
}
