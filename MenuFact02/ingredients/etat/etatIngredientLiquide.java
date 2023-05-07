package ingredients.etat;

import ingredients.exceptions.IngredientException;

public class etatIngredientLiquide implements etatIngredient {

    private double volume;
    public etatIngredientLiquide(double qty) throws IngredientException {
        setQuantity(qty);
    }
    @Override
    public double getQuantity() {
        return volume;
    }

    @Override
    public void setQuantity(double qty) throws IngredientException {
        if (qty < 0) {
            throw new IngredientException("Quantité d'ingrédient ne peut pas être négative");
        } else {
            volume = qty;
        }
    }

    @Override
    public String toString(){
        return "LiquideQty = " + volume;
    }
}
