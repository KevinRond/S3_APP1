package menufact.facture;

import menufact.Chef;
import menufact.Client;
import menufact.facture.Etat.FactureEtat;
import menufact.facture.Etat.FactureEtatFermee;
import menufact.facture.Etat.FactureEtatOuverte;
import menufact.facture.Etat.FactureEtatPayee;
import menufact.facture.exceptions.FactureException;
import menufact.plats.PlatChoisi;
import menufact.plats.exceptions.PlatException;

import java.util.ArrayList;
import java.util.Date;

/**
 * Une facture du systeme Menufact
 * @author Kevin Rondeau
 * @version 2.0
 */
public class Facture {
    private Date date;
    private String description;
    private FactureEtat etat;
    private ArrayList<PlatChoisi> platchoisi = new ArrayList<PlatChoisi>();
    private int courant;
    private Client client;
    private Chef chef;


    /**********************Constantes ************/
    private final double TPS = 0.05;
    private final double TVQ = 0.095;

    /**
     *
     * @param client le client de la facture
     */
    public void associerClient (Client client)
    {
        this.client = client;
    }

    /**
     * Calcul du sous total de la facture
     * @return le sous total
     */
    public double sousTotal()
    {
        double soustotal=0;
         for (PlatChoisi p : platchoisi)
             soustotal += p.getQuantite() * p.getPlat().getPrix();
        return soustotal;
    }

    /**
     *
     * @return le total de la facture
     */
    public double total(){
        return sousTotal()+tps()+tvq();
    }

    /**
     *
     * @return la valeur de la TPS
     */
    private double tps(){
        return TPS*sousTotal();
    }

    /**
     *
     * @return la valeur de la TVQ
     */
    private  double tvq(){
        return TVQ*(TPS+1)*sousTotal();
    }

    /**
     * Permet de changer l'état de la facture à PAYEE
     */
    public void payer() throws FactureException {
       //etat = FactureEtat.PAYEE;
        if (etat.changerEtat(new FactureEtatPayee())) {
            etat = new FactureEtatPayee();
        } else {
            throw new FactureException("La facture ne peut pas etre payee");
        }
    }
    /**
     * Permet de chager l'état de la facture à FERMEE
     */
    public void fermer() throws FactureException {
       //etat = FactureEtat.FERMEE;
        if (etat.changerEtat(new FactureEtatFermee())){
            etat = new FactureEtatFermee();
        } else {
            throw new FactureException("La facture ne peut pas etre fermee");
        }
    }

    /**
     * Permet de changer l'état de la facture à OUVERTE
     * @throws FactureException en cas que la facture soit PAYEE
     */
    public void ouvrir() throws FactureException
    {
        if (etat.changerEtat(new FactureEtatOuverte()))
            etat = new FactureEtatOuverte();
        else
            throw new FactureException("La facture ne peut pas être reouverte.");
    }

    /**
     *
     * @return l'état de la facture
     */
    public FactureEtat getEtat()
    {
        return etat;
    }

    /**
     *
     * @param description la description de la Facture
     */
    public Facture(String description) {
        date = new Date();
        etat = new FactureEtatOuverte();
        courant = -1;
        this.description = description;
    }

    /**
     *
     * @param p un plat choisi
     * @throws FactureException Seulement si la facture est OUVERTE
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        if (etat instanceof FactureEtatFermee || etat instanceof FactureEtatPayee){
            throw new FactureException("On peut ajouter un plat seulement sur une facture OUVERTE.");
        }
        if (p == null){
            throw new PlatException("Le plat choisi ne peut pas etre null.");
        }
        if (chef == null){
            throw new FactureException("Il ne peut pas y avoir aucun chef pour ajouter un plat.");
        }
        if (etat instanceof FactureEtatOuverte)
            platchoisi.add(p);
    }

    /**
     *
     * @return le contenu de la facture en chaîne de caracteres
     */
    @Override
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
     *
     * @return une chaîne de caractères avec la facture à imprimer
     */
    public String genererFacture()
    {
        String lesPlats = new String();
        String factureGenere = new String();

        int i = 1;


        factureGenere =   "Facture generee.\n" +
                          "Date:" + date + "\n" +
                          "Description: " + description + "\n" +
                          "Client:" + client.getNom() + "\n" +
                          "Les plats commandes:" + "\n" + lesPlats +
                            "Chef:" + "\n" + chef;

        factureGenere += "Seq   Plat         Prix   Quantite\n";
        for (PlatChoisi plat : platchoisi)
        {
            factureGenere +=  i + "     " + plat.getPlat().getDescription() +  "  " + plat.getPlat().getPrix() +  "      " + plat.getQuantite() + "\n";
            i++;
        }

        factureGenere += "          TPS:               " + tps() + "\n";
        factureGenere += "          TVQ:               " + tvq() + "\n";
        factureGenere += "          Le total est de:   " + total() + "\n";

        return factureGenere;
    }
}
