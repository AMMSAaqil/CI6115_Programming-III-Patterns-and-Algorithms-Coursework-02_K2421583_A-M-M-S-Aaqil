package decorators;

public class ExtraCheeseDecorator extends PizzaDecorator {
    public ExtraCheeseDecorator(Pizza pizza) {
        super(pizza);
    }

    @Override
    public void makePizza() {
        super.makePizza();
        System.out.println("Adding extra cheese.");
    }
}
