package menufact.facture.Etat;

/**
 * Interface FactureEtat
 */
public interface FactureEtat {
    /**
     * Vérifie si l'état peut être changé
     * @param etat objet de FactureEtat
     * @return
     */
    public boolean changerEtat(FactureEtat etat);
}
