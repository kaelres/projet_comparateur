package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.postgresql.util.PSQLException;

import controleur.Controleur;
import controleur.ReservationDAO;
import modele.Client;
import modele.Reservation;

@SuppressWarnings("serial")
public class Panneau_compte_client extends JPanel
{

	private Client client;
	
	private JLabel label_nom;
	private JLabel label_prenom;	
	private JLabel label_email;	
	private JLabel label_ordi;	
	private JLabel label_client;
	
	private JLabel field_nom;
	private JLabel field_prenom;
	private JLabel field_email;
	private JLabel field_ordi;
	private JLabel field_client;
	
	private JButton b_precedant;
	private JButton b_suivant;
	
	private ArrayList<Reservation> liste;
	private ListIterator<Reservation> itePrevious;
	private ListIterator<Reservation> iteNext;
	private Reservation courant;

	Panneau_compte_client(Fenetre_client f, Client cl) throws PSQLException, SQLException
	{

		client = cl;
		
		ReservationDAO daoR = Controleur.getReservationDAO();
		client.setResas(daoR.search(client));
		
		JPanel conteneur=new JPanel();
		conteneur.setLayout(new BorderLayout());
		JPanel p_info_client=new JPanel();
		p_info_client.setLayout(new BoxLayout(p_info_client, BoxLayout.PAGE_AXIS));
		
		JPanel p1=new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_nom=new JLabel("Nom : ");
		p1.add(label_nom);
		field_nom=new JLabel(client.getNom());
		p1.add(field_nom);
		p_info_client.add(p1);
		
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_prenom=new JLabel("Prénom : ");
		p2.add(label_prenom);
		field_prenom=new JLabel(client.getPrenom());
		
		p2.add(field_prenom);
		p_info_client.add(p2);
		
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_email=new JLabel("Adresse e-mail : ");
		p3.add(label_email);
		field_email=new JLabel(client.getMail());
		
		p3.add(field_email);
		p_info_client.add(p3);
		
		p_info_client.add(Box.createRigidArea(new Dimension(20, 20)));
		
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4, BoxLayout.LINE_AXIS));
		label_ordi = new JLabel("Identifiant produit : ");
		field_ordi = new JLabel("\\");
		
		p4.add(label_ordi);
		p4.add(field_ordi);
		p_info_client.add(p4);
		
		JPanel p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5, BoxLayout.LINE_AXIS));
		label_client = new JLabel("Identifiant client : ");
		field_client = new JLabel("\\");
		
		p5.add(label_client);
		p5.add(field_client);
		p_info_client.add(p5);
		
		JPanel p6 = new JPanel();
		b_precedant = new JButton("Précédant");
		b_precedant.setEnabled(false);
		b_precedant.addActionListener(new BoutonListenerPrecedant());
		b_suivant = new JButton("Suivant");
		b_suivant.setEnabled(false);
		b_suivant.addActionListener(new BoutonListenerSuivant());
		
		p6.add(b_precedant);
		p6.add(b_suivant);
		p_info_client.add(p6);
		
		conteneur.add(p_info_client,BorderLayout.CENTER);
		
		liste = client.getResas();
		if (!liste.isEmpty() ) {
			itePrevious = liste.listIterator();
			iteNext = liste.listIterator();
			courant = iteNext.next();
			if (iteNext.hasNext()) b_suivant.setEnabled(true);
		} else
			courant = new Reservation("\\", -1);
		maj_ihm();
		add(conteneur);
	}
	
	public void maj_ihm() {
		Reservation r = courant;
		field_client.setText(r.getLogin_client());
		field_ordi.setText(r.getId_ordi()+"");
	}

	class BoutonListenerPrecedant implements ActionListener {

		@Override
		//itePrevious est toujours un pas avant ou au même endroit que iteNext, inutile de check next donc
		public void actionPerformed(ActionEvent arg0) {
			if (itePrevious.hasPrevious()) {
				
				//affichage du précédant
				iteNext.previous();
				courant = itePrevious.previous();				
				maj_ihm();

				//mise à jour de l'état des boutons
				b_suivant.setEnabled(true);
				if (!itePrevious.hasPrevious()) b_precedant.setEnabled(false);
			}
		}
		
	}
	
	class BoutonListenerSuivant implements ActionListener {

		@Override
		//iteNext est toujours un pas plus loin ou au même endroit que itePrevious, inutile de check previous donc
		public void actionPerformed(ActionEvent arg0) {
			if (iteNext.hasNext()) {
				
				//affichage du suivant
				itePrevious.next();
				courant = iteNext.next();
				maj_ihm();
				
				//mise à jour de l'état des boutons
				b_precedant.setEnabled(true);
				if (!iteNext.hasNext()) b_suivant.setEnabled(false);
			}
		}
		
	}
}

