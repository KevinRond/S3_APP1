package ingredients.factory;

import ingredients.Ingredient;
import ingredients.Legume;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorLegume implements FactoryIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Legume(nom, etat);
    }
}
