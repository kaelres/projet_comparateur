package IHM;

import java.awt.BorderLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;

public class Panneau_compte_client extends JPanel
{

	private Fenetre_client f_cri;
	private Controleur cont;
	
	private JLabel label_nom;
	private JLabel field_nom;
	
	private JLabel label_prenom;
	private JLabel field_prenom;
	
	private JLabel label_email;
	private JLabel field_email;


	Panneau_compte_client(Fenetre_client f, Controleur c)
	{
		f_cri=f;
		cont =c;
		JPanel conteneur=new JPanel();
		conteneur.setLayout(new BorderLayout());
		JPanel p_info_client=new JPanel();
		p_info_client.setLayout(new BoxLayout(p_info_client, BoxLayout.PAGE_AXIS));
		
		JPanel p1=new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_nom=new JLabel("Nom :");
		p1.add(label_nom);
		field_nom=new JLabel(/*piocher le nom du client dans la BD et le mettre*/);
		p1.add(field_nom);
		p_info_client.add(p1);
		
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_prenom=new JLabel("Prénom :");
		p2.add(label_prenom);
		field_prenom=new JLabel(/*piocher le prenom du client dans la BD et le mettre*/);
		
		p2.add(field_prenom);
		p_info_client.add(p2);
		
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_email=new JLabel("Adresse e-mail :");
		p3.add(label_email);
		field_email=new JLabel(/*piocher l'email du client dans la BD et le mettre*/);
		
		p3.add(field_email);
		p_info_client.add(p3);
		
		conteneur.add(p_info_client,BorderLayout.CENTER);
		
		
		JPanel p_resa_client=new JPanel();
		/**
		 * le client doit avoir un nb de résa N à  son actif
		 * et un arraylist<ordinateur> tab_réservation
		 * int i;
		 * for (i=0;i<N;i++)
		 * {
		 * 		Jpanel p=new JPanel();
		 * 		p.setLayout(new BoxLayout(p,BoxLayout.PAGE_AXIS));
		 *  	JLabel label_nom=new JLabel(le nom de l'ordi);
		 *  	p.add(label_nom);
		 *      JLabel label_type=new JLabel(le type de l'ordi);
		 *      p.add(label_type);
		 *  	...
		 *  	p_resa_client.add(p);
		 * }
		 */
		conteneur.add(p_resa_client,BorderLayout.SOUTH);
		
		add(conteneur);
	}
}

