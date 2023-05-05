package menufact.facture.Etat;

public class FactureEtatOuverte implements FactureEtat {
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatPayee || etat instanceof FactureEtatFermee;
    }
}
