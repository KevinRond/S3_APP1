package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;
import menufact.plats.state.CommandeState;

public class PlatChoisi {
    private PlatAuMenu plat;
    private int quantite;
    private CommandeState state;

    public PlatChoisi(PlatAuMenu plat, int quantite) throws PlatException {
        this.plat = plat;
        if (quantite < 0){
            throw new PlatException("Quantite negative impossible");
        }
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatChoisi{" +
                "quantite=" + quantite +
                ", plat=" + plat +
                '}';
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantite) throws PlatException {
        if (quantite < 0){
            throw new PlatException("Quantite negative impossible");
        }
        this.quantite = quantite;
    }

    public PlatAuMenu getPlat() {
        return plat;
    }
    public CommandeState getState() {
        return state;
    }
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
