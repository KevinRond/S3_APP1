package ingredients;

import ingredients.etat.etatIngredient;

public class Epice extends Ingredient {
    public Epice(String name) {
        setTypeIngredient(TypeIngredient.EPICE);
        setNom(name);
    }
    public Epice(String name, etatIngredient etat) {
        setTypeIngredient(TypeIngredient.EPICE);
        setNom(name);
        setEtat(etat);
    }
    public Epice(String name, etatIngredient etat, double desired_quantity) {
        setTypeIngredient(TypeIngredient.EPICE);
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
