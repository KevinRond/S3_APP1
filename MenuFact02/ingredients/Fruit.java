package ingredients;

import ingredients.etat.etatIngredient;

/**
 * Sous-classe d'Ingredient
 *
 * @author Kevin
 */
public class Fruit extends Ingredient{
    public Fruit(String name) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
    }
    public Fruit(String name, etatIngredient etat) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setNom(name);
        setEtat(etat);
    }
    public Fruit(String name, etatIngredient etat, double desired_quantity) {
        setTypeIngredient(TypeIngredient.FRUIT);
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
