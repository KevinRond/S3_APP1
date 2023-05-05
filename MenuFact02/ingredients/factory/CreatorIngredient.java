package ingredients.factory;

import ingredients.Ingredient;
import ingredients.etat.etatIngredient;

public interface CreatorIngredient {
    public Ingredient create(String nom, etatIngredient etat);
}
