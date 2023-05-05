package ingredients.factory;

import ingredients.Ingredient;
import ingredients.etat.etatIngredient;

public interface FactoryIngredient {
    public Ingredient create(String nom, etatIngredient etat);
}
