package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.Legume;
import ingredients.etat.etatIngredient;

/**
 * Classe ConcreteCreatorLegume
 */
public class ConcreteCreatorLegume implements FactoryCreatorIngredient {
    /**
     * Crée un ingrédient Légume
     * @param nom
     * @param etat
     * @return
     */
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Legume(nom, etat);
    }

    /**
     * Crée un ingrédient Légume static
     * @param intrinsicIngredient
     * @param nom
     * @return
     */
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Legume(intrinsicIngredient, nom);
    }
}
