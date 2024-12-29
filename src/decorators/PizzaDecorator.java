package decorators;

public abstract class PizzaDecorator implements Pizza {
    private final Pizza pizza;

    public PizzaDecorator(Pizza pizza) {
        this.pizza = pizza;
    }

    @Override
    public void makePizza() {
        pizza.makePizza();
    }
}
