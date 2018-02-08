package IHM;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class Fenetre_authentification extends JFrame
{
	private Panneau_authentification panneau;
	public Fenetre_authentification ()
	{
		super();
		this.setTitle("Authentification");
		Toolkit tk=Toolkit.getDefaultToolkit();
		Dimension dim=tk.getScreenSize();
		int largeur=dim.width;
		int hauteur=dim.height;
		this.setSize( largeur/2, hauteur/2);
		this.setLocationRelativeTo(null);
		panneau=new Panneau_authentification(this); 
		add(panneau);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); 
	}
}
