package ingredients.etat;

import ingredients.exceptions.IngredientException;

/**
 * Classe etatIngredientLiquide
 */
public class etatIngredientLiquide implements etatIngredient {

    private double volume;
    private String etat = "Liquide";

    /**
     * Constructeur de etatIngredientLiquide
     * @param qty
     * @throws IngredientException
     */
    public etatIngredientLiquide(double qty) throws IngredientException {
        setQuantity(qty);
    }

    /**
     * Renvoie le volume d'ingrédient
     * @return
     */
    @Override
    public double getQuantity() {
        return volume;
    }

    /**
     * CHange le volume d'ingrédient
     * @param qty
     * @throws IngredientException
     */
    @Override
    public void setQuantity(double qty) throws IngredientException {
        if (qty < 0) {
            throw new IngredientException("Quantité d'ingrédient ne peut pas être négative");
        } else {
            volume = qty;
        }
    }

    /**
     * Renvoie l'état
     * @return
     */
    @Override
    public String getEtat(){
        return etat;
    }

    /**
     * Renvoie de l'information sur l'état de l'ingrédient
     * @return
     */
    @Override
    public String toString(){
        return "LiquideQty = " + volume;
    }
}
