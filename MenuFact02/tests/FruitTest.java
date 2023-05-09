package tests;

import ingredients.*;
import ingredients.etat.etatIngredient;
import ingredients.etat.etatIngredientLiquide;
import ingredients.etat.etatIngredientSolide;
import ingredients.exceptions.IngredientException;
import ingredients.factory.ConcreteCreatorFruit;
import ingredients.factory.FactoryCreatorIngredient;
import inventaire.Inventaire;
import menufact.Chef;
import menufact.Client;
import menufact.exceptions.MenuException;
import menufact.facture.exceptions.FactureException;
import menufact.plats.*;
import menufact.Menu;
import menufact.builder.*;
//import menufact.plats.builder.*;
import menufact.plats.exceptions.PlatException;
import menufact.plats.state.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;

import static ingredients.TypeIngredient.*;
import static org.junit.jupiter.api.Assertions.*;

class etatIngredientTest {

    @BeforeEach
    void setUp(){
    }
    @Test
    void getQuantity() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(5);
        assertEquals(5, solide.getQuantity());
    }
    @Test
    void setQuantity() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(5);
        solide.setQuantity(10);
        assertEquals(10, solide.getQuantity());
    }
    @Test
    void getEtat() throws IngredientException {
        etatIngredient solide = new etatIngredientSolide(5);
        assertEquals("Solide", solide.getEtat());
        etatIngredient liquide = new etatIngredientLiquide(5);
        assertEquals("Liquide", liquide.getEtat());
    }
    @Test
    void setNegQuantity(){
        assertThrows(IngredientException.class, () -> {
            etatIngredient solide = new etatIngredientSolide(-5);
        });
    }
}
class FruitTest {

    @BeforeEach
    void setUp() {

    }

    @Test
    void getNom() throws IngredientException {
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient fraise = factoryCreatorIngredient.create("fraise", solide);
        assertEquals("fraise", fraise.getNom());
    }

    @Test
    void setNom() throws IngredientException {
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient fraise = factoryCreatorIngredient.create("fraise", solide);
        assertEquals("fraise", fraise.getNom());
    }

    @Test
    void getDescription() throws IngredientException {
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient fraise = factoryCreatorIngredient.create("fraise", solide);
        fraise.setDescription("Une delicieuse fraise");
        assertEquals("Une delicieuse fraise", fraise.getDescription());
    }

    @Test
    void setDescription() throws IngredientException {
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient fraise = factoryCreatorIngredient.create("fraise", solide);
        fraise.setDescription("Une delicieuse fraise");
        assertEquals("Une delicieuse fraise", fraise.getDescription());
    }

    @Test
    void getQuantity() throws IngredientException {
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient fraise = factoryCreatorIngredient.create("fraise", solide);
        assertEquals(0.5, fraise.getQuantity());
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
    void getTypeIngredient() throws IngredientException {
        FactoryFlyweightIngredient factoryFlyweightIngredient = new FactoryFlyweightIngredient();
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        IntrinsicIngredient fraise = factoryFlyweightIngredient.getIntrinsicIngredient(TypeIngredient.FRUIT, solide);
        assertEquals(FRUIT, fraise.getType());
    }

    @Test
    void setTypeIngredient() throws IngredientException {
        FactoryFlyweightIngredient factoryFlyweightIngredient = new FactoryFlyweightIngredient();
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        IntrinsicIngredient fraise = factoryFlyweightIngredient.getIntrinsicIngredient(TypeIngredient.FRUIT, solide);
        assertEquals(FRUIT, fraise.getType());
    }
    @Test
    void createIngredientNegQuantity(){
        FactoryFlyweightIngredient factoryFlyweightIngredient = new FactoryFlyweightIngredient();
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        assertThrows(IngredientException.class, () -> {
            IntrinsicIngredient fraise = factoryFlyweightIngredient.getIntrinsicIngredient(TypeIngredient.FRUIT, new etatIngredientSolide(-10));
        });
    }

    @Test
    void testToString() throws IngredientException {
        FactoryCreatorIngredient factoryCreatorIngredient = new ConcreteCreatorFruit();
        etatIngredient solide = new etatIngredientSolide(0.5);
        Ingredient fraise = factoryCreatorIngredient.create("fraise", solide);
        System.out.println(fraise);
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
    void testToString() {
        chantallle = Chef.getInstance("Chantallle");
        assertEquals("Chef: {Nom: Chantallle}", chantallle.toString());
    }
}

class MenuTest {

    Menu menu;
    @Test
    void getInstance() throws MenuException, PlatException {
        menu = Menu.getInstance();
        PlatAuMenu soupe = new PlatAuMenu(4, "soupe de schtroumpf", 0);
        menu.ajoute(soupe);

        Menu menu1 = Menu.getInstance();
        PlatAuMenu boeuf = new PlatAuMenu(2, "boeuf strogonoff", 430);
        menu.ajoute(boeuf);

        assertEquals(menu, menu1);
    }

    @Test
    void setDescription() {
        menu = Menu.getInstance();
        menu.setDescription("T pourris");
        assertEquals("T pourris", menu.getDescription());
        menu.setDescription("Alex y pu");
        assertEquals("Alex y pu", menu.getDescription());
    }

    @Test
    void getDescription() {
        menu = Menu.getInstance();
        menu.setDescription("T pourris");
        assertEquals("T pourris", menu.getDescription());
    }

    @Test
    void ajoute() throws MenuException, PlatException {
        menu = Menu.getInstance();
        PlatAuMenu cuisseDeCanard = new PlatAuMenu(36, "bon avec la sauce secrete", 100);
        menu.ajoute(cuisseDeCanard);
        PlatAuMenu cuisseDeCanard2 = new PlatAuMenu(6, "bon avec la sauce", 10);
        menu.ajoute(cuisseDeCanard2);
        PlatAuMenu cuisseDeCanard3 = new PlatAuMenu(3, "sauce secrete", 1);
        menu.ajoute(cuisseDeCanard3);
        menu.position(3);
        assertEquals(cuisseDeCanard2, menu.platCourant());
        menu.positionSuivante();
        assertEquals(cuisseDeCanard3, menu.platCourant());
        menu.positionPrecedente();
        menu.positionPrecedente();
        assertEquals(cuisseDeCanard, menu.platCourant());
    }

}
class InventaireTest {
    Inventaire inventaire;
    Recette recette;

    InventaireTest() throws IngredientException {
    }

    @BeforeEach
    void setUp() {
        inventaire = Inventaire.getInstance();
    }

    @Test
    void getInstance() {
        inventaire = Inventaire.getInstance();
        assertEquals(inventaire, Inventaire.getInstance());
    }

    @Test
    void ajouterIngredient() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        assertEquals("fraise", inventaire.getIngredient("fraise").getNom());
        Inventaire.clear();
    }
    @Test
    void ajouterIngredientQuantiteNegative() throws IngredientException {
        assertThrows(IngredientException.class, ()->{
            inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(-2), "fraise");
        });
    }

    @Test
    void getIngredient() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        assertEquals("fraise", inventaire.getIngredient("fraise").getNom());
        assertEquals(FRUIT, inventaire.getIngredient("fraise").getTypeIngredient());
        Inventaire.clear();
    }

    @Test
    void getIngredientQuantity() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        assertEquals(10, inventaire.getIngredientQuantity("fraise"));
    }

    @Test
    void getQuantityInCongelateur() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "orange");
        inventaire.ajouterIngredient(VIANDE, new etatIngredientSolide(10), "viande");
        inventaire.ajouterIngredient(LAITIER, new etatIngredientSolide(10), "lait");
        assertEquals(4, inventaire.getQuantityInCongelateur());
    }

    @Test
    void utiliserIngredients() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "orange");
        inventaire.ajouterIngredient(VIANDE, new etatIngredientSolide(10), "viande");
        inventaire.ajouterIngredient(LAITIER, new etatIngredientSolide(10), "lait");

        ArrayList<Ingredient> listIngredient = new ArrayList<Ingredient>();
        listIngredient.add(inventaire.getIngredient("fraise"));
        listIngredient.add(inventaire.getIngredient("orange"));
        listIngredient.add(inventaire.getIngredient("viande"));
        listIngredient.add(inventaire.getIngredient("lait"));
        recette = new Recette(listIngredient);
        assertEquals(10, inventaire.getIngredientQuantity("fraise"));
        inventaire.utiliserIngredients(recette, 1, 1);
        assertEquals(0, inventaire.getIngredientQuantity("fraise"));
        Inventaire.clear();
    }
    @Test
    void utiliserIngredientRecetteNull() {
        assertThrows(IngredientException.class, () -> {
            inventaire.utiliserIngredients(recette, 1, 1);
        });
    }
    @Test
    void utiliserIngredientQuantitePlatNegative() {
        ArrayList<Ingredient> listIngredient = new ArrayList<Ingredient>();
        listIngredient.add(inventaire.getIngredient("fraise"));
        listIngredient.add(inventaire.getIngredient("orange"));
        listIngredient.add(inventaire.getIngredient("viande"));
        listIngredient.add(inventaire.getIngredient("lait"));
        recette = new Recette(listIngredient);
        assertThrows(IngredientException.class, () -> {
            inventaire.utiliserIngredients(recette, -1, 1);
        });
    }
    @Test
    void utiliserIngredientProportionTropPetite() {
        ArrayList<Ingredient> listIngredient = new ArrayList<Ingredient>();
        listIngredient.add(inventaire.getIngredient("fraise"));
        listIngredient.add(inventaire.getIngredient("orange"));
        listIngredient.add(inventaire.getIngredient("viande"));
        listIngredient.add(inventaire.getIngredient("lait"));
        recette = new Recette(listIngredient);
        assertThrows(IngredientException.class, () -> {
            inventaire.utiliserIngredients(recette, 1, -1);
        });
    }
    @Test
    void utiliserIngredientProportionTropGrande() {
        ArrayList<Ingredient> listIngredient = new ArrayList<Ingredient>();
        listIngredient.add(inventaire.getIngredient("fraise"));
        listIngredient.add(inventaire.getIngredient("orange"));
        listIngredient.add(inventaire.getIngredient("viande"));
        listIngredient.add(inventaire.getIngredient("lait"));
        recette = new Recette(listIngredient);
        assertThrows(IngredientException.class, () -> {
            inventaire.utiliserIngredients(recette, 1, 1.1);
        });
    }

    @Test
    void clear() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "orange");
        inventaire.ajouterIngredient(VIANDE, new etatIngredientSolide(10), "viande");
        inventaire.ajouterIngredient(LAITIER, new etatIngredientSolide(10), "lait");
        assertEquals(4, inventaire.getQuantityInCongelateur());
        Inventaire.clear();
        assertEquals(0, inventaire.getQuantityInCongelateur());
    }

    @Test
    void getSize() {
    }

    @Test
    void setSize() {
    }

    @Test
    void testToString() throws IngredientException {
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "fraise");
        inventaire.ajouterIngredient(FRUIT, new etatIngredientSolide(10), "orange");
        inventaire.ajouterIngredient(VIANDE, new etatIngredientSolide(10), "viande");
        inventaire.ajouterIngredient(LAITIER, new etatIngredientSolide(10), "lait");
        //System.out.println(inventaire);
        String expected = "Inventaire={orange=Ingredient{Type=FRUIT, Nom=orange,  Etat=Solide: Qty = 10.0, Quantite=10.0}\n" +
                ", viande=Ingredient{Type=VIANDE, Nom=viande,  Etat=Solide: Qty = 10.0, Quantite=10.0}\n" +
                ", lait=Ingredient{Type=LAITIER, Nom=lait,  Etat=Solide: Qty = 10.0, Quantite=10.0}\n" +
                ", fraise=Ingredient{Type=FRUIT, Nom=fraise,  Etat=Solide: Qty = 10.0, Quantite=10.0}\n" +
                "}";
        assertEquals(expected, inventaire.toString());
    }
}

class PlatEnfantTest {

    PlatEnfant demiSteak = new PlatEnfant(5, "Steak coupe en deux", 15, 0.5);

    PlatEnfantTest() throws PlatException {
    }

    @Test
    void getProportion() {
        assertEquals(0.5, demiSteak.getProportion());
    }

    @Test
    void setProportion() throws PlatException {
        demiSteak.setProportion(0.7);
        assertEquals(0.7, demiSteak.getProportion());
        assertThrows(PlatException.class, () -> {
            demiSteak.setProportion(-0.4);
        });
        assertThrows(PlatException.class, () -> {
            demiSteak.setProportion(1.4);
        });
    }
}

class PlatSanteTest {

    PlatSante salade = new PlatSante(4, "Salade a l'herbe", 7, 6, 3, 2);

    PlatSanteTest() throws PlatException {
    }

    @Test
    void getTests() {
        assertEquals(6, salade.getKcal());
        assertEquals(3, salade.getChol());
        assertEquals(2, salade.getGras());
    }

    @Test
    void setTests() throws PlatException {
        salade.setKcal(4);
        salade.setChol(2);
        salade.setGras(1);
        assertEquals(4, salade.getKcal());
        assertEquals(2, salade.getChol());
        assertEquals(1, salade.getGras());
        assertThrows(PlatException.class, () -> {
            salade.setKcal(-4);
        });
        assertThrows(PlatException.class, () -> {
            salade.setChol(-2);
        });
        assertThrows(PlatException.class, () -> {
            salade.setGras(-1);
        });
    }
}

class PlatChoisiTest {

    PlatAuMenu yoyo = new PlatAuMenu(69, "Sup", 420);

    PlatChoisiTest() throws PlatException {
    }

    PlatChoisi fgf = new PlatChoisi(yoyo, 1);
    StateCommande stateCommande = new StateCommande();

    @Test
    void getQuantite() {
        assertEquals(1, fgf.getQuantite());
    }

    @Test
    void setQuantite() throws PlatException {
        fgf.setQuantite(2);
        assertEquals(2, fgf.getQuantite());
        assertThrows(PlatException.class, () -> {
            fgf.setQuantite(-1);
        });
    }

    @Test
    void getPlat() {
        assertEquals(yoyo, fgf.getPlat());
    }

    @Test
    void getState() throws PlatException {
        assertNull(fgf.getState());
    }

    @Test
    void setState() throws PlatException {
        fgf.setState(stateCommande);
        assertEquals(stateCommande, fgf.getState());
    }

    StateEnPreparation stateEnPreparation = new StateEnPreparation();

    @Test
    void changeState() throws PlatException {
        fgf.setState(stateEnPreparation);
        assertEquals(stateEnPreparation, fgf.getState());
    }
}

class BuilderPlatTest {

    private BuilderPlat builderPlat;

    public BuilderPlatTest() throws IngredientException {
    }

    @BeforeEach
    public void setUp() {
        builderPlat = new BuilderPlat();
    }

    @Test
    public void testBuildDescription() {
        String description = "Poulet grillé";
        PlatAuMenu plat = builderPlat.buildDescription(description).getPlatFinal();
        assertEquals(description, plat.getDescription());
    }

    @Test
    public void testBuildPrix() {
        double prix = 15.99;
        PlatAuMenu plat = builderPlat.buildPrix(prix).getPlatFinal();
        assertEquals(prix, plat.getPrix());
    }

    private Ingredient poulet = new Viande("Poulet", new etatIngredientSolide(100));
    private Ingredient epices = new Epice("Epices", new etatIngredientSolide(10));
    private Ingredient huile = new Viande("Huile", new etatIngredientSolide(5));

    @Test
    public void testBuildRecetteWithArray() throws PlatException {
        Ingredient[] ingredients = new Ingredient[] {poulet, epices, huile};
        Recette recette = new Recette(ingredients);
        PlatAuMenu plat = builderPlat.buildRecette(ingredients).getPlatFinal();
        assertEquals(recette.toString(), plat.getRecette().toString());
    }

    @Test
    public void testBuildRecetteWithObject() throws PlatException {
        Ingredient[] ingredients = new Ingredient[] {poulet, epices, huile};
        Recette recette = new Recette(ingredients);
        PlatAuMenu plat = builderPlat.buildRecette(recette).getPlatFinal();
        assertEquals(recette.toString(), plat.getRecette().toString());
    }

    @Test
    public void testClear() {
        PlatAuMenu plat = builderPlat.buildDescription("Poulet grillé").buildPrix(15.99).clear().getPlatFinal();
        assertEquals(new PlatAuMenu().toString(), plat.toString());
    }
}

class BuilderPlatEnfantTest {

    @Test
    public void testBuildProportion() throws PlatException {
        BuilderPlatEnfant builder = new BuilderPlatEnfant();
        double proportion = 0.5;
        PlatEnfant plat = builder.buildProportion(proportion).getPlatFinal();
        assertEquals(proportion, plat.getProportion());
    }

    @Test
    public void testClear() throws PlatException {
        BuilderPlatEnfant builder = new BuilderPlatEnfant();
        double proportion1 = 0.5;
        double proportion2 = 0.3;
        PlatEnfant plat1 = builder.buildProportion(proportion1).getPlatFinal();
        PlatEnfant plat2 = builder.clear().buildProportion(proportion2).getPlatFinal();
        assertNotEquals(plat1, plat2);
        assertEquals(proportion2, plat2.getProportion());
    }

}

class BuilderPlatSanteTest {

    private Ingredient poulet = new Viande("Poulet", new etatIngredientSolide(100));
    private Ingredient riz = new Legume("Riz", new etatIngredientSolide(50));

    BuilderPlatSanteTest() throws IngredientException {
    }

    @Test
    void testBuildKcal() throws PlatException {
        BuilderPlatSante builder = new BuilderPlatSante();
        double kcal = 500.0;
        builder.buildKcal(kcal);
        PlatSante plat = builder.getPlatFinal();
        assertEquals(kcal, plat.getKcal());
    }

    @Test
    void testBuildChol() throws PlatException {
        BuilderPlatSante builder = new BuilderPlatSante();
        double chol = 30.0;
        builder.buildChol(chol);
        PlatSante plat = builder.getPlatFinal();
        assertEquals(chol, plat.getChol());
    }

    @Test
    void testBuildGras() throws PlatException {
        BuilderPlatSante builder = new BuilderPlatSante();
        double gras = 10.0;
        builder.buildGras(gras);
        PlatSante plat = builder.getPlatFinal();
        assertEquals(gras, plat.getGras());
    }

    @Test
    void testBuildRecette() throws PlatException {
        BuilderPlatSante builder = new BuilderPlatSante();
        Ingredient[] ingredients = {poulet, riz};
        builder.buildRecette(new Recette(ingredients));
        PlatSante plat = builder.getPlatFinal();
        assertEquals(ingredients.length, plat.getRecette().getIngredients().size());
    }

    @Test
    void testClear() throws PlatException {
        BuilderPlatSante builder = new BuilderPlatSante();
        double kcal = 500.0;
        builder.buildKcal(kcal);
        PlatSante plat1 = builder.getPlatFinal();
        builder.clear();
        PlatSante plat2 = builder.getPlatFinal();
        assertNotEquals(plat1, plat2);
    }
}

class TestIngredient {

    etatIngredient e1 = new etatIngredientLiquide(100.0);
    etatIngredient e2 = new etatIngredientSolide(500.0);
    private Ingredient fraise = new Fruit("Fraise", e1);
    private Ingredient porc = new Viande("Porc", e2);

    TestIngredient() throws IngredientException {
    }

    @Test
    void testEtatIngredientLiquide() throws IngredientException {
        etatIngredientLiquide e = new etatIngredientLiquide(100.0);
        assertEquals(100.0, e.getQuantity(), 0.001);
        e.setQuantity(50.0);
        assertEquals(50.0, e.getQuantity(), 0.001);
        assertThrows(IngredientException.class, () -> e.setQuantity(-50.0));
    }

    @Test
    void testEtatIngredientSolide() throws IngredientException {
        etatIngredientSolide e = new etatIngredientSolide(500.0);
        assertEquals(500.0, e.getQuantity(), 0.001);
        e.setQuantity(250.0);
        assertEquals(250.0, e.getQuantity(), 0.001);
        assertThrows(IngredientException.class, () -> e.setQuantity(-250.0));
    }

    @Test
    void testIngredient() throws IngredientException {
        assertEquals(TypeIngredient.FRUIT, fraise.getTypeIngredient());
        assertEquals("Fraise", fraise.getNom());
        assertEquals(e1, fraise.getEtat());
        assertEquals(VIANDE, porc.getTypeIngredient());
        assertEquals("Porc", porc.getNom());
        assertEquals(e2, porc.getEtat());
    }
}