package menufact.builder;

import ingredients.Ingredient;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatEnfant;
import menufact.plats.Recette;
import menufact.plats.exceptions.PlatException;

/**
 * Classe BuilderPlat
 */
public class BuilderPlat {
    protected PlatAuMenu plat;

    /**
     * Constructeur de BuilderPlat
     */
    public BuilderPlat(){
        plat = new PlatAuMenu();
    }

    /**
     * Change et renvoie la description
     * @param description
     * @return
     */
    public BuilderPlat buildDescription(String description){
        plat.setDescription(description);
        return this;
    }

    /**
     * Change et renvoie le prix
     * @param prix
     * @return
     */
    public BuilderPlat buildPrix(double prix){
        plat.setPrix(prix);
        return this;
    }

    /**
     * Change et renvoie la recette
     * @param recette
     * @return
     * @throws PlatException
     */
    public BuilderPlat buildRecette(Recette recette) throws PlatException {
        plat.setRecette(recette);
        return this;
    }

    /**
     * Change et renvoie la recette avec un tableau d'ingrédients
     * @param ingredients
     * @return
     * @throws PlatException
     */
    public BuilderPlat buildRecette(Ingredient[] ingredients) throws PlatException {
        plat.setRecette(new Recette(ingredients));
        return this;
    }

    /**
     * Renvoie le plat final
     * @return
     */
    public PlatAuMenu getPlatFinal(){
        return plat;
    }

    /**
     * Vide le PlatAuMenu
     * @return
     */
    public BuilderPlat clear(){
        plat = new PlatAuMenu();
        return this;
    }
}
