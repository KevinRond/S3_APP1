package menufact.plats.state;

public class StateCommande implements CommandeState {
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateEnPreparation || state instanceof StateImpossibleDeServir;
    }
    @Override
    public String toString(){
        return "Plat commande";
    }
}
