package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.Legume;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorLegume implements FactoryCreatorIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Legume(nom, etat);
    }
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Legume(intrinsicIngredient, nom);
    }
}
