package menufact.builder;

import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;
import menufact.plats.exceptions.PlatException;

/**
 * Classe BuilderPlatSante
 */
public class BuilderPlatSante extends BuilderPlat {
    /**
     * Constructeur vide
     */
    public BuilderPlatSante(){
        plat = new PlatSante();
    }

    /**
     * Change et renvoie une valeur de kcal
     * @param kcal variable double
     * @return
     * @throws PlatException
     */
    public BuilderPlatSante buildKcal(double kcal) throws PlatException {
        ((PlatSante) plat).setKcal(kcal);
        return this;
    }

    /**
     * Change et renvoie une valeur de chol
     * @param chol variable double
     * @return
     * @throws PlatException
     */
    public BuilderPlatSante buildChol(double chol) throws PlatException {
        ((PlatSante) plat).setChol(chol);
        return this;
    }

    /**
     * Change et renvoie une valeur de gras
     * @param gras variable double
     * @return
     * @throws PlatException
     */
    public BuilderPlatSante buildGras(double gras) throws PlatException {
        ((PlatSante) plat).setGras(gras);
        return this;
    }

    /**
     * Vide le PlatSante
     * @return un PlatSante vide
     */
    @Override
    public BuilderPlatSante clear(){
        plat = new PlatSante();
        return this;
    }

    /**
     * Retourne le PlatSante
     * @return
     */
    @Override
    public PlatSante getPlatFinal(){
        return (PlatSante) plat;
    }
}
