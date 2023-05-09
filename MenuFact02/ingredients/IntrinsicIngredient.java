package ingredients;

import ingredients.etat.etatIngredient;

/**
 * Classe IntrinsicIngredient
 */
public class IntrinsicIngredient {
    private TypeIngredient type;
    private etatIngredient etat;

    /**
     * Constructeur IntrinsicIngredient
     * @param type
     * @param etat
     */
    public IntrinsicIngredient(TypeIngredient type, etatIngredient etat){
        this.type = type;
        this.etat = etat;
    }

    /**
     * Renvoie l'état
     * @return
     */
    public etatIngredient getEtat(){
        return etat;
    }

    /**
     * Renvoie le type d'ingrédient
     * @return
     */
    public TypeIngredient getType() {
        return type;
    }
}
