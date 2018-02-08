package ameliorations_future;

import java.awt.BorderLayout;

import javax.swing.JPanel;

@Deprecated
public class Panneau_accueil extends JPanel
{
	private Fenetre_accueil fen_courante;
	
	Panneau_accueil(Fenetre_accueil f)
	{
		fen_courante=f;
		Panneau_accueil_bouton p1=new Panneau_accueil_bouton(fen_courante);
		Panneau_accueil_questio p2=new Panneau_accueil_questio();
		setLayout(new BorderLayout());
		add(p1,BorderLayout.SOUTH);
		add(p2,BorderLayout.CENTER);
		
	}
}
