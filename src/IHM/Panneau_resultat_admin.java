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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.OrdiDAO_Admin;
import modele.Ordinateur;

@SuppressWarnings("serial")
public class Panneau_resultat_admin extends JPanel {

	private JButton b_quitter;
	private JButton b_modifier;
	private JButton b_supprimer;
	private JButton b_precedant;
	private JButton b_suivant;
	
	private JLabel label_type;
	private JComboBox<String> liste_type;
	
	private JLabel label_prix;
	private JTextField champ_prix;
	
	private JLabel label_RAM;
	private JComboBox<Integer> liste_RAM;
	
	private JLabel label_typeDD;
	private JComboBox<String> liste_typeDD;
	
	private JLabel label_CG;
	private JComboBox<String> liste_CG;
	
	private JLabel label_CM;
	private JComboBox<String> liste_CM;
	
	private JLabel label_id;
	private JTextField champ_id;
	
	private JLabel label_nom;
	private JTextField champ_nom;
	
	private JTextArea enTete;

	private Fenetre_resultat_admin f_res;
	private ArrayList<Ordinateur> liste;
	private Ordinateur courant;
	
	private ListIterator<Ordinateur> itePrevious;
	private ListIterator<Ordinateur> iteNext;
	private boolean avancerAuDernier = true;;
	
	private Controleur cont;
	OrdiDAO_Admin dao;
	
	public Panneau_resultat_admin(Fenetre_resultat_admin f, ArrayList<Ordinateur> ordiListe, Controleur C) {
		
		f_res = f;
		liste = ordiListe;
		itePrevious = liste.listIterator();
		iteNext = liste.listIterator();
		cont = C;
		dao = (OrdiDAO_Admin )cont.getOrdiDAO();
		
		JPanel conteneur = new JPanel (new BorderLayout());
		
		//boutons en SOUTH
		b_quitter = new JButton("Quitter");
		b_quitter.addActionListener(new BoutonListenerQuitter());
		b_modifier = new JButton("Modifier");
		b_modifier.addActionListener(new BoutonListenerModifier());
		b_supprimer = new JButton("Supprimer");
		b_supprimer.addActionListener(new BoutonListenerSupprimer());
		
		JPanel p_boutonBas = new JPanel();
		p_boutonBas.add(b_quitter);
		p_boutonBas.add(b_modifier);
		p_boutonBas.add(b_supprimer);
		
		b_precedant = new JButton("Précédent");
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
		
		//CENTER
		
		enTete = new JTextArea("Aucun résultat n'a été trouvé");
		if (iteNext.hasNext()) {			
			courant = iteNext.next();
			enTete.setText("Vous trouverez ci-dessous les ordinateurs trouvés.\n"
							+ "Leurs caractéristiques sont visibles ci-dessous et modifiables.\n"
							+ "La première ligne de boutons permet de naviguer.\n"
							+ "La seconde d'agir sur l'Ordinateur ou de quitter.");
			if (iteNext.hasNext()) b_suivant.setEnabled(true);
		}
		else 
			courant = new Ordinateur (1, 2, "Mecanique", "Portable", "MSI", "ATX_standard", "Aucun ordinateur dans la liste", -1);

		enTete.setOpaque(false);
		enTete.setEditable(false);
		
		JPanel p1=new JPanel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_type=new JLabel("Type d'ordinateur :");
		String[] liste_choixType= {"Portable","Fixe"};
		liste_type=new JComboBox<String>(liste_choixType);
		liste_type.setLightWeightPopupEnabled (false);
				
		p1.add(label_type);
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(liste_type);		
						
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_prix=new JLabel("Prix (en euros) :");
		champ_prix=new JTextField(10);
		
		p2.add(label_prix);
		p2.add(Box.createRigidArea(new Dimension(20,0)));
		p2.add(champ_prix);
					
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_RAM=new JLabel("Quantité de mémoire RAM (en Go) :");
		Integer[] liste_choixRAM= {2,4,8,16,32};
		liste_RAM= new JComboBox<Integer>(liste_choixRAM);
		liste_RAM.setLightWeightPopupEnabled (false);
				
		p3.add(label_RAM);
		p3.add(Box.createRigidArea(new Dimension(20,0)));
		p3.add(liste_RAM);
				
		JPanel p4=new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.LINE_AXIS));
		label_typeDD=new JLabel("Type de Disque Dur :");
		String[] liste_choixDD= {"Mécanique","SSD"};
		liste_typeDD=new JComboBox<String>(liste_choixDD);
		liste_typeDD.setLightWeightPopupEnabled (false);
			
		p4.add(label_typeDD);
		p4.add(Box.createRigidArea(new Dimension(20,0)));
		p4.add(liste_typeDD);
				
		JPanel p5=new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.LINE_AXIS));
		label_CG=new JLabel("Marque de la Carte Graphique :");
		String[] liste_choixCG= {"MSI","PNY","ASUS","EVGA"};
		liste_CG=new JComboBox<String>(liste_choixCG);
		liste_CG.setLightWeightPopupEnabled (false);
				
		p5.add(label_CG);
		p5.add(Box.createRigidArea(new Dimension(20,0)));
		p5.add(liste_CG);
				
		JPanel p6=new JPanel();
		p6.setLayout(new BoxLayout(p6,BoxLayout.LINE_AXIS));
		label_CM=new JLabel("Format de la carte mère :");
		String[] liste_choixCM= {"ATX_standard","micro_ATX","mini_ITX"};
		liste_CM=new JComboBox<String>(liste_choixCM);
		liste_CM.setLightWeightPopupEnabled (false);
		
		p6.add(label_CM);
		p6.add(Box.createRigidArea(new Dimension(20,0)));
		p6.add(liste_CM);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new BoxLayout(p7,BoxLayout.LINE_AXIS));
		label_id = new JLabel("Identifiant :");
		champ_id=new JTextField(10);
		champ_id.setEditable(false);
		
		p7.add(label_id);
		p7.add(Box.createRigidArea(new Dimension(20,0)));
		p7.add(champ_id);
		
		JPanel p8 = new JPanel();
		p8.setLayout(new BoxLayout(p8,BoxLayout.LINE_AXIS));
		label_nom = new JLabel("Nom :");
		champ_nom =new JTextField(10); 
		
		p8.add(label_nom);
		p8.add(Box.createRigidArea(new Dimension(20,0)));
		p8.add(champ_nom);		
		
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

	
	public void maj_ihm() {
		
		Ordinateur o = courant;
		this.liste_type.getModel().setSelectedItem(o.getType());
		this.champ_prix.setText(""+o.getPrix());
		this.liste_RAM.getModel().setSelectedItem(o.getRAM());
		this.liste_typeDD.getModel().setSelectedItem(o.getDisque());
		this.liste_CG.getModel().setSelectedItem(o.getCg());
		this.liste_CM.getModel().setSelectedItem(o.getCm());
		this.champ_id.setText(""+o.getId());
		this.champ_nom.setText(""+o.getNom());
		
		if (liste.isEmpty()) {
			b_modifier.setEnabled(false);
			b_supprimer.setEnabled(false);
		}
	}
	
	class BoutonListenerQuitter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			f_res.dispose();
			
		}
		
	}
	
	class BoutonListenerModifier implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			//On supprime les espaces avant et apr�s le nom
			String str = champ_nom.getText();
			String passageUn = str.replaceAll("\\s+$", "");
			String nom = passageUn.replaceAll("^\\s+", ""); 
		    
		    //On supprime tous les espaces du prix pour �viter une NUmberFormatException
		    str = champ_prix.getText();
		    String prixStr = str.replaceAll("\\s", "");
		    try {
		    		double prix = Double.parseDouble(prixStr);
		    		
		    		if (prix <= 0) throw new ExceptionPrix();
		    		if (nom.equals("")) throw new ExceptionNom();
		    		
					int ram = (int )liste_RAM.getSelectedItem();
					String disque = (String )liste_typeDD.getSelectedItem();
					String type = (String )liste_type.getSelectedItem();
					String cg = (String )liste_CG.getSelectedItem();
					String cm = (String )liste_CM.getSelectedItem();
					int id = courant.getId();
				
					Ordinateur o = new Ordinateur (prix, ram, disque, type, cg, cm, nom, id);
					dao.update(o);
					
					int index = liste.indexOf(courant);
					liste.set(index, o);
					courant = o;
					maj_ihm();
					
		    } catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(	null, 
						"Le prix ne doit pas contenir de lettre", 
						"Erreur de prix", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (ExceptionPrix e) {
				JOptionPane.showMessageDialog(	null, 
												"Le prix doit être positif et celui-ci doit obligatoirement �tre renseign�.", 
												"Erreur de prix", 
												JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (ExceptionNom e) {
				JOptionPane.showMessageDialog(	null, 
												"Le champ nom ne peut être laissé vide.", 
												"Erreur de nom", 
												JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
			
		}
		
	}
	
	class BoutonListenerSupprimer implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			Ordinateur o = courant;
			
			//suppression en BDD
			dao.remove(o);
			
			itePrevious.next();
			itePrevious.previous();
			
			//supression de la liste
			if (!liste.isEmpty()) {
				itePrevious.remove();
				
				//remise du curseur en début de liste
				itePrevious = liste.listIterator();
				iteNext = liste.listIterator();
				b_precedant.setEnabled(false);
				b_suivant.setEnabled(false);
				
				if (iteNext.hasNext()) {
					courant = iteNext.next();
					maj_ihm();
					if (iteNext.hasNext()) b_suivant.setEnabled(true);
				}
				else {			//plus aucun element
					enTete.setText("Aucun résultat restant");
					courant = new Ordinateur (1, 2, "Mecanique", "Portable", "MSI", "ATX_standard", "Aucun ordinateur restant dans la liste", -1);
					maj_ihm();
				}
			}
			
			
		}
		
	}
	
	
	//On encadre le courant avec un iterateur avant et après
	//Un se charge des precedances et l'auvre des elements qui suivent
	class BoutonListenerPrecedant implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (itePrevious.hasPrevious()) {
				
				//affichage du précédant
				iteNext.previous();
				courant = itePrevious.previous();				
				maj_ihm();
				
				//mise à jour de l'état des boutons
				b_suivant.setEnabled(true);
				if (!itePrevious.hasPrevious()) b_precedant.setEnabled(false);
				
				//mise à jour du booleen utile à la suppression
				avancerAuDernier = false;
				
			}
		}
		
	}
	
	class BoutonListenerSuivant implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (iteNext.hasNext()) {
				
				//affichage du suivant
				itePrevious.next();
				courant = iteNext.next();
				maj_ihm();
				

				//mise à jour de l'état des boutons
				b_precedant.setEnabled(true);
				if (!iteNext.hasNext()) b_suivant.setEnabled(false);
				
				//mise à jour du booleen utile à la suppression
				avancerAuDernier = true;
				
			}
		}
		
	}
	
	
}
