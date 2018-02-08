package controleur;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.postgresql.util.PSQLException;

public class MaConnexion {
	private static Connection connec;
	//private final String url = "jdbc:postgresql://localhost:5432/table_test";
	private final String url = "jdbc:postgresql://postgresql-francois-even.alwaysdata.net:5432/francois-even_bdd";
	private static String usr;
	private static String passwd;
	private static boolean admin = false;
	
	private MaConnexion() throws SQLException, PSQLException {
		connec = DriverManager.getConnection(url, usr, passwd);
		checkAdmin();
	}
	
	public static Connection getInstance() throws SQLException, PSQLException{
	    if(connec == null){
	      new MaConnexion();
	    } 
	    return connec;
	}
	
	public static void setID(String u, String p) {
		usr = u;
		passwd = p;
	}
	
	public static String getUsr() { return usr;}
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
	
	private static void SetAdmin() { admin = true;}
	
	public static boolean IsAdmin() { return admin;}
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
