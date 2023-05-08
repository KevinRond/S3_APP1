package ingredients.etat;

import ingredients.exceptions.IngredientException;

public interface etatIngredient {

    public double getQuantity();

    void setQuantity(double qty) throws IngredientException;
    //public boolean equals(Object);
    public String getEtat();
}
