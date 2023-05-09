package ingredients.etat;

import ingredients.exceptions.IngredientException;

/**
 * Classe etatIngredientSolide
 */
public class etatIngredientSolide implements etatIngredient {

    private double weight;
    private String etat = "Solide";

    /**
     * Constructeur de etatIngredientSolide
     * @param qty
     * @throws IngredientException
     */
    public etatIngredientSolide(double qty) throws IngredientException {
        setQuantity(qty);
    }

    /**
     * Renvoie le poids de l'ingrédient
     * @return
     */
    @Override
    public double getQuantity() {
        return weight;
    }

    /**
     * Change le poids de l'ingrédient
     * @param qty
     * @throws IngredientException
     */
    @Override
    public void setQuantity(double qty) throws IngredientException {
        if (qty < 0) {
            throw new IngredientException("Quantité d'ingrédient ne peut pas être négative");
        } else {
            weight = qty;
        }
    }

    /**
     * Renvoie l'état de l'ingrédient
     * @return
     */
    @Override
    public String getEtat() {
        return etat;
    }

    /**
     * Renvoie de l'information sur l'état de l'ingrédient
     * @return
     */
    @Override
    public String toString(){
        return "Solide: Qty = " + weight;
    }
}
