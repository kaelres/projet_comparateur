package IHM;

import java.awt.BorderLayout;

import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Panneau_admin_global extends JPanel
{
	
	Panneau_admin_global(Fenetre_admin f)
	{
		
		setLayout(new BorderLayout());
		Panneau_admin_ajout p1=new Panneau_admin_ajout(f);
		Panneau_admin_modifier_supprimer p2=new Panneau_admin_modifier_supprimer(f);
		JTabbedPane onglets = new JTabbedPane(SwingConstants.TOP);
		onglets.addTab("Ajouter", p1);
		onglets.addTab("Modifier/Supprimer", p2);
		onglets.setOpaque(true);
		add(onglets);
	}
}
