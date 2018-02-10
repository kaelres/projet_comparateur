package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.SQLException;
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
import controleur.OrdiDAO_Admin;
import modele.ExceptionNom;
import modele.ExceptionPrix;
import modele.Ordinateur;


@SuppressWarnings("serial")
public class Panneau_admin_ajout extends JPanel
{
	private Fenetre_admin f_admin; 
	
	private JLabel label_type;
	private JComboBox<String> liste_type;
	
	private JLabel label_nom;
	private JTextField champ_nom;
	
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
	
	
	private JButton b_retour;
	private JButton b_ajouter;
	
	private Controleur cont;
	
	
	Panneau_admin_ajout(Fenetre_admin f, Controleur c)
	{
		cont = c;
		f_admin=f;
		
		/*.setLightWeightPopupEnabled (false);
		 * très important sinon les jcombobox ne peuvent être deroulés pour voir les items des fois*/
		JPanel conteneur=new JPanel();
		conteneur.setLayout(new BorderLayout());
		
		Panel p0=new Panel();
		p0.setLayout(new BoxLayout(p0,BoxLayout.LINE_AXIS));
		JLabel label_titre1=new JLabel("Ordinateur :");
		Font font = new Font("Arial",Font.BOLD,16);
		label_titre1.setFont(font);
		label_titre1.setForeground(Color.BLUE);
		p0.add(label_titre1);

		Panel p1=new Panel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_nom=new JLabel("Nom :");
		champ_nom=new JTextField(13);
		p1.add(label_nom);
		p1.add(Box.createRigidArea(new Dimension(20,10)));
		p1.add(champ_nom);		
		
		Panel p2=new Panel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.LINE_AXIS));
		label_type=new JLabel("Type d'ordinateur :");
		String[] liste_choixType= {"Portable","Fixe"};
		liste_type=new JComboBox<String>(liste_choixType);
		liste_type.setLightWeightPopupEnabled (false);
		p2.add(label_type);
		p2.add(Box.createRigidArea(new Dimension(20,0)));
		p2.add(liste_type);		
				
		Panel p3=new Panel();
		p3.setLayout(new BoxLayout(p3,BoxLayout.LINE_AXIS));
		label_prix=new JLabel("Prix (en €) :");
		champ_prix=new JTextField(10); // on accepte que les entiers
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
		liste_RAM.setLightWeightPopupEnabled (false);
		p5.add(label_RAM);
		p5.add(Box.createRigidArea(new Dimension(20,0)));
		p5.add(liste_RAM);
		
		Panel p6=new Panel();
		p6.setLayout(new BoxLayout(p6,BoxLayout.LINE_AXIS));
		label_typeDD=new JLabel("Type de Disque Dur :");
		String[] liste_choixDD= {"Mécanique","SSD"};
		liste_typeDD=new JComboBox<String>(liste_choixDD);
		liste_typeDD.setLightWeightPopupEnabled (false);
		p6.add(label_typeDD);
		p6.add(Box.createRigidArea(new Dimension(20,0)));
		p6.add(liste_typeDD);
		
		Panel p7=new Panel();
		p7.setLayout(new BoxLayout(p7,BoxLayout.LINE_AXIS));
		label_CG=new JLabel("Marque de la Carte Graphique :");
		String[] liste_choixCG= {"MSI","PNY","ASUS","EVGA"};
		liste_CG=new JComboBox<String>(liste_choixCG);
		liste_CG.setLightWeightPopupEnabled (false);
		p7.add(label_CG);
		p7.add(Box.createRigidArea(new Dimension(20,0)));
		p7.add(liste_CG);
		
		Panel p8=new Panel();
		p8.setLayout(new BoxLayout(p8,BoxLayout.LINE_AXIS));
		label_CM=new JLabel("Format de la carte mère :");
		String[] liste_choixCM= {"ATX_standard","micro_ATX","mini_ITX"};
		liste_CM=new JComboBox<String>(liste_choixCM);
		liste_CM.setLightWeightPopupEnabled (false);
		p8.add(label_CM);
		p8.add(Box.createRigidArea(new Dimension(20,0)));
		p8.add(liste_CM);
		
		Panel p_formu=new Panel();
		p_formu.setLayout(new BoxLayout(p_formu, BoxLayout.PAGE_AXIS));
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p0);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p1);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p2);
		p_formu.add(Box.createRigidArea(new Dimension(0,10)));
		p_formu.add(p3);
		p_formu.add(Box.createRigidArea(new Dimension(0,30)));
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
		b_retour= new JButton("Retour");
		b_retour.addActionListener(new BoutonListenerRetour());
		b_ajouter=new JButton("Ajouter");
		b_ajouter.addActionListener(new BoutonListenerAdd());
		p_boutons.add(b_retour);
		p_boutons.add(b_ajouter);
		conteneur.add(p_boutons,BorderLayout.SOUTH);
		
		add(conteneur);
 		
	}
	
	class BoutonListenerRetour implements ActionListener 
	{
		public void actionPerformed(ActionEvent arg0)
		{
			Fenetre_authentification f_auth=new Fenetre_authentification();
			f_auth.setVisible(true);
			MaConnexion.clean();
			f_admin.dispose();			
		}	  
	}
	
	private class BoutonListenerAdd implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			try {
				OrdiDAO_Admin myDAO = (OrdiDAO_Admin)cont.getOrdiDAO();
				ResultSet result = myDAO.exec("SELECT MAX(id) FROM \"Ordinateur\"");
				result.next();
				
				//On supprime les espaces avant et après le nom
				String str = champ_nom.getText();
				String passageUn = str.replaceAll("\\s+$", "");
			    String nom = passageUn.replaceAll("^\\s+", "");
			    
			    //On supprime tous les espaces du prix pour éviter une NUmberFormatException
			    str = champ_prix.getText();
			    String prix = str.replaceAll("\\s", "");
				
				if (!nom.equals("")) {
					double p = Double.parseDouble(prix);
					Ordinateur ordi = new Ordinateur(p, (int )liste_RAM.getSelectedItem(), (String )liste_typeDD.getSelectedItem(),
												(String )liste_type.getSelectedItem(), (String )liste_CG.getSelectedItem(),
												(String )liste_CM.getSelectedItem(), nom, result.getInt(1)+1);
				
																				//On necessite d'être admin pour acceder à la fenetre, 
					myDAO.add(ordi);											//on a donc accès au DAO admin	Le cas test donc sûr											
				} else {
					JOptionPane.showMessageDialog(	null, 
												"Les champs prix et nom ne peuvent être vide.", 
												"Erreur de prix et/ou de nom", 
												JOptionPane.ERROR_MESSAGE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(	null, 
												"Le prix ne doit pas contenir de lettre, d'espaces et doit être renseigné", 
												"Erreur de prix", 
												JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (ExceptionPrix e) {
				JOptionPane.showMessageDialog(	null, 
												"Le champ nom ne peut être laissé vide.", 
												"Erreur de nom", 
												JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			} catch (ExceptionNom e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
	}
}
