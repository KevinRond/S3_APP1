package menufact;

import ingredients.Ingredient;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;
import menufact.plats.Recette;
import menufact.plats.exceptions.PlatException;
import menufact.plats.state.*;

/**
 * Classe du Chef
 */
public class Chef {
    private String nom;
    private static Chef instance = null;

    /**
     * Change le nom du chef
     * @param nom nom du chef
     */
    private Chef(String nom){this.nom = nom;}

    /**
     * Instancie un chef unique avec un nom
     * @param nom nom du chef
     * @return instance
     */
    public static Chef getInstance(String nom){
        if (instance == null){
            instance = new Chef(nom);
        }
        return instance;
    }

    /**
     * Retourne le nom du chef
     * @return nom
     */
    public String getNom(){
        return this.nom;
    }

    /**
     * Change le nom du chef
     * @param nom nom du chef
     */
    public void setNom(String nom){this.nom = nom;}

    /**
     * Cuisine un plat en consommant les ingrédients
     * @param plat platChoisi
     * @return Le plat
     * @throws IngredientException
     * @throws PlatException
     */
    public PlatChoisi cuisiner(PlatChoisi plat) throws IngredientException, PlatException {
        plat.setState(new StateCommande());
        if(verifierIngredient(plat)){
            preparer(plat);
            terminer(plat);
            return servir(plat);
        }
        else{
            return plat;
        }
    }

    /**
     *Vérifie si on a assez d'ingrédients pour faire une recette
     * @param plat le plat à cuisiner
     * @return Vrai si on a assez d'ingrédients, faux sinon
     * @throws IngredientException
     * @throws PlatException
     */
    private boolean verifierIngredient(PlatChoisi plat) throws IngredientException, PlatException {
        Inventaire inventaire = Inventaire.getInstance();
        Recette recette = plat.getPlat().getRecette();

            for (Ingredient ingredient : recette.getIngredients()){
                double quantiteRecette = plat.getQuantite() * plat.getPlat().getProportion();
                double quantiteInventaire = inventaire.getIngredient(ingredient.getNom()).getQuantity();

                if (quantiteInventaire < quantiteRecette){
                    plat.setState(new StateImpossibleDeServir());
                    throw new IngredientException("Il manque cette ingredient: " + ingredient);
                }
            }
        return true;
    }

    /**
     * Prepare le PlatChoisi en utilisant les ingrédients disponibles
     * @param plat le PlatChoisi à cuisiner
     * @throws IngredientException
     * @throws PlatException
     */
    private void preparer(PlatChoisi plat) throws IngredientException, PlatException {
        plat.setState(new StateEnPreparation());

        Inventaire inventaire = Inventaire.getInstance();
        Recette recette = plat.getPlat().getRecette();

        inventaire.utiliserIngredients(recette, plat.getQuantite(), plat.getPlat().getProportion());
    }

    /**
     * Change l'état du plat à terminer
     * @param plat PlatChoisi
     * @throws PlatException
     */
    private void terminer(PlatChoisi plat) throws PlatException {
        plat.setState(new StateTermine());
    }

    /**
     * Change l'état du plat à servi
     * @param plat PlatChoisi
     * @return
     * @throws PlatException
     */
    private PlatChoisi servir(PlatChoisi plat) throws PlatException {
        plat.setState(new StateServi());
        return plat;
    }

    /**
     * Retourne des informations sur le Chef
     * @return
     */
    @Override
    public String toString(){return "Chef: {" + "Nom: " + nom + "}";};
}
