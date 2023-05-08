package inventaire;

import ingredients.FactoryFlyweightIngredient;
import ingredients.Ingredient;
import ingredients.IntrinsicIngredient;
import ingredients.TypeIngredient;
import ingredients.etat.etatIngredient;
import ingredients.exceptions.IngredientException;
import ingredients.factory.*;
import menufact.plats.Recette;

import java.util.HashMap;

public class Inventaire {
    //private ArrayList<Ingredient> lesIngredients = new ArrayList<Ingredient>();
    private HashMap<String, Ingredient> congelateur;
    private FactoryFlyweightIngredient flyweightFactory;
    private int size = 0;
    private static Inventaire instance = null;

    private Inventaire(){
        congelateur = new HashMap<>();
        flyweightFactory = new FactoryFlyweightIngredient();
    }
    public static Inventaire getInstance(){
        if (instance == null){
            instance = new Inventaire();
        }
        return instance;
    }

    public void ajouterIngredient(Ingredient[] ingredients) throws IngredientException {
        if (ingredients == null){
            throw new IngredientException("Impossible d'ajouter un ingredient null");
        }
        for (Ingredient ingredient : ingredients) {
            ajouterIngredient(ingredient);
        }
    }

    public void ajouterIngredient(Ingredient ingredient) throws IngredientException {
        if (ingredient == null){
            throw new IngredientException("Impossible d'ajouter un ingredient null");
        }
        if (congelateur.containsKey(ingredient.getNom())) {
            Ingredient temporary_ingredient = congelateur.get(ingredient.getNom());
            temporary_ingredient.setQuantity(temporary_ingredient.getQuantity() + ingredient.getQuantity());
        } else {
            congelateur.put(ingredient.getNom(), ingredient);
            size++;
        }
    }
    public void ajouterIngredient(TypeIngredient type, etatIngredient etat, String nom) throws IngredientException {
        IntrinsicIngredient intrinsicIngredient = flyweightFactory.getIntrinsicIngredient(type, etat);
        String typeIngredientString= type.toString();
        switch (typeIngredientString) {
            case "FRUIT" -> {
                Ingredient fruit = ConcreteCreatorFruit.create(intrinsicIngredient, nom);
                if (congelateur.containsKey(fruit.getNom())) {
                    Ingredient ingredient = congelateur.get(fruit.getNom());
                    ingredient.setQuantity(ingredient.getQuantity() + fruit.getQuantity());

                } else {
                    congelateur.put(fruit.getNom(), fruit);
                    size++;
                }
            }
            case "LEGUME" -> {
                Ingredient legume = ConcreteCreatorLegume.create(intrinsicIngredient, nom);
                if (congelateur.containsKey(legume.getNom())) {
                    Ingredient ingredient = congelateur.get(legume.getNom());
                    ingredient.setQuantity(ingredient.getQuantity() + legume.getQuantity());

                } else {
                    congelateur.put(legume.getNom(), legume);
                    size++;
                }
            }
            case "VIANDE" -> {
                Ingredient viande = ConcreteCreatorViande.create(intrinsicIngredient, nom);
                if (congelateur.containsKey(viande.getNom())) {
                    Ingredient ingredient = congelateur.get(viande.getNom());
                    ingredient.setQuantity(ingredient.getQuantity() + viande.getQuantity());

                } else {
                    congelateur.put(viande.getNom(), viande);
                    size++;
                }
            }
            case "LAITIER" -> {
                Ingredient laitier = ConcreteCreatorLaitier.create(intrinsicIngredient, nom);
                if (congelateur.containsKey(laitier.getNom())) {
                    Ingredient ingredient = congelateur.get(laitier.getNom());
                    ingredient.setQuantity(ingredient.getQuantity() + laitier.getQuantity());

                } else {
                    congelateur.put(laitier.getNom(), laitier);
                    size++;
                }
            }
            case "EPICE" -> {
                Ingredient epice = ConcreteCreatorEpice.create(intrinsicIngredient, nom);
                if (congelateur.containsKey(epice.getNom())) {
                    Ingredient ingredient = congelateur.get(epice.getNom());
                    ingredient.setQuantity(ingredient.getQuantity() + epice.getQuantity());

                } else {
                    congelateur.put(epice.getNom(), epice);
                    size++;
                }
            }
        }

    }
    public Ingredient getIngredient(String nomIngredient){
        return congelateur.get(nomIngredient);
    }
    public double getIngredientQuantity(Ingredient ingredient){
        if (congelateur.get(ingredient.getNom()) == null){
            return 0;
        } else {
            return congelateur.get(ingredient.getNom()).getQuantity();
        }
    }
    public int getQuantityInCongelateur(){
        return congelateur.size();
    }
    public void utiliserIngredients(Recette recette, int quantitePlats, double proportion) throws IngredientException {
        if (recette == null){
            throw new IngredientException("La recette ne peut pas etre nulle.");
        }
        if (quantitePlats <= 0) {
            throw new IngredientException("La quantite ne peut pas etre 0 ou moins.");
        }
        if (proportion <= 0){
            throw new IngredientException("La proportion ne peut pas etre negative.");
        }
        if (proportion > 1){
            throw new IngredientException("La proportion ne peut pas etre plus grande que 1.");
        }
        for (Ingredient ingredient : recette.getIngredients()){
            if (congelateur.containsKey(ingredient.getNom())){
                Ingredient ingredientCongel = congelateur.get(ingredient.getNom());

                double quantite_inventaire = congelateur.get(ingredient.getNom()).getQuantity();
                double quantite_recette = ingredient.getQuantity() * quantitePlats * proportion;
                if (quantite_inventaire < quantite_recette){
                    throw new IngredientException("Pas assez d'ingredients pour cette recette dans l'inventaire");

                }
                ingredientCongel.setQuantity(quantite_inventaire - quantite_recette);
            } else {
                throw new IngredientException("Ingredient de la recette pas trouve dans l'inventaire");
            }
        }
    }
    public static void clear(){
        if (instance != null){
            instance.congelateur.clear();
            instance = null;
        }
    }
    public int getSize(){
        return size;
    }
    public void setSize(int size){
        this.size = size;
    }
    @Override
    public String toString(){
        return "Inventaire=" + congelateur;
    }

}
