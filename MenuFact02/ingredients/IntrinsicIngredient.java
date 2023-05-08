package ingredients;

import ingredients.etat.etatIngredient;

public class IntrinsicIngredient {
    private TypeIngredient type;
    private etatIngredient etat;
    public IntrinsicIngredient(TypeIngredient type, etatIngredient etat){
        this.type = type;
        this.etat = etat;
    }
    public etatIngredient getEtat(){
        return etat;
    }

    public TypeIngredient getType() {
        return type;
    }
}
