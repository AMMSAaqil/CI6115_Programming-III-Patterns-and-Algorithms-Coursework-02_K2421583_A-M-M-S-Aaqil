package states;

public class PreparingState implements OrderState {
    private final OrderContext context;

    public PreparingState(OrderContext context) {
        this.context = context;
    }

    @Override
    public void nextState() {
        System.out.println("Moving to 'Delivering' state.");
        context.setState(new DeliveringState(context));
    }

    @Override
    public void prevState() {
        System.out.println("Moving back to 'Placed' state.");
        context.setState(new PlacedState(context));
    }

    @Override
    public void printStatus() {
        System.out.println("Order is being prepared.");
    }
}
