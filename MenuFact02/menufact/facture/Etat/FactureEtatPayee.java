package menufact.facture.Etat;

/**
 * Classe FactureEtatPayee
 */
public class FactureEtatPayee implements FactureEtat {
    /**
     * Vérifie si l'état peut être changé
     * @param etat objet de FactureEtat
     * @return
     */
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatFermee;
    }
}
