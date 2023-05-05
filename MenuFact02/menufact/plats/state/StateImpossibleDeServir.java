package menufact.plats.state;

public class StateImpossibleDeServir implements CommandeState {
    @Override
    public boolean changeState(CommandeState state) {
        return false;
    }
    @Override
    public String toString(){
        return "Erreur Plat: Impossible de preparer le plat";
    }
}
