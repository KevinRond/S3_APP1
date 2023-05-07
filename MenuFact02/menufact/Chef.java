package menufact;

import ingredients.Ingredient;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.plats.PlatChoisi;
import menufact.plats.PlatSante;
import menufact.plats.Recette;
import menufact.plats.state.*;

public class Chef {
    private String nom;
    private static Chef instance = null;
    private Chef(String nom){this.nom = nom;}
    public static Chef getInstance(String nom){
        if (instance == null){
            instance = new Chef(nom);
        }
        return instance;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){this.nom = nom;}
    public PlatChoisi cuisiner(PlatChoisi plat) throws IngredientException {
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
    private boolean verifierIngredient(PlatChoisi plat) throws IngredientException {
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
    private void preparer(PlatChoisi plat) throws IngredientException {
        plat.setState(new StateEnPreparation());

        Inventaire inventaire = Inventaire.getInstance();
        Recette recette = plat.getPlat().getRecette();

        inventaire.utiliserIngredients(recette, plat.getQuantite(), plat.getPlat().getProportion());
    }
    private void terminer(PlatChoisi plat){
        plat.setState(new StateTermine());
    }
    private PlatChoisi servir(PlatChoisi plat){
        plat.setState(new StateServi());
        return plat;
    }
    @Override
    public String toString(){return "Chef: {" + "Nom: " + nom + "}";};
}
