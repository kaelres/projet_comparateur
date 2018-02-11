package IHM;

import java.awt.BorderLayout;
import java.sql.SQLException;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import org.postgresql.util.PSQLException;

import controleur.ClientDAO;
import controleur.Controleur;
import controleur.MaConnexion;
import modele.Client;

@SuppressWarnings("serial")
public class Panneau_client extends JPanel
{
	Panneau_client(Fenetre_client f) throws PSQLException, SQLException
	{
		ClientDAO daoC = Controleur.getClientDAO();
		Client client = daoC.search(MaConnexion.getUsr());
		
		setLayout(new BorderLayout());
		Panneau_critere p1=new Panneau_critere(f, client);
		Panneau_compte_client p2=new Panneau_compte_client(f, client);
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		onglets.addTab("Recherche", p1);
		onglets.addTab("Mon compte", p2);
		onglets.setOpaque(true);
		add(onglets);
	}
}
