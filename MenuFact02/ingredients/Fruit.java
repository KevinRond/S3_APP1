package ingredients;

import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Fruit extends Ingredient{
    /**
     * Constructeur de Fruit
     * @param intrinsicIngredient
     * @param name
     */
    public Fruit(IntrinsicIngredient intrinsicIngredient, String name) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
        setEtat(intrinsicIngredient.getEtat());
    }

    /**
     * Constructeur de Fruit
     * @param name
     * @param etat
     */
    public Fruit(String name, etatIngredient etat) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
        setEtat(etat);
    }

    /**
     * Constructeur de Fruit
     * @param name
     * @param etat
     * @param desired_quantity
     * @throws IngredientException
     */
    public Fruit(String name, etatIngredient etat, double desired_quantity) throws IngredientException {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
        setEtat(etat);
        setQuantity(desired_quantity);
    }

    /**
     * Renvoie de l'information de l'ingrédient Fruit
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
