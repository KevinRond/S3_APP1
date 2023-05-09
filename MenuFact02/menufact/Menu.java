package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

/**
 * Classe Menu singleton
 */
public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();
    private static Menu instance;

    /**
     * Crée un menu avec une description
     * @param description
     */
    private Menu(String description) {
        this.description = description;
    }

    /**
     * Crée un menu s'il n'y en a pas déjà un, retourne le menu déjà créé sinon
     * @return instance
     */
    public synchronized static Menu getInstance(String description) {
        return instance == null ? instance = new Menu(description) : instance;
    }

    /**
     * Permet de changer la description du Menu
     * @param description
     */
    public void setDescription(String description){
        this.description=description;
    }

    /**
     * Retourne la description
     * @return description
     */
    public String getDescription(){
        return description;
    }

    /**
     * Ajoute un nouveau plat au menu
     * @param p variable de PlatAuMenu
     * @throws MenuException
     */
    public void ajoute (PlatAuMenu p) throws MenuException {
        if (p != null){
            plat.add(p);
        }
        else{
            throw new MenuException("Le plat ne peut pas etre vide");
        }
    }

    /**
     * Met le plat courant à la position i
     * @param i position du nouveau plat courant
     */
    public void position(int i){
        if(i >= 0){
            courant = i;
        }
    }

    /**
     * Retourne le plat à la position courant
     * @return le plat courant
     */
    public PlatAuMenu platCourant(){
        return plat.get(courant);
    }

    /**
     * Met le plat courant au plat suivant le présent si on est pas au dernier plat
     * @throws MenuException
     */
    public void positionSuivante() throws MenuException {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    /**
     * Met le plat courant au plat précédent le présent si on est pas au premier plat
     * @throws MenuException
     */
    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }

    /**
     * Retourne de l'information sur le menu
     * @return la description, la position du plat courant et le plat
     */
    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
