package ingredients.etat;

import ingredients.exceptions.IngredientException;

public class etatIngredientSolide implements etatIngredient {

    private double weight;
    private String etat = "Solide";
    public etatIngredientSolide(double qty) throws IngredientException {
        setQuantity(qty);
    }
    @Override
    public double getQuantity() {
        return weight;
    }

    @Override
    public void setQuantity(double qty) throws IngredientException {
        if (qty < 0) {
            throw new IngredientException("Quantité d'ingrédient ne peut pas être négative");
        } else {
            weight = qty;
        }
    }

    @Override
    public String getEtat() {
        return etat;
    }

    @Override
    public String toString(){
        return "Solide: Qty = " + weight;
    }
}
