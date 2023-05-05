package ingredients.factory;

import ingredients.Ingredient;
import ingredients.Viande;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorViande implements FactoryIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Viande(nom, etat);
    }
}
