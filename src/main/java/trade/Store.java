package trade;

import java.util.HashMap;
import java.util.Map;

import bo.Item;
import bo.User;

public class Store {
    private Map<Item, Integer> stock;
    private Map<User, Cart> clients;

    public Store() {
        stock = new HashMap<Item, Integer>();
        clients = new HashMap<User, Cart>();
    }

    /**
     * Methode "ajouterUser". Cette methode permet d'ajouter un Utilisateur au
     * magasin avec son panier
     * 
     * @param user L'utilisateur a ajoute
     */
    public void ajouterUser(User user) {
        clients.put(user, new Cart());
    }

    /**
     * Methode "ajouterItem". Ajoute un article au magasin ainsi que son stock
     * 
     * @param Item Article ajoute
     */
    public void ajouterItem(Item Item) {
        if (stock.containsKey(Item)) {
            int previousStock = stock.get(Item);
            stock.put(Item, previousStock + 1);
        } else {
            stock.put(Item, 1);
        }
    }

    /**
     * Methode "ajouterNItem". Ajoute X article a un panier.
     * 
     * @param Item Article a ajoute au panier
     * @param n    nombre d'Items a ajouter
     */
    public void ajouterNItem(Item Item, int n) {
        for (int i = 0; i < n; i++) {
            this.ajouterItem(Item);
        }
    }

    /**
     * Methode "getItemStock". Renvoie la valeur du stock d'un Item
     * 
     * @param Item Item dont on veut connaitre le stock
     * @return le stock
     */
    public int getItemStock(Item Item) {
        int result = 0;
        if (stock.containsKey(Item)) {
            result = stock.get(Item);
        }
        return result;
    }

    /**
     * Methode "ajouterItemACart". Ajoute un article a un panier. La methode doit
     * verifier si l'article existe, si l'utilisateur existe ainsi que le stock de
     * l'article disponible dans le mangasin
     * 
     * @param Item Item a ajouter au panier
     * @param user User du panier
     */
    public void ajouterItemACart(Item Item, User user) {
        /*
         * Si l'Item existe en stock et que l'User fait partie de la liste des clients
         * Alors on peut ajouter l'Item à son Cart
         */
        if (stock.containsKey(Item) && stock.get(Item) > 0 && clients.containsKey(user)) {
            Cart Cart = clients.get(user);

            if (Cart.containsKey(Item)) {
                int quantite = Cart.get(Item);
                Cart.put(Item, quantite + 1);
            } else {
                Cart.put(Item, 1);
            }
        }
    }

    /**
     * Methode "payCart". Montant que doit payer l'User apres avoir fait son panier.
     * @param user User qui doit payer son panier
     */
    public void payCart(User user) {
        if (clients.containsKey(user)) {
            Cart Cart = clients.get(user);
            Cart.forEach((Item, qtt) -> {
                int stockQtt = stock.get(Item);
                if (stockQtt >= qtt) {
                    stock.put(Item, stockQtt - qtt);
                    Cart.put(Item, 0);
                } else {
                    System.out.println("L'Item " + Item + " est en stock insuffisant. (" + qtt + " demandés contre "
                            + stockQtt + " en stock)");
                }
            });
        }
    }

    public Map<Item, Integer> getStock() {
        return stock;
    }

    public Map<User, Cart> getClients() {
        return clients;
    }

}
