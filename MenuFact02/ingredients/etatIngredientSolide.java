package ingredients;

public class etatIngredientSolide implements etatIngredient {

    private double weight;
    @Override
    public double getQuantity() {
        return 0;
    }

    @Override
    public void setQuantity(double quantity) {
        weight = quantity;
    }
}
