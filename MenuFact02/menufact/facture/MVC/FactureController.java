package menufact.facture.MVC;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;
import menufact.facture.Facture;
import menufact.Client;
import menufact.Chef;
import menufact.facture.exceptions.FactureException;
import menufact.plats.exceptions.PlatException;
import menufact.plats.PlatChoisi;
import menufact.facture.Etat.*;

import java.util.ArrayList;
import java.util.Date;

/**
 * Classe FactureController
 */
public class FactureController {
    private Facture modele;
    private FactureView view;

    /**
     *Constructeur de Facture
     * @param Modele object facture
     * @param View object View pour afficher
     */
    public FactureController(Facture Modele, FactureView View){
        this.modele=Modele;
        this.view=View;
    }

    /**
     *Change le client
     * @param client a associer a la facture
     */
    public void associerClient(Client client){
        modele.associerClient(client);
    }

    /**
     *Retourne le sous-total
     * @return sousTotal de la facture
     */
    public double getSousTotal(){
        return modele.sousTotal();
    }

    /**
     *Retourne le total
     * @return total de la facture
     */
    public double getTotal(){
        return modele.total();
    }

    /**
     *retourne la tps du plat
     * @return tps de la facture
     */
    public double getTps(){
        return modele.tps();
    }

    /**
     *Retourne la tvq du plat
     * @return tvq de la facture
     */
    public double getTvq(){
        return modele.tvq();
    }

    /**
     * paye la facture
     * @throws FactureException
     */
    public void payer() throws FactureException{
        modele.payer();
    }

    /**
     * ferme la facture
     * @throws FactureException
     */
    public void fermer() throws FactureException{
        modele.fermer();
    }

    /**
     * ouvre la facture
     * @throws FactureException
     */
    public void ouvrir() throws FactureException{
        modele.ouvrir();
    }

    /**
     *Retourne l'état du plat
     * @return etat de la facture
     */
    public FactureEtat getEtat(){
        return modele.getEtat();
    }

    /**
     *Ajoute un plat à l'ArrayList
     * @param p platChoisi a ajouter a la facture
     * @throws FactureException
     * @throws PlatException
     */
    public void ajoutePlat(PlatChoisi p) throws FactureException, PlatException {
        modele.ajoutePlat(p);

    }

    /**
     *Cuisine un plat et consomme des ingrédients
     * @param cuisinier
     */
    public void observer(Chef cuisinier){
        modele.observer(cuisinier);
    }

    /**
     *Affiche les informations de la facture
     * @return String a afficher
     */
    public String afficheFacture(){
        view.setDescription(modele.getDescription());
        view.setEtat(modele.getEtat());
        view.setPlatchoisi(modele.getPlatsChoisis());
        view.setCourant(modele.getCourant());
        view.setClient(modele.getClient());
        return view.toString();

    }

    /**
     *Génère une facture complète
     * @return String a afficher
     * @throws MenuException
     */
    public String genereFacture() throws MenuException {
        view.setDescription(modele.getDescription());
        view.setEtat(modele.getEtat());
        view.setPlatchoisi(modele.getPlatsChoisis());
        view.setCourant(modele.getCourant());
        view.setClient(modele.getClient());
        view.setTpsPlat(modele.tps());
        view.setTvqPlat(modele.tvq());
        view.setTotal(modele.total());
        return view.genererFacture();
    }
}