package ingredients.factory;

import ingredients.Epice;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.Viande;
import ingredients.etat.etatIngredient;

public class ConcreteCreatorViande implements FactoryCreatorIngredient {
    @Override
    public Ingredient create(String nom, etatIngredient etat) {
        return new Viande(nom, etat);
    }
    public static Ingredient create(IntrinsicIngredient intrinsicIngredient, String nom){
        return new Viande(intrinsicIngredient, nom);
    }
}
