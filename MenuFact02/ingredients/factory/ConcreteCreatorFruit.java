package ingredients.factory;

import ingredients.Epice;
import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorFruit implements FactoryCreatorIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Fruit(nom, etat);
    }
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Fruit(intrinsicIngredient, nom);
    }
}
