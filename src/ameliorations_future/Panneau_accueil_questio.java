package ameliorations_future;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

@Deprecated
public class Panneau_accueil_questio extends JPanel
{
	private JLabel label_1;
	private JComboBox q_1;
	
	private JLabel label_2;
	private JComboBox q_2;
	
	private JLabel label_3;
	private JRadioButton jr1;
	private JRadioButton jr2;
	
	private JLabel label_4;
	private JComboBox q_4;
	
	Panneau_accueil_questio()
	{
		setLayout(new GridLayout(10,1));
		
		JPanel pan1=new JPanel();
		String[] liste_choix1 = {"1", "2", "3", "4"};
		q_1=new JComboBox(liste_choix1);
		label_1= new JLabel("Combien de fois par jour"
				+ " utilisez-vous un ordinateur ?");
		pan1.add(label_1);
		pan1.add(q_1);
		pan1.setBorder(BorderFactory.createLineBorder(Color.black));
		pan1.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(pan1);
		
		JPanel pan2=new JPanel();
		String[] liste_choix2 = {"moins d'1 heure", "1"
				+ " à 2 heure(s)", "plus de 2 heures"};
		q_2=new JComboBox(liste_choix2);
		label_2= new JLabel("Combien d'heure(s) passez"
				+ "_vous dessus par jour ?");
		pan2.add(label_2);
		pan2.add(q_2);
		pan2.setBorder(BorderFactory.createLineBorder(Color.black));
		pan2.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(pan2);
		
		JPanel pan3=new JPanel();
		label_3= new JLabel("Utilisez-vous votre"
				+ " ordinateur pour jouer aux jeux vidéos ?");
		jr1=new JRadioButton("Oui");
		jr2=new JRadioButton("Non");
		pan3.add(label_3);
		pan3.add(jr1);
		pan3.add(jr2);
		pan3.setBorder(BorderFactory.createLineBorder(Color.black));
		pan3.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(pan3);
		
		JPanel pan4=new JPanel();
		String[] liste_choix4 = {"", "2", "3", "4"};
		q_1=new JComboBox(liste_choix1);
		label_1= new JLabel("Combien de fois par jour"
				+ " utilisez-vous un ordinateur ?");
		pan4.add(label_1);
		pan4.add(q_1);
		pan4.setBorder(BorderFactory.createLineBorder(Color.black));
		pan4.setLayout(new FlowLayout(FlowLayout.LEADING));
		add(pan4);
		
		
	}
}
