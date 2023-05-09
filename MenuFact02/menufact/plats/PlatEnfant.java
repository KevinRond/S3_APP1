package menufact.plats;

import menufact.plats.exceptions.PlatException;

/**
 * Classe de PlatEnfant
 */
public class PlatEnfant extends PlatAuMenu {
    private double proportion;

    /**
     * Constructeur vide
     */
    public PlatEnfant() {
    }

    /**
     * Constructeur d'un PlatEnfant
     * @param code
     * @param description
     * @param prix
     * @param proportion
     * @throws PlatException
     */
    public PlatEnfant(int code, String description, double prix, double proportion) throws PlatException {
        super(code, description, prix);
        this.proportion = proportion;
    }

    /**
     * Retourne la proportion
     * @return
     */
    public double getProportion() {
        return proportion;
    }

    /**
     * Change la proportion du plat
     * @param proportion
     * @throws PlatException
     */
    public void setProportion(double proportion) throws PlatException {
        if (proportion < 0 || proportion > 1){
            throw new PlatException("Proportion doit etre entre 0 et 1");
        }
        this.proportion=proportion;
    }

    /**
     * Retourne des informations sur le plat
     * @return
     */
    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
