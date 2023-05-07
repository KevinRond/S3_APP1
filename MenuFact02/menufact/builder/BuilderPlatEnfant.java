package menufact.builder;

import menufact.plats.PlatEnfant;
import menufact.plats.exceptions.PlatException;

public class BuilderPlatEnfant extends BuilderPlat {
    public BuilderPlatEnfant(){
        plat = new PlatEnfant();
    }
    public BuilderPlatEnfant buildProportion(double proportion) throws PlatException {
        ((PlatEnfant) plat).setProportion(proportion);
        return this;
    }
    @Override
    public BuilderPlatEnfant clear(){
        plat = new PlatEnfant();
        return this;
    }
    @Override
    public PlatEnfant getPlatFinal(){
        return (PlatEnfant) plat;
    }
}
