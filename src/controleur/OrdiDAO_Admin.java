package controleur;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

import org.postgresql.util.PSQLException;

import modele.Ordinateur;

/**
 * Cette classe permet la manipulation et la recherche dans la table "Ordinateur" de la base de données. Celle-ci hérite d'OrdiDAO. 
 * Toute manipulation des lignes de la table "Ordinateur" nécessitant des privilèges Administrateur lui sont délégués.
 * @author Francois
 * @see OrdiDAO
 * @see modele.Ordinateur
 */
public class OrdiDAO_Admin extends OrdiDAO{

	public OrdiDAO_Admin(){}
	
	/**
	 * Cette méthode permet l'ajout d'une ligne à la table "Ordinateur" dans la base de données. 
	 * Un message pop-up prévient l'utilisateur de la réussite (ou échec) de la procédure.
	 * @param o Objet de type "Ordinateur" représentant l'information à ajouter en base de données.
	 */
	public void add(Ordinateur o) {
		String str = "Insertion echoue !";
		try {
			String query = "INSERT INTO \"Ordinateur\" VALUES ";
			query += " (?, ?, ?, ?, ?, ?, ?, ?)";
			
			PreparedStatement prep = MaConnexion.getInstance().prepareStatement(query);
			
			prep.setDouble	(1, o.getPrix());
			prep.setInt		(2, o.getRAM());
			prep.setString	(3, o.getDisque());
			prep.setString	(4, o.getType());
			prep.setString	(5, o.getCg());
			prep.setString	(6, o.getCm());
			prep.setString	(7, o.getNom());
			prep.setInt		(8, o.getId());

			prep.executeUpdate();
			str = "Insertion reussie.";
		} catch (PSQLException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(	null, 
					str, 
					"Etat de l'opération", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Cette méthode permet la suppression d'une ligne de la table "Ordinateur" dans la base de données. 
	 * Un message pop-up prévient l'utilisateur de la réussite (ou échec) de la procédure.
	 * On utilise l'identifiant unique de l'ordinateur pour choisir quel ligne supprimer.
	 * @param o Objet de type "Ordinateur" représentant l'information à supprimer dans la base de données.
	 */
	public void remove(Ordinateur o) {
		String str = "";
		try {
			String query = "DELETE FROM \"Ordinateur\" ";
			query += "WHERE id = ?";
			PreparedStatement prep = MaConnexion.getInstance().prepareStatement(query);
			prep.setInt		(1, o.getId());
			
			prep.executeUpdate();
			str = "Suppression reussie.";
		} catch (PSQLException e) {
			str = "Suppression echoue.";
			e.printStackTrace();
		} catch (SQLException e) {
			str = "Suppression echoue.";
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(	null, 
					str, 
					"Etat de l'opération", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Cette méthode permet la mise à jour d'une ligne de la table "Ordinateur" dans la base de données. 
	 * Un message pop-up prévient l'utilisateur de la réussite (ou échec) de la procédure.
	 * On utilise l'identifiant unique à chaque ordinateur afin de désigner la ligne à mettre à jour.
	 * @param o Objet de type "Ordinateur" représentant l'information à mettre à jour dans la base de données.
	 */
	public void update(Ordinateur o) {
		String str = "";
		try {
			double prix = o.getPrix();
			int ram = o.getRAM();
			String typeDD = o.getDisque();
			String type = o.getType();
			String cg = o.getCg();
			String cm = o.getCm();
			String nom = o.getNom();
			int id = o.getId();
			
			String query = "UPDATE \"Ordinateur\" SET ";
			query += "prix = \'"+prix+"\',  ram = \'"+ram+"\', disque = \'"+typeDD+"\' ";
			query += ", type = \'"+type+"\', carte_G = \'"+cg+"\', carte_M = \'"+cm+"\' ";
			query += ", nom = \'"+nom+"\' ";
			query += "WHERE id = \'"+id+"\'";
			System.out.println("-"+query+"-");
			Statement st = MaConnexion.getInstance().createStatement();
			st.executeUpdate(query);
			str = "Mise a jour reussie.";
		} catch (PSQLException e) {
			str = "Mise a jour echoue.";
			e.printStackTrace();
		} catch (SQLException e) {
			str = "Mise a jour echoue.";
			e.printStackTrace();
		} finally {
			JOptionPane.showMessageDialog(	null, 
					str, 
					"Etat de l'opération", 
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Cette méthode permet d'effectuer une requête en base de données.
	 * @param str Requête à effectuer
	 * @return Renvoie le résultat de la requête fournie
	 * @throws PSQLException Exception PSQL potentielle à l'utilisation de méthode de la JDBC
	 * @throws SQLException Exception SQL potentielle à l'utilisation de méthode de la JDBC
	 */
	public ResultSet exec(String str) throws PSQLException, SQLException {
		
		Statement st = MaConnexion.getInstance().createStatement();
		return st.executeQuery(str);			
	}
}
