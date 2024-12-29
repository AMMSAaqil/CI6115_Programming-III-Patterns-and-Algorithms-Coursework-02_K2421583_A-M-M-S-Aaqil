package states;

public class DeliveringState implements OrderState {
    private final OrderContext context;

    public DeliveringState(OrderContext context) {
        this.context = context;
    }

    @Override
    public void nextState() {
        System.out.println("Moving to 'Delivered' state.");
        context.setState(new DeliveredState(context));
    }

    @Override
    public void prevState() {
        System.out.println("Moving back to 'Preparing' state.");
        context.setState(new PreparingState(context));
    }

    @Override
    public void printStatus() {
        System.out.println("Order is out for delivery.");
    }
}
