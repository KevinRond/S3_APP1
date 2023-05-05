package menufact;

import menufact.plats.PlatChoisi;

public class Chef {
    private String nom;
    private static Chef instance = null;
    private Chef(String nom){this.nom = nom;}
    public Chef getInstance(String nom){
        if (instance == null){
            instance = new Chef(nom);
        }
        return instance;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){this.nom = nom;}
    public PlatChoisi cuisiner(PlatChoisi plat){
        return plat;
    }
    private void verifierIngredient(PlatChoisi plat){

    }
    private void preparer(PlatChoisi plat){

    }
    private PlatChoisi servir(PlatChoisi plat){return plat;}
    @Override
    public String toString(){return "";}
}
