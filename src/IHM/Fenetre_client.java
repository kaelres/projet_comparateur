package IHM;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre_client extends JFrame
{
	private Panneau_critere p;
	Fenetre_client ()
	{
		super();
		this.setTitle("Choix des critères");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int largeur=dim.width;
		int hauteur=dim.height;
		this.setSize( largeur/2, hauteur/2);
		this.setLocationRelativeTo(null);
		p=new Panneau_critere(this);
		add(p);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
