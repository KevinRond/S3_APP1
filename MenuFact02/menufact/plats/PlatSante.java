package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;

public class PlatSante extends PlatAuMenu {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) throws PlatException {
        super(code, description, prix);
        if (kcal < 0 || chol < 0 || gras < 0){
            throw new PlatException("Kcal, chol et gras ne peuvent etre des valeurs negatives");
        }
        this.kcal = kcal;
        this.chol = chol;
        this.gras = gras;
    }

    public PlatSante() {
    }

    @Override
    public String toString() {
        return "menufact.plats.PlatSante{" +
                "kcal=" + kcal +
                ", chol=" + chol +
                ", gras=" + gras +
                "} " + super.toString();
    }

    public double getKcal(){
        return kcal;
    }
    public void setKcal(double Kcal) throws PlatException {
        if (Kcal < 0){
            throw new PlatException("kcal ne peut pas etre negatif.");
        }
        this.kcal=Kcal;
    }

    public double getChol(){
        return chol;
    }
    public void setChol(double Chol) throws PlatException {
        if (Chol < 0){
            throw new PlatException("Chol ne peut pas etre negatif.");
        }
        this.chol=Chol;
    }

    public double getGras() {
        return gras;
    }
    public void setGras(double Gras) throws PlatException {
        if (Gras < 0){
            throw new PlatException("Gras ne peut pas etre negatif.");
        }
        this.gras=Gras;
    }
}
