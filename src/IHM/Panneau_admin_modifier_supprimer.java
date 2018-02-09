package IHM;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.MaConnexion;
import controleur.OrdiDAO_Admin;
import modele.Ordinateur;

@SuppressWarnings("serial")
public class Panneau_admin_modifier_supprimer extends JPanel
{
	private Fenetre_admin f_admin;
	Fenetre_resultat_admin resultatRecherche;

	private JButton b_retour1;
	private JButton b_val;

	private JButton b_retour2;
	private JButton b_annuler;
	private JButton b_rechercher;
	
//	private JLabel label_nom;
//	private JTextField champ_nom;
	
	private JPanel p_choix1;
	private JPanel p_choix2;
	
	private JLabel label_critere;
	private JCheckBox case_type;
	private JCheckBox case_prix;
	private JCheckBox case_RAM;
	private JCheckBox case_typeDD;
	private JCheckBox case_CG;
	private JCheckBox case_CM;
	private JCheckBox case_id;
	private JCheckBox case_nom;
	
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
	
	private String[] tab_critere= {"Nom","Type ordinateur","Prix","Mémoire RAM",
			"Type Disque Dur","Carte Graphique","Carte mère", "Identifiant"};
	
	private ArrayList<JCheckBox> tab1=new ArrayList<JCheckBox>();
	private ArrayList<JPanel> tab2=new ArrayList<JPanel>();
	
	private Controleur cont;
	
	public Panneau_admin_modifier_supprimer(Fenetre_admin f, Controleur c)
	{
		f_admin=f;
		cont = c;
		
		JPanel p_titre1=new JPanel();
		label_critere=new JLabel("Choix des critères");
		p_titre1.add(label_critere);
			
		JPanel p_ligne1=new JPanel();
		p_ligne1.setLayout(new BoxLayout(p_ligne1,BoxLayout.LINE_AXIS));
		case_nom = new JCheckBox(tab_critere[0]);
		case_nom.addActionListener(new CaseListener());
		p_ligne1.add(case_nom);
		case_type=new JCheckBox(tab_critere[1]);
		case_type.addActionListener(new CaseListener());
		p_ligne1.add(case_type);
		case_prix=new JCheckBox(tab_critere[2]);
		case_prix.addActionListener(new CaseListener());
		p_ligne1.add(case_prix);
		case_RAM=new JCheckBox(tab_critere[3]);
		case_RAM.addActionListener(new CaseListener());
		p_ligne1.add(case_RAM);
				
		JPanel p_ligne2=new JPanel();
		p_ligne2.setLayout(new BoxLayout(p_ligne2,BoxLayout.LINE_AXIS));
		case_typeDD=new JCheckBox(tab_critere[4]);
		case_typeDD.addActionListener(new CaseListener());
		p_ligne2.add(case_typeDD);
		case_CG=new JCheckBox(tab_critere[5]);
		case_CG.addActionListener(new CaseListener());
		p_ligne2.add(case_CG);
		case_CM=new JCheckBox(tab_critere[6]);
		case_CM.addActionListener(new CaseListener());
		p_ligne2.add(case_CM);
		case_id = new JCheckBox(tab_critere[7]);
		case_id.addActionListener(new CaseListener());
		p_ligne2.add(case_id);
			
		JPanel p_critere=new JPanel();
		p_critere.setLayout(new BoxLayout(p_critere,BoxLayout.PAGE_AXIS));
		p_critere.add(p_titre1);
		p_critere.add(p_ligne1);
		p_critere.add(p_ligne2);
		
		JPanel p_bouton1=new JPanel();
		b_retour1=new JButton("Retour");
		b_retour1.addActionListener(new BoutonRListener());		
		b_val=new JButton("Valider");
		b_val.addActionListener(new BoutonVListener());
		p_bouton1.add(b_retour1);
		p_bouton1.add(b_val);
		
		p_choix1=new JPanel();
		p_choix1.setLayout(new BorderLayout());
		p_choix1.add(p_critere,BorderLayout.CENTER);
		p_choix1.add(p_bouton1,BorderLayout.SOUTH);
		add(p_choix1);
		
		
		
//		JPanel p_choixcrit=new JPanel();
//		p_choixcrit.setLayout(new BoxLayout(p_choixcrit,BoxLayout.PAGE_AXIS));
		
		JPanel p1=new JPanel();
		
		JPanel p0 = new JPanel();
		p0.setLayout(new BoxLayout(p0,BoxLayout.LINE_AXIS));
		label_nom = new JLabel("Nom :");
		champ_nom =new JTextField(10); 
		tab1.add(case_nom);
		tab2.add(p0);
		
		p0.add(label_nom);
		p0.add(Box.createRigidArea(new Dimension(20,0)));
		p0.add(champ_nom);
		
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_type=new JLabel("Type d'ordinateur :");
		String[] liste_choixType= {"Portable","Fixe"};
		liste_type=new JComboBox<String>(liste_choixType);
		liste_type.setLightWeightPopupEnabled (false);
		tab1.add(case_type);
		tab2.add(p1);
		
				
		p1.add(label_type);
		p1.add(Box.createRigidArea(new Dimension(20,0)));
		p1.add(liste_type);		
						
		JPanel p2=new JPanel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_prix=new JLabel("Prix (en euros) :");
		champ_prix=new JTextField(10);
		tab1.add(case_prix);
		tab2.add(p2);
				
		p2.add(label_prix);
		p2.add(Box.createRigidArea(new Dimension(20,0)));
		p2.add(champ_prix);
					
		JPanel p3=new JPanel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_RAM=new JLabel("Quantité de mémoire RAM (en Go) :");
		Integer[] liste_choixRAM= {2,4,8,16,32};
		liste_RAM= new JComboBox<Integer>(liste_choixRAM);
		liste_RAM.setLightWeightPopupEnabled (false);
		tab1.add(case_RAM);
		tab2.add(p3);
				
		p3.add(label_RAM);
		p3.add(Box.createRigidArea(new Dimension(20,0)));
		p3.add(liste_RAM);
				
		JPanel p4=new JPanel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.LINE_AXIS));
		label_typeDD=new JLabel("Type de Disque Dur :");
		String[] liste_choixDD= {"Mécanique","SSD"};
		liste_typeDD=new JComboBox<String>(liste_choixDD);
		liste_typeDD.setLightWeightPopupEnabled (false);
		tab1.add(case_typeDD);
		tab2.add(p4);
			
		p4.add(label_typeDD);
		p4.add(Box.createRigidArea(new Dimension(20,0)));
		p4.add(liste_typeDD);
				
		JPanel p5=new JPanel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.LINE_AXIS));
		label_CG=new JLabel("Marque de la Carte Graphique :");
		String[] liste_choixCG= {"MSI","PNY","ASUS","EVGA"};
		liste_CG=new JComboBox<String>(liste_choixCG);
		liste_CG.setLightWeightPopupEnabled (false);
		tab1.add(case_CG);
		tab2.add(p5);
				
		p5.add(label_CG);
		p5.add(Box.createRigidArea(new Dimension(20,0)));
		p5.add(liste_CG);
				
		JPanel p6=new JPanel();
		p6.setLayout(new BoxLayout(p6,BoxLayout.LINE_AXIS));
		label_CM=new JLabel("Format de la carte mère :");
		String[] liste_choixCM= {"ATX_standard","micro_ATX","mini_ITX"};
		liste_CM=new JComboBox<String>(liste_choixCM);
		liste_CM.setLightWeightPopupEnabled (false);
		tab1.add(case_CM);
		tab2.add(p6);
		
		p6.add(label_CM);
		p6.add(Box.createRigidArea(new Dimension(20,0)));
		p6.add(liste_CM);
		
		JPanel p7 = new JPanel();
		p7.setLayout(new BoxLayout(p7,BoxLayout.LINE_AXIS));
		label_id = new JLabel("Identifiant :");
		champ_id=new JTextField(10); 
		tab1.add(case_id);
		tab2.add(p7);
		
		p7.add(label_id);
		p7.add(Box.createRigidArea(new Dimension(20,0)));
		p7.add(champ_id);
		

		
		JPanel p_formu=new JPanel();
		p_formu.setLayout(new BoxLayout(p_formu, BoxLayout.PAGE_AXIS));
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p0);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p1);
		p_formu.add(Box.createRigidArea(new Dimension(0,30)));
		p_formu.add(p2);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p3);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p4);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p5);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p6);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p7);
			
		JPanel p_bouton2=new JPanel();
		b_retour2=new JButton("Retour");
		b_retour2.addActionListener(new BoutonRListener());	
		p_bouton2.add(b_retour2);		
		b_annuler=new JButton("Annuler");
		b_annuler.addActionListener(new BoutonAListener());	
		p_bouton2.add(b_annuler);		
		b_rechercher=new JButton("Rechercher");
		b_rechercher.addActionListener(new BoutonListenerRechercher());
		p_bouton2.add(b_rechercher);
		
		p_choix2=new JPanel();
		p_choix2.setVisible(false);
		p_choix2.setLayout(new BorderLayout());
		p_choix2.add(p_formu,BorderLayout.CENTER);
		p_choix2.add(p_bouton2,BorderLayout.SOUTH);
		add(p_choix2);
		
	}
	
	class CaseListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{

		}	  
	}
	
	class BoutonRListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{
			Fenetre_authentification f_auth=new Fenetre_authentification();
			f_auth.setVisible(true);
			MaConnexion.clean();
			f_admin.dispose();			
		}	  
	}
	
	class BoutonVListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{
			p_choix1.setVisible(false);
			p_choix2.setVisible(true);
			int i=0;
			for (JCheckBox box : tab1)
			{
				if(!box.isSelected())
				{
					tab2.get(i).setVisible(false); //tab mm taille avec les query "ram = ",...
				}
				i++;
			}
		}	  
	}
	
	class BoutonAListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{
			p_choix2.setVisible(false);
			p_choix1.setVisible(true);
			for (JPanel compo : tab2)
			{
				compo.setVisible(true);
			}
			resultatRecherche.dispose();
		}	  
	}
	
	class BoutonListenerRechercher implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{
			
			//On supprime les espaces avant et après le nom
			String str = champ_nom.getText();
			String passageUn = str.replaceAll("\\s+$", "");
		    String nom = passageUn.replaceAll("^\\s+", "");
		    
		    //On supprime tous les espaces du prix pour éviter une NUmberFormatException
		    str = champ_prix.getText();
		    String prix = str.replaceAll("\\s", "");
			try {
					//On vérifie la validité du prix
					String query= "";
					String[] tab = {"type = ", "prix = ", "ram = ", "disque = ", "carte_G = ", "carte_M = ", "id = ", "nom = "};
					if (tab2.get(0).isVisible()) query += tab[0] + "\'" +(String )liste_type.getSelectedItem()+"\' AND ";
					if (tab2.get(1).isVisible()) query += tab[1] + "\'" + Double.parseDouble(prix) +"\' AND ";
					if (tab2.get(2).isVisible()) query += tab[2] + "\'" +liste_RAM.getSelectedItem() +"\' AND ";
					if (tab2.get(3).isVisible()) query += tab[3] + "\'" +(String )liste_typeDD.getSelectedItem()+"\' AND ";
					if (tab2.get(4).isVisible()) query += tab[4] + "\'" +(String )liste_CG.getSelectedItem()+"\' AND ";
					if (tab2.get(5).isVisible()) query += tab[5] + "\'" +(String )liste_CM.getSelectedItem()+"\' AND ";
					if (tab2.get(6).isVisible()) query += tab[6] + "\'" +champ_id.getText() +"\' AND ";
					if (tab2.get(7).isVisible()) query += tab[7] + "\'" +nom +"\' AND ";
			
					String data = query.replaceAll(" AND $", "");
					OrdiDAO_Admin dao = (OrdiDAO_Admin )cont.getOrdiDAO();
					
					if 	( (tab2.get(7).isVisible() && nom.equals("")) ||
						(tab2.get(6).isVisible() && champ_id.getText().equals("")) ) {		//prix vide => NumberFormatException ,pas a check donc
						JOptionPane.showMessageDialog(	null, 
														"Un champ choisi doit etre rempli.", 
														"Erreur de saisie", 
														JOptionPane.ERROR_MESSAGE);
					} else {
						ArrayList<Ordinateur> ordiListe = dao.search(data);
						resultatRecherche = new Fenetre_resultat_admin(ordiListe, cont);
					}
					
					
				
		    } catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(	null, 
						"Le prix ne doit pas contenir de lettre", 
						"Erreur de prix", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}	  
	}

}
