package ingredients;

import ingredients.etat.etatIngredient;

public class Viande extends Ingredient{
    public Viande(String name) {
        setTypeIngredient(TypeIngredient.VIANDE);
        setNom(name);
    }
    public Viande(String name, etatIngredient etat) {
        setTypeIngredient(TypeIngredient.VIANDE);
        setNom(name);
        setEtat(etat);
    }
    public Viande(String name, etatIngredient etat, double desired_quantity) {
        setTypeIngredient(TypeIngredient.VIANDE);
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
