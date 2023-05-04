package ingredients.factory;

import ingredients.Ingredient;
import ingredients.Laitier;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorLaitier implements CreatorIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Laitier(nom, etat);
    }
}
