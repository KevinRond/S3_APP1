package tests;

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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static ingredients.TypeIngredient.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

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
    }
}

class ClientTest {

    private Client client = new Client(120, "Alex Pourris", "5258 6492 5482 9734");

    ClientTest() throws FactureException {
    }

    @Test
    void getIdClient() {
        assertEquals(120, client.getIdClient());
    }

    @Test
    void setIdClient() throws FactureException {
        client.setIdClient(100);
        assertEquals(100, client.getIdClient());

        assertThrows(FactureException.class, () -> {
            client.setIdClient(-5);
        });
    }

    @Test
    void getNom() {
        assertEquals("Alex Pourris", client.getNom());
    }

    @Test
    void setNom() {
        client.setNom("Ou est Bozzo");
        assertEquals("Ou est Bozzo", client.getNom());
    }

    @Test
    void getNumeroCarteCredit() {
        assertEquals("5258 6492 5482 9734", client.getNumeroCarteCredit());
    }

    @Test
    void setNumeroCarteCredit() throws FactureException {
        client.setNumeroCarteCredit("5258 9375 6426 5627");
        assertEquals("5258 9375 6426 5627", client.getNumeroCarteCredit());

        assertThrows(FactureException.class, () -> {
            client.setNumeroCarteCredit(null);
        });
    }

    @Test
    void testToString() {
        assertEquals("menufact.Client{idClient=120, nom='Alex Pourris', numeroCarteCredit='5258 6492 5482 9734'}", client.toString());
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

    Menu menu = Menu.getInstance("delicieux");
    @Test
    void getInstance() throws MenuException, PlatException {
        PlatAuMenu soupe = new PlatAuMenu(4, "soupe de schtroumpf", 0);
        menu.ajoute(soupe);

        Menu menu1 = Menu.getInstance("pourri");
        PlatAuMenu boeuf = new PlatAuMenu(2, "boeuf strogonoff", 430);
        menu.ajoute(boeuf);

        assertEquals(menu, menu1);
    }

    @Test
    void setDescription() {
        menu.setDescription("T pourris");
        assertEquals("T pourris", menu.getDescription());
        menu.setDescription("Alex y pu");
        assertEquals("Alex y pu", menu.getDescription());
    }

    @Test
    void getDescription() {
        menu.setDescription("T pourris");
        assertEquals("T pourris", menu.getDescription());
    }

    @Test
    void ajoute() throws MenuException, PlatException {
        menu = Menu.getInstance("T pourris");
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
        assertEquals(8, inventaire.getQuantityInCongelateur());
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
        String expected = "Inventaire={orange=Ingredient{Type=FRUIT, Nom=orange,  Etat=Solide: Qty = 20.0, Quantite=20.0}\n" +
                ", viande=Ingredient{Type=VIANDE, Nom=viande,  Etat=Solide: Qty = 20.0, Quantite=20.0}\n" +
                ", Saucisse=Ingredient{Type=VIANDE, Nom=Saucisse,  Etat=Solide: Qty = 0.0, Quantite=0.0}\n" +
                ", lait=Ingredient{Type=LAITIER, Nom=lait,  Etat=Solide: Qty = 20.0, Quantite=20.0}\n" +
                ", Pain=Ingredient{Type=FRUIT, Nom=Pain,  Etat=Solide: Qty = 0.0, Quantite=0.0}\n" +
                ", fraise=Ingredient{Type=FRUIT, Nom=fraise,  Etat=Solide: Qty = 20.0, Quantite=20.0}\n" +
                ", Moutarde=Ingredient{Type=FRUIT, Nom=Moutarde,  Etat=LiquideQty = 0.0, Quantite=0.0}\n" +
                ", Reliche=Ingredient{Type=FRUIT, Nom=Reliche,  Etat=LiquideQty = 0.0, Quantite=0.0}\n" +
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

class FactureTest {

    FactureTest() throws FactureException, PlatException, IngredientException {
    }
    Facture model = new Facture("Yoyo");
    FactureView view = new FactureView();
    FactureController controller = new FactureController(model, view);

    private Inventaire frigidaire;
    private Ingredient pain = new Fruit("Pain", new etatIngredientSolide(1));
    private Ingredient saucisse = new Viande("Saucisse", new etatIngredientSolide(2));
    private Ingredient reliche = new Fruit("Reliche", new etatIngredientLiquide(100));
    private Ingredient moutarde = new Fruit("Moutarde", new etatIngredientLiquide(200));

    private Recette hotDogRecette = new Recette(new Ingredient[]{pain, saucisse, reliche, moutarde});
    private PlatAuMenu hotDogMenu = new PlatAuMenu(68, "hot dog reliche, moutarde", 4);
    private PlatChoisi hotDog = new PlatChoisi(hotDogMenu, 1);
    private PlatChoisi hotDogVide = new PlatChoisi(hotDogMenu, 2);

    Facture facture = new Facture("Facture test");

    PlatAuMenu plat1 = new PlatAuMenu(1, "Poutine", 5.50);
    PlatAuMenu plat2 = new PlatAuMenu(2, "Pizza", 12.00);

    PlatChoisi platChoisi1 = new PlatChoisi(plat1, 2);
    PlatChoisi platChoisi2 = new PlatChoisi(plat2, 1);

    ArrayList<PlatChoisi> platsChoisis = new ArrayList<PlatChoisi>();

    @Test
    public void testSousTotal() throws Exception {
        platsChoisis.add(platChoisi1);
        platsChoisis.add(platChoisi2);

        view.setPlatchoisi(platsChoisis);
        facture.setPlatchoisi(platsChoisis);

        double expected = 23.00;
        double actual = facture.sousTotal();

        assertEquals(expected, actual, 0.01);
    }

    @Test
    public void testTotal() throws Exception {
        platsChoisis.add(platChoisi1);
        platsChoisis.add(platChoisi2);

        view.setPlatchoisi(platsChoisis);
        facture.setPlatchoisi(platsChoisis);

        double expected = 26.335;
        double actual = facture.total();

        assertEquals(expected, actual, 0.01);
    }

    @Test
    void associerClient() throws FactureException {
        Facture facture = new Facture("Ca va couter cher");
        Client boClient = new Client(420, "Alex le bg", "4782 2834 5832 1290");
        facture.associerClient(boClient);
        assertEquals(boClient, facture.getClient());
    }
    @Test
    void ouvrirTest() throws FactureException{
        assertThrows(FactureException.class, ()->{
            facture.ouvrir();
        });
    }

    @Test
    void fermerTest() throws FactureException {
        facture.fermer();
        assertTrue(facture.getEtat() instanceof FactureEtatFermee);
    }

    @Test
    void payerTest() throws FactureException{
        facture.payer();
        assertTrue(facture.getEtat() instanceof FactureEtatPayee);
    }

}

class TestFactureController{
    private Inventaire inventaire;
    ArrayList<Ingredient> ingredients = new ArrayList<>();
    IntrinsicIngredient gangDePoulet;
    Ingredient poulet;
    Recette recette;
    PlatAuMenu platAuMenu;
    PlatChoisi platChoisi;
    Facture facture;
    FactureView view;
    FactureController controller;
    Client Kevin;
    Chef Bozzo;

    @BeforeEach
    void setUp() throws IngredientException, PlatException, FactureException {
        gangDePoulet=new IntrinsicIngredient(TypeIngredient.VIANDE, new etatIngredientSolide(5));
        poulet= ConcreteCreatorViande.create(gangDePoulet, "poulet");

        ingredients= new ArrayList<>();
        ingredients.add(poulet);

        inventaire = Inventaire.getInstance();
        inventaire.ajouterIngredient(TypeIngredient.FRUIT, new etatIngredientSolide(50), "poulet");



        recette= new Recette(ingredients);

        platAuMenu= new PlatAuMenu(1, "menoum plat aux fruits", 10.0);
        platAuMenu.setRecette(recette);

        platChoisi= new PlatChoisi(platAuMenu, 2);

        facture = new Facture("Ma facture");
        view= new FactureView();
        controller= new FactureController(facture,view);

        Kevin= new Client(01,"Snitch", "abcdef");
        Bozzo= Chef.getInstance("gustau");
    }
    @Test
    void afficheFacture() throws PlatException, IngredientException, FactureException {
        controller.associerClient(Kevin);
        controller.observer(Bozzo);

        String expectedString= "menufact.facture.Facture{date="+ facture.getDate() + ", description='Ma facture', etat=Facture etat ouverte, platchoisi=[], courant=-1, client=menufact.Client{idClient=1, nom='Snitch', numeroCarteCredit='abcdef'}, TPS=0.05, TVQ=0.095}";
        assertEquals(expectedString, controller.afficheFacture());


        String expectedString2= "menufact.facture.Facture{date="+ facture.getDate() + ", description='Ma facture', etat=Facture etat ouverte, platchoisi=[menufact.plats.PlatChoisi{quantite=2, plat=menufact.plats.PlatAuMenu{code=1, description='menoum plat aux fruits', prix=10.0}\n}], courant=-1, client=menufact.Client{idClient=1, nom='Snitch', numeroCarteCredit='abcdef'}, TPS=0.05, TVQ=0.095}";
        controller.ajoutePlat(platChoisi);
        String actual = view.toString();
        assertEquals(expectedString2, actual);
    }

    @Test
    void genereFacture() throws IngredientException, PlatException, MenuException, FactureException {
        controller.associerClient(Kevin);
        controller.observer(Bozzo);

        controller.ajoutePlat(platChoisi);
        controller.payer();
        String expectedString="Facture generee.\n" +
                "Date:"+ facture.getDate()+ "\n" +
                "Description: Ma facture\n" +
                "Client:Snitch\n" +
                "Les plats commandes:\n" +
                "Seq   Plat         Prix   Quantite\n" +
                "1     menoum plat aux fruits  10.0      2\n" +
                "          TPS:               1.0\n" +
                "          TVQ:               1.9\n" +
                "          Le total est de:   22.9\n";
        assertEquals(expectedString,controller.genereFacture());


    }

    @Test
    void associerClient(){
        controller.associerClient(Kevin);
        assertEquals(Kevin,facture.getClient());
    }

    @Test
    void observer(){
        controller.observer(Bozzo);
        assertEquals(Bozzo,facture.getChef());

    }

    @Test
    void payer() throws FactureException {
        controller.payer();
        assertTrue(facture.getEtat() instanceof FactureEtatPayee);
    }
    @Test
    void fermer() throws FactureException {
        controller.fermer();
        assertTrue(facture.getEtat() instanceof FactureEtatFermee);
    }

    @Test
    void ouvrir() throws FactureException {
        controller.fermer();
        controller.ouvrir();
        assertTrue(facture.getEtat() instanceof FactureEtatOuverte);
    }

    @Test
    void ajoutePlat() throws PlatException, FactureException {
        controller.observer(Bozzo);
        controller.ajoutePlat(platChoisi);
        ArrayList<PlatChoisi> expectedPlats = new ArrayList<>();
        expectedPlats.add(platChoisi);
        assertEquals(expectedPlats, facture.getPlatsChoisis() );

    }

    @Test
    void getSousTotal() throws PlatException, FactureException {
        controller.observer(Bozzo);
        controller.ajoutePlat(platChoisi);
        double expectedSousTotal= 20.0;
        assertEquals(expectedSousTotal, controller.getSousTotal() );

    }

    @Test
    void getTps() throws PlatException, FactureException {
        controller.observer(Bozzo);
        controller.ajoutePlat(platChoisi);
        double expectedTps= 20.0*0.05;
        assertEquals(expectedTps, controller.getTps() );

    }

    @Test
    void getTvq() throws PlatException, FactureException {
        controller.observer(Bozzo);
        controller.ajoutePlat(platChoisi);
        double expectedTvq= 20.0*0.095;
        assertEquals(expectedTvq, controller.getTvq());
    }

    void getTotal() throws PlatException, FactureException {
        controller.observer(Bozzo);
        controller.ajoutePlat(platChoisi);
        double expectedTotal= 20.0*0.095+20.0*0.05+20.0;
        assertEquals(expectedTotal,controller.getTotal());

    }
}

class TestFactureEtatFermee{
    @Test
    public void testChangerEtat() {
        FactureEtatFermee etatFermee = new FactureEtatFermee();

        // Test avec un état valide pour changer en FactureEtatPayee
        boolean expected = true;
        boolean actual = etatFermee.changerEtat(new FactureEtatPayee());
        assertEquals(expected, actual);

        // Test avec un état valide pour changer en FactureEtatOuverte
        expected = true;
        actual = etatFermee.changerEtat(new FactureEtatOuverte());
        assertEquals(expected, actual);

        // Test avec un état invalide pour changer en FactureEtatFermee
        expected = false;
        actual = etatFermee.changerEtat(new FactureEtatFermee());
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        FactureEtatFermee etatFermee = new FactureEtatFermee();

        // Test du contenu de la chaîne de caractères renvoyée
        String expected = "Facture etat fermee";
        String actual = etatFermee.toString();
        assertEquals(expected, actual);
    }
}

class TestFactureEtatOuverte{
    @Test
    public void testChangerEtat() {
        FactureEtatOuverte etatOuverte = new FactureEtatOuverte();

        // Test avec un état valide pour changer en FactureEtatFermee
        boolean expected = true;
        boolean actual = etatOuverte.changerEtat(new FactureEtatFermee());
        assertEquals(expected, actual);

        // Test avec un état valide pour changer en FactureEtatPayee
        expected = true;
        actual = etatOuverte.changerEtat(new FactureEtatPayee());
        assertEquals(expected, actual);

        // Test avec un état invalide pour changer en FactureEtatOuverte
        expected = false;
        actual = etatOuverte.changerEtat(new FactureEtatOuverte());
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        FactureEtatOuverte etatOuverte = new FactureEtatOuverte();

        // Test du contenu de la chaîne de caractères renvoyée
        String expected = "Facture etat ouverte";
        String actual = etatOuverte.toString();
        assertEquals(expected, actual);
    }
}

class TestFactureEtatPayee{
    @Test
    public void testChangerEtat() {
        FactureEtatPayee etatPayee = new FactureEtatPayee();

        // Test que l'état ne peut pas être changé en FactureEtatOuverte
        boolean expected = false;
        boolean actual = etatPayee.changerEtat(new FactureEtatOuverte());
        assertEquals(expected, actual);

        // Test que l'état ne peut pas être changé en FactureEtatFermee
        expected = false;
        actual = etatPayee.changerEtat(new FactureEtatFermee());
        assertEquals(expected, actual);

        // Test que l'état ne peut pas être changé en FactureEtatPayee
        expected = false;
        actual = etatPayee.changerEtat(new FactureEtatPayee());
        assertEquals(expected, actual);
    }

    @Test
    public void testToString() {
        FactureEtatPayee etatPayee = new FactureEtatPayee();

        // Test du contenu de la chaîne de caractères renvoyée
        String expected = "Facture etat payee";
        String actual = etatPayee.toString();
        assertEquals(expected, actual);
    }
}