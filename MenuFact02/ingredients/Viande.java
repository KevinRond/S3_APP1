package ingredients;

import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Viande extends Ingredient{
    public Viande(IntrinsicIngredient intrinsicIngredient, String name) {
        //setTypeIngredient(TypeIngredient.VIANDE);
        setNom(name);
    }
    public Viande(String name, etatIngredient etat) {
        //setTypeIngredient(TypeIngredient.VIANDE);
        setNom(name);
        setEtat(etat);
    }
    public Viande(String name, etatIngredient etat, double desired_quantity) throws IngredientException {
        //setTypeIngredient(TypeIngredient.VIANDE);
        setNom(name);
        setEtat(etat);
        setQuantity(desired_quantity);
    }
    @Override
    public String toString() {
        return "Ingredient{" +
                "Type=" + this.getTypeIngredient() + ", " +
                "Nom=" + this.getNom() + ",  "+
                "Etat=" + this.getEtat() + ", " +
                "Quantite=" + this.getQuantity() +
                '}' + "\n";
    }
}
