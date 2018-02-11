package modele;

import java.util.Comparator;

/**
 * Comparateur d'ordinateur implémentant l'interface Comparator.
 * Ce comparateur permet de trier les Ordinateurs par score par ordre décroissant.
 * @author Francois
 *
 */
public class ComparateurOrdi implements Comparator<Ordinateur>{

	/**
	 * Permet lors de l'appel à array.sort() si le comparateur est donné en argument de trier les Ordinateurs par score décroissant.
	 */
	@Override
	public int compare(Ordinateur arg0, Ordinateur arg1) {
		return (int )(arg1.getScore() - arg0.getScore());
	}

}
