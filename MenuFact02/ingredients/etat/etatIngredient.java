package ingredients.etat;

import ingredients.exceptions.IngredientException;

/**
 * Interface etatIngredient
 */
public interface etatIngredient {

    public double getQuantity();

    /**
     * Change la quantité d'ingrédient
     * @param qty
     * @throws IngredientException
     */
    void setQuantity(double qty) throws IngredientException;
    //public boolean equals(Object);

    /**
     * Renvoie l'état de l'ingrédient
     * @return
     */
    public String getEtat();
}
