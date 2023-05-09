package menufact.plats.state;

/**
 * Classe StateCommande
 */
public class StateCommande implements CommandeState {
    /**
     * Vérifie si on peut changer l'état
     * @param state
     * @return
     */
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateEnPreparation || state instanceof StateImpossibleDeServir;
    }
    /**
     * Retourne l'état du plat
     * @return
     */
    @Override
    public String toString(){
        return "Plat commande";
    }
}
