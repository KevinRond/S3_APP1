package ingredients;

import ingredients.exceptions.IngredientException;

/**
 * Classe IngredientInventaire
 */
public class IngredientInventaire {

    private IngredientInventaire ingredientInventaire;
    private int quantite;

    /**
     * Constructeur de IngredientInventaire
     * @param ingredientInventaire
     * @param quantite
     */
    public IngredientInventaire(IngredientInventaire ingredientInventaire, int quantite) {
        this.ingredientInventaire = ingredientInventaire;
        this.quantite = quantite;
    }

    /**
     * Renvoie une quantite
     * @return
     */
    public int getQuantite() {
        return quantite;
    }

    /**
     * Change la quantite
     * @param quantite
     * @throws IngredientException
     */
    public void setQuantite(int quantite) throws IngredientException{

        if (quantite < 0)
            throw new IngredientException("Il n'est pas possible d'avoir une quantité negative");
        else
            this.quantite = quantite;
    }
}
