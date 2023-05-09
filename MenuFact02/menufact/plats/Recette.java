package menufact.plats;

import ingredients.Ingredient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Classe recette
 */
public class Recette {
    private ArrayList<Ingredient> ingredients;

    /**
     * Constructeur d'une recette à partir d'un tableau d'ingrédients
     * @param ingredients_recette
     */
    public Recette(Ingredient[] ingredients_recette){
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients_recette));
    }

    /**
     * Constructeur d'une recette à partir d'un ArrayList
     * @param ingredients_recette
     */
    public Recette(ArrayList<Ingredient> ingredients_recette){
        this.ingredients = ingredients_recette;
    }

    /**
     * Retourne l'ArrayList d'ingrédients
     * @return
     */
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }

    /**
     * Met des nouveaux ingrédients dans l'ArrayList à partir d'un tableau
     * @param ingredients_recette
     */
    public void setIngredients(Ingredient[] ingredients_recette){
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients_recette));
    }

    /**
     * Met des nouveaux ingrédients dans l'ArrayList à partir d'un ArrayList
     * @param ingredients_recette
     */
    public void setIngredients(ArrayList<Ingredient> ingredients_recette){
        this.ingredients = ingredients_recette;
    }

    /**
     * Ajoute une ingrédient dans l'ArrayList
     * @param nouvel_ingredient
     */
    public void addIngredient(Ingredient nouvel_ingredient){
        ingredients.add(nouvel_ingredient);
    }

    /**
     * Indique des informations sur la recette
     * @return
     */
    @Override
    public String toString(){
        return "Recette=" + Arrays.toString(new ArrayList[]{ingredients});
    }
}
