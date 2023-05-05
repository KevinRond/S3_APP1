package tests;

import static ingredients.TypeIngredient.FRUIT;
import static ingredients.TypeIngredient.LEGUME;
import static org.junit.jupiter.api.Assertions.*;

import ingredients.*;
import ingredients.etat.etatIngredient;
import ingredients.etat.etatIngredientLiquide;
import ingredients.etat.etatIngredientSolide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FruitTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void getNom() {
        Ingredient fraise = new Fruit("fraise");
        assertEquals("fraise", fraise.getNom());
    }

    @Test
    void setNom() {
        Ingredient fraise = new Fruit("FRsawsw");
        fraise.setNom("fraise");
        assertEquals("fraise", fraise.getNom());
    }

    @Test
    void getDescription() {
        Ingredient fraise = new Fruit("fraise");
        fraise.setDescription("Une delicieuse fraise");
        assertEquals("Une delicieuse fraise", fraise.getDescription());
    }

    @Test
    void setDescription() {
        Ingredient fraise = new Fruit("fraise");
        fraise.setDescription("Une delicieuse fraise");
        assertEquals("Une delicieuse fraise", fraise.getDescription());
    }

    @Test
    void getQuantity() {
        etatIngredient solide = new etatIngredientSolide();
        Ingredient orange = new Fruit("orange",solide, 20.0);
        assertEquals(20.0, orange.getQuantity());
    }

    @Test
    void setQuantity() {
        etatIngredient solide = new etatIngredientSolide();
        Ingredient orange = new Fruit("orange", solide, 20.0);
        orange.setQuantity(10.0);
        assertEquals(10.0, orange.getQuantity());
    }

    @Test
    void getEtat() {
        etatIngredient solide = new etatIngredientSolide();
        Ingredient orange = new Fruit("orange", solide, 20.0);
        assertEquals(solide, orange.getEtat());
    }

    @Test
    void setEtat() {
        etatIngredient solide = new etatIngredientSolide();
        etatIngredient liquide = new etatIngredientLiquide();
        Ingredient orange = new Fruit("orange", solide, 20.0);
        orange.setEtat(liquide);
        assertEquals(liquide, orange.getEtat());
    }

    @Test
    void getTypeIngredient() {
        Ingredient fraise = new Fruit("fraise");
        assertEquals(FRUIT, fraise.getTypeIngredient());
    }

    @Test
    void setTypeIngredient() {
        Ingredient fraise = new Fruit("fraise");
        fraise.setTypeIngredient(LEGUME);
        assertEquals(LEGUME, fraise.getTypeIngredient());
    }

    @Test
    void testToString() {
        etatIngredient solide = new etatIngredientSolide();
        Ingredient orange = new Fruit("orange", solide, 20.0);
        System.out.println(orange);
    }
}