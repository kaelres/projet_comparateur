package controleur;

import IHM.Fenetre_authentification;

public class Main 
{
    @SuppressWarnings("unused")
	public static void main(String[] args) 
    {
    	Fenetre_authentification f= new Fenetre_authentification(); 
    } 
}
/*	TODO LIST
 * 	-mettre les MaCo.clean() sur les boutons de retour pour pouvoir relancer une connexion
 *  
 *  -que des controleurs en attributs PAS DE DAO (ni de connection)!!!!!
 *  
 *  -faire en sorte de pouvoir ajouter même si pas encore d'ordi en bdd (si bdd vide max(id) rend rien et la pls !)
 * */
 