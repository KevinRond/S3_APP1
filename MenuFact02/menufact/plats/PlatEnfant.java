package menufact.plats;

import menufact.plats.exceptions.PlatException;

public class PlatEnfant extends PlatAuMenu {
    private double proportion;

    public PlatEnfant() {
    }

    public PlatEnfant(int code, String description, double prix, double proportion) throws PlatException {
        super(code, description, prix);
        this.proportion = proportion;
    }

    public double getProportion() {
        return proportion;
    }

    public void setProportion(double proportion) throws PlatException {
        if (proportion < 0 || proportion > 1){
            throw new PlatException("Proportion doit etre entre 0 et 1");
        }
        this.proportion=proportion;
    }

    @Override
    public String toString() {
        return "PlatEnfant{" +
                "proportion=" + proportion +
                "} " + super.toString();
    }
}
