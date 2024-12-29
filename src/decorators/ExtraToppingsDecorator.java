package decorators;

public class ExtraToppingsDecorator extends PizzaDecorator {
    public ExtraToppingsDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void makePizza() {
        super.makePizza();
        System.out.println("Adding extra toppings.");
    }
}
