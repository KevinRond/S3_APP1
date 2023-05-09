package ingredients;

import ingredients.etat.etatIngredient;

import java.util.HashMap;
import java.util.Map;

public class FactoryFlyweightIngredient {
    private Map<String, IntrinsicIngredient> groupeIntrinsicIngredientMap = new HashMap<>();
    public String createKey(TypeIngredient type, String etat){
        return type.toString() + "-" + etat;
    }
    public IntrinsicIngredient getIntrinsicIngredient(TypeIngredient type, etatIngredient etat){
        String key = createKey(type, etat.getEtat());
        IntrinsicIngredient intrinsicIngredient = groupeIntrinsicIngredientMap.get(key);

        if (intrinsicIngredient == null){
            intrinsicIngredient = new IntrinsicIngredient(type, etat);
        }

        return intrinsicIngredient;
    }
}
