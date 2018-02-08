package IHM;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;

import org.postgresql.util.PSQLException;

import controleur.Controleur;

@SuppressWarnings("serial")
public class Fenetre_admin extends JFrame
{
	private Panneau_admin_global panneau;
	
	Fenetre_admin () throws PSQLException, SQLException
	{
		super();
		this.setTitle("Accès à la Base de données");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int largeur=dim.width;
		int hauteur=dim.height;
		this.setSize( largeur/2, hauteur/2);
		this.setLocationRelativeTo(null);
		Controleur C = new Controleur();
		panneau=new Panneau_admin_global(this, C); 
		add(panneau);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
