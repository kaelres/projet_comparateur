package controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import modele.Client;
import modele.Reservation;

public class ReservationDAO {

	public ReservationDAO() {}
	
	public ArrayList<Reservation> search(Client client) {
		
		ArrayList<Reservation> array = new ArrayList<>();
		String query = "SELECT * FROM \"Reservation\" WHERE login_client = \'"+client.getLogin()+"\'";
		String nomC, nomO;
		double prixO;
		ResultSet result_2;
		
		try {
			Statement st = MaConnexion.getInstance().createStatement();
			ResultSet result = st.executeQuery(query);
			
			while (result.next()) {
				
				/*Si il existe une reservation, l'ordinateur existe donc il y a moyen d'utiliser next()
				 * De plus, l'id est la clef primaire, il n'y a donc qu'un seul résultat*/
				result_2 = st.executeQuery("SELECT nom, Prix FROM \"Ordinateur\" WHERE id ="+result.getInt(2));
				result_2.next();
				nomO = result_2.getString(1);
				prixO = result_2.getDouble(2);
				
				result_2 = st.executeQuery("SELECT nom FROM \"Client\" WHERE login = \'"+client.getLogin()+"\'");
				result_2.next();
				nomC = result_2.getString(1);
				
				Reservation r = new Reservation(result.getString(1), result.getInt(2), prixO, nomO, nomC);
				array.add(r);
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
		}
		
		return array;
		
	}

	public void add(Reservation resa) {
		String query = "INSERT INTO \"Ordinateur\" VALUES (?, ?)";
		String str = "La création de la réservation à ";
		
		try {
			PreparedStatement prep = MaConnexion.getInstance().prepareStatement(query);
			
			prep.setString(1, resa.getLogin_client());;
			prep.setInt(2, resa.getId_ordi());
			
			prep.executeUpdate(query);
			str += "réussie.";
		} catch (SQLException e) {
			str += "échouée.";
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(	null, 
											str, 
											"Etat de l'opération", 
											JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
