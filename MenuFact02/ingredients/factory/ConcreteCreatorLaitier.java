package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.Laitier;
import ingredients.etat.etatIngredient;

/**
 * Classe ConcreteCreatorLaitier
 */
public class ConcreteCreatorLaitier implements FactoryCreatorIngredient {
    /**
     * Crée un ingrédient Laitier
     * @param nom
     * @param etat
     * @return
     */
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Laitier(nom, etat);
    }

    /**
     * Crée un ingrédient Laitier static
     * @param intrinsicIngredient
     * @param nom
     * @return
     */
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Laitier(intrinsicIngredient, nom);
    }
}
