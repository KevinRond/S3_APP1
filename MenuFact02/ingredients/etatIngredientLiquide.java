package ingredients;

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
}
