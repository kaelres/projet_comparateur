package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import modele.ErreurPrix;
import modele.Ordinateur;

public class OrdiDAO {
	
	public OrdiDAO() {}
	
	public ArrayList<Ordinateur> search(String data) {

		ArrayList<Ordinateur> array = new ArrayList<>();
		String query = "SELECT * FROM \"Ordinateur\" ";
		query += data;
		
		
		Statement st;
		try {
			st = MaConnexion.getInstance().createStatement();
			ResultSet result = st.executeQuery(query);
			
			while (result.next()) {
				array.add(new Ordinateur (result.getDouble(1), result.getInt(2), result.getString(3),
											result.getString(4), result.getString(5), result.getString(6), 
											result.getString(7), result.getInt(8)));
			}
			
		} catch (PSQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(	null, 
											"Erreur PSQL", 
											"Etat de l'opération", 
											JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(	null, 
											"Erreur SQL", 
											"Etat de l'opération", 
											JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		} catch (ErreurPrix e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return array;
	}
}
