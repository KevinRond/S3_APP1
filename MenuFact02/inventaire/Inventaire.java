package inventaire;

import ingredients.Ingredient;
import ingredients.exceptions.IngredientException;
import menufact.plats.Recette;

import java.util.ArrayList;
import java.util.HashMap;

public class Inventaire {
    //private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();
    private HashMap<String, Ingredient> congelateur;
    private static Inventaire instance;

    private Inventaire(){
        congelateur = new HashMap<>();
    }
    public static Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }

    public void ajouterIngredient(Ingredient ingredient) throws IngredientException {
        if (ingredient == null){
            throw new IngredientException("Impossible d'ajouter un ingredient null");
        }
        if (congelateur.containsKey(ingredient.getNom())) {
            Ingredient temporary_ingredient = congelateur.get(ingredient.getNom());
            temporary_ingredient.setQuantity(temporary_ingredient.getQuantity() + ingredient.getQuantity());
        } else {
            congelateur.put(ingredient.getNom(), ingredient);
        }
    }
    public Ingredient getIngredient(String nomIngredient){
        return congelateur.get(nomIngredient);
    }
    public int getQuantityInCongelateur(){
        return congelateur.size();
    }
    public void utiliserIngredients(Recette recette, int quantitePlats, double proportion) throws IngredientException {
        for (Ingredient ingredient : recette.getIngredients()){
            if (congelateur.containsKey(ingredient.getNom())){
                double quantite_inventaire = congelateur.get(ingredient.getNom()).getQuantity();
                double quantite_recette = ingredient.getQuantity() * quantitePlats * proportion;
                if (quantite_inventaire < quantite_recette){
                    throw new IngredientException("Pas assez d'ingredients pour cette recette dans l'inventaire");

                }
                congelateur.get(ingredient.getNom()).setQuantity(quantite_inventaire-quantite_recette);
            } else {
                throw new IngredientException("Ingredient de la recette pas trouve dans l'inventaire");
            }
        }
    }
    public static void clear(){
        if (instance != null){
            instance.congelateur.clear();
            instance = null;
        }
    }
    @Override
    public String toString(){
        return "Inventaire=" + congelateur;
    }

}
