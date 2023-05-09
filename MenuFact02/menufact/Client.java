package menufact;

import menufact.facture.exceptions.FactureException;

/**
 * Classe client
 */
public class Client {
    private int idClient;
    private String nom;
    private String numeroCarteCredit;

    /**
     * Constructeur de client
     * @param idClient numéro associé à un client
     * @param nom nom du client
     * @param numeroCarteCredit numéro de carte de crédit du client
     * @throws FactureException
     */
    public Client(int idClient, String nom, String numeroCarteCredit) throws FactureException {
        this.idClient = idClient;
        this.nom = nom;
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Retourne le numéro associé au client
     * @return idClient
     */
    public int getIdClient() {
        return idClient;
    }

    /**
     * Change le numéro associé au client
     * @param idClient numéro du client
     * @throws FactureException
     */
    public void setIdClient(int idClient) throws FactureException {
        if(idClient < 0){
            throw new FactureException("un id ne peut pas etre negatif");
        }
        this.idClient = idClient;
    }

    /**
     * Retourne le nom du client
     * @return nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * Change le nom du client
     * @param nom nom du client
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * Retourne le numéro de carte de crédit
     * @return numeroCarteCredit
     */
    public String getNumeroCarteCredit() {
        return numeroCarteCredit;
    }

    /**
     * Change le numéro de carte de crédit
     * @param numeroCarteCredit numéro de carte de crédit
     * @throws FactureException
     */
    public void setNumeroCarteCredit(String numeroCarteCredit) throws FactureException {
        if (numeroCarteCredit == null) {
            throw new FactureException("Numéro de carte de crédit ne peut pas être null");
        }
        this.numeroCarteCredit = numeroCarteCredit;
    }

    /**
     * Retourne les informations du client
     * @return idClient, le nom et le numéro de carte
     */
    @Override
    public String toString() {
        return "menufact.Client{" +
                "idClient=" + idClient +
                ", nom='" + nom + '\'' +
                ", numeroCarteCredit='" + numeroCarteCredit + '\'' +
                '}';
    }
}
/*
@startuml
class menufact.Client{}
* */