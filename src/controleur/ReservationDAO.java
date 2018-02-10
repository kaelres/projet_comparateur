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
		
		try {
			Statement st = MaConnexion.getInstance().createStatement();
			ResultSet result = st.executeQuery(query);
			
			while (result.next()) {

				String login = result.getString(1);
				int id = result.getInt(2);
				Reservation r = new Reservation(login, id);
				array.add(r);
			}
		} catch (PSQLException e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(	null, 
											"Erreur PSQL lors de la récupération d'une résérvation", 
											"Etat de l'opération", 
											JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			JOptionPane.showMessageDialog(	null, 
											"Erreur SQL lors de la récupération d'une résérvation", 
											"Etat de l'opération", 
											JOptionPane.INFORMATION_MESSAGE);
			e.printStackTrace();
		}
		
		return array;
		
	}

	public void add(Reservation resa) {
		String query = "INSERT INTO \"Reservation\" VALUES (\'"+resa.getLogin_client()+"\', "+resa.getId_ordi()+")";
		String str = "La création de la réservation à ";
		
		try {
			Statement st = MaConnexion.getInstance().createStatement();			
			st.executeUpdate(query);
			str += "réussie.\n Celle-ci sera visible à votre prochaine connexion.";
			
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
