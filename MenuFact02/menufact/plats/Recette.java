package menufact.plats;

import ingredients.Ingredient;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Recette {
    private ArrayList<Ingredient> ingredients;

    public Recette(Ingredient[] ingredients_recette){
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients_recette));
    }
    public Recette(ArrayList<Ingredient> ingredients_recette){
        this.ingredients = ingredients_recette;
    }
    public ArrayList<Ingredient> getIngredients() {
        return ingredients;
    }
    public void setIngredients(Ingredient[] ingredients_recette){
        this.ingredients = new ArrayList<>(Arrays.asList(ingredients_recette));
    }
    public void setIngredients(ArrayList<Ingredient> ingredients_recette){
        this.ingredients = ingredients_recette;
    }
    public void addIngredient(Ingredient nouvel_ingredient){
        ingredients.add(nouvel_ingredient);
    }
    @Override
    public String toString(){
        return "Recette=" + Arrays.toString(new ArrayList[]{ingredients});
    }
}
