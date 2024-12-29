package builders;

public class PizzaBuilder {
    private String crust;
    private String sauce;
    private String cheese;
    private String[] toppings;

    public PizzaBuilder setCrust(String crust) {
        this.crust = crust;
        return this;
    }

    public PizzaBuilder setSauce(String sauce) {
        this.sauce = sauce;
        return this;
    }

    public PizzaBuilder setCheese(String cheese) {
        this.cheese = cheese;
        return this;
    }

    public PizzaBuilder setToppings(String[] toppings) {
        this.toppings = toppings;
        return this;
    }

    public Pizza build() {
        return new Pizza(crust, sauce, cheese, toppings);
    }

    public static class Pizza {
        private final String crust;
        private final String sauce;
        private final String cheese;
        private final String[] toppings;

        private Pizza(String crust, String sauce, String cheese, String[] toppings) {
            this.crust = crust;
            this.sauce = sauce;
            this.cheese = cheese;
            this.toppings = toppings;
        }

        public void displayPizza() {
            System.out.println("\n--- Pizza Details ---");
            System.out.println("Crust: " + crust);
            System.out.println("Sauce: " + sauce);
            System.out.println("Cheese: " + cheese);
            System.out.print("Toppings: ");
            if (toppings != null && toppings.length > 0) {
                for (String topping : toppings) {
                    System.out.print(topping + " ");
                }
                System.out.println();
            } else {
                System.out.println("None");
            }
        }
    }
}
