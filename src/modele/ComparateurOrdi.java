package modele;

import java.util.Comparator;

public class ComparateurOrdi implements Comparator<Ordinateur>{

	@Override
	public int compare(Ordinateur arg0, Ordinateur arg1) {
		return (int )(arg1.getScore() - arg0.getScore());
	}

}
