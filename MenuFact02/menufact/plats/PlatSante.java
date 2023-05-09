package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;

/**
 * Classe de PlatSante
 */
public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    /**
     * constructeur de PlatSante
     * @param code
     * @param description
     * @param prix
     * @param kcal
     * @param chol
     * @param gras
     * @throws PlatException
     */
    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) throws PlatException {
        super(code, description, prix);
        if (kcal < 0 || chol < 0 || gras < 0){
            throw new PlatException("Kcal, chol et gras ne peuvent etre des valeurs negatives");
        }
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    /**
     * Constructeur vide
     */
    public PlatSante() {
    }

    /**
     * Retourne de l'information sur le plat
     * @return
     */
    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    /**
     * Retourne le nombre de kilocalories
     * @return
     */
    public double getKcal(){
        return kcal;
    }

    /**
     * Indique un nouveau nombre de kilocalories pour un plat
     * @param Kcal
     * @throws PlatException
     */
    public void setKcal(double Kcal) throws PlatException {
        if (Kcal < 0){
            throw new PlatException("kcal ne peut pas etre negatif.");
        }
        this.kcal=Kcal;
    }

    /**
     * Retourne la quantité de cholestérol
     * @return
     */
    public double getChol(){
        return chol;
    }

    /**
     * Change la quantité de cholestérol
     * @param Chol
     * @throws PlatException
     */
    public void setChol(double Chol) throws PlatException {
        if (Chol < 0){
            throw new PlatException("Chol ne peut pas etre negatif.");
        }
        this.chol=Chol;
    }

    /**
     * Retourne la quantite de gras du plat
     * @return
     */
    public double getGras() {
        return gras;
    }

    /**
     * Change la quantite de gras d'un plat
     * @param Gras
     * @throws PlatException
     */
    public void setGras(double Gras) throws PlatException {
        if (Gras < 0){
            throw new PlatException("Gras ne peut pas etre negatif.");
        }
        this.gras=Gras;
    }
}
