package menufact.plats.state;

/**
 * Classe StateServi
 */
public class StateServi implements CommandeState {
    /**
     * Vérifie s'il peut changer d'état
     * @param state
     * @return
     */
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateImpossibleDeServir;
    }

    /**
     * Retourne l'état
     * @return
     */
    @Override
    public String toString(){
        return "Plat servi";
    }
}
