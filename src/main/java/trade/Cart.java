package trade;

import java.util.HashMap;
import java.util.Map;

import bo.Item;

//Panier
public class Cart {

    private Map<Item, Integer> carts;

    public Cart() {
        carts = new HashMap<Item, Integer>();
    }

    public Map<Item, Integer> getCarts() {
        return carts;
    }

    public void setCarts(Map<Item, Integer> carts) {
        this.carts = carts;
    }

    // ----------------------------------------------------------------------------\\
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Cart [carts=");
        builder.append(carts);
        builder.append("]");
        return builder.toString();
    }

    // ----------------------------------------------------------------------------\\
    /**
     * Methode "addItemCart". Ajoute un article et son stock dans un panier.
     * La methode doit vérifier si l'article n'est pas deja présent dans panier
     * 
     * @param items Article a ajouter au panier
     * @param stock Stock disponible de l'Article choisi
     */
    public void addItemCart(Item items, Integer stock) {
        if (carts.containsKey(items)) {
            throw new RuntimeException("L'article est déjà dans le panier");
        }
        carts.put(items, stock);
    }
}
