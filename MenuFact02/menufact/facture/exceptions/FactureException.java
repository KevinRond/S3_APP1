package menufact.facture.exceptions;

/**
 * Classe FactureException
 */
public class FactureException extends Exception{
    /**
     * Retourne un message d'erreur pour une exception
     * @param message
     */
    public FactureException(String message){
        super("FactureException: " + message);
   }
}
