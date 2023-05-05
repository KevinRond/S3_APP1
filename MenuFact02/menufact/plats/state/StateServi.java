package menufact.plats.state;

public class StateServi implements CommandeState {
    @Override
    public boolean changeState(CommandeState state) {
        return state instanceof StateImpossibleDeServir;
    }
    @Override
    public String toString(){
        return "Plat servi";
    }
}
