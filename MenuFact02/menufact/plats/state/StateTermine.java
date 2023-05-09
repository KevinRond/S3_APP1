package menufact.plats.state;

/**
 * Classe de StateTermine
 */
public class StateTermine implements CommandeState {
    /**
     * Vérifie si on peut changer l'état
     * @param state
     * @return
     */
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateServi || state instanceof StateImpossibleDeServir;
    }

    /**
     * Retourne l'état du plat
     * @return
     */
    @Override
    public String toString(){
        return "Plat termine";
    }
}
