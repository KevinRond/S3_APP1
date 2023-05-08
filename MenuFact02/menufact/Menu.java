package menufact;

import menufact.exceptions.MenuException;
import menufact.plats.PlatAuMenu;

import java.util.ArrayList;

public class Menu {
    private String description;
    private int courant;
    private ArrayList<PlatAuMenu> plat = new ArrayList<PlatAuMenu>();
    private static Menu instance;
    public Menu(String description) {
        this.description = description;
    }

    public synchronized static Menu getInstance() {
        return instance == null ? instance = new Menu(null) : instance;
    }

    public void setDescription(String description){
        this.description=description;
    }

    public String getDescription(){
        return description;
    }

    public void ajoute (PlatAuMenu p) throws MenuException {
        if (p != null){
            plat.add(p);
        }
        else{
            throw new MenuException("Le plat ne peut pas etre vide");
        }
    }

    public void position(int i){
        if(i >= 0){
            courant = i;
        }
    }

    public PlatAuMenu platCourant(){
        return plat.get(courant);
    }

    public void positionSuivante() throws MenuException {
        if (courant+1 >= plat.size())
            throw new MenuException("On depasse le nombre maximale de plats.");
        else
            courant++;
    }

    public void positionPrecedente() throws MenuException
    {
        if (courant-1 < 0)
            throw new MenuException("On depasse le nombre minimale de plats");
        else
            courant--;
    }


    @Override
    public String toString() {
        return "menufact.Menu{" +
                "description='" + description + '\'' +
                ", courant=" + courant +
                ", plat=" + "\n" + plat +
                '}';
    }
}
