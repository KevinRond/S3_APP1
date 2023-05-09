package menufact.facture.Etat;

/**
 * Classe de FactureEtatFermee
 */
public class FactureEtatFermee implements FactureEtat {
    /**
     * Vérifie si l'état peut être changé
     * @param etat objet de FactureEtat
     * @return
     */
    @Override
    public boolean changerEtat(FactureEtat etat) {
        return etat instanceof FactureEtatPayee || etat instanceof FactureEtatOuverte;
    }

    /**
     * Methode pour obtenir le string de l etat de la facture
     * @return le string de l etat de la facture
     */
    public String toString(){
        return "Facture etat fermee";
    }
}
