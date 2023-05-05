package tests;

import ingredients.*;
import ingredients.etat.etatIngredient;
import ingredients.etat.etatIngredientLiquide;
import ingredients.etat.etatIngredientSolide;
import ingredients.exceptions.IngredientException;
import ingredients.factory.FactoryIngredient;
import inventaire.Inventaire;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InventaireTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void getInstance() {
        Inventaire inventaire1 = Inventaire.getInstance();
        Inventaire inventaire2 = Inventaire.getInstance();
        assertEquals(inventaire1, inventaire2);
        Inventaire.clear();
    }

    @Test
    void ajouterIngredient() throws IngredientException {
        Inventaire inventaire1 = Inventaire.getInstance();
        etatIngredient solide = new etatIngredientSolide();
        Ingredient fraise = new Fruit("fraise", solide);
        inventaire1.ajouterIngredient(fraise);
        assertEquals(fraise, inventaire1.getIngredient("fraise"));
        Inventaire.clear();
//        Inventaire inventaire1 = Inventaire.getInstance();
//        etatIngredient solide = new etatIngredientSolide();
//        FactoryIngredient factory = new FactoryIngredient();

    }

    @Test
    void getIngredient() throws IngredientException {
        Inventaire inventaire1 = Inventaire.getInstance();
        etatIngredient liquide = new etatIngredientSolide();
        Ingredient tomate = new Fruit("tomate", liquide);
        inventaire1.ajouterIngredient(tomate);
        assertEquals(tomate, inventaire1.getIngredient("tomate"));
        Inventaire.clear();
    }

    @Test
    void getQuantityInCongelateur() throws IngredientException {
        Inventaire inventaire1 = Inventaire.getInstance();
        etatIngredient solide = new etatIngredientSolide();
        Ingredient fraise = new Fruit("fraise", solide, 3.0);
        Ingredient steak = new Viande("steak", solide, 10.0);
        inventaire1.ajouterIngredient(fraise);
        inventaire1.ajouterIngredient(steak);
        assertEquals(2, inventaire1.getQuantityInCongelateur());
        Inventaire.clear();
    }

    @Test
    void utiliserIngredients() {
    }

    @Test
    void clear() throws IngredientException {
        Inventaire inventaire1 = Inventaire.getInstance();
        etatIngredient solide = new etatIngredientSolide();
        Ingredient fraise = new Fruit("fraise", solide, 3.0);
        Ingredient steak = new Viande("steak", solide, 10.0);
        inventaire1.ajouterIngredient(fraise);
        inventaire1.ajouterIngredient(steak);
        Inventaire.clear();
        assertEquals(0, inventaire1.getQuantityInCongelateur());
    }

    @Test
    void testToString() throws IngredientException {
        Inventaire inventaire1 = Inventaire.getInstance();
        etatIngredient solide = new etatIngredientSolide();
        etatIngredient liquide = new etatIngredientLiquide();
        Ingredient fraise = new Fruit("fraise", solide, 3.0);
        Ingredient concombre = new Legume("concombre", solide, 3);
        Ingredient steak = new Viande("steak", solide, 10.0);
        Ingredient lait = new Laitier("lait", liquide, 5);
        Ingredient cayenne = new Epice("cayenne", solide, 0.3);
        inventaire1.ajouterIngredient(fraise);
        inventaire1.ajouterIngredient(concombre);
        inventaire1.ajouterIngredient(steak);
        inventaire1.ajouterIngredient(lait);
        inventaire1.ajouterIngredient(cayenne);
        System.out.println(inventaire1);
    }
}