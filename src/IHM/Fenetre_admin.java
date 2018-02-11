package IHM;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import org.postgresql.util.PSQLException;

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
		panneau=new Panneau_admin_global(this); 
		add(panneau);
		JScrollPane scrollPane = new JScrollPane(panneau);
		add(scrollPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
