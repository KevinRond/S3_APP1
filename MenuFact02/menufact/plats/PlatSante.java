package menufact.plats;

import menufact.plats.PlatAuMenu;
import menufact.plats.exceptions.PlatException;

public class PlatSante extends PlatAuMenu implements InterfacePlat {
    private double kcal;
    private double chol;
    private double gras;

    public PlatSante(int code, String description, double prix, double kcal, double chol, double gras) throws PlatException {
        super(code, description, prix);
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

    public double getKcal() {
        return kcal;
    }
    public void setKcal(double Kcal){
        this.kcal=Kcal;
    }

    public double getChol() {
        return chol;
    }
    public void setChol(double Chol){
        this.chol=Chol;
    }

    public double getGras() {
        return gras;
    }
    public void setGras(double Gras){
        this.gras=Gras;
    }
}
