package menufact.builder;

import menufact.plats.PlatEnfant;
import menufact.plats.PlatSante;
import menufact.plats.exceptions.PlatException;

public class BuilderPlatSante extends BuilderPlat {
    public BuilderPlatSante(){
        plat = new PlatSante();
    }
    public BuilderPlatSante buildKcal(double kcal) throws PlatException {
        ((PlatSante) plat).setKcal(kcal);
        return this;
    }
    public BuilderPlatSante buildChol(double chol) throws PlatException {
        ((PlatSante) plat).setChol(chol);
        return this;
    }
    public BuilderPlatSante buildGras(double gras) throws PlatException {
        ((PlatSante) plat).setGras(gras);
        return this;
    }
    @Override
    public BuilderPlatSante clear(){
        plat = new PlatSante();
        return this;
    }
    @Override
    public PlatSante getPlatFinal(){
        return (PlatSante) plat;
    }
}
