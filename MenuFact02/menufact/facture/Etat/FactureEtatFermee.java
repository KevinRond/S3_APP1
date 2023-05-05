package menufact.facture.Etat;

public class FactureEtatFermee implements FactureEtat {
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatPayee || etat instanceof FactureEtatOuverte;
    }
}
