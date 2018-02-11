package controleur;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import modele.Ordinateur;

/**
 * Cette classe permet la recherche dans la table "Ordinateur" de la base de données.
 * Seul les requêtes de type SELECT seront délégués à cette classe. Les autres requêtes seront délégués à sa classe fille, OrdiDAo_Admin.
 * @author Francois
 * @see OrdiDAO_Admin
 * @see modele.Ordinateur
 */
public class OrdiDAO {
	
	public OrdiDAO() {}
	
	/**
	 * Cette méthode rend une liste d'ordinateur correspondant à la recherche effectuée avec les conditions fournies en argument.
	 * La recherche renvoie l'ensemble des champs de la table "Ordinateur".
	 * @param data Ce paramètre contient soit une chaîne vide soit des conditions de recherche en base de données commençant par "WHERE ".
	 * @return Renvoie une liste d'objet "Ordinateur" correspondant aux ordinateurs en base de données qui correspondant à la requête effectué.
	 * @see modele.Ordinateur
	 */
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
}
