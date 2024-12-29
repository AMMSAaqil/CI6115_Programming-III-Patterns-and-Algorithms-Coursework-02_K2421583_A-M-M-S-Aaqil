package main;

import java.util.ArrayList;
import java.util.List;

public class SeasonalPromotionsManager {
    private final List<String> promotions = new ArrayList<>();

    public void addPromotion(String promotion) {
        promotions.add(promotion);
        System.out.println("Added seasonal promotion: " + promotion);
    }

    public void displayPromotions() {
        System.out.println("\n--- Seasonal Promotions ---");
        for (String promotion : promotions) {
            System.out.println("- " + promotion);
        }
    }
}
