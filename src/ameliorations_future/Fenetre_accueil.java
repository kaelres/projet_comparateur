package ameliorations_future;

import java.awt.Dimension;
import java.awt.HeadlessException;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controleur.MaConnexion;

@Deprecated
public class Fenetre_accueil extends JFrame
{
	private Panneau_accueil panneau;

	public Fenetre_accueil() throws HeadlessException 
	{
		super();
		this.setTitle("Exercice 6");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int largeur=dim.width;
		int hauteur=dim.height;
		this.setSize( largeur/2, hauteur/2);
		this.setLocationRelativeTo(null);
		panneau=new Panneau_accueil(this); 
		add(panneau);
	}
	public static void main(String[] args) {
		String url = "jdbc:postgresql://postgresql-francois-even.alwaysdata.net:5432/francois-even_bdd";
		String usr = "francois-even_admin";
		String passwd = "admin";
		
		try {
			Connection conn = DriverManager.getConnection(url, usr, passwd);
			DatabaseMetaData meta = conn.getMetaData();
			ResultSet priv;
			priv = meta.getTablePrivileges(conn.getCatalog(), "%", "Ordinateur");
			
			while (priv.next()) {
			   	String privilege = priv.getString("PRIVILEGE");
			   	String grantee = priv.getString("GRANTEE");
			   	System.out.print(grantee+"  ");
			   	String str = grantee.substring(2, grantee.length()-2);
			   	System.out.println(str);
			}	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
