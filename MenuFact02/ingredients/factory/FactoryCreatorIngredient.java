package ingredients.factory;

import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.etat.etatIngredient;

import java.util.HashMap;

public interface FactoryCreatorIngredient {
    public Ingredient create(String nom, etatIngredient etat);

    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom) {
        return null;
    }
}
