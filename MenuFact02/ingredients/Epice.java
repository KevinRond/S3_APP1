package ingredients;

import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Epice extends Ingredient {
    public Epice(IntrinsicIngredient intrinsicIngredient, String name) {
        setTypeIngredient(TypeIngredient.EPICE);
        setNom(name);
        setEtat(intrinsicIngredient.getEtat());
    }
    public Epice(String name, etatIngredient etat) {
        //setTypeIngredient(TypeIngredient.EPICE);
        setNom(name);
        setEtat(etat);
    }
    public Epice(String name, etatIngredient etat, double desired_quantity) throws IngredientException {
        //setTypeIngredient(TypeIngredient.EPICE);
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
