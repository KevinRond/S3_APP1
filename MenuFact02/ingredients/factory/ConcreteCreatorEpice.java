package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorEpice implements FactoryIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Epice(nom, etat);
    }
}
