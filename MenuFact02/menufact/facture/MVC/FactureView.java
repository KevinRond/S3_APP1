package menufact.facture.MVC;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.plats.PlatChoisi;
import menufact.Client;
import menufact.facture.MVC.*;
import menufact.facture.Facture;
import menufact.facture.Etat.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

/**
 * Classe de FactureView
 */
public class FactureView {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi= new ArrayList<>();
    private int courant;
    private Client client;
    private final double TPS= 0.05;
    private final double TVQ=0.095;
    private double total;
    private double tpsPlat;
    private double tvqPlat;

    /**
     *Retourne de l'information sur la facture
     * @return String a afficher
     */
    public String toString() {
        return "menufact.facture.Facture{" +
                "date=" + date +
                ", description='" + description + '\'' +
                ", etat=" + etat +
                ", platchoisi=" + platchoisi +
                ", courant=" + courant +
                ", client=" + client +
                ", TPS=" + TPS +
                ", TVQ=" + TVQ +
                '}';
    }

    /**
     *Fait une facture avec les informations nécessaires
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture() throws MenuException
    {
        if (!(etat instanceof FactureEtatPayee)){
            throw new MenuException("Facture non payee");
        }
        String lesPlats = new String();
        String factureGenere = new String();

        int i =1;


        factureGenere =   "Facture generee.\n" +
                "Date:" + date + "\n" +
                "Description: " + description + "\n" +
                "Client:" + client.getNom() + "\n" +
                "Les plats commandes:" + "\n" + lesPlats;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tpsPlat + "\n";
        factureGenere += "          TVQ:               " + tvqPlat + "\n";
        factureGenere += "          Le total est de:   " + total+ "\n";

        return factureGenere;
    }

    /**
     * Retourne la description
     * @param Description String qui décrit la facture
     */
    public void setDescription(String Description){
        description=Description;
    }

    /**
     * Change l'état
     * @param Etat objet de type FactureEtat
     */
    public void setEtat(FactureEtat Etat){
        etat=Etat;
    }

    /**
     * Met les PlatChoisi dans l'ArrayList
     * @param platchoisi ArrayList de PlatChoisi
     */
    public void setPlatchoisi(ArrayList<PlatChoisi> platchoisi) {
        this.platchoisi = platchoisi;
    }

    /**
     * Change le plat courant
     * @param Courant nombre entier
     */
    public void setCourant(int Courant){
        courant=Courant;
    }

    /**
     * Change le client
     * @param Client objet de la classe Client
     */
    public void setClient(Client Client){
        client=Client;
    }

    /**
     * Change le tps du plat
     * @param tpsplat variable double
     */
    public void setTpsPlat(double tpsplat){
        tpsPlat=tpsplat;
    }

    /**
     * Change la tvq du plat
     * @param tvqplat variable double
     */
    public void setTvqPlat(double tvqplat){
        tvqPlat=tvqplat;
    }

    /**
     * Change le total
     * @param Total variable double
     */
    public void setTotal(double Total){
        total=Total;
    }
}