package trade;

import java.util.HashMap;
import java.util.Map;

import bo.Item;
import bo.User;

public class Store {

    private Map<User, Cart> users;
    private Map<Item, Integer> stockItems;

    public Store(Map<User, Cart> users, Map<Item, Integer> stockItems) {
        users = new HashMap<User, Cart>();
        stockItems = new HashMap<Item, Integer>();
    }

    public Map<User, Cart> getUsers() {
        return users;
    }

    public Map<Item, Integer> getStockItems() {
        return stockItems;
    }

    public void setUsers(Map<User, Cart> users) {
        this.users = users;
    }

    public void setStockItems(Map<Item, Integer> stockItems) {
        this.stockItems = stockItems;
    }

//--------------------Méthodes--------------------------------------------------------\\
    /**
     * Methode "addUsers". Cette methode permet d'ajouter un Utilisateur au magasin
     * ainsi que le panier associé
     * 
     * @param user L'utilisateur a ajouté
     */
    public void addUsers(User user) {
        users.put(user, new Cart());
    }

    /**
     * Methode "addItems". Ajoute un article au magasin ainsi que son stock
     * 
     * @param items Article ajouté
     * @param stock Stock associé a l'article
     */
    public void addItems(Item items, Integer stock) {
        stockItems.put(items, stock);
    }

    /**
     * Methode "addItemsToCart". Ajoute un article a un panier. La methode doit
     * vérifier si l'article existe, si l'utilisateur existe ainsi que le stock de
     * l'article disponible dans le mangasin
     * 
     * @param items Article a ajouté au panier
     * @param user  Utilisateur concerne
     * @param stock Sotck disponible de l'Article choisi
     */
    public void addItemsToCart(Item items, User user, Integer stock) {
        // Vérification si article et user existent
        if (stockItems.containsKey(items) && users.containsKey(user)) {
            // Vérification du stock
            if (stockItems.get(items) < stock) {
                throw new RuntimeException("Stock insuffisant");
            }
            // Ajout de l'article dans le panier
            Cart cart = new Cart();
            cart.addItemCart(items, stock);
        }
        if (!stockItems.containsKey(items))
            throw new RuntimeException("Article inexsistant");
        if (!users.containsKey(user))
            throw new RuntimeException("Utilisateur inexsistant");
    }

    /**
     * Methode "payCart" : regle la facture du panier. Le panier est vide et le
     * stock de l'article dans le magasin est actualise. Remove sur le panier et
     * decrementer le stock. Boucle pour parcourir la map d'Articles
     */
    public void payCart() {

    }

    // ----------------------------------------------------------------------------\\
    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Store [users=");
        builder.append(users);
        builder.append(", stockItems=");
        builder.append(stockItems);
        builder.append("]");
        return builder.toString();
    }

}
