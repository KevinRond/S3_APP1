package menufact.plats.state;

/**
 * Classe StateImpossibleDeServir
 */
public class StateImpossibleDeServir implements CommandeState {
    /**
     * Vérifie si on peut changer l'état
     * @param state
     * @return
     */
    @Override
    public boolean changeState(CommandeState state) {
        return false;
    }
    /**
     * Retourne l'état du plat
     * @return
     */
    @Override
    public String toString(){
        return "Erreur Plat: Impossible de preparer le plat";
    }
}
