package menufact.plats.state;

public class StateTermine implements CommandeState {
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateServi || state instanceof StateImpossibleDeServir;
    }
    @Override
    public String toString(){
        return "Plat termine";
    }
}
