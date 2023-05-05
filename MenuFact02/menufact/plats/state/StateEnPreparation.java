package menufact.plats.state;

public class StateEnPreparation implements CommandeState {
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateImpossibleDeServir || state instanceof StateTermine;
    }
    @Override
    public String toString(){
        return "Plat en preparation";
    }
}
