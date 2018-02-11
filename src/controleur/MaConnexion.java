package controleur;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

/**
 * Classe mettant en place le design pattern "Singleton".
 * Elle permet l'accès à un objet de type "Connection" de la JDBC et empêche la
 * création de multiples instances.
 * @author Francois
 */
public class MaConnexion {
	
	/**
	 * <p>Connection à la base de donnée.</p>
	 * <p> Elle est de type statique afin d'être manipulable par getInstance().</p>
	 */
	private static Connection connec;
	
	/**
	 * <p>Url de la base de donnée nécessaire à l'établissement d'une connexion. 
	 * Celle-ci n'est pas modifiable afin d'éviter le dysfonctionnement du système.</p>
	 */
	private final String url = "jdbc:postgresql://postgresql-francois-even.alwaysdata.net:5432/francois-even_bdd";
	
	/**
	 * <p>Login utilisé par l'usager pour tenter de se connecter.</p>
	 */
	private static String usr;
	
	/**
	 * <p>Mot de passe utilisé par l'utilisateur pour tenter de se connecter.</p>
	 */
	private static String passwd;
	
	/**
	 * Booléen permettant de conserver les privilèges de l'utilisateur connecté.
	 */
	private static boolean admin = false;
	
	/**
	 * Constructeur privé créant une connexion à l'aide d'un url, d'un mot de passe et d'un login.
	 * De plus vérifie si la personne qui se connecte possède des droits d'aministration ou non.
	 * @throws SQLException Exception SQL potentielle à l'utilisation de méthode de la JDBC
	 * @throws PSQLException Exception PSQL potentielle à l'utilisation de méthode de la JDBC
	 */
	private MaConnexion() throws SQLException, PSQLException {
		connec = DriverManager.getConnection(url, usr, passwd);
		checkAdmin();
	}
	
	/**
	 * Cette méthode vérifie si il existe déjà une instance de connexion avec la base de données.
	 * Si ce n'est pas le cas une nouvelle est créée avec les identifiants clients actuellements enregistrés en attribut.
	 * Suite à cela, qu'une nouvelle instance est été créée ou non, l'instance de connexion est renvoyée.
	 * @return renvoie un lien ver l'objet "Connection" faisant liaison avec la base de données. 
	 * @throws SQLException Exception SQL potentielle à l'utilisation de méthode de la JDBC
	 * @throws PSQLException Exception PSQL potentielle à l'utilisation de méthode de la JDBC
	 */
	public static Connection getInstance() throws SQLException, PSQLException{
	    if(connec == null){
	      new MaConnexion();
	    } 
	    return connec;
	}
	
	/**
	 * Cette méthode statique permet de mettre à jour les identifiants et mot de passe utilisé pour créer une nouvelle connexion
	 * à la base de données. Aucune vérification n'est faite sur leur validitée.
	 * @param u Chaîne de charactère correspondant au login utilisateur
	 * @param p Chaîne de charactère correspondant au mot de passe utilisateur
	 */
	public static void setID(String u, String p) {
		usr = u;
		passwd = p;
	}
	
	/**
	 * Cette mthode donne accès à l'attribut usr en elcture
	 * @return Renvoie le login utilisateur actuellement enregistré. 
	 */
	public static String getUsr() { return usr;}
	
	/**
	 * Cette méthode ferme la connexion avec la base de donnée et réinitialise la classe à son été initial.
	 */
	public static void clean() {
		try {
			connec.close();
			connec = null;
			usr = "";
			passwd = "";
			admin = false;
		} catch (PSQLException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * Cette méthode met l'attribut booléen "admin" à true. 
	 * L'utilisateur est alors considéré comme administrateur par le reste de l'application.
	 */
	private static void SetAdmin() { admin = true;}
	
	/**
	 * Cette méthode permet de savoir si l'utilisateur dispose des privilèges d'administrateur.
	 * @return Renvoie l'attribut booléen "admin"
	 */
	public static boolean IsAdmin() { return admin;}
	
	/**
	 * Cette méthode regarde dans la table "Ordinateur" les privilèges et considère l'utilisateur comme administrateur si celui-ci peut
	 * possède comme privilèges celui d'UPDATE la table.
	 * @throws SQLException Exception SQL potentielle à l'utilisation de méthode de la JDBC
	 */
	public static void checkAdmin() throws SQLException {
		DatabaseMetaData meta = connec.getMetaData();
		ResultSet priv;
		priv = meta.getTablePrivileges(connec.getCatalog(), "%", "Ordinateur");
		String nom = MaConnexion.getUsr();
		
		while (priv.next()) {
			
		   	String privilege = priv.getString("PRIVILEGE");
		   	String grantee = priv.getString("GRANTEE");
		   	if ( (grantee.equals("\\\""+nom+"\\\""))&&(privilege.equals("UPDATE")) ) MaConnexion.SetAdmin();
		}		    
	}
}
