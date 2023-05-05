package ingredients;

import ingredients.etat.etatIngredient;

public class Legume extends Ingredient{
    public Legume(String name) {
        setTypeIngredient(TypeIngredient.LEGUME);
        setNom(name);
    }
    public Legume(String name, etatIngredient etat) {
        setTypeIngredient(TypeIngredient.LEGUME);
        setNom(name);
        setEtat(etat);
    }
    public Legume(String name, etatIngredient etat, double desired_quantity) {
        setTypeIngredient(TypeIngredient.LEGUME);
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
                '}';
    }
}
