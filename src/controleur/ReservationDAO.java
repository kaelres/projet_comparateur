package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import modele.Client;
import modele.Reservation;

/**
 * Cette classe permet la recherche et l'ajout en base de données dans la table "Reservation".
 * Toute action sur les lignes de la table "Reservation" est déléguée à cette classe.
 * @author Francois
 * @see modele.Reservation
 */
public class ReservationDAO {

	public ReservationDAO() {}
	
	/**
	 * Cette méthode permet d'obtenir l'ensemble des réservatiosn d'un client donné. Un message pop-up indique à l'utilisateur la
	 * réussite (ou l'échec) de la procédure.
	 * @param client Objet de type "Client" représentant le client dont on souhaite obtenir la liste des reservations.
	 * @return Renvoie une liste d'objet de type "Reservation" qui représente la liste des réservation du client.
	 */
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
	
	/**
	 * Cette méthode permet l'ajout d'une ligne dans la table "Reservation" de la base de données. 
	 * Un message pop-up prévient l'utilisateur de la réussite (ou échec) de la procédure.
	 * @param resa Objet de type "Reservation" représentant l'information à ajouter en base de données.
	 */
	public void add(Reservation resa) {
		String query = "INSERT INTO \"Reservation\" VALUES (\'"+resa.getLogin_client()+"\', "+resa.getId_ordi()+")";
		String str = "La création de la réservation à ";
		
		try {
			Statement st = MaConnexion.getInstance().createStatement();			
			st.executeUpdate(query);
			str += "réussie.\n Celle-ci sera visible à votre prochaine connexion.";
			
		} catch (SQLException e) {
			str += "échouée.\n Vous avez déjà faite cette réservation.";
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(	null, 
											str, 
											"Etat de l'opération", 
											JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
