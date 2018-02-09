package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Controleur;
import controleur.MaConnexion;
import controleur.OrdiDAO;
import modele.Ordinateur;

@SuppressWarnings("serial")
public class Panneau_critere extends JPanel
{
	private Fenetre_client f_cri;
	private Controleur cont;
	
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
	
	private JButton b_annuler;
	private JButton b_ajouter;
	
	/*
	 * pour plus tard quand on fera la requête
	
	 */
	Panneau_critere(Fenetre_client f, Controleur c)
	{
		f_cri=f;
		cont =c;
		JPanel conteneur=new JPanel();
		conteneur.setLayout(new BorderLayout());
		
		Panel p0=new Panel();
		p0.setLayout(new BoxLayout(p0,BoxLayout.LINE_AXIS));
		JLabel label_titre1=new JLabel("Ordinateur :");
		Font font = new Font("Arial",Font.BOLD,16);
		label_titre1.setFont(font);
		label_titre1.setForeground(Color.BLUE);
		p0.add(label_titre1);
		
		Panel p2=new Panel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_type=new JLabel("Type d'ordinateur :");
		String[] liste_choixType= {"Portable","Fixe"};
		liste_type=new JComboBox<String>(liste_choixType);
		liste_type.setSelectedIndex(0);
		liste_type.setLightWeightPopupEnabled (false);
		p2.add(label_type);
		p2.add(Box.createRigidArea(new Dimension(20,0)));
		p2.add(liste_type);		
				
		Panel p3=new Panel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_prix=new JLabel("Prix (en €) :");
		champ_prix=new JTextField(); // on accepte que les entiers
		p3.add(label_prix);
		p3.add(Box.createRigidArea(new Dimension(20,0)));
		p3.add(champ_prix);
		
		Panel p4=new Panel();
		p4.setLayout(new BoxLayout(p4,BoxLayout.LINE_AXIS));
		JLabel label_titre2=new JLabel("Caractéristiques :");
		label_titre2.setFont(font);
		label_titre2.setForeground(Color.BLUE);
		p4.add(label_titre2);
			
		Panel p5=new Panel();
		p5.setLayout(new BoxLayout(p5,BoxLayout.LINE_AXIS));
		label_RAM=new JLabel("Quantité de mémoire RAM (en Go) :");
		Integer[] liste_choixRAM= {2,4,8,16,32};
		liste_RAM= new JComboBox<Integer>(liste_choixRAM);
		liste_RAM.setSelectedIndex(0);
		liste_RAM.setLightWeightPopupEnabled (false);
		p5.add(label_RAM);
		p5.add(Box.createRigidArea(new Dimension(20,0)));
		p5.add(liste_RAM);
		
		Panel p6=new Panel();
		p6.setLayout(new BoxLayout(p6,BoxLayout.LINE_AXIS));
		label_typeDD=new JLabel("Type de Disque Dur :");
		String[] liste_choixDD= {"Mécanique","SSD"};
		liste_typeDD=new JComboBox<String>(liste_choixDD);
		liste_typeDD.setSelectedIndex(0);
		liste_typeDD.setLightWeightPopupEnabled (false);
		p6.add(label_typeDD);
		p6.add(Box.createRigidArea(new Dimension(20,0)));
		p6.add(liste_typeDD);
		
		Panel p7=new Panel();
		p7.setLayout(new BoxLayout(p7,BoxLayout.LINE_AXIS));
		label_CG=new JLabel("Marque de la Carte Graphique :");
		String[] liste_choixCG= {"MSI","PNY","ASUS","EVGA"};
		liste_CG=new JComboBox<String>(liste_choixCG);
		liste_CG.setSelectedIndex(0);
		liste_CG.setLightWeightPopupEnabled (false);
		p7.add(label_CG);
		p7.add(Box.createRigidArea(new Dimension(20,0)));
		p7.add(liste_CG);
		
		Panel p8=new Panel();
		p8.setLayout(new BoxLayout(p8,BoxLayout.LINE_AXIS));
		label_CM=new JLabel("Format de la carte mère :");
		String[] liste_choixCM= {"ATX_standard","micro_ATX", "mini_ITX"};
		liste_CM=new JComboBox<String>(liste_choixCM);
		liste_CM.setSelectedIndex(0);
		liste_CM.setLightWeightPopupEnabled (false);
		p8.add(label_CM);
		p8.add(Box.createRigidArea(new Dimension(20,0)));
		p8.add(liste_CM);
		
		Panel p_formu=new Panel();
		p_formu.setLayout(new BoxLayout(p_formu, BoxLayout.PAGE_AXIS));
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p0);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p2);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p3);
		p_formu.add(Box.createRigidArea(new Dimension(0,30)));
//		p_formu.add(Box.createVerticalGlue());     ça marche pas
		p_formu.add(p4);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p5);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p6);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p7);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p8);
		p_formu.add(Box.createRigidArea(new Dimension(0,50)));
		conteneur.add(p_formu,BorderLayout.CENTER);
		
		
		Panel p_boutons=new Panel();	
		b_annuler= new JButton("Retour");
		b_annuler.addActionListener(new BoutonAListener());
		b_ajouter=new JButton("Valider");
		b_ajouter.addActionListener(new BoutonVListener());
		p_boutons.add(b_annuler);
		p_boutons.add(b_ajouter);
		conteneur.add(p_boutons,BorderLayout.SOUTH);
		
		add(conteneur);
	}
	

	class BoutonVListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{		    
		    //On supprime tous les espaces du prix pour éviter une NUmberFormatException
		    String str = champ_prix.getText();
		    String prix = str.replaceAll("\\s", "");
			try {
					//On vérifie la validitée du prix
					String query= "";
					String[] tab = {"type = ", "prix = ", "ram = ", "disque = ", "carte_G = ", "carte_M = ", "nom = "};
					query += tab[0] + "\'" +(String )liste_type.getSelectedItem()+"\' AND ";
					query += tab[1] + "\'" + Double.parseDouble(prix) +"\' AND ";
					query += tab[2] + "\'" +liste_RAM.getSelectedItem() +"\' AND ";
					query += tab[3] + "\'" +(String )liste_typeDD.getSelectedItem()+"\' AND ";
					query += tab[4] + "\'" +(String )liste_CG.getSelectedItem()+"\' AND ";
					query += tab[5] + "\'" +(String )liste_CM.getSelectedItem()+"\'";
			
					String data = query.replaceAll(" AND $", "");
					OrdiDAO dao = cont.getOrdiDAO();
					
					//Il faudra créer une fonction qui récupere  tous les ordis puis les compare
					//Quel rpz des ordis ?
					ArrayList<Ordinateur> ordiListe = dao.search(data);
					new Fenetre_resultat(ordiListe);
					
				
		    } catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(	null, 
						"Le prix ne doit pas contenir de lettre ou être vide", 
						"Erreur de prix", 
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}	  
	}
	class BoutonAListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{
			new Fenetre_authentification();
			MaConnexion.clean();
			f_cri.dispose();
		}	  
	}
}
