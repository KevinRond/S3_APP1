package menufact.builder;

import menufact.plats.PlatEnfant;
import menufact.plats.exceptions.PlatException;

/**
 * Classe BuilderPlatEnfant
 */
public class BuilderPlatEnfant extends BuilderPlat {
    /**
     * Constructeur de PlatEnfant
     */
    public BuilderPlatEnfant(){
        plat = new PlatEnfant();
    }

    /**
     * Change et renvoie la proportion
     * @param proportion variable double
     * @return
     * @throws PlatException
     */
    public BuilderPlatEnfant buildProportion(double proportion) throws PlatException {
        ((PlatEnfant) plat).setProportion(proportion);
        return this;
    }

    /**
     * Vide le PlatEnfant et retourne un PlatEnfant vide
     * @return le PlatEnfant
     */
    @Override
    public BuilderPlatEnfant clear(){
        plat = new PlatEnfant();
        return this;
    }

    /**
     * Retourne le PlatEnfant
     * @return
     */
    @Override
    public PlatEnfant getPlatFinal(){
        return (PlatEnfant) plat;
    }
}
