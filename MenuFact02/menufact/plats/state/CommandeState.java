package menufact.plats.state;

/**
 * Interface CommandeState
 */
public interface CommandeState {
    /**
     * Vérifie si on peut changer l'état
     * @param state
     * @return
     */
    public boolean changeState(CommandeState state);
}
