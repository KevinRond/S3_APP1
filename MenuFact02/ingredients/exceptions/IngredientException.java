package ingredients.exceptions;

/**
 * Classe IngredientException
 */
public class IngredientException extends Exception{
    /**
     * Renvoie un message d'erreur lorsqu'il y a une exception
     * @param message
     */
    public IngredientException(String message){
        super("IngredientException: " + message);
    }
}
