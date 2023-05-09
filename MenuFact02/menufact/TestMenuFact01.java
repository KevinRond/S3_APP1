package menufact;

import ingredients.*;
import ingredients.etat.etatIngredient;
import ingredients.etat.etatIngredientLiquide;
import ingredients.etat.etatIngredientSolide;
import ingredients.exceptions.IngredientException;
import ingredients.factory.ConcreteCreatorFruit;
import ingredients.factory.ConcreteCreatorViande;
import ingredients.factory.FactoryCreatorIngredient;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.Client;
import menufact.exceptions.MenuException;
import menufact.facture.Etat.FactureEtatFermee;
import menufact.facture.Etat.FactureEtatOuverte;
import menufact.facture.Etat.FactureEtatPayee;
import menufact.facture.MVC.FactureController;
import menufact.facture.MVC.FactureView;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import menufact.Menu;
import menufact.builder.*;
import menufact.facture.Facture;
import menufact.plats.PlatChoisi;
//import menufact.plats.builder.*;
import menufact.plats.exceptions.PlatException;
import menufact.plats.state.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

import static ingredients.TypeIngredient.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMenuFact01 {
    public static void main(String[] args) throws IngredientException, PlatException, MenuException, FactureException {
        System.out.println("===CREATION CHEF===");
        Chef Bozzo = Chef.getInstance("Bozzo");
        System.out.println(Bozzo.toString()+ "\n");

        System.out.println("===CREATION INVENTAIRE===");
        Inventaire inventaire = Inventaire.getInstance();
        System.out.println(inventaire.toString()+ "\n");

        System.out.println("===CREATION INGREDIENTS");
        Ingredient pate = new Legume("Pate a pizza", new etatIngredientSolide(15));
        Ingredient sauce = new Legume("Sauce tomate", new etatIngredientLiquide(500));
        Ingredient pepperoni = new Viande("Peperronis", new etatIngredientSolide(30));
        Ingredient fromage = new Laitier("Fromage", new etatIngredientSolide(10));

        Ingredient piment = new Legume("Piments", new etatIngredientSolide(20));

        Ingredient olive = new Legume("Olives", new etatIngredientSolide(20));
        Ingredient tomate = new Legume("Tomates", new etatIngredientSolide(40));

        System.out.println(pate.toString());
        System.out.println(sauce.toString());
        System.out.println(pepperoni.toString());
        System.out.println(fromage.toString());
        System.out.println(piment.toString());
        System.out.println(olive.toString());
        System.out.println(tomate.toString() + "\n");

        System.out.println("===AJOUT INGREDIENTS DANS INVENTAIRE===");
        inventaire.ajouterIngredient(new Ingredient[]{pate, sauce, pepperoni, fromage, piment, olive, tomate});
        System.out.println(inventaire.toString() + "\n");

        System.out.println("===CREATION MENU===");
        Menu menu = Menu.getInstance("Bienvenue chez Domino's pizza\n"+"Pizza pepperonis\n"+"Pizza all dressed\n"+"Pizza vege");
        System.out.println(menu.toString()+"\n");

        System.out.println("===CREATION DE PLAT===");
        PlatAuMenu pizzaPepperoni = new PlatAuMenu(1, "Pizza pepperoni", 31.99);
        PlatAuMenu pizzaAllDressed = new PlatAuMenu(2, "Pizza All Dressed", 34.99);
        PlatAuMenu pizzaVege = new PlatAuMenu(3, "Pizza Vegetarienne", 33.99);
        System.out.println(pizzaPepperoni.toString());
        System.out.println(pizzaAllDressed.toString());
        System.out.println(pizzaVege.toString()+"\n");

        System.out.println("===CREATION RECETTE===");
        ArrayList<Ingredient> recette1 = new ArrayList<>((Arrays.asList(pate, sauce, pepperoni, fromage)));
        ArrayList<Ingredient> recette2 = new ArrayList<>((Arrays.asList(pate, sauce, pepperoni, fromage, piment)));
        ArrayList<Ingredient> recette3 = new ArrayList<>((Arrays.asList(pate, sauce, pepperoni, fromage, olive, tomate)));

        Recette pizzaPepperoniRecette = new Recette(recette1);
        Recette pizzaAllDressedRecette = new Recette(recette2);
        Recette pizzaVegeRecette = new Recette(recette3);

        System.out.println(pizzaPepperoniRecette.toString());
        System.out.println(pizzaAllDressedRecette.toString());
        System.out.println(pizzaVegeRecette.toString()+"\n");

        System.out.println("--------Association recette et plat--------");

        pizzaPepperoni.setRecette(pizzaPepperoniRecette);
        pizzaAllDressed.setRecette(pizzaAllDressedRecette);
        pizzaVege.setRecette(pizzaVegeRecette);

        System.out.println(pizzaPepperoni.toString() + "\n");

        System.out.println("--------Mettre les plats au menu---------");

        menu.ajoute(pizzaPepperoni);
        menu.ajoute(pizzaAllDressed);
        menu.ajoute(pizzaVege);

        System.out.println(menu.toString() + "\n");

        System.out.println("--------Generer un client--------");

        Client Raphael = new Client(21, "Raphael <3", "1234 5678 8888 2222");
        System.out.println(Raphael.toString() + "\n");

        System.out.println("--------Changer de position dans le menu--------");

        menu.positionSuivante();
        System.out.println(menu.toString() + "\n");

        System.out.println("--------Selection plat--------");

        PlatChoisi delicieusePizza = new PlatChoisi(pizzaPepperoni, 1);

        System.out.println(delicieusePizza.toString() + "\n");

        System.out.println("--------Cuisiner le plat selectionne--------");

        Bozzo.cuisiner(delicieusePizza);

        System.out.println("Etat du plat" + delicieusePizza.getState() + "\n\n");

        System.out.println("------------FIN DE L ITERATION-------------");
    }
}
