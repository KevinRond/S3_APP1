package menufact.plats.state;

/**
 * Classe StateEnPreparation
 */
public class StateEnPreparation implements CommandeState {
    /**
     * Vérifie si on peut changer l'état
     * @param state
     * @return
     */
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateImpossibleDeServir || state instanceof StateTermine;
    }
    /**
     * Retourne l'état du plat
     * @return
     */
    @Override
    public String toString(){
        return "Plat en preparation";
    }
}
