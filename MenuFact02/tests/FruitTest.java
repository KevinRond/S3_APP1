package tests;

import ingredients.*;
import ingredients.etat.etatIngredient;
import ingredients.etat.etatIngredientLiquide;
import ingredients.etat.etatIngredientSolide;
import ingredients.exceptions.IngredientException;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.Client;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.plats.Recette;
import inventaire.Inventaire;
//import menufact.plats.builder.*;
import menufact.plats.exceptions.PlatException;
import menufact.plats.state.StateServi;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static ingredients.TypeIngredient.FRUIT;
import static ingredients.TypeIngredient.LEGUME;
import static org.junit.jupiter.api.Assertions.*;


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
    void getQuantity() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient orange = new Fruit("orange",solide, 20.0);
        assertEquals(20.0, orange.getQuantity());
    }

    @Test
    void setQuantity() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient orange = new Fruit("orange", solide, 20.0);
        orange.setQuantity(10.0);
        assertEquals(10.0, orange.getQuantity());
    }

    @Test
    void getEtat() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient orange = new Fruit("orange", solide, 20.0);
        assertEquals(solide, orange.getEtat());
    }

    @Test
    void setEtat() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(0.5);
        etatIngredient liquide = new etatIngredientLiquide(0.2);
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
    void testToString() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(0.5);
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
    private Inventaire frigidaire;

    private Chef chantallle = Chef.getInstance("Chantallle");
    private Ingredient pain = new Fruit("Pain", new etatIngredientSolide(1));
    private Ingredient saucisse = new Viande("Saucisse", new etatIngredientSolide(2));
    private Ingredient reliche = new Fruit("Reliche", new etatIngredientLiquide(100));
    private Ingredient moutarde = new Fruit("Moutarde", new etatIngredientLiquide(200));

    private Recette hotDogRecette = new Recette(new Ingredient[]{pain, saucisse, reliche, moutarde});
    private PlatAuMenu hotDogMenu = new PlatAuMenu(68, "hot dog reliche, moutarde", 4);
    private PlatChoisi hotDog = new PlatChoisi(hotDogMenu, 1);
    private PlatChoisi hotDogVide = new PlatChoisi(hotDogMenu, 2);

    ChefTest() throws PlatException, IngredientException {
    }

    @BeforeAll
    public static void affichage(){
        System.out.println("-----DEBUT DES TESTS DE LA CLASSE CHEF-----\n");
    }

    @Test
    void getInstance() {
        chantallle = Chef.getInstance("Raph Sleep");
        assertEquals("Chantallle", chantallle.getNom());
    }

    @Test
    void getNom() {
        assertEquals("Chantallle", chantallle.getNom());
    }

    @Test
    void setNom() {
        chantallle.setNom("Raph Sleep");
        assertEquals("Raph Sleep", chantallle.getNom());
    }

    @Test
    void cuisiner() throws PlatException, IngredientException {
        hotDogMenu.setRecette(hotDogRecette);
        frigidaire = Inventaire.getInstance();
        frigidaire.ajouterIngredient(new Ingredient[]{pain, saucisse, reliche, moutarde});
        assertThrows(PlatException.class, () -> {
            hotDogMenu = new PlatAuMenu(68, "hot dog reliche, moutarde", -4);
        });
        assertThrows(IngredientException.class, () -> {
            chantallle.cuisiner(hotDogVide);
        });

        chantallle.cuisiner(hotDog);
        assertTrue(hotDog.getState() instanceof StateServi);
    }

    @Test
    void verifierIngredient() {

    }

    @Test
    void preparer() {

    }

    @Test
    void terminer() {

    }

    @Test
    void servir() {

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
        /*Chef chantallle = Chef.getInstance("Chantallle");
        assertEquals("Chef: {Nom: Chantallle}", chantallle.toString());*/
    }
}

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
        etatIngredient solide = new etatIngredientSolide(0.5);
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
        etatIngredient liquide = new etatIngredientSolide(0.5);
        Ingredient tomate = new Fruit("tomate", liquide);
        inventaire1.ajouterIngredient(tomate);
        assertEquals(tomate, inventaire1.getIngredient("tomate"));
        Inventaire.clear();
    }

    @Test
    void getQuantityInCongelateur() throws IngredientException {
        Inventaire inventaire1 = Inventaire.getInstance();
        etatIngredient solide = new etatIngredientSolide(0.5);
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
        etatIngredient solide = new etatIngredientSolide(0.5);
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
        etatIngredient solide = new etatIngredientSolide(0.5);
        etatIngredient liquide = new etatIngredientLiquide(0.2);
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