package tests;

import ingredients.Fruit;
import ingredients.Ingredient;
import ingredients.etat.etatIngredient;
import ingredients.etat.etatIngredientLiquide;
import ingredients.etat.etatIngredientSolide;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Recette;
//import menufact.plats.builder.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ingredients.TypeIngredient.FRUIT;
import static ingredients.TypeIngredient.LEGUME;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


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

class ClientTest {

    @BeforeAll
    public static void affichage(){
        System.out.println("-----DEBUT DES TESTS DE LA CLASSE CLIENT-----\n");
    }

    private Client client = new Client(120, "Alex Pourris", "5258 6492 5482 9734");

    ClientTest() throws FactureException {
    }

    @Test
    void getIdClient() {
        System.out.println("Debut du test de getIdClient:");
        System.out.println("Resultat attendu: 120");
        System.out.println("Resultat obtenu: " + client.getIdClient());
        assertEquals(120, client.getIdClient(), "Le test a echoue");
        System.out.println("Le test est un succes\n");
    }

    @Test
    void setIdClient() throws FactureException {
        System.out.println("Debut du test 1 de setIdClient:");
        System.out.println("Resultat attendu: 100");
        client.setIdClient(100);
        System.out.println("Resultat obtenu: " + client.getIdClient());
        assertEquals(100, client.getIdClient(), "Le test a echoue");
        System.out.println("Le test est un succes\n");

        System.out.println("Debut du test 2 de setIdClient:");
        System.out.println("Resultat attendu: 100");
        System.out.println("Resultat obtenu: " + client.getIdClient());
        assertThrows(FactureException.class, () -> {
            client.setIdClient(-5);
        }, "Le test a echoue");
        System.out.println("Le test est un succes\n");
    }

    @Test
    void getNom() {
        System.out.println("Debut du test de getNom:");
        System.out.println("Resultat attendu: Alex Pourris");
        System.out.println("Resultat obtenu: " + client.getNom());
        assertEquals("Alex Pourris", client.getNom(), "Le test a echoue");
        System.out.println("Le test est un succes\n");
    }

    @Test
    void setNom() {
        System.out.println("Debut du test de setNom:");
        System.out.println("Resultat attendu: Ou est Bozzo");
        client.setNom("Ou est Bozzo");
        System.out.println("Resultat obtenu: " + client.getNom());
        assertEquals("Ou est Bozzo", client.getNom(), "Le test a echoue");
        System.out.println("Le test est un succes\n");
    }

    @Test
    void getNumeroCarteCredit() {
        System.out.println("Debut du test de getNumeroCarteCredit:");
        System.out.println("Resultat attendu: 5258 6492 5482 9734");
        System.out.println("Resultat obtenu: " + client.getNumeroCarteCredit());
        assertEquals("5258 6492 5482 9734", client.getNumeroCarteCredit(), "Le test a echoue");
        System.out.println("Le test est un succes\n");
    }

    @Test
    void setNumeroCarteCredit() throws FactureException {
        System.out.println("Debut du test 1 de setNumeroCarteCredit:");
        System.out.println("Resultat attendu: 5258 9375 6426 5627");
        client.setNumeroCarteCredit("5258 9375 6426 5627");
        System.out.println("Resultat obtenu: " + client.getNumeroCarteCredit());
        assertEquals("5258 9375 6426 5627", client.getNumeroCarteCredit(), "Le test a echoue");
        System.out.println("Le test est un succes\n");

        System.out.println("Debut du test 2 de setNumeroCarteCredit:");
        System.out.println("Resultat attendu: 5258 9375 6426 5627");
        System.out.println("Resultat obtenu: " + client.getNumeroCarteCredit());
        assertThrows(FactureException.class, () -> {
            client.setNumeroCarteCredit(null);
        }, "Le test a echoue");
        System.out.println("Le test est un succes \n");
    }

    @Test
    void testToString() {
        System.out.println("Debut du test de toString:");
        System.out.println("Resultat attendu: menufact.Client{idClient=100, nom='Alex Pourris', numeroCarteCredit='5258 6492 5482 9734'}");
        System.out.println("Resultat obtenu: " + client.toString());
        assertEquals("menufact.Client{idClient=120, nom='Alex Pourris', numeroCarteCredit='5258 6492 5482 9734'}", client.toString(), "Le test a echoue");
        System.out.println("Le test est un succes\n");
    }

    @AfterAll
    public static void afficheFin(){
        System.out.println("-----FIN DES TESTS DE LA CLASSE CLIENT-----\n\n");
    }
}

class ChefTest {

    Chef chantallle;
    Inventaire frigidaire;

    Ingredient pain;
    Ingredient saucisse;
    Ingredient reliche;
    Ingredient moutarde;

    Recette hotDogRecette;
    PlatAuMenu hotDogMenu;
    PlatChoisi hotDog;
    PlatChoisi hotDogVide;

    @BeforeAll
    public static void affichage(){
        System.out.println("-----DEBUT DES TESTS DE LA CLASSE CHEF-----\n");
    }

    @Test
    void getInstance() {
        chantallle = Chef.getInstance("Chantallle");
        chantallle = Chef.getInstance("Raph Sleep");
        assertEquals("Chantallle", chantallle.getNom());
    }

    @Test
    void getNom() {
        chantallle = Chef.getInstance("Chantallle");
        assertEquals("Chantallle", chantallle.getNom());
    }

    @Test
    void setNom() {
        chantallle = Chef.getInstance("Chantallle");
        chantallle.setNom("Raph Sleep");
        assertEquals("Raph Sleep", chantallle.getNom());
    }

    @Test
    void cuisiner() {

    }

    @Test
    void testToString() {
        chantallle = Chef.getInstance("Chantallle");
        assertEquals("Chef: {Nom: Chantallle}", chantallle.toString());
    }
}

class MenuTest {

    @Test
    void ajoute() {
    }

    @Test
    void position() {
    }

    @Test
    void platCourant() {
    }

    @Test
    void positionSuivante() {
    }

    @Test
    void positionPrecedente() {
    }

    @Test
    void testToString() {
        Chef chantallle = Chef.getInstance("Chantallle");
        assertEquals("\"menufact.Menu{description= HotDog, courant= courant, plat= plat}", chantallle.toString());
    }
}