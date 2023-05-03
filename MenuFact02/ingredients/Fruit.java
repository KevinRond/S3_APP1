package ingredients;

public class Fruit extends Ingredient{
    public Fruit() {
        setTypeIngredient(TypeIngredient.FRUIT);
    }
    public Fruit(etatIngredient etat) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setEtat(etat);
    }
    public Fruit(etatIngredient etat, double desired_quantity) {
        setTypeIngredient(TypeIngredient.FRUIT);
        setEtat(etat);
        setQuantity(desired_quantity);
    }
    @Override
    public String toString() {
        return "Ingredient{" +
                "Type=" + this.getTypeIngredient() + '\''+
                "Nom=" + this.getNom() + " \""+
                "Etat='" + this.getEtat() + '\'' +
                "Quantite='" + this.getQuantity() + '\'' +
                '}';
    }

}
