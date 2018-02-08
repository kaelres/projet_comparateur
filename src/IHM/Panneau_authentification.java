package IHM;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.postgresql.util.PSQLException;

import controleur.MaConnexion;


@SuppressWarnings("serial")
public class Panneau_authentification extends JPanel
{
	private Fenetre_authentification f_auth;
	
	private JLabel label_login;
	private JTextField champ_login;
	
	private JLabel label_mdp;
	private JPasswordField champ_mdp;
	
	private JButton bouton_valider;
	private JButton bouton_quitter;
	
	Panneau_authentification(Fenetre_authentification f)
	{
		f_auth=f;
		
		setLayout(new BorderLayout());
		
		Panel p0=new Panel();
		p0.setLayout(new BoxLayout(p0,BoxLayout.LINE_AXIS));
		label_login=new JLabel("Login :");
		champ_login=new JTextField(10);
		p0.add(label_login);
		p0.add(Box.createRigidArea(new Dimension(10,0)));
		p0.add(champ_login);
		
		Panel p1=new Panel();
		p1.setLayout(new BoxLayout(p1,BoxLayout.LINE_AXIS));
		label_mdp=new JLabel("Mot de Passe :");
		champ_mdp=new JPasswordField(10);
		p1.add(label_mdp);
		p1.add(Box.createRigidArea(new Dimension(10,0)));
		p1.add(champ_mdp);
		
		Panel p2=new Panel();
		p2.setLayout(new BoxLayout(p2,BoxLayout.PAGE_AXIS));
		p2.add(Box.createRigidArea(new Dimension(0,50)));
		p2.add(p0);
		p2.add(Box.createRigidArea(new Dimension(0,10)));
		p2.add(p1);
		
		Panel p3=new Panel();
		p3.add(p2);
		add(p3,BorderLayout.CENTER);
		
		Panel p_boutons=new Panel();
		bouton_valider=new JButton("Valider");
		bouton_valider.addActionListener(new BoutonListenerValider());
		bouton_quitter=new JButton("Quitter");
		bouton_quitter.addActionListener(new BoutonListenerQuitter());
		p_boutons.add(bouton_valider);
		p_boutons.add(bouton_quitter);
		add(p_boutons,BorderLayout.SOUTH);
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		/*File file = new File("C:\\Users\\valen\\OneDrive\\Images\\fond_fen.jpg");
		BufferedImage img=null;
		try {
			img = ImageIO.read(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		g.drawImage(img, 0, 0, null);*/
	}
	
	class BoutonListenerValider implements ActionListener
	{

		@SuppressWarnings("unused")
		@Override
		public void actionPerformed(ActionEvent e) {
			String usr = champ_login.getText();
			String passwd = new String(champ_mdp.getPassword());
			MaConnexion.setID(usr, passwd);
			
			try {
				Connection conn = MaConnexion.getInstance();
				MaConnexion.checkAdmin();
				
				if (MaConnexion.IsAdmin()) {
					Fenetre_admin f_admin=new Fenetre_admin();
					f_admin.setVisible(true);
					f_auth.dispose();
				}
				else {
					Fenetre_client f_cri=new Fenetre_client();
					f_cri.setVisible(true);
					f_auth.dispose();
				}
				
				
			} catch (PSQLException e2) {
				JOptionPane.showMessageDialog(	f_auth, 
												"Mauvais Login et/ou mot de passe", 
												"Erreur", 
												JOptionPane.ERROR_MESSAGE);
				
				MaConnexion.clean();
				e2.printStackTrace();
			} catch  (SQLException e1) {
				
				e1.printStackTrace();
			} 
		
		}  
	}

	class BoutonListenerQuitter implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			System.exit(0);
			
		}
		
	}
}
