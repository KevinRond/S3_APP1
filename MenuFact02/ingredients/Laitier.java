package ingredients;

import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Laitier extends Ingredient {
    public Laitier(IntrinsicIngredient intrinsicIngredient, String name) {
        //setTypeIngredient(TypeIngredient.LAITIER);
        setNom(name);
    }
    public Laitier(String name, etatIngredient etat) {
        //setTypeIngredient(TypeIngredient.LAITIER);
        setNom(name);
        setEtat(etat);
    }
    public Laitier(String name, etatIngredient etat, double desired_quantity) throws IngredientException {
        //setTypeIngredient(TypeIngredient.LAITIER);
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
