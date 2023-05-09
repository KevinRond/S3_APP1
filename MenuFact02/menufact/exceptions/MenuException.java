package menufact.exceptions;

/**
 * Classe MenuException
 */
public class MenuException extends Exception{
    /**
     * Renvoie un message d'erreur en cas d'exception
     * @param message un String
     */
    public MenuException(String message){
        super("MenuException: " + message);
    }
}

