package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.Laitier;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorLaitier implements FactoryCreatorIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Laitier(nom, etat);
    }
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Laitier(intrinsicIngredient, nom);
    }
}
