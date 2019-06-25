package util;

import java.util.HashMap;

import bo.User;
import trade.Cart;

public class DataSetUser {

    public static void mockListUSer(HashMap<User, Cart> users)  {
        users.put(("Alexei","alexei@test.fr", 31), 1);
        users.put(("Adrien","adrien@test.com", 26), 1);
        users.put(("Mathide","mathilde@monique.fr", 32), 1);
        users.put(("Glen", "glen@test.com",23), 1);

    }
    
}
