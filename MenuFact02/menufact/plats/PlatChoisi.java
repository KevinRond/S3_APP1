package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;
import menufact.plats.state.CommandeState;

/**
 * Classe du PlatChoisi
 */
public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private CommandeState state;

    /**
     * Constructeur de PlatChoisi
     * @param plat
     * @param quantite
     * @throws PlatException
     */
    public PlatChoisi(PlatAuMenu plat, int quantite) throws PlatException {
        this.plat = plat;
        if (quantite < 0){
            throw new PlatException("Quantite negative impossible");
        }
        this.quantite = quantite;
    }

    /**
     * Retourne des informations sur le plat
     * @return
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    /**
     * Retourne la quantite
     * @return
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Change la quantite
     * @param quantite
     * @throws PlatException
     */
    public void setQuantite(int quantite) throws PlatException {
        if (quantite < 0){
            throw new PlatException("Quantite negative impossible");
        }
        this.quantite = quantite;
    }

    /**
     * Retourne le plat
     * @return
     */
    public PlatAuMenu getPlat() {
        return plat;
    }

    /**
     * Retourne l'état
     * @return
     */
    public CommandeState getState() {
        return state;
    }

    /**
     * Change l'état
     * @param state
     * @throws PlatException
     */
    public void setState(CommandeState state) throws PlatException {
        if (this.state == null) {
            this.state = state;
        } else if (this.state.changeState(state)) {
            this.state = state;
        } else {
            throw new PlatException("Imposibilite de changer vers cette etat");
        }
    }
}
