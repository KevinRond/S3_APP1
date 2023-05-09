package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.etat.etatIngredient;

/**
 * Classe ConcreteCreatorEpice
 */
public class ConcreteCreatorEpice implements FactoryCreatorIngredient {
    /**
     * Crée un ingrédient Epice
     * @param nom
     * @param etat
     * @return
     */
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Epice(nom, etat);
    }

    /**
     * Crée un ingrédient Epice static
     * @param intrinsicIngredient
     * @param nom
     * @return
     */
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Epice(intrinsicIngredient, nom);
    }
}

