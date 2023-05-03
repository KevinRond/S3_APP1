package ingredients.etat;

import ingredients.etat.etatIngredient;

public class etatIngredientSolide implements etatIngredient {

    private double weight;
    @Override
    public double getQuantity() {
        return weight;
    }

    @Override
    public void setQuantity(double quantity) {
        weight = quantity;
    }

    @Override
    public String toString(){
        return "Solide";
    }
}
