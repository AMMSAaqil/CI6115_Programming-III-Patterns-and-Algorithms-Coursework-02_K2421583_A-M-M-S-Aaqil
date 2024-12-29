package states;

public class PlacedState implements OrderState {
    private final OrderContext context;

    public PlacedState(OrderContext context) {
        this.context = context;
    }

    @Override
    public void nextState() {
        System.out.println("Moving to 'Preparing' state.");
        context.setState(new PreparingState(context));
    }

    @Override
    public void prevState() {
        System.out.println("Order is already in the initial state (Placed).");
    }

    @Override
    public void printStatus() {
        System.out.println("Order has been placed.");
    }
}
