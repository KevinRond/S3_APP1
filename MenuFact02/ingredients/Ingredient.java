package ingredients;

import ingredients.etat.etatIngredient;
/**
 * Ingredient abstrait qui formeront les recettes et les plats
 *
 * @author Kevin
 */
public abstract class Ingredient {
    /**
     * Nom de l'ingredient
     */
    private String nom;
    /**
     * Description de l'ingredient
     */
    private String description;
    /**
     * Type de l'ingredient
     */
    private TypeIngredient typeIngredient;
    /**
     * Etat de l'ingredient
     */
    protected etatIngredient etat;

    public Ingredient(){}

    /**
     * Retourne le nom de l'ingredient
     *
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Set le nom de l'ingredient
     *
     * @param nom a set
     */
    public void setNom(String nom) {
        if (nom != null) {
            this.nom = nom;
        }
    }

    /**
     * Retourne la description de l'ingredient
     *
     * @return description
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set la decription de l'ingredient
     *
     * @param description a set
     */
    public void setDescription(String description) {
        if (description != null) {
            this.description = description;
        }
    }

    /**
     * Retourne la quantite de l'ingredient
     *
     * @return quantite
     */
    public double getQuantity() {
        return etat.getQuantity();
    }

    /**
     * Set la quantite de l'ingredient
     *
     * @param quantity de l'ingredient
     */
    public void setQuantity(double quantity) {
        this.etat.setQuantity(quantity);
    }

    /**
     * Retourne l'etat de l'ingredient
     *
     * @return etat
     */
    public etatIngredient getEtat(){
        return etat;
    }

    /**
     * Set l'etat de l'ingredient
     *
     * @param nouvel_etat de l'ingredient
     */
    public void setEtat(etatIngredient nouvel_etat){
        this.etat = nouvel_etat;
    }

    /**
     * Retourne le type de l'ingredient
     *
     * @return typeIngredient
     */
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    /**
     * Set le type de l'ingredient
     *
     * @param typeIngredient a set
     */
    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
