package ameliorations_future;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
@Deprecated
public class Panneau_accueil_bouton extends JPanel
{
	private JFrame fen_courante;
	private JButton reinit; 
	private JButton valider;
	private JButton admin;
	
	Panneau_accueil_bouton(Fenetre_accueil f)
	{
		fen_courante=f;
		reinit= new JButton("Reinitialiser");
		valider= new JButton("Valider");
		admin= new JButton("Administrateur");
		GridLayout gl=new GridLayout(1, 6);
		gl.setHgap(5);
		setLayout(gl);
		add(admin);
		JPanel panel=new JPanel(); // tres sale, a changer si le temps
		add(panel);
		add(reinit);
		add(valider);

		
		Reinit_action ca=new Reinit_action();
		reinit.addActionListener(ca);
		
		Valider_action fa=new Valider_action();
		valider.addActionListener(fa);
		
		Admin_action aa=new Admin_action();
		admin.addActionListener(aa);
	}
	
	private class Reinit_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

		}
	}
	
	private class Valider_action implements ActionListener 
	{
		public void actionPerformed(ActionEvent e)
		{

		}
	}
	
	private class Admin_action implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{

		}
	}
}
