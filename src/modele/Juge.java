package modele;

/**
 * Interface à implémenter par les différents juge qui caractérise chaque profil
 * @author Francois
 * @see JugeGaming, JugeBureautique
 */
public interface Juge {
	public void juger(Ordinateur o);
}
