package ingredients;

import ingredients.etat.etatIngredient;

import java.util.HashMap;
import java.util.Map;

/**
 * Classe FactoryFlyweightIngredient
 */
public class FactoryFlyweightIngredient {
    private Map<String, IntrinsicIngredient> groupeIntrinsicIngredientMap = new HashMap<>();

    /**
     * Crée une clé pour le hashmap
     * @param type
     * @param etat
     * @return
     */
    public String createKey(TypeIngredient type, String etat){
        return type.toString() + "-" + etat;
    }

    /**
     * Renvoie un élément du Hashmap
     * @param type
     * @param etat
     * @return
     */
    public IntrinsicIngredient getIntrinsicIngredient(TypeIngredient type, etatIngredient etat){
        String key = createKey(type, etat.getEtat());
        IntrinsicIngredient intrinsicIngredient = groupeIntrinsicIngredientMap.get(key);

        if (intrinsicIngredient == null){
            intrinsicIngredient = new IntrinsicIngredient(type, etat);
        }

        return intrinsicIngredient;
    }
}
