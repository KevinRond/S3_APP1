package menufact.plats.exceptions;

/**
 * Classe PlatException
 */
public class PlatException extends Exception{
    /**
     * Envoie un message d'erreur lorsqu'il y a une exception
     * @param message
     */
    public PlatException(String message){
        super("PlatException: " + message);
    }
}
