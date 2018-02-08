package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

import controleur.Controleur;

public class Panneau_client extends JPanel
{
	Panneau_client(Fenetre_client f, Controleur cont)
	{
		
		setLayout(new BorderLayout());
		Panneau_critere p1=new Panneau_critere(f, cont);
		Panneau_compte_client p2=new Panneau_compte_client(f, cont);
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		onglets.addTab("Recherche", p1);
		onglets.addTab("Mon compte", p2);
		onglets.setOpaque(true);
		add(onglets);
	}
}
