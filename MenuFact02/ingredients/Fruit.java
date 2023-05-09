package ingredients;

import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Fruit extends Ingredient{
    public Fruit(IntrinsicIngredient intrinsicIngredient, String name) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
        setEtat(intrinsicIngredient.getEtat());
    }
    public Fruit(String name, etatIngredient etat) {
        //setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
        setEtat(etat);
    }
    public Fruit(String name, etatIngredient etat, double desired_quantity) throws IngredientException {
        //setTypeIngredient(TypeIngredient.FRUIT);
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
