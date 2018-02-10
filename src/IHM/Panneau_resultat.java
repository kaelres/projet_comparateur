package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.ListIterator;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import controleur.Controleur;
import controleur.ReservationDAO;
import modele.Client;
import modele.Ordinateur;
import modele.Reservation;

@SuppressWarnings("serial")
public class Panneau_resultat extends JPanel {

	private JButton b_quitter;
	private JButton b_reserver;
	private JButton b_precedant;
	private JButton b_suivant;
	
	private JLabel label_type;
	private JLabel field_type;
	
	private JLabel label_prix;
	private JLabel field_prix;
	
	private JLabel label_RAM;
	private JLabel field_RAM;
	
	private JLabel label_typeDD;
	private JLabel field_typeDD;
	
	private JLabel label_CG;
	private JLabel field_CG;
	
	private JLabel label_CM;
	private JLabel field_CM;
	
	private JLabel label_id;
	private JLabel field_id;
	
	private JLabel label_nom;
	private JLabel field_nom;
	
	private JTextArea enTete;

	private Fenetre_resultat f_res;
	private ArrayList<Ordinateur> liste;
	private Ordinateur courant;
	
	private ListIterator<Ordinateur> itePrevious;
	private ListIterator<Ordinateur> iteNext;
	
	private Controleur cont;
	private Client client;
	
	public Panneau_resultat(Fenetre_resultat f, ArrayList<Ordinateur> ordiListe, Client cl, Controleur co) {
		
		f_res = f;
		liste = ordiListe;
		itePrevious = liste.listIterator();
		iteNext = liste.listIterator();
		cont = co;
		client = cl;
		
		JPanel conteneur = new JPanel (new BorderLayout());
		
		//boutons
		b_quitter = new JButton("Quitter");
		b_quitter.addActionListener(new BoutonListenerQuitter());
		b_reserver = new JButton("Reserver");
		b_reserver.addActionListener(new BoutonListenerReserver());
		b_reserver.setEnabled(false);
		
		JPanel p_boutonBas = new JPanel();
		p_boutonBas.add(b_quitter);
		p_boutonBas.add(b_reserver);
		
		b_precedant = new JButton("Precedant");
		b_precedant.addActionListener(new BoutonListenerPrecedant());
		b_precedant.setEnabled(false);
		b_suivant = new JButton("Suivant");
		b_suivant.addActionListener(new BoutonListenerSuivant());
		b_suivant.setEnabled(false);
		
		JPanel p_boutonHaut = new JPanel();
		p_boutonHaut.add(b_precedant);
		p_boutonHaut.add(b_suivant);
		
		JPanel ButtonWrapper = new JPanel();
		ButtonWrapper.setLayout(new BoxLayout(ButtonWrapper, BoxLayout.PAGE_AXIS));
		ButtonWrapper.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonWrapper.add(p_boutonHaut);
		ButtonWrapper.add(Box.createRigidArea(new Dimension(0, 10)));
		ButtonWrapper.add(p_boutonBas);
		conteneur.add(ButtonWrapper, BorderLayout.SOUTH);
		
		//Critères
		
		enTete = new JTextArea("Aucun résultat n'a été trouvé");
		enTete.setOpaque(false);
		enTete.setEditable(false);
		
		if (iteNext.hasNext()) {
			courant = iteNext.next();
			enTete.setText("Vous trouverez ci-dessous les ordinateurs trouvés.\n"
							+ "La première ligne de boutons permet de naviguer.\n");
			b_reserver.setEnabled(true);
			if (iteNext.hasNext()) b_suivant.setEnabled(true);
		} else 
			courant = new Ordinateur (1, 2, "Mecanique", "Portable", "MSI", "ATX_standard", "Aucun ordinateur dans la liste", -1);
		
		
		JPanel p1 = new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_type = new JLabel("Type d'ordinateur :");
		field_type = new JLabel();
					
		p1.add(label_type);
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(field_type);		
						
		JPanel p2 = new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_prix = new JLabel("Prix (en euros) :");
		field_prix = new JLabel();
		//indiquer la taille si ça fonctionne pas sans ?
		
		p2.add(label_prix);
		p2.add(Box.createRigidArea(new Dimension(20,0)));
		p2.add(field_prix);
					
		JPanel p3 = new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_RAM = new JLabel("Quantité de mémoire RAM (en Go) :");
		field_RAM = new JLabel();
				
		p3.add(label_RAM);
		p3.add(Box.createRigidArea(new Dimension(20,0)));
		p3.add(field_RAM);
				
		JPanel p4 = new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.LINE_AXIS));
		label_typeDD = new JLabel("Type de Disque Dur :");
		field_typeDD = new JLabel();
			
		p4.add(label_typeDD);
		p4.add(Box.createRigidArea(new Dimension(20,0)));
		p4.add(field_typeDD);
				
		JPanel p5 = new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.LINE_AXIS));
		label_CG = new JLabel("Marque de la Carte Graphique :");
		field_CG = new JLabel();
				
		p5.add(label_CG);
		p5.add(Box.createRigidArea(new Dimension(20,0)));
		p5.add(field_CG);
				
		JPanel p6 = new JPanel();
		p6.setLayout(new BoxLayout(p6,BoxLayout.LINE_AXIS));
		label_CM = new JLabel("Format de la carte mère :");
		field_CM = new JLabel();
		
		p6.add(label_CM);
		p6.add(Box.createRigidArea(new Dimension(20,0)));
		p6.add(field_CM);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new BoxLayout(p7,BoxLayout.LINE_AXIS));
		label_id = new JLabel("Identifiant :");
		field_id = new JLabel();
		
		p7.add(label_id);
		p7.add(Box.createRigidArea(new Dimension(20,0)));
		p7.add(field_id);
		
		JPanel p8 = new JPanel();
		p8.setLayout(new BoxLayout(p8,BoxLayout.LINE_AXIS));
		label_nom = new JLabel("Nom :");
		field_nom =new JLabel();
		
		p8.add(label_nom);
		p8.add(Box.createRigidArea(new Dimension(20,0)));
		p8.add(field_nom);
		
		maj_ihm();
		
		JPanel p_formu=new JPanel();
		p_formu.setLayout(new BoxLayout(p_formu, BoxLayout.PAGE_AXIS));
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(enTete);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p1);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p2);
		p_formu.add(Box.createRigidArea(new Dimension(0,30)));
		p_formu.add(p3);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p4);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p5);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p6);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p7);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p8);
		
		conteneur.add(p_formu);
		add(conteneur);
	}

	
	private void maj_ihm() {
		
		Ordinateur o = courant;
		
		this.field_type.setText(o.getType());
		this.field_prix.setText(""+o.getPrix());
		this.field_RAM.setText(""+o.getRAM());
		this.field_typeDD.setText(o.getDisque());
		this.field_CG.setText(o.getCg());
		this.field_CM.setText(o.getCm());
		this.field_id.setText(""+o.getId());
		this.field_nom.setText(o.getNom());
	}
	
	class BoutonListenerQuitter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			f_res.dispose();
		}
		
	}
	
	class BoutonListenerReserver implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Reservation r = new Reservation(client.getLogin(), courant.getId());
			ReservationDAO dao = cont.getReservationDAO();
			dao.add(r);
		}
		
	}
	
	
	//On encadre le courant avec un iterateur avant et après
	//Un se charge des precedances et l'auvre des elements qui suivent
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
