package PizzaOrderingSystem.test;

import builders.PizzaBuilder;

public class TestPizzaCustomization {
    public static void main(String[] args) {
        PizzaBuilder.Pizza pizza = new PizzaBuilder()
                .setCrust("Thin Crust")
                .setSauce("Tomato Basil")
                .setCheese("Mozzarella")
                .setToppings(new String[]{"Pepperoni", "Olives"})
                .build();

        pizza.displayPizza();
        System.out.println("Test passed: Pizza customization works as expected.");
    }
}
