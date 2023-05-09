package ingredients.factory;

import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.etat.etatIngredient;

import java.util.HashMap;

/**
 * Interface FactoryCreatorIngredient
 */
public interface FactoryCreatorIngredient {
    /**
     * Crée un ingrédient
     * @param nom
     * @param etat
     * @return
     */
    public Ingredient create(String nom, etatIngredient etat);

    /**
     * Crée un ingrédient static et retourne null
     * @param intrinsicIngredient
     * @param nom
     * @return
     */
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom) {
        return null;
    }
}
