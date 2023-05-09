package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorEpice implements FactoryCreatorIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Epice(nom, etat);
    }
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Epice(intrinsicIngredient, nom);
    }
}

