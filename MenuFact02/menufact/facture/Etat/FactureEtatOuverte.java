package menufact.facture.Etat;

/**
 * Classe FactureEtatOuverte
 */
public class FactureEtatOuverte implements FactureEtat {
    /**
     * Vérifie si l'état peut être changé
     * @param etat objet de FactureEtat
     * @return
     */
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatPayee || etat instanceof FactureEtatFermee;
    }
}
