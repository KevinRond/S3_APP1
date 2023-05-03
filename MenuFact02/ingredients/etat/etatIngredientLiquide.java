package ingredients.etat;

import ingredients.etat.etatIngredient;

public class etatIngredientLiquide implements etatIngredient {

    private double volume;
    @Override
    public double getQuantity() {
        return volume;
    }

    @Override
    public void setQuantity(double quantity) {
        volume = quantity;
    }

    @Override
    public String toString(){
        return "Liquide";
    }
}
