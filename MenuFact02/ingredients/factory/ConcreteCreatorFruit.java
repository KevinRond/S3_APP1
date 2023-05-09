package ingredients.factory;

import ingredients.Epice;
import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.etat.etatIngredient;

/**
 * Classe ConcreteCreatorFruit
 */
public class ConcreteCreatorFruit implements FactoryCreatorIngredient {
    /**
     * Crée un ingrédient Fruit
     * @param nom
     * @param etat
     * @return
     */
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Fruit(nom, etat);
    }

    /**
     * Crée un ingrédient Fruit static
     * @param intrinsicIngredient
     * @param nom
     * @return
     */
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Fruit(intrinsicIngredient, nom);
    }
}
