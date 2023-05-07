package menufact.builder;

import ingredients.Ingredient;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatEnfant;
import menufact.plats.Recette;
import menufact.plats.exceptions.PlatException;

public class BuilderPlat {
    protected PlatAuMenu plat;
    public BuilderPlat(){
        plat = new PlatAuMenu();
    }
    public BuilderPlat buildDescription(String description){
        plat.setDescription(description);
        return this;
    }
    public BuilderPlat buildPrix(double prix){
        plat.setPrix(prix);
        return this;
    }
    public BuilderPlat buildRecette(Recette recette) throws PlatException {
        plat.setRecette(recette);
        return this;
    }
    public BuilderPlat buildRecette(Ingredient[] ingredients) throws PlatException {
        plat.setRecette(new Recette(ingredients));
        return this;
    }
    public PlatAuMenu getPlatFinal(){
        return plat;
    }
    public BuilderPlat clear(){
        plat = new PlatAuMenu();
        return this;
    }
}
