package main;

import java.util.HashMap;
import java.util.Map;

public class UserProfileManager {
    private final Map<String, String> favoritePizzas = new HashMap<>();

    public void saveFavorite(String username, String pizzaDetails) {
        favoritePizzas.put(username, pizzaDetails);
        System.out.println("Saved " + username + "'s favorite pizza: " + pizzaDetails);
    }

    public String getFavorite(String username) {
        return favoritePizzas.getOrDefault(username, "No favorite pizza found.");
    }
}
