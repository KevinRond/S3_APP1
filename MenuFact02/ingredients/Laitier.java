package ingredients;

import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Laitier extends Ingredient {
    /**
     * Constructeur de Laitier
     * @param intrinsicIngredient
     * @param name
     */
    public Laitier(IntrinsicIngredient intrinsicIngredient, String name) {
        setTypeIngredient(TypeIngredient.LAITIER);
        setNom(name);
        setEtat(intrinsicIngredient.getEtat());
    }

    /**
     * Constructeur de Laitier
     * @param name
     * @param etat
     */
    public Laitier(String name, etatIngredient etat) {
        setTypeIngredient(TypeIngredient.LAITIER);
        setNom(name);
        setEtat(etat);
    }

    /**
     * Constructeur de Laitier
     * @param name
     * @param etat
     * @param desired_quantity
     * @throws IngredientException
     */
    public Laitier(String name, etatIngredient etat, double desired_quantity) throws IngredientException {
        setTypeIngredient(TypeIngredient.LAITIER);
        setNom(name);
        setEtat(etat);
        setQuantity(desired_quantity);
    }

    /**
     * Renvoie les informations sur l'ingrédient laitier
     * @return
     */
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
