package ameliorations_future;

public class Vieille_recherche {
	/*Ancienne mthode de recherche stricte
	public void actionPerformed(ActionEvent arg0)
	{		    
	    //On supprime tous les espaces du prix pour éviter une NUmberFormatException
	    String str = champ_prix.getText();
	    String prix = str.replaceAll("\\s", "");
		try {
				//On vérifie la validitée du prix
				String query= "";
				String[] tab = {"type = ", "prix = ", "ram = ", "disque = ", "carte_g = ", "carte_m = ", "nom = "};
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
	}	 */ 
}
