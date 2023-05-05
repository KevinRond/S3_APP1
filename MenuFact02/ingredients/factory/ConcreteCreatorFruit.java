package ingredients.factory;

import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorFruit implements FactoryIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Fruit(nom, etat);
    }
}
