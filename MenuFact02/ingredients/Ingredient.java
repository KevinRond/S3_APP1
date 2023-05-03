package ingredients;

import ingredients.etat.etatIngredient;

public abstract class Ingredient {
    private String nom;
    private String description;
    private TypeIngredient typeIngredient;
    protected etatIngredient etat;

    public Ingredient(){

    }
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public double getQuantity() {
        return etat.getQuantity();
    }
    public void setQuantity(double quantity) {
        this.etat.setQuantity(quantity);
    }
    public etatIngredient getEtat(){
        return etat;
    }
    public void setEtat(etatIngredient nouvel_etat){
        this.etat = nouvel_etat;
    }
    public TypeIngredient getTypeIngredient() {
        return typeIngredient;
    }

    public void setTypeIngredient(TypeIngredient typeIngredient) {
        this.typeIngredient = typeIngredient;
    }
}
