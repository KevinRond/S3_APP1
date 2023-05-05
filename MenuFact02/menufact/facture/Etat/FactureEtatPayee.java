package menufact.facture.Etat;

public class FactureEtatPayee implements FactureEtat {
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatFermee;
    }
}
